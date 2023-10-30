package org.school.schoolproject.util;

import org.school.schoolproject.entities.Person;
import org.school.schoolproject.enums.Roles;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TeacherUtil {
    public List<Person> listOfTeachers = new ArrayList<>();

    public void readTeacherFiles() throws IOException {
        //LINE TO RECEIVE INFO FROM FILE
        String line;

        ////BUFFERED READER READS FILE
        BufferedReader reader = new BufferedReader(new FileReader("/Users/wikiwoo/Desktop/JavaTuts/week-1-ChielokaCode/src/main/java/org/school/schoolproject/file/teacher-data.csv"));


        ////CHECK IF HEADER OF FILE IS TRUE, THEN JUMPS OVER IT
        boolean isHeader = true;
        while ((line = reader.readLine()) != null) {
            if (isHeader) {
                // Skip the header row
                isHeader = false;
                continue;
            }


            String[] col = line.split(",");


            ///UPDATE FIELDS TO STUDENT OBJECTS
            String ID = col[0];
            String email = col[1];
            String firstName = col[2];
            String lastName = col[3];

            Person teacher = Person.builder()
                    .ID(ID)
                    .emailAddress(email)
                    .firstName(firstName)
                    .lastName(lastName)
                    .role(Roles.TEACHER)
                    .build();

            listOfTeachers.add(teacher);
        }

        ///DISPLAY LIST OF STUDENTS
        for (Person teacher : listOfTeachers) {
            System.out.println(teacher);
        }
    }
}
