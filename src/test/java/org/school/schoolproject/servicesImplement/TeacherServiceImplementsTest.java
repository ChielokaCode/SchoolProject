package org.school.schoolproject.servicesImplement;

import org.junit.jupiter.api.Test;
import org.school.schoolproject.entities.Courses;
import org.school.schoolproject.entities.Students;
import org.school.schoolproject.entities.Teacher;

import static org.junit.jupiter.api.Assertions.*;

class TeacherServiceImplementsTest {
    TeacherServiceImplements teacherService = new TeacherServiceImplements();


    /////TESTS TO CHECK THE COURSES THE TEACHER TEACH
    @Test
    void coursesTaughtByTeacherTestOne() {
        Teacher teacher = new Teacher(3);
        assertTrue(teacherService.coursesTaughtByTeacher(teacher));

    }

    //TESTS TO CHECK STUDENT PASS OR FAIL COURSES
    @Test
    void passOrFailStudentsToCheckIfStudentGotA() {
        Students student = new Students(){
            @Override
            public int calCourseAverage() {
                return 90;
            }
        };
        assertEquals("Student got A", teacherService.passOrFailStudents(student));

    }

    @Test
    void passOrFailStudentsToCheckIfStudentGotB() {
        Students student = new Students(){
            @Override  //This overrides my value from calCourseAverage, so i can be able to test other values
            public int calCourseAverage() {
                return 75;
            }
        };
        assertEquals("Student got B", teacherService.passOrFailStudents(student));

    }

    @Test
    void passOrFailStudentsToCheckIfStudentGotC() {
        Students student = new Students(){
            @Override  //This overrides my value from calCourseAverage, so i can be able to test other values
            public int calCourseAverage() {
                return 60;
            }
        };
        assertEquals("Student got C", teacherService.passOrFailStudents(student));

    }

    @Test
    void passOrFailStudentsToCheckIfStudentGotD() {
        Students student = new Students(){
            @Override  //This overrides my value from calCourseAverage, so i can be able to test other values
            public int calCourseAverage() {
                return 40;
            }
        };
        assertEquals("Student got D", teacherService.passOrFailStudents(student));
    }


    @Test
    void passOrFailStudentsToCheckIfStudentGotF() {
        Students student = new Students(){
            @Override //This overrides my value from calCourseAverage, so I can be able to test other values
            public int calCourseAverage() {
                return 10;
            }
        };
        assertEquals("Student got F - Student fails Course", teacherService.passOrFailStudents(student));
    }

    @Test
    void passOrFailStudentsToCheckIfStudentInvalidNumberAbove100() {
        Students student = new Students(){
            @Override  //This overrides my value from calCourseAverage, so i can be able to test other values
            public int calCourseAverage() {
                return 120;
            }
        };
        assertEquals("Invalid Mark", teacherService.passOrFailStudents(student));
    }

    @Test
    void passOrFailStudentsToCheckIfStudentInvalidMarkBelow0() {
        Students student = new Students(){
            @Override  //This overrides my value from calCourseAverage, so i can be able to test other values
            public int calCourseAverage() {
                return -30;
            }
        };
        assertEquals("Invalid Mark", teacherService.passOrFailStudents(student));
    }
}