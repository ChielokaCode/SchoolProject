package org.school.schoolproject.services;

public class BookNotAvailableException extends Exception {
   public BookNotAvailableException(String s){
      super(s);
   }
}
