package org.school.schoolproject.servicesImplement;

import org.junit.jupiter.api.Test;
import org.school.schoolproject.entities.Courses;

import static org.junit.jupiter.api.Assertions.*;

class TeacherServiceImplementsTest {
    TeacherServiceImplements teacherService = new TeacherServiceImplements();


    //TESTS TO CHECK STUDENT PASS OR FAIL COURSES
    @Test
    void passOrFailStudentsToCheckIfStudentGotA() {
        Courses course = new Courses(){
            @Override  //This overrides my value from calCourseAverage, so I can be able to test other values
            public int calCourseAverage() {
                return 90;
            }
        };
        assertEquals("Student got A", teacherService.passOrFailStudents(course));

    }

    @Test
    void passOrFailStudentsToCheckIfStudentGotB() {
        Courses course = new Courses(){
            @Override  //This overrides my value from calCourseAverage, so I can be able to test other values
            public int calCourseAverage() {
                return 75;
            }
        };
        assertEquals("Student got B", teacherService.passOrFailStudents(course));

    }

    @Test
    void passOrFailStudentsToCheckIfStudentGotC() {
        Courses course = new Courses(){
            @Override  //This overrides my value from calCourseAverage, so I can be able to test other values
            public int calCourseAverage() {
                return 60;
            }
        };
        assertEquals("Student got C", teacherService.passOrFailStudents(course));

    }

    @Test
    void passOrFailStudentsToCheckIfStudentGotD() {
        Courses course = new Courses(){
            @Override  //This overrides my value from calCourseAverage, so I can be able to test other values
            public int calCourseAverage() {
                return 40;
            }
        };
        assertEquals("Student got D", teacherService.passOrFailStudents(course));
    }


    @Test
    void passOrFailStudentsToCheckIfStudentGotF() {
        Courses course = new Courses(){
            @Override //This overrides my value from calCourseAverage, so I can be able to test other values
            public int calCourseAverage() {
                return 10;
            }
        };
        assertEquals("Student got F - Student fails Course", teacherService.passOrFailStudents(course));
    }

    @Test
    void passOrFailStudentsToCheckIfStudentInvalidNumberAbove100() {
        Courses course = new Courses(){
            @Override  //This overrides my value from calCourseAverage, so I can be able to test other values
            public int calCourseAverage() {
                return 120;
            }
        };
        assertEquals("Invalid Mark", teacherService.passOrFailStudents(course));
    }

    @Test
    void passOrFailStudentsToCheckIfStudentInvalidMarkBelow0() {
        Courses course = new Courses(){
            @Override  //This overrides my value from calCourseAverage, so I can be able to test other values
            public int calCourseAverage() {
                return -30;
            }
        };
        assertEquals("Invalid Mark", teacherService.passOrFailStudents(course));
    }
}