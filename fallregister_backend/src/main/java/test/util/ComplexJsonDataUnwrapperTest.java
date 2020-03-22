package test.util;

import com.google.gson.stream.JsonReader;
import de.coronavirus.application.util.ComplexJsonDataUnwrapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class ComplexJsonDataUnwrapperTest {

    private ComplexJsonDataUnwrapper unwrapper = new ComplexJsonDataUnwrapper();
    private String objectWithValuesString = objectWithValuesString();

    @BeforeEach
    void setUp() {
        unwrapper = new ComplexJsonDataUnwrapper();
        objectWithValuesString = objectWithValuesString();
    }

    @AfterEach
    void tearDown() {
        unwrapper = null;
        objectWithValuesString = null;
    }


    /**
     * Test if and only if readValuesOutOfJsonArray() is able of parsing a Json Arrays values to a list,
     * where firstName, lastName and so on are the values to pass in a list
     *
     * "cols": [ // Pass the following to a List
     * 		"firstName",
     * 		"lastName",
     * 		"gender",
     * 		"dateOfBirth",
     * 		"dateOfIllness",
     * 		"dateOfDeath",
     * 		"infectionSource"
     * 	]
     */
    @Test
    void readValuesOutOfJsonArray() {
        try (StringReader stringReader = new StringReader(objectWithValuesString)){
            List<String> actual = unwrapper.readValuesOutOfJsonArray(new JsonReader(stringReader));
            List<String> expected = objectWithValuesStringToList();
            assertTrue(actual.containsAll(expected));
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Tests if and only if readArrayValuesOutFromSecondArrayString() is able of parsing an Json-array in an Json-object
     * like the previous test readValuesOutOfJsonArray() but only an array within an object
     *
     * {
     * 	"cols": [ // Pass the following to a List
     * 		"firstName",
     * 		"lastName",
     * 		"gender",
     * 		"dateOfBirth",
     * 		"dateOfIllness",
     * 		"dateOfDeath",
     * 		"infectionSource"
     * 	  ]
     * 	}
     */
    @Test
    void readValuesFromFirstArrayInObject() {
        try (StringReader stringReader = new StringReader(readArrayValuesOutFromSecondArrayString())){
            List<String> actual = unwrapper.readValuesFromFirstArrayInObject(new JsonReader(stringReader));
            List<String> expected = keysFromFirstObjectStringToList();
            assertTrue(actual.containsAll(expected));
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Tests if and only if readArrayValuesOutFromSecondArray() is able of parsing the arrayS in the second array
     * in the given example object to a list of list of array values
     *
     *{
     * 	"cols": [
     * 		"firstName",
     * 		"lastName",
     * 		"gender",
     * 		"dateOfBirth",
     * 		"dateOfIllness",
     * 		"dateOfDeath",
     * 		"infectionSource"
     * 	],
     * 	"data": [
     * 		[   // Pass the following to a List
     * 			"Beau",
     * 			"Mcbride",
     * 			"DIVERSE",
     * 			"14,04,1862",
     * 			"14,08,2020",
     * 			"19,09,2019",
     * 			"nec metus facilisis"
     * 		]
     * 	}
     */
    @Test
    void readArrayValuesOutFromSecondArray() {
        try (StringReader stringReader = new StringReader(readArrayValuesOutFromSecondArrayString())){
            List<List<String>> actual = unwrapper.readArrayValuesOutFromSecondArray(new JsonReader(stringReader));
            List<String> expected = readArrayValuesOutFromSecondArrayToList();
            assertTrue(actual.get(0).containsAll(expected));
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }



    private String objectWithValuesString() {
        return "[\n" +
                "\t\t\t\"Beau\",\n" +
                "\t\t\t\"Mcbride\",\n" +
                "\t\t\t\"DIVERSE\",\n" +
                "\t\t\t\"14,04,1862\",\n" +
                "\t\t\t\"14,08,2020\",\n" +
                "\t\t\t\"19,09,2019\",\n" +
                "\t\t\t\"nec metus facilisis\"\n" +
                "\t\t]";
    }

    private List<String> objectWithValuesStringToList() {
        List <String> values = new ArrayList<String>(7);
        values.add("Beau");
        values.add("Mcbride");
        values.add("DIVERSE");
        values.add("14,04,1862");
        values.add("14,08,2020");
        values.add("19,09,2019");
        values.add("nec metus facilisis");
        return values;
    }

    private String keysFromFirstObjectString() {
        return "{\n" +
                "\t\"cols\": [\n" +
                "\t\t\"firstName\",\n" +
                "\t\t\"lastName\",\n" +
                "\t\t\"gender\",\n" +
                "\t\t\"dateOfBirth\",\n" +
                "\t\t\"dateOfIllness\",\n" +
                "\t\t\"dateOfDeath\",\n" +
                "\t\t\"infectionSource\"\n" +
                "\t]," +
                "}";
    }

    private List<String> keysFromFirstObjectStringToList() {
        List <String> values = new ArrayList<String>(7);
        values.add("firstName");
        values.add("lastName");
        values.add("gender");
        values.add("dateOfBirth");
        values.add("dateOfIllness");
        values.add("dateOfDeath");
        values.add("infectionSource");
        return values;
    }

    private String readArrayValuesOutFromSecondArrayString() {
        return "{\n" +
                "\t\"cols\": [\n" +
                "\t\t\"firstName\",\n" +
                "\t\t\"lastName\",\n" +
                "\t\t\"gender\",\n" +
                "\t\t\"dateOfBirth\",\n" +
                "\t\t\"dateOfIllness\",\n" +
                "\t\t\"dateOfDeath\",\n" +
                "\t\t\"infectionSource\"\n" +
                "\t],\n" +
                "\t\"data\": [\n" +
                "\t\t[\n" +
                "\t\t\t\"Beau\",\n" +
                "\t\t\t\"Mcbride\",\n" +
                "\t\t\t\"DIVERSE\",\n" +
                "\t\t\t\"14,04,1862\",\n" +
                "\t\t\t\"14,08,2020\",\n" +
                "\t\t\t\"19,09,2019\",\n" +
                "\t\t\t\"nec metus facilisis\"\n" +
                "\t\t]," +
                "}";
    }

    private List<String> readArrayValuesOutFromSecondArrayToList() {
        return objectWithValuesStringToList();
    }

}