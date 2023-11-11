package org.school.schoolproject.entities;

import org.school.schoolproject.enums.Roles;

import java.util.Comparator;

public class PatronComparator implements Comparator<RequestList> {
    @Override
    public int compare(RequestList person1, RequestList person2) {
        // Compare based on roles
        if (person1.getPerson().getRole() == Roles.TEACHER) {
            return -1; // person1 is a teacher, so it comes first
        } else if (person2.getPerson().getRole() == Roles.TEACHER) {
            return 1; // person2 is a teacher, so it comes first
        } else if (person1.getPerson().getRole() == Roles.SENIOR_STUDENT) {
            return -1; // person1 is a senior student, so it comes before junior students
        } else if (person2.getPerson().getRole() == Roles.SENIOR_STUDENT) {
            return 1; // person2 is a senior student, so it comes before junior students
        } else {
            return 0; // Both have the same role (junior student), order doesn't matter
        }
    }

//    @Override
//    public int compare(Person person1, Person person2) {
//        if (person1.getRole().ordinal()>person2.getRole().ordinal()){
//            return 1;
//        } else if (person1.getRole().ordinal()<person2.getRole().ordinal()) {
//            return -1;
//        }else {
//
//            return 0;
//        }
//    }
}


