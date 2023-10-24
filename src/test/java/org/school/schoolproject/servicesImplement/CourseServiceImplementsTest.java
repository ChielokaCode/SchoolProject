package org.school.schoolproject.servicesImplement;

import org.junit.jupiter.api.Test;
import org.school.schoolproject.entities.Courses;
import org.school.schoolproject.entities.Students;
import org.school.schoolproject.entities.Teacher;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceImplementsTest {
    CourseServiceImplements courseService = new CourseServiceImplements();

    /////TESTS TO CHECK THE COURSES THE TEACHER TEACH
    @Test
    void coursesTaughtByTeacherTestOne() {
        Courses courses = new Courses();
        assertTrue(courseService.coursesTaughtByTeacher(courses));

    }

    /////TESTS TO CHECK THE COURSES THE STUDENT TAKES
    @Test
    void courseStudentTakesTestOne() {
        Courses courses = new Courses();
        assertTrue(courseService.courseStudentTakes(courses));
    }
}