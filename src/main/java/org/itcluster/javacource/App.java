package org.itcluster.javacource;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Hello JSON world!
 *
 */
public class App {

    private static ObjectMapper mapper = new ObjectMapper();
    static {
// you need to register the datatype support offered by this library into you objectmapper object
        mapper.findAndRegisterModules();
    }

    public static void main( String[] args ) throws IOException {
        studentExample();
        groupExample();
        collectionExample();
    }

    private static void studentExample() throws IOException {
        Student student = new Student("Emma", "Watson", LocalDate.of(1990, 4, 15), 4.5, "notes");

        // Object to JSON in String
        String jsonInString = mapper.writeValueAsString(student);

        // Object to JSON in file
//         mapper.writeValue(new File("student.json"), student);

        System.out.println(jsonInString);

        //JSON from String to Object
        Student student2 = mapper.readValue(jsonInString, Student.class);
        System.out.println(student2);


        // JSON from file to Object
        // Student obj = mapper.readValue(new File("student.json"), Student.class);

        //JSON from URL to Object
        // Student obj = mapper.readValue(new URL("http://your.host.location/api/staff.json"), Student.class);

    }

    private static void groupExample() throws IOException {
        List<Student> students = Arrays.asList(
                new Student("Emma", "Watson", LocalDate.of(1990, 4, 15), 4.5, "notes"),
                new Student("Daniel", "Radcliffe ", LocalDate.of(1989, 7, 23), 3.5, "notes one more"),
                new Student("Rupert", "Grint", LocalDate.of(1988, 8, 24), 3.5, "no notes")
                );

        Group group = new Group(
                "Griffindor Stars",
                new Student("Percy", "Weasley", null, 0, null),
                students);

        String jsonInString = mapper.writeValueAsString(group);

        System.out.println(jsonInString);

        Group group2 = mapper.readValue(jsonInString, Group.class);
        System.out.println(group2);
    }


    private static void collectionExample() throws IOException {
        List<Student> students = Arrays.asList(
                new Student("Emma", "Watson", LocalDate.of(1990, 4, 15), 4.5, "notes"),
                new Student("Daniel", "Radcliffe ", LocalDate.of(1989, 7, 23), 3.5, "notes one more"),
                new Student("Rupert", "Grint", LocalDate.of(1988, 8, 24), 3.5, "no notes")
        );

        String jsonInString = mapper.writeValueAsString(students);
        System.out.println(jsonInString);

//        Not good!!! We've got the List of Maps not the List of Students
        List objects = mapper.readValue(jsonInString, List.class);


        JavaType studentsListType = mapper.getTypeFactory().constructCollectionType(List.class, Student.class);
        List<Student> students2 = mapper.readValue(jsonInString, studentsListType);
        for (Student student : students2) {
            System.out.println(student);
        }
    }
}
