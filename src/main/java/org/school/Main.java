package org.school;

import org.school.schoolproject.entities.Courses;
import org.school.schoolproject.entities.Person;
import org.school.schoolproject.servicesImplement.CourseServiceImplements;
import org.school.schoolproject.servicesImplement.PrincipalServiceImplements;
import org.school.schoolproject.servicesImplement.TeacherServiceImplements;
import org.school.schoolproject.util.StudentUtil;
import org.school.schoolproject.util.TeacherUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        PrincipalServiceImplements principalService = new PrincipalServiceImplements();
        TeacherServiceImplements teacherService = new TeacherServiceImplements();
        CourseServiceImplements courseService = new CourseServiceImplements();
        StudentUtil studentUtil = new StudentUtil();
        TeacherUtil teacherUtil = new TeacherUtil();
        Courses courses = new Courses();



        //////SCHOOL SYSTEM STARTS/////////////
        System.out.println("Bright International Secondary School Management App Start...!");
        System.out.println();

        ////TO VIEW TEACHER DETAILS////
        System.out.println("TEACHERS PRESENT IN SCHOOL");
        Person teacher1 = Person.builder().firstName("Emmanuel").lastName("James").build();
        Person teacher2 = Person.builder().firstName("Sam").lastName("Felix").build();

        List<Person> listOfTeachers = new ArrayList<>(Arrays.asList(teacher1,teacher2));
        for(Person teacher : listOfTeachers){
            System.out.print(teacher.getFirstName());
            System.out.print(" ");
            System.out.println(teacher.getLastName());
        }

        /////COURSES TEACHER TEACHES AND IF TEACHER IS EMPLOYABLE OR NOT
        System.out.println();
        courseService.coursesTaughtByTeacher(courses);
        System.out.println(principalService.employTeachers(courses));

        /////STUDENTS PRESENT IN SCHOOL///
        System.out.println();
        System.out.println("STUDENTS PRESENT IN SCHOOL");
        Person student1 = Person.builder().firstName("Felix").lastName("Ozo").build();
        Person student2 = Person.builder().firstName("Emeka").lastName("Matthew").build();

        List<Person> listOfStudents = new ArrayList<>(Arrays.asList(student1,student2));
        for(Person student : listOfStudents){
            System.out.print(student.getFirstName());
            System.out.print(" ");
            System.out.println(student.getLastName());
        }

        //COURSES STUDENT TAKES
        System.out.println();
        courseService.courseStudentTakes(courses);

        //TO CHECK IF STUDENT PASSES OR FAILS COURSE BASED ON COURSE AVERAGE
        System.out.println();
        System.out.println("Student Course Average is "+ courses.calCourseAverage() + "%");
        System.out.println(teacherService.passOrFailStudents(courses));

        //TO EXPEL A STUDENT IF COURSE AVERAGE IS BELOW 30%
        System.out.println(principalService.expelStudents(courses));

        //TO ADMIT A STUDENT BASED ON AGE
        System.out.println();
        System.out.println(principalService.admitApplicants(15));
        System.out.println();


        /////READ INPUT, CREATED OBJECTS AND UPDATED INFO FROM EXCEL FILE(CSV FORMAT)
        System.out.println("LIST OF STUDENTS PRESENT IN FILE");
        studentUtil.readStudentFiles();
        System.out.println(" ");
        System.out.println("LIST OF TEACHERS PRESENT IN FILE");
        teacherUtil.readTeacherFiles();











    }
}