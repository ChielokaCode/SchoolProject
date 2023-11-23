package org.school.schoolproject.servicesImplement;


import org.junit.jupiter.api.Test;
import org.school.schoolproject.entities.Book;
import org.school.schoolproject.entities.Person;
import org.school.schoolproject.enums.Roles;
import static org.junit.jupiter.api.Assertions.*;


public class LibraryServiceImplements1Test {
     public static LibraryServiceImplements1 libraryService = new LibraryServiceImplements1();


    @Test
    public void testAddBook() {
        Book book = new Book("TestBook", 5);
        libraryService.addBook(book);
        assertTrue(libraryService.isBookAvailableInLibrary(book.getName()));
        assertEquals(5, libraryService.getBookCount(book.getName()));
    }

    @Test
    public void testIsBookAvailableInLibrary() {
        assertFalse(libraryService.isBookAvailableInLibrary("NonExistentBook"));
    }

    @Test
    public void testGetBookCountTestOne() {
        assertEquals(0, libraryService.getBookCount("NonExistentBook"));
    }
    @Test
    public void testGetBookCountTestTwo() {
        Book book1 = new Book("The Earth", 5);
        libraryService.addBook(book1);
        assertEquals(book1.getQuantity(), libraryService.getBookCount(book1.getName()));
    }

    @Test
    public void testOffLoad() {
        Book book = new Book("The President", 3);
        libraryService.addBook(book);
        libraryService.offLoad(book.getName(), 2);
        assertEquals(1, libraryService.getBookCount(book.getName()));
        libraryService.offLoad(book.getName(), 1);
        assertEquals(0, libraryService.getBookCount(book.getName()));
    }

    @Test
    public void testPriorityRequest() {
        Person person = new Person("John", Roles.TEACHER);
        Book book = new Book("The Snake", 2);
        libraryService.priorityRequest(person, book.getName());
        assertEquals(1, libraryService.priorityRequest.size());
    }

    @Test
    public void testFifoRequest() {
        Person person = new Person("Jane", Roles.SENIOR_STUDENT);
        Book book = new Book("The Lion", 3);
        libraryService.fifoRequest(person, book.getName());
        assertEquals(1, libraryService.fifoRequest.size());
    }

    @Test
    public void testGrantPriorityRequest() {
        Person teacher = new Person("Teacher", Roles.TEACHER);
        Book book = new Book("The Ambassador", 2);
        libraryService.addBook(book);
        libraryService.priorityRequest(teacher, book.getName());
        assertEquals(1, libraryService.priorityRequest.size());
        assertEquals(book.getQuantity(), libraryService.getBookCount(book.getName()));

    }

    @Test
    public void testGrantFifoRequest() {
        Person student = new Person("Student", Roles.JUNIOR_STUDENT);
        Book book = new Book("My Sunlight", 3);
        libraryService.addBook(book);
        libraryService.fifoRequest(student, book.getName());
        assertEquals(1, libraryService.fifoRequest.size());
        assertEquals(book.getQuantity(), libraryService.getBookCount(book.getName()));
    }
}

