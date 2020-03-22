package de.coronavirus.application.util;

import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * The point of this Class is to unwrap Json-structures like the following:
 * {
 * 	"keys": [
 * 		"key1",
 * 		"key2",
 * 		....
 * 	],
 * 	"values": [
 * 		[
 * 			"value1",
 * 			"value2",
 * 			....
 * 		],
 * 	}
 */
public class ComplexJsonDataUnwrapper {



    public List<String> readValuesFromFirstArrayInObject(JsonReader reader) throws IOException {
        reader.beginObject();
        return readValuesOutOfJsonArray(reader);
    }


    public List<List<String>> readArrayValuesOutFromSecondArray(JsonReader reader) throws IOException {
        List<List<String>> listOfValueLists = new LinkedList<List<String>>();
        reader.beginObject();
        while(reader.hasNext()) {
            listOfValueLists.add(readValuesOutOfJsonArray(reader));
        }
        return listOfValueLists;
    }

    public List<String> readValuesOutOfJsonArray(JsonReader reader) throws IOException {
        List<String> values = new LinkedList<String>();
        reader.nextName();
        reader.beginArray();
        while (reader.hasNext()) {
            values.add(reader.nextString());
        }
        return values;
    }
}
