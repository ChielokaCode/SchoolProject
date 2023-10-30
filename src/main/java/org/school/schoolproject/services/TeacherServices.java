package org.school.schoolproject.services;

import org.school.schoolproject.entities.Courses;

public interface TeacherServices {

    //TEACHER CAN PASS OR FAIL STUDENTS BASED ON COURSE AVERAGE
    String passOrFailStudents(Courses courses);
}
