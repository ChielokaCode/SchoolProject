package org.school.schoolproject.services;

import org.school.schoolproject.entities.Courses;
import org.school.schoolproject.entities.Students;
import org.school.schoolproject.entities.Teacher;

public interface TeacherServices {

    //TEACHER CAN PASS OR FAIL STUDENTS BASED ON COURSE AVERAGE
    String passOrFailStudents(Courses courses);
}
