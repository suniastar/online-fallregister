package de.coronavirus.application.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.stream.JsonReader;
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
import de.coronavirus.domain.model.Infected;
import de.coronavirus.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

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

    private static Path resources;

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

    public static List<Infected> getInfectedFromTestData() throws IOException {
        ComplexJsonDataUnwrapper unwrapper = new ComplexJsonDataUnwrapper();
        BufferedReader bufferedReader = Files.newBufferedReader(getTestResourcesDirectory().resolve("Test_Infected_Data.json"));
        JsonReader jsonReader = new JsonReader(bufferedReader);
        // get Keys
        List<String> keys = unwrapper.readValuesFromFirstArrayInObject(jsonReader);
        // get Values
        bufferedReader = Files.newBufferedReader(getTestResourcesDirectory().resolve("Test_Infected_Data.json"));
        jsonReader = new JsonReader(bufferedReader);
        List<List<String>> values = unwrapper.readArrayValuesOutFromSecondArray(jsonReader);
        // reconstruct them
        List<ComplexJsonDataUnwrapper.KeyValue> keyValues = unwrapper.reconstructSimpleJsonKeyValue(keys, values);
        // create Infected from reconstructed list
        List<Infected> infecteds = JsonTestDataToModelConverter.stringsToInfected(keyValues);
        return infecteds;
    }

    private static Path getTestResourcesDirectory() {
        if (resources == null) {
            // Paths.get("") = ...online-fallregister/fallregister_backend
            resources = Paths.get("").resolve("src").resolve("main").resolve("resources").resolve("Test");
            // Path ressources = src/main/Test/
        }
        return resources;
    }

//    private List<Infected> addRandomAmountOfPhoneNumbers(List<Infected> infecteds) {
//
//    }
//
//    private List<Infected> addRandomAmountOfEmailAdresses(List<Infected> infecteds){
//
//    }

    public static <T> List<List<T>> getRandomPartitionOfList (List<T> list, int amountUpperLimit){
        List<List<T>> partitions = new LinkedList<List<T>>();
        Iterator<T> listIterator = list.iterator();
        while(listIterator.hasNext()){
            int random = Generator.generateRandomIntBetween(1, amountUpperLimit);
            List<T> part = new ArrayList<T>(amountUpperLimit);
            for(int i = 0; i < random && listIterator.hasNext(); i++){
                part.add(listIterator.next());
            }
            partitions.add(part);
        }
        return partitions;
    }

}
