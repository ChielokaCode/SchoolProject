package org.school.schoolproject.services;

import org.school.schoolproject.entities.Book;
import org.school.schoolproject.entities.Person;
import org.school.schoolproject.entities.RequestList;
import org.school.schoolproject.enums.Roles;

import java.util.List;

public interface LibraryService<P, B> {
    boolean isBookAvailableInLibrary(String bookName);
    void addBook(Book book);
    void priorityRequest(Person person, String book);
    void fifoRequest(Person person, String book);
    void grantPriorityRequest();
    //void stockUpBook(Book book);
    //void checkBookAvailability();
    //boolean teacherWithPriority(List<P> teacher, List<P> seniorStudent, B book);
   // boolean seniorStudentWithPriority(List<P> seniorStudent, List<P> juniorStudent, B book);

    //boolean firstComeFirstServe(List<P> teacher, List<P> seniorStudent, List<P> juniorStudent, B book);

}
