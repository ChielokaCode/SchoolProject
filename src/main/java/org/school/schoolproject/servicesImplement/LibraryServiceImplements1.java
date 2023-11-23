package org.school.schoolproject.servicesImplement;

import org.school.schoolproject.entities.Book;
import org.school.schoolproject.entities.PatronComparator;
import org.school.schoolproject.entities.Person;
import org.school.schoolproject.entities.RequestList;
import org.school.schoolproject.services.BookInterface;
import org.school.schoolproject.services.BookNotAvailableException;
import org.school.schoolproject.services.LibraryInterface;
import org.school.schoolproject.services.QueueInterface;

import java.util.*;
import java.util.function.Consumer;

public class LibraryServiceImplements1 {

    ////TWO QUEUE TO HOLD THE DIFFERENT REQUESTS
    PriorityQueue<RequestList> priorityRequest = new PriorityQueue<>(new PatronComparator());
    Queue<RequestList> fifoRequest = new LinkedList<>();


    ///////ADD BOOK TO LIBRARY
    public Consumer<Book> addBook = (book) -> {
        Book.bookAvailable.put(book.getName(), book.getQuantity());
        System.out.println(book.getName() + " has been added to Library. Quantity is " + book.getQuantity() );
    };

/////////////CHECK BOOK AVAILABILITY
    public BookInterface<Boolean, String> isBookAvailableInLibrary = (bookName) ->{
        Book.bookAvailable.putIfAbsent(bookName, 0);
        return Book.bookAvailable.getOrDefault(bookName, 0) > 0;
    };


    ////GET BOOK QUANTITY
    public BookInterface<Integer, String> getBookCount = (bookName) -> Book.bookAvailable.getOrDefault(bookName, 0);

       ////////REMOVE BOOK BY AMOUNT
        public QueueInterface<String, Integer> offLoad = (bookName, count) -> {
                int currentCount = getBookCount.bookFunction(bookName);
                if (currentCount >= count) {
                    Book.bookAvailable.put(bookName, currentCount - count);
                    System.out.println("Book quantity is now " + (currentCount-count));
                }
        };



    /////////////ADD REQUEST FOR PRIORITY
    public QueueInterface<Person, String> makePriorityRequest = (person, book) -> {
        if(isBookAvailableInLibrary.bookFunction(book)) {
            priorityRequest.add(new RequestList(person, book));
            System.out.println("Request has been ADDED for " + person.getFirstName() + " a " + person.getRole() + ", Book Title: " + book);
        } else {
            System.out.println(book + " is not Available");
        }

    };


    /////////////ADD REQUEST FOR PRIORITY
    public QueueInterface<Person, String> makeFifoRequest = (person, book) -> {
        if(isBookAvailableInLibrary.bookFunction(book)){
            fifoRequest.add(new RequestList(person, book));
            System.out.println("Request has been ADDED for " + person.getFirstName() + " a " + person.getRole() + ", Book Title: " + book);
        } else {
            System.out.println(book + " is not Available");
        }
    };




    ///ISSUED BOOK BASED ON FIRST COME FIRST SERVE BASIS
    public LibraryInterface grantFifoRequest = () -> {
        System.out.println();
        fifoRequest
                .forEach(request -> {
                    try {
                        if (isBookAvailableInLibrary.bookFunction(request.getBookName())) {
                            offLoad.accept(request.getBookName(), 1);
                            System.out.println("Issued '" + request.getBookName() + "' to " + request.getPerson().getRole());
                        } else {
                            throw new BookNotAvailableException("Book not available: " + request.getBookName());
                        }
                    } catch (BookNotAvailableException e) {
                        try {
                            throw new BookNotAvailableException("Book not available: " + request.getBookName());
                        } catch (BookNotAvailableException ex) {
                            throw new RuntimeException(ex);
                        }
                        // You can handle the exception as needed, e.g., log it, notify the user, etc.
                    }
                });
    };


    ///ISSUED BOOK TO TEACHER WITH HIGHEST PRIORITY
    public LibraryInterface grantPriorityRequest = () ->{
        while (!priorityRequest.isEmpty()) {
            RequestList request = priorityRequest.poll();
            String bookTitle = request.getBookName();
            if (isBookAvailableInLibrary.bookFunction(bookTitle)) {
                System.out.println("Issued " + bookTitle + " with Priority to "+ request.getPerson().getRole());
                offLoad.accept(bookTitle, 1);
            }else {
                System.out.println();
               throw new BookNotAvailableException("Book not Available");
            }

    }
    };
    }

