package test.util;

import de.coronavirus.application.util.SampleDataImporter;
import de.coronavirus.application.util.TimeConverter;
import de.coronavirus.domain.model.Infected;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.AssertTrue;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SampleDataImporterTest {

    /*@org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }*/

/*    @org.junit.jupiter.api.Test
    void resetToSampleData() {
    }*/

    @Test
    void getInfectedFromTestData() throws IOException {
       List<Infected> infecteds =  SampleDataImporter.getInfectedFromTestData();
       Infected testInfected = new Infected();
       testInfected.setFirstName("Beau");
       testInfected.setLastName("Mcbride");
       testInfected.setGender(Infected.Gender.DIVERSE);
       testInfected.setDateOfBirth(TimeConverter.convertLocalDateToDate(LocalDate.parse("1862-04-14", DateTimeFormatter.ISO_LOCAL_DATE)));           //14,04,1862 Format: dd,mm,yyyy
       testInfected.setDateOfIllness(TimeConverter.convertLocalDateToDate(LocalDate.parse("2020-08-14", DateTimeFormatter.ISO_LOCAL_DATE)));         //14,08,2020
       testInfected.setDateOfDeath(TimeConverter.convertLocalDateToDate(LocalDate.parse("2019-09-19", DateTimeFormatter.ISO_LOCAL_DATE)));           //19,09,2019
       testInfected.setInfectionSource("nec metus facilisis");
       assertTrue(!infecteds.contains(testInfected));
    }

    @Test
    void getRandomPartitionOfList() {
        List<List<String>> emailListPartition = SampleDataImporter.getRandomPartitionOfList(getEmailAddresses(), 3);
        assertTrue(emailListPartition.size() >= 2 && emailListPartition.size() <= 7);
        List<String> emailListActual = new ArrayList<>(7);
        for (List<String> emailList : emailListPartition){
            emailListActual.addAll(emailList);
        }
        assertTrue(getEmailAddresses().containsAll(emailListActual));
    }

    private List<String> getEmailAddresses(){
        ArrayList<String> emailList = new ArrayList<String>(7);
        emailList.add("Nunc.ut@feugiatnon.ca");
        emailList.add("nec.eleifend@litoratorquent.net");
        emailList.add("sodales@AliquamnislNulla.com");
        emailList.add("sit.amet@convallis.com");
        emailList.add("lorem.ac@lacusMauris.ca");
        emailList.add("Nunc@Donecconsectetuermauris.edu");
        emailList.add("lectus.ante@maurisrhoncus.net");
        return emailList;
    }
}