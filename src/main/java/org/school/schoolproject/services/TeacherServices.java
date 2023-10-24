package org.school.schoolproject.services;

import org.school.schoolproject.entities.Students;
import org.school.schoolproject.entities.Teacher;

public interface TeacherServices {

    //COURSES TEACHER CAN TEACH
    boolean coursesTaughtByTeacher(Teacher teacher);

    //TEACHER CAN PASS OR FAIL STUDENTS BASED ON COURSE AVERAGE
    String passOrFailStudents(Students students);
}
