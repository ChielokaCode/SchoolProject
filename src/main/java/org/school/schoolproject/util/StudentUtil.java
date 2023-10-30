package org.school.schoolproject.util;

import org.school.schoolproject.entities.Person;
import org.school.schoolproject.enums.Roles;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentUtil {
    public static List<Person> listOfStudents = new ArrayList<>();

    public void readStudentFiles() throws IOException {
        //LINE TO RECEIVE INFO FROM FILE
        String line;

        ////BUFFERED READER READS FILE
        FileReader filePath = new FileReader("/Users/wikiwoo/Desktop/JavaTuts/week-1-ChielokaCode/src/main/java/org/school/schoolproject/file/student-data-seeding1.csv");
        BufferedReader reader = new BufferedReader(filePath);

        ////CHECK IF HEADER OF FILE IS TRUE, THEN JUMPS OVER IT
        boolean isHeader = true;

        while ((line = reader.readLine()) != null) {
            if (isHeader) {
                isHeader = false;
                continue;
            }

            String[] col = line.split(",", -1);

            ///IF COL IS EMPTY OR IS NULL, REPLACE WITH NULL
            for (int i = 0; i < col.length; i++) {
                if (col[i].isEmpty() || col[i] == null) {
                    col[i] = null;
                }
            }

            ///UPDATE FIELDS TO STUDENT OBJECTS
            String ID = col[0];
            String firstName = col[1];
            String lastName = col[2];
            Integer gradeLevel = Integer.parseInt(col[3]);
            String email = col[4];
            String guardianEmail1 = col[5];
            String guardianEmail2 = col[6];
            String isArchived = col[7];
            String isDeleted = col[8];


            Person student = Person.builder()
                    .ID(ID)
                    .firstName(firstName)
                    .lastName(lastName)
                    .gradeLevel(gradeLevel)
                    .emailAddress(email)
                    .guardianEmail1(guardianEmail1)
                    .guardianEmail2(guardianEmail2)
                    .isArchived(isArchived)
                    .isDeleted(isDeleted)
                    .role(Roles.STUDENT)
                    .build();

            listOfStudents.add(student);

        }
        ///DISPLAY LIST OF STUDENTS
        for (Person student : listOfStudents) {
            System.out.println(student);
        }
    }
}




