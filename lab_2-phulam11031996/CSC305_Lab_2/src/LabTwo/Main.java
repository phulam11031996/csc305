package LabTwo;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

class Main {

    public static void main(String[] args) throws IOException {
        String[] fileNames = new String[] { "input1.json", "input2.json", "input3.json" };

        ObjectMapper mapper = new ObjectMapper();
        for (String fileName : fileNames) {
            Person tmpPerson = mapper.readValue(new File(fileName), Person.class);
            System.out.println(tmpPerson);
        }

    }
}


    