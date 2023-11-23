package org.school.schoolproject.services;

@FunctionalInterface
public interface LibraryInterface {
        void grantFunction() throws BookNotAvailableException;
}
