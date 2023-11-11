package org.school.schoolproject.example;

import org.school.schoolproject.entities.Person;

import java.util.ArrayList;
import java.util.List;

public interface DefaultServices<P, C> {

    P addNewData(C person);
    C setNewData(C c);
}
