package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Scanner in = new Scanner(Paths.get("input.txt"));
        exam exam1 = new exam();
        exam exam2 = new exam();
        exam exam3 = new exam();
        exam1.input(in);
        exam2.input(in);
        exam3.input(in);
        ArrayList<exam> exams = new ArrayList<>();
        exams.add(exam1);
        exams.add(exam2);
        exams.add(exam3);
        //String json = mapper.writeValueAsString(exams);
        //System.out.println(json);
        mapper.writeValue(new File("output.json"), exams);

        ObjectMapper mapper_ = new ObjectMapper();
        String json_ = "[{\"subject\":\"mathematical analysis\",\"mark\":8},{\"subject\":\"programming\",\"mark\":9},{\"subject\":\"foreign language\",\"mark\":8}]";
        List<exam> exams_ = mapper_.readValue(json_, new TypeReference<>(){});
        exams_.forEach(e-> System.out.println(e.getSubject() + " " + e.getMark()));
        //System.out.println(exams_.size());
    }
}