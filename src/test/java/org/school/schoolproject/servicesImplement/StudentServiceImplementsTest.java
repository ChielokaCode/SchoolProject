package org.school.schoolproject.servicesImplement;

import org.junit.jupiter.api.Test;
import org.school.schoolproject.entities.Students;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplementsTest {
    StudentServiceImplements studentService = new StudentServiceImplements();


    @Test
    void courseStudentTakesTestOne() {
        Students students = new Students();
        assertTrue(studentService.courseStudentTakes(students));
    }
}