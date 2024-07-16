package com.cydeo.jsonData;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonToPOJOReader {

    @Test
    public void test01() throws FileNotFoundException {

        Gson gson = new Gson();

        FileReader reader = new FileReader("/Users/oscar/IdeaProjects/AutomationTopicsWithOscar/src/test/java/com/cydeo/jsonData/testData.json");

        Product testProduct = gson.fromJson(reader, Product.class);

        System.out.println("testProduct = " + testProduct);

        System.out.println(testProduct.getProductName());

    }
   @Test
    public void test02() throws FileNotFoundException {
        Gson gson = new Gson();

        FileReader reader = new FileReader("/Users/oscar/IdeaProjects/AutomationTopicsWithOscar/src/test/java/com/cydeo/jsonData/bigData.json");

        BigData bigData = gson.fromJson(reader, BigData.class);
       // System.out.println("bigData = " + bigData);

       Assertions.assertEquals(4,bigData.products.get(1).prices.get(1).getNumberOfInstallments());
    }
}
