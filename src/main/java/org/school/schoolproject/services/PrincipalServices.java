package org.school.schoolproject.services;

import org.school.schoolproject.entities.Courses;

public interface PrincipalServices<S, C> {

    ///PRINCIPAL ADMITS APPLICANTS(STUDENTS) BASED ON AGE//
    S admitApplicants(int age);

    //PRINCIPAL EMPLOYS TEACHER BASED ON THE NUMBER OF COURSES TEACHER CAN TEACH//
    S employTeachers(C courses);

    //PRINCIPAL EXPELS STUDENTS BASED ON POOR GRADES BELOW 20%//
    S expelStudents(C courses);

}
