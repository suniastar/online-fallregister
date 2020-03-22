package de.coronavirus.application.util;

import com.google.gson.stream.JsonReader;
import de.coronavirus.domain.model.Infected;

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
        reader.nextName();
        return readValuesOutOfJsonArray(reader);
    }


    public List<List<String>> readArrayValuesOutFromSecondArray(JsonReader reader) throws IOException {
        List<List<String>> listOfValueLists = new LinkedList<List<String>>();
        reader.beginObject();
        reader.nextName();
        reader.beginArray();
        while(reader.hasNext()){
            reader.nextString();
        }
        reader.endArray();
        reader.nextName();
        reader.beginArray();
        while(reader.hasNext()) {
            listOfValueLists.add(readValuesOutOfJsonArray(reader));
        }
        return listOfValueLists;
    }

    public List<String> readValuesOutOfJsonArray(JsonReader reader) throws IOException {
        List<String> values = new LinkedList<String>();
        reader.beginArray();
        while (reader.hasNext()) {
            values.add(reader.nextString());
        }
        return values;
    }

    public List<ComplexJsonDataUnwrapper.KeyValue> reconstructSimpleJsonKeyValue(List<String> keys, List<List<String>> listOfListWithValues) {
        List<ComplexJsonDataUnwrapper.KeyValue> keyValueList = new LinkedList<ComplexJsonDataUnwrapper.KeyValue>();
        // assert that the values can be evenly distributed to keys
        for (List<String> listOfValues  : listOfListWithValues) {
            for(String value : listOfValues) {
                keyValueList.add(new ComplexJsonDataUnwrapper.KeyValue("", value));
            }
        }
        for(int i = 0; i < keyValueList.size(); i++) {
            keyValueList.get(i).setKey(keys.get(i % keys.size()));
        }
        return keyValueList;
    }


    public class KeyValue {
        private String key;
        private String value;

        public KeyValue(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public KeyValue() {
            this.key = "";
            this.value = "";
        }

        public void setKey(String key) {
            this.key = key;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
}
