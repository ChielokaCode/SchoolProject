package org.school.schoolproject.services;

import org.school.schoolproject.entities.Book;
import org.school.schoolproject.entities.Courses;
import org.school.schoolproject.entities.Person;

import java.util.List;


public interface TeacherServices {

    //TEACHER CAN PASS OR FAIL STUDENTS BASED ON COURSE AVERAGE
    String passOrFailStudents(Courses courses);

    //List<RequestInfo> requestBook(Person teacher, Book book);
}
