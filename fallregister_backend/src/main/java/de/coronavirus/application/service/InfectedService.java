package de.coronavirus.application.service;

import de.coronavirus.application.dtos.request.CreateInfectedRequest;
import de.coronavirus.application.dtos.request.UpdateInfectedRequest;
import de.coronavirus.application.dtos.service.InfectedDto;
import de.coronavirus.domain.exception.NotFoundException;
import de.coronavirus.domain.infrastructure.repositories.AccommodationRepository;
import de.coronavirus.domain.infrastructure.repositories.AddressRepository;
import de.coronavirus.domain.infrastructure.repositories.CityRepository;
import de.coronavirus.domain.infrastructure.repositories.CountryRepository;
import de.coronavirus.domain.infrastructure.repositories.DetectorRepository;
import de.coronavirus.domain.infrastructure.repositories.DiagnosisRepository;
import de.coronavirus.domain.infrastructure.repositories.EmailAddressRepository;
import de.coronavirus.domain.infrastructure.repositories.InfectedRepository;
import de.coronavirus.domain.infrastructure.repositories.LaboratoryRepository;
import de.coronavirus.domain.infrastructure.repositories.PhoneNumberRepository;
import de.coronavirus.domain.infrastructure.repositories.PostCodeRepository;
import de.coronavirus.domain.infrastructure.repositories.StreetRepository;
import de.coronavirus.domain.model.Accommodation;
import de.coronavirus.domain.model.Address;
import de.coronavirus.domain.model.City;
import de.coronavirus.domain.model.Country;
import de.coronavirus.domain.model.Detector;
import de.coronavirus.domain.model.Diagnosis;
import de.coronavirus.domain.model.EmailAddress;
import de.coronavirus.domain.model.Infected;
import de.coronavirus.domain.model.Laboratory;
import de.coronavirus.domain.model.PhoneNumber;
import de.coronavirus.domain.model.PostCode;
import de.coronavirus.domain.model.Street;
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

        final Detector detector = createOrReadDetector(
                request.getDetectorLastName() + ", " + request.getDetectorFirstName(),
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
        diagnosis.setDiagnosticResult(request.getDiagnosisName());
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
        infected.setFirstName(request.getPatientFirstName());
        infected.setLastName(request.getPatientLastName());
        infected.setGender(Infected.Gender.valueOf(request.getPatientSex()));
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
        infected.setInfectionSource(request.getInfectionSource() + ", " + request.getInfectionPlace());
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

        if (countryName != null) {
            final Country country = countryRepository.findByName(countryName).orElseGet(() -> {
                final Country c = new Country();
                c.setName(countryName);
                countryRepository.saveAndFlush(c);
                return c;
            });

            if (cityName != null) {
                final City city = cityRepository.findByCountryAndName(country.getId(), cityName).orElseGet(() -> {
                    final City c = new City();
                    c.setCountry(country);
                    c.setName(cityName);
                    country.getCities().add(c);
                    countryRepository.flush();
                    return c;
                });

                if (postCodeId != 0) {
                    final PostCode postCode = postCodeRepository.findByCityAndCode(city.getId(), postCodeId).orElseGet(() -> {
                        final PostCode c = new PostCode();
                        c.setCity(city);
                        c.setCode(postCodeId);
                        city.getPostCodes().add(c);
                        cityRepository.flush();
                        return c;
                    });

                    if (streetName != null) {
                        final Street street = streetRepository.findByPostCodeAndName(postCode.getCode(), streetName).orElseGet(() -> {
                            final Street s = new Street();
                            s.setPostCode(postCode);
                            s.setName(streetName);
                            postCode.getStreets().add(s);
                            postCodeRepository.flush();
                            return s;
                        });

                        address = addressRepository.findByStreetAndHouseNumber(street.getId(), number).orElseGet(() -> {
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
        if (name == null) return null;

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
        if (name == null || address == null) return null;

        final Detector detector = detectorRepository.findByNameAndAddress(name, address.getId()).orElseGet(() -> {
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
        if (name == null) return null;

        final Laboratory laboratory = laboratoryRepository.findByName(name).orElseGet(() -> {
            final Laboratory l = new Laboratory();
            l.setAddress(address);
            l.setName(name);
            return l;
        });

        if (phoneNumber != null && !laboratory.getPhoneNumber().contains(phoneNumber)) {
            laboratory.getPhoneNumber().add(phoneNumber);
        }

        if (emailAddress != null && !laboratory.getEmailAddresses().contains(emailAddress)) {
            laboratory.getEmailAddresses().add(emailAddress);
        }

        laboratoryRepository.saveAndFlush(laboratory);
        return laboratory;
    }

    private PhoneNumber createOrReadPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) return null;
        return phoneNumberRepository.findByNumber(phoneNumber).orElseGet(() -> {
            final PhoneNumber n = new PhoneNumber();
            n.setNumber(phoneNumber);
            phoneNumberRepository.saveAndFlush(n);
            return n;
        });
    }

    private EmailAddress createOrReadEmailAddress(String emailAddress) {
        if (emailAddress == null) return null;
        return emailAddressRepository.findByEmail(emailAddress).orElseGet(() -> {
            final EmailAddress e = new EmailAddress();
            e.setEmail(emailAddress);
            emailAddressRepository.saveAndFlush(e);
            return e;
        });
    }
}
