package de.coronavirus.application.util;

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
import de.coronavirus.domain.infrastructure.repositories.TokenRepository;
import de.coronavirus.domain.infrastructure.repositories.UserRepository;
import de.coronavirus.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleDataImporter {

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
    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;

    @Autowired
    public SampleDataImporter(final AccommodationRepository accommodationRepository,
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
                              final StreetRepository streetRepository,
                              final TokenRepository tokenRepository,
                              final UserRepository userRepository) {

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
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
    }

    public void resetToSampleData() {
        accommodationRepository.deleteAll();
        addressRepository.deleteAll();
        cityRepository.deleteAll();
        countryRepository.deleteAll();
        detectorRepository.deleteAll();
        diagnosisRepository.deleteAll();
        emailAddressRepository.deleteAll();
        infectedRepository.deleteAll();
        laboratoryRepository.deleteAll();
        phoneNumberRepository.deleteAll();
        postCodeRepository.deleteAll();
        streetRepository.deleteAll();
        tokenRepository.deleteAll();
        userRepository.deleteAll();

        insertUserSample();
    }

    private void insertUserSample() {
        User user1 = new User();
        user1.setName("testuser");
        user1.setPassword("03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4"); // sha256 of 1234
        userRepository.saveAndFlush(user1);

        User user2 = new User();
        user2.setName("unsicherman");
        user2.setPassword("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8"); // sha256 of password
        userRepository.saveAndFlush(user2);

        user2.addToken();
        userRepository.flush();
    }
}
