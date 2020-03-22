package de.coronavirus.application.service;

import de.coronavirus.application.dtos.request.CreateInfectedRequest;
import de.coronavirus.application.dtos.request.UpdateInfectedRequest;
import de.coronavirus.application.dtos.service.InfectedDto;
import de.coronavirus.domain.exception.NotFoundException;
import de.coronavirus.domain.infrastructure.repositories.*;
import de.coronavirus.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class InfectedService {

    private final AccommodationRepository accommodationRepository;
    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final DetectorRepository detectorRepository;
    private final DiagnosisRepository diagnosisRepository;
    private final EmailAddressRepository emailAddressRepository;
    private final InfectedRepository infectedRepository;
    private final LaboratoryRepository laboratoryRepository;
    private final PhoneNumberRepository phoneNumberRepository;
    private final PostCodeRepository postCodeRepository;
    private final StreetRepository streetRepository;

    @Autowired
    public InfectedService(final AccommodationRepository accommodationRepository,
                           final AddressRepository addressRepository,
                           final CityRepository cityRepository,
                           final CountryRepository countryRepository,
                           final DetectorRepository detectorRepository,
                           final DiagnosisRepository diagnosisRepository,
                           final EmailAddressRepository emailAddressRepository,
                           final InfectedRepository infectedRepository,
                           final LaboratoryRepository laboratoryRepository,
                           final PhoneNumberRepository phoneNumberRepository,
                           final PostCodeRepository postCodeRepository,
                           final StreetRepository streetRepository) {

        this.accommodationRepository = accommodationRepository;
        this.addressRepository = addressRepository;
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.detectorRepository = detectorRepository;
        this.diagnosisRepository = diagnosisRepository;
        this.emailAddressRepository = emailAddressRepository;
        this.infectedRepository = infectedRepository;
        this.laboratoryRepository = laboratoryRepository;
        this.phoneNumberRepository = phoneNumberRepository;
        this.postCodeRepository = postCodeRepository;
        this.streetRepository = streetRepository;
    }

    public List<InfectedDto> findAll() {
        return infectedRepository.findAllDtoBy();
    }

    public InfectedDto findInfected(long id) {
        return infectedRepository.findDtoById(id).orElseThrow(() -> new NotFoundException("Error: Infected Person not found!", "The infected Person could not been found!"));
    }

    public InfectedDto createInfected(CreateInfectedRequest request) {

        final PhoneNumber infectedPhoneNumber = createOrReadPhoneNumber(request.getPatientPhone());
        final PhoneNumber detectorPhoneNumber = createOrReadPhoneNumber(request.getDatectorPhone());
        final PhoneNumber detectionOfficeNumber = createOrReadPhoneNumber(request.getDetectionOfficePhone());
        final PhoneNumber laboratoryNumber = createOrReadPhoneNumber(request.getLaboratoryPhone());

        final EmailAddress infectedEmail = createOrReadEmailAddress(request.getPatientEmail());
        final EmailAddress detectorEmail = createOrReadEmailAddress(request.getDetectorEmail());
        final EmailAddress detectionOfficeEmail = createOrReadEmailAddress(request.getDetectionOfficeEmail());

        final Address infectedAddress = createOrReadAddress(
                request.getPatientAddressCountry(),
                request.getPatientAddressCity(),
                request.getPatientAddressZipcode(),
                request.getPatientAddressStreet(),
                request.getPatientAddressHousenumber());
        final Address detectorAddress = createOrReadAddress(
                request.getDetectorAddressCountry(),
                request.getDetectorAddressCity(),
                request.getDetectorAddressZipcode(),
                request.getDetectorAddressStreet(),
                request.getDetectorAddressHousenumber());
        final Address detectionOfficeAddress = createOrReadAddress(
                request.getDetectionOfficeAddressCountry(),
                request.getDetectionOfficeAddressCity(),
                request.getDetectionOfficeAddressZipcode(),
                request.getDetectionOfficeAddressStreet(),
                request.getDetectionOfficeAddressHousenumber());

        String detectorName = request.getDetectorLastName() + ", " + request.getDetectorFirstName();
        final Detector detector = createOrReadDetector(
                detectorName.length() > 2 ? detectorName : null,
                detectorAddress,
                detectorPhoneNumber,
                detectorEmail);
        final Detector detectionOffice = createOrReadDetector(
                request.getDetectionOfficeName(),
                detectionOfficeAddress,
                detectionOfficeNumber,
                detectionOfficeEmail);

        final Laboratory laboratory = createOrReadLaboratory(
                request.getLaboratoryName(),
                null, // TODO location is only one string (dont know syntax)
                laboratoryNumber,
                null); // TODO no email supplied

        final Accommodation accommodation = createOrReadAccommodation(
                request.getAccommodationNameAndAddress(), // TODO this is bullshit
                null,
                request.isAccommodationCommunal(),
                request.isAccommodationHospital(),
                request.getAccommodationDateOfHospitalisation(),
                request.isAccommodationIcu(),
                request.getAccommodationDateOfIcu(),
                null,
                null);

        final Diagnosis diagnosis = new Diagnosis();
        diagnosis.setDiagnosticResult(removeSpaces(request.getDiagnosisName()));
        diagnosis.setDate(request.getDiagnosisDateOfDiagnosis());
        diagnosis.setSuspicion(request.isDiagnosisSuspected());
        diagnosis.setClinicalDiagnosis(!request.isDiagnosisSuspected());
        diagnosis.setDead(request.isDiagnosisDead());
        diagnosis.setDetector(detector);
        diagnosis.setDetectionOffice(detectionOffice);
        diagnosis.setLaboratory(laboratory);
        diagnosis.setConfirmed(request.isDiagnosisDiagnosed());
        diagnosisRepository.saveAndFlush(diagnosis);

        final Infected infected = new Infected();
        infected.setFirstName(removeSpaces(request.getPatientFirstName()));
        infected.setLastName(removeSpaces(request.getPatientLastName()));
        infected.setGender(Infected.Gender.valueOf(removeSpaces(request.getPatientSex().toUpperCase())));
        infected.setDateOfBirth(request.getPatientBirthday());
        if (infectedPhoneNumber != null) infected.getPhoneNumbers().add(infectedPhoneNumber);
        infected.setAddress(infectedAddress);
        if (infectedEmail != null) infected.getEmailAddresses().add(infectedEmail);
        infected.setJobInMedicalField(request.isJobMedical());
        infected.setJobInFoodFiled(request.isJobFood());
        infected.setJobInCommunityField(request.isJobCommunal());
        infected.setAccommodation(accommodation);
        infected.setDateOfIllness(request.getDiagnosisDateOfSickness());
        infected.getDiagnoses().add(diagnosis);
        infected.setDateOfDeath(request.getDateOfDeath());
        String infectionSource = request.getInfectionSource() + ", " + request.getInfectionPlace();
        infected.setInfectionSource(infectionSource.length() > 2 ? infectionSource : null);
        infected.setIntensiveCareTreatment(request.isAccommodationIcu());
        infectedRepository.saveAndFlush(infected);

        if (accommodation != null) accommodation.getInfected().add(infected);
        accommodationRepository.flush();

        diagnosis.setInfected(infected);
        diagnosisRepository.flush();

        return infectedRepository.findDtoById(infected.getId()).orElseThrow(() -> new NotFoundException("Error: Infected person not found!", "The infected Person could not been found!"));
    }

    public InfectedDto updateInfected(UpdateInfectedRequest updateRequest, long id) {
        return findInfected(id);
    }

    public void delete(long id) {
        infectedRepository.deleteById(id);
    }

    private Address createOrReadAddress(String countryName, String cityName, long postCodeId, String streetName, String number) {

        Address address = null;

        if (!isEmpty(countryName)) {
            final Country country = countryRepository.findByName(countryName).orElseGet(() -> {
                final Country c = new Country();
                c.setName(countryName);
                countryRepository.saveAndFlush(c);
                return c;
            });

            if (!isEmpty(cityName)) {
                final City city = cityRepository.findByCountryAndName(country, cityName).orElseGet(() -> {
                    final City c = new City();
                    c.setCountry(country);
                    c.setName(cityName);
                    country.getCities().add(c);
                    countryRepository.flush();
                    return c;
                });

                if (postCodeId != 0) {
                    final PostCode postCode = postCodeRepository.findByCityAndCode(city, postCodeId).orElseGet(() -> {
                        final PostCode c = new PostCode();
                        c.setCity(city);
                        c.setCode(postCodeId);
                        city.getPostCodes().add(c);
                        cityRepository.flush();
                        return c;
                    });

                    if (!isEmpty(streetName)) {
                        final Street street = streetRepository.findByPostCodeAndName(postCode, streetName).orElseGet(() -> {
                            final Street s = new Street();
                            s.setPostCode(postCode);
                            s.setName(streetName);
                            postCode.getStreets().add(s);
                            postCodeRepository.flush();
                            return s;
                        });

                        address = addressRepository.findByStreetAndHouseNumber(street, number).orElseGet(() -> {
                            final Address a = new Address();
                            a.setHouseNumber(number);
                            a.setStreet(street);
                            addressRepository.saveAndFlush(a);
                            return a;
                        });
                    }
                }
            }
        }

        return address;
    }

    private Accommodation createOrReadAccommodation(String name,
                                                    Address address,
                                                    boolean community,
                                                    boolean inCare,
                                                    Date inCareSince,
                                                    boolean inIcu,
                                                    Date inIcuSince,
                                                    PhoneNumber phoneNumber,
                                                    EmailAddress emailAddress) {
        if (isEmpty(name)) return null;

        final Accommodation accommodation = accommodationRepository.findByName(name).orElseGet(() -> {
            Accommodation a = new Accommodation();
            a.setAddress(address);
            a.setName(name);
            return a;
        });

        if (phoneNumber != null && accommodation.getPhoneNumbers().contains(phoneNumber)) {
            accommodation.getPhoneNumbers().add(phoneNumber);
        }

        if (emailAddress != null && accommodation.getEmailAddresses().contains(emailAddress)) {
            accommodation.getEmailAddresses().add(emailAddress);
        }

        accommodation.setCommunityField(community);
        accommodation.setInCare(inCare);
        accommodation.setInCareSince(inCareSince);
        accommodation.setInIcu(inIcu);
        accommodation.setInIcuSince(inIcuSince);

        accommodationRepository.saveAndFlush(accommodation);
        return accommodation;
    }

    private Detector createOrReadDetector(String name, Address address, PhoneNumber phoneNumber, EmailAddress emailAddress) {
        if (isEmpty(name) || address == null) return null;

        final Detector detector = detectorRepository.findByNameAndAddress(name, address).orElseGet(() -> {
            final Detector d = new Detector();
            d.setAddress(address);
            d.setName(name);
            return d;
        });

        if (phoneNumber != null && !detector.getPhoneNumbers().contains(phoneNumber)) {
            detector.getPhoneNumbers().add(phoneNumber);
        }
        if (emailAddress != null && !detector.getEmailAddresses().contains(emailAddress)) {
            detector.getEmailAddresses().add(emailAddress);
        }

        detectorRepository.saveAndFlush(detector);
        return detector;
    }

    private Laboratory createOrReadLaboratory(String name, Address address, PhoneNumber phoneNumber, EmailAddress emailAddress) {
        if (isEmpty(name)) return null;

        final Laboratory laboratory = laboratoryRepository.findByName(name).orElseGet(() -> {
            final Laboratory l = new Laboratory();
            l.setAddress(address);
            l.setName(name);
            return l;
        });

        if (phoneNumber != null && !laboratory.getPhoneNumbers().contains(phoneNumber)) {
            laboratory.getPhoneNumbers().add(phoneNumber);
        }

        if (emailAddress != null && !laboratory.getEmailAddresses().contains(emailAddress)) {
            laboratory.getEmailAddresses().add(emailAddress);
        }

        laboratoryRepository.saveAndFlush(laboratory);
        return laboratory;
    }

    private PhoneNumber createOrReadPhoneNumber(String phoneNumber) {
        if (isEmpty(phoneNumber)) return null;
        return phoneNumberRepository.findByNumber(phoneNumber).orElseGet(() -> {
            final PhoneNumber n = new PhoneNumber();
            n.setNumber(phoneNumber);
            phoneNumberRepository.saveAndFlush(n);
            return n;
        });
    }

    private EmailAddress createOrReadEmailAddress(String emailAddress) {
        if (isEmpty(emailAddress)) return null;
        return emailAddressRepository.findByEmail(emailAddress).orElseGet(() -> {
            final EmailAddress e = new EmailAddress();
            e.setEmail(emailAddress);
            emailAddressRepository.saveAndFlush(e);
            return e;
        });
    }

    private boolean isEmpty(String string) {
        return string == null || string.isBlank();
    }

    private String removeSpaces(final String string) {
        String removed = string.trim();
        return removed.length() != 0 ? removed : null;
    }
}
