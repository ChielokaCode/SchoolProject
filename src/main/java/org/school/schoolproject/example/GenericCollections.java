package org.school.schoolproject.example;

import org.school.schoolproject.entities.Person;

public class GenericCollections implements DefaultServices<Person, Company>{
    //todo: We use GENERICS FOR CODE RE-USEABILITY
    //TODO: WE CAN SET THE RETURN/DATA TYPES AS ANY ALPHABET AND USE IT IN ANY CLASS AS WHAT WE WANT THE ALPHABET TO BE OF
    //TODO: IN THE INTERFACE I USED <P, C> BUT IN THIS CLASS I MADE P BECOME PERSON AND C AS COMPANY
    @Override
    public Person addNewData(Company person) {
        return null;
    }

    @Override
    public Company setNewData(Company company) {
        return null;
    }
}
