package com.cydeo.jsonData;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

public class JsonReader {
    /*
    The purpose of this class is to read JSON files
    We are using Object mappers either GSON or Jackson Library/dependency
     */
    public static void main(String[] args) {

        Gson gson = new Gson();

        String rootPath = System.getProperty("user.dir");

        try {
            FileReader reader = new FileReader("/Users/oscar/IdeaProjects/AutomationTopicsWithOscar/src/test/java/com/cydeo/jsonData/valData.json");
       // put absolute path in file reader
            Map<String,Object> qaDataMap = gson.fromJson(reader, Map.class);

           // System.out.println("qaDataMap = " + qaDataMap);

            System.out.println(qaDataMap.get("hobbies"));

           List<String> hobbies = (List<String>) qaDataMap.get("hobbies");

            System.out.println(hobbies.get(0));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
