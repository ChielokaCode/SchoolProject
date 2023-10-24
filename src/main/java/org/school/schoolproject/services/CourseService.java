package org.school.schoolproject.services;

import org.school.schoolproject.entities.Courses;

public interface CourseService {
    boolean coursesTaughtByTeacher(Courses courses);

    boolean courseStudentTakes(Courses courses);
}
