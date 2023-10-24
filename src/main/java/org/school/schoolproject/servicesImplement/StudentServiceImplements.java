package org.school.schoolproject.servicesImplement;

import org.school.schoolproject.entities.Students;
import org.school.schoolproject.services.StudentServices;

public class StudentServiceImplements implements StudentServices {

    /////COURSES STUDENT TAKES//
    @Override
    public boolean courseStudentTakes(Students student) {
        student.addCoursesTaken();
        student.displayCoursesStudentTakes();

        return true;
    }
}
