package org.school.schoolproject.servicesImplement;

import org.school.schoolproject.entities.Book;
import org.school.schoolproject.entities.PatronComparator;
import org.school.schoolproject.entities.Person;
import org.school.schoolproject.entities.RequestList;
import org.school.schoolproject.services.LibraryService;

import java.util.*;

public class LibraryServiceImplements1 implements LibraryService<Person, Book> {
    PriorityQueue<RequestList> priorityRequest = new PriorityQueue<>(new PatronComparator());
    Queue<RequestList> fifoRequest = new LinkedList<>();


    ///////ADD BOOK TO LIBRARY
    public void addBook(Book book) {
        Book.bookAvailable.put(book.getName(), book.getQuantity());
        System.out.println(book.getName() + " has been added to Library. Quantity is " + book.getQuantity() );
    }

/////////////CHECK BOOK AVAILABILITY
    public boolean isBookAvailableInLibrary(String bookName) {
        return Book.bookAvailable.getOrDefault(bookName, 0) > 0;
    }



    public int getBookCount(String bookName) {
       return Book.bookAvailable.getOrDefault(bookName, 0);

    }


        public void offLoad(String bookName, int count) {
                int currentCount = getBookCount(bookName);
                if (currentCount >= count) {
                    Book.bookAvailable.put(bookName, currentCount - count);
                    System.out.println("Book quantity is now " + (currentCount-count));
                }
                if (Book.bookAvailable.get(bookName) == 0) {
                System.out.println("Book All Taken");
            }
        }


    /////////////ADD REQUEST
    public void priorityRequest(Person person, String book) {
        if(isBookAvailableInLibrary(book)) {
            priorityRequest.add(new RequestList(person, book));
            System.out.println("Request has been ADDED for " + person.getFirstName() + " a " + person.getRole() + ", Book Title: " + book);
        } else {
            System.out.println(book + " is not Available");
        }
    }

    public void fifoRequest(Person person, String book) {
        if(isBookAvailableInLibrary(book)) {
            fifoRequest.add(new RequestList(person, book));
            System.out.println("Request has been ADDED for " + person.getFirstName() + " a " + person.getRole() + ", Book Title: " + book);
        } else {
            System.out.println(book + " is not Available");
        }
    }

        /////ISSUED BOOK TO TEACHER WITH HIGHEST PRIORITY
    public void grantPriorityRequest() {
        while (!priorityRequest.isEmpty()) {
            RequestList request = priorityRequest.poll();
            String bookTitle = request.getBookName();
            if (isBookAvailableInLibrary(bookTitle)) {
                System.out.println("Issued " + bookTitle + " with Priority to "+ request.getPerson().getRole());
                offLoad(bookTitle, 1);
                System.out.println();
            }
    }
    }
    public void grantFifoRequest() {
        while (!fifoRequest.isEmpty()) {
            RequestList request = fifoRequest.poll();
            String bookTitle = request.getBookName();
            if (isBookAvailableInLibrary(bookTitle)) {
                System.out.println("Issued " + bookTitle + " to "+ request.getPerson().getRole());
                offLoad(bookTitle, 1);
                System.out.println();
            }
        }
    }
}

