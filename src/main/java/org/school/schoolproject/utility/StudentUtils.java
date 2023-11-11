package org.school.schoolproject.utility;

import org.school.schoolproject.entities.Person;
import org.school.schoolproject.enums.Roles;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentUtils {
    //public static Person student;
    public static List<Person> listOfJuniorStudent = new ArrayList<>();
    public static List<Person> listOfSeniorStudent = new ArrayList<>();

    public void readStudentFiles(String file){
        //LINE TO RECEIVE INFO FROM FILE
        String line;

       try( ////BUFFERED READER READS FILE
        FileReader filePath = new FileReader(file);
        BufferedReader reader = new BufferedReader(filePath);)
       {
           ////CHECK IF HEADER OF FILE IS TRUE, THEN JUMPS OVER IT
           boolean isHeader = true;

           while ((line = reader.readLine()) != null) {
               if (isHeader) {
                   isHeader = false;
                   continue;
               }

               String[] rows = line.split(",", -1);

               ///IF COL IS EMPTY OR IS NULL, REPLACE WITH NULL
               for (int i = 0; i < rows.length; i++) {
                   if (rows[i].isBlank()) {
                       rows[i] = null;
                   }
               }

               ///UPDATE FIELDS TO STUDENT OBJECTS
               String ID = rows[0];
               String firstName = rows[1];
               String lastName = rows[2];
               Integer gradeLevel = Integer.parseInt(rows[3]);
               String email = rows[4];
               String guardianEmail1 = rows[5];
               String guardianEmail2 = rows[6];
               String isArchived = rows[7];
               String isDeleted = rows[8];


               Person student = Person.builder()
                       .gradeLevel(gradeLevel)
                       .build();

               if(student.getGradeLevel() >= 3) {
                   student = Person.builder()
                           .ID(ID)
                           .firstName(firstName)
                           .lastName(lastName)
                           .gradeLevel(gradeLevel)
                           .emailAddress(email)
                           .guardianEmail1(guardianEmail1)
                           .guardianEmail2(guardianEmail2)
                           .isArchived(isArchived)
                           .isDeleted(isDeleted)
                           .role(Roles.SENIOR_STUDENT)
                           .build();
                   listOfSeniorStudent.add(student);
               }else {
                   student = Person.builder()
                           .ID(ID)
                           .firstName(firstName)
                           .lastName(lastName)
                           .gradeLevel(gradeLevel)
                           .emailAddress(email)
                           .guardianEmail1(guardianEmail1)
                           .guardianEmail2(guardianEmail2)
                           .isArchived(isArchived)
                           .isDeleted(isDeleted)
                           .role(Roles.JUNIOR_STUDENT)
                           .build();
                   listOfJuniorStudent.add(student);
               }

               //listOfStudents.add(student);

           }

           ///DISPLAY LIST OF STUDENTS
           for(Person juniorStudent : listOfJuniorStudent){
               System.out.println(juniorStudent);
           }
           for(Person seniorStudent : listOfSeniorStudent){
               System.out.println(seniorStudent);
           }


       }catch (IOException e){
           e.printStackTrace();
       }
    }

    public void writeStudentInfoToFile(String fileName){

        try (
                FileWriter fileWriter = new FileWriter(fileName);
                BufferedWriter writer = new BufferedWriter(fileWriter);
        )
        {
           for(Person juniorStudent : listOfJuniorStudent){
               writer.write(String.valueOf(juniorStudent));
               writer.newLine();
           }
            for(Person seniorStudent : listOfSeniorStudent){
                writer.write(String.valueOf(seniorStudent));
                writer.newLine();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}




