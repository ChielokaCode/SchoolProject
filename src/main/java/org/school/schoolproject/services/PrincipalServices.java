package org.school.schoolproject.services;

import org.school.schoolproject.entities.Courses;
import org.school.schoolproject.entities.Students;
import org.school.schoolproject.entities.Teacher;

import java.util.List;

public interface PrincipalServices {

    ///PRINCIPAL ADMITS APPLICANTS(STUDENTS) BASED ON AGE//
    String admitApplicants(int age);

    //PRINCIPAL EMPLOYS TEACHER BASED ON THE NUMBER OF COURSES TEACHER CAN TEACH//
    String employTeachers(Courses courses);

    //PRINCIPAL EXPELS STUDENTS BASED ON POOR GRADES BELOW 20%//
    String expelStudents(Courses courses);

}
