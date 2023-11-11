package org.school.schoolproject.utility;

import org.school.schoolproject.entities.Person;
import org.school.schoolproject.enums.Roles;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherUtils {
   public static Person teacher = new Person();
    public static List<Person> listOfTeachers = new ArrayList<>();

    public void readTeacherFiles(String file){
        //LINE TO RECEIVE INFO FROM FILE
        String line;

        try(////BUFFERED READER READS FILE
        BufferedReader reader = new BufferedReader(new FileReader(file));)
        {
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

                teacher = Person.builder()
                        .ID(ID)
                        .emailAddress(email)
                        .firstName(firstName)
                        .lastName(lastName)
                        .role(Roles.TEACHER)
                        .build();

                listOfTeachers.add(teacher);
            }

            ///DISPLAY LIST OF TEACHERS
            for (Person teacher : listOfTeachers) {
                System.out.println(teacher);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeTeacherInfoToFile(String fileName){

        try (
                FileWriter fileWriter = new FileWriter(fileName);
                BufferedWriter writer = new BufferedWriter(fileWriter);
        )
        {
            for(Person teacher : listOfTeachers){
                writer.write(String.valueOf(teacher));
                writer.newLine();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public String getTeacherById(int id){
//        String teacherID = null;
//        for (int i = 0; i < listOfTeachers.size(); i++){
//            teacherID = String.valueOf(listOfTeachers.get(id));
//        }
//        return teacherID;
//    }
}
