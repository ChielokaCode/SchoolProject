package org.school;

import org.school.schoolproject.entities.Book;
import org.school.schoolproject.entities.Courses;
import org.school.schoolproject.entities.Person;
import org.school.schoolproject.enums.Roles;
import org.school.schoolproject.services.BookNotAvailableException;
import org.school.schoolproject.servicesImplement.*;
import org.school.schoolproject.utility.StudentUtils;
import org.school.schoolproject.utility.TeacherUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws BookNotAvailableException {

        PrincipalServiceImplements principalService = new PrincipalServiceImplements();
        TeacherServiceImplements teacherService = new TeacherServiceImplements();
        CourseServiceImplements courseService = new CourseServiceImplements();
        LibraryServiceImplements1 libraryService = new LibraryServiceImplements1();
        StudentUtils studentUtil = new StudentUtils();
        TeacherUtils teacherUtil = new TeacherUtils();
        Courses courses = new Courses();



        //////SCHOOL SYSTEM STARTS/////////////
        System.out.println("Bright International Secondary School Management App Start...!");
        System.out.println();

        ////TO VIEW TEACHER DETAILS////
        System.out.println("TEACHERS PRESENT IN SCHOOL");
        Person teacher1 = Person.builder().firstName("Emmanuel").lastName("James").role(Roles.TEACHER).build();
        Person teacher2 = Person.builder().firstName("Sam").lastName("Felix").role(Roles.TEACHER).build();

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
        Person student1 = Person.builder().firstName("Felix").lastName("Ozo").role(Roles.JUNIOR_STUDENT).build();
        Person student2 = Person.builder().firstName("Emeka").lastName("Matthew").role(Roles.SENIOR_STUDENT).build();

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


        ///READ INPUT, CREATED OBJECTS AND UPDATED INFO FROM EXCEL FILE(CSV FORMAT)
        System.out.println("LIST OF STUDENTS PRESENT IN FILE");

        studentUtil.readStudentFiles("/Users/wikiwoo/Desktop/JavaTuts/week-3-ChielokaCode/src/main/java/org/school/schoolproject/file/student-data-seeding1.csv");
        System.out.println(" ");

        System.out.println("LIST OF TEACHERS PRESENT IN FILE");
        teacherUtil.readTeacherFiles("/Users/wikiwoo/Desktop/JavaTuts/week-3-ChielokaCode/src/main/java/org/school/schoolproject/file/teacher-data.csv");


        ////WRITE STUDENT INFO TO CREATED FILE ON SYSTEM
        System.out.println();
        studentUtil.writeStudentInfoToFile("/Users/wikiwoo/Desktop/JavaTuts/week-3-ChielokaCode/src/main/java/org/school/schoolproject/file/student-output1.csv");

        ////WRITE TEACHER INFO TO CREATED FILE ON SYSTEM
        System.out.println();
        teacherUtil.writeTeacherInfoToFile("/Users/wikiwoo/Desktop/JavaTuts/week-3-ChielokaCode/src/main/java/org/school/schoolproject/file/teacher-output1.csv");

//////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////LIBRARY/////////////////////////////////////////////////
        Book book1 = new Book("The Earth", 2);
        Book book2 = new Book("The Planet", 3);

        System.out.println("************LIBRARY*************");
        System.out.println();

        libraryService.addBook.accept(book1);
        libraryService.addBook.accept(book2);
        System.out.println("************************************************");
        System.out.println("IMPLEMENTATION 1 - TEACHER WITH PRIORITY");
        System.out.println("************************************************");
        System.out.println("REQUEST MADE FOR PRIORITY");
        System.out.println();

        libraryService.makePriorityRequest.accept(student1, "The Earth");
        libraryService.makePriorityRequest.accept(teacher1, "The Earth");
        libraryService.makePriorityRequest.accept(student2, "The Earth");
        System.out.println();

        /////ISSUE BOOK TO TEACHER WITH PRIORITY
        System.out.println("REQUEST GRANTED");
        System.out.println();
        libraryService.grantPriorityRequest.grantFunction();
        System.out.println();
        System.out.println("************************************************");
        System.out.println("IMPLEMENTATION 2 - FIRST COME FIRST SERVE");
        System.out.println("************************************************");
        System.out.println("REQUEST MADE FOR FIFO");
        System.out.println();

        libraryService.makeFifoRequest.accept(student2, "The Planet");
        libraryService.makeFifoRequest.accept(teacher2, "The Planet");
        libraryService.makeFifoRequest.accept(student1, "The Planet");
        System.out.println();

        ////FIRST COME FIRST SERVE
        System.out.println("REQUEST GRANTED");
        System.out.println();

        libraryService.grantFifoRequest.grantFunction();

    }
}
