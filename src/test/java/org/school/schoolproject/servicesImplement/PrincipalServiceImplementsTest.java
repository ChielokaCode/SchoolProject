package org.school.schoolproject.servicesImplement;

import org.junit.jupiter.api.Test;
import org.school.schoolproject.entities.Students;
import org.school.schoolproject.entities.Teacher;

import static org.junit.jupiter.api.Assertions.*;

class PrincipalServiceImplementsTest {

    PrincipalServiceImplements principal = new PrincipalServiceImplements();


    /////////////ADMIT APPLICANTS (STUDENTS) TESTS/////////////////
    @Test
    void admitApplicantsToCheckIfStudentIsPastAge() {
        assertEquals("Student is over age - Can't be admitted", principal.admitApplicants(20));
    }

    @Test
    void admitApplicantsToCheckIfStudentIsSenior() {
        assertEquals("Student is admitted to Senior class", principal.admitApplicants(17));
    }

    @Test
    void admitApplicantsToCheckIfStudentIsJunior() {
        assertEquals("Student is admitted to junior class", principal.admitApplicants(13));
    }

    @Test
    void admitApplicantsToCheckIfStudentIsNotUpToRequiredAge() {
        assertEquals("Student is not of required age - can't be admitted", principal.admitApplicants(8));
    }


    ////////////////EMPLOY TEACHER TESTS////////////////
    @Test
    void employTeachersWithNoOfCoursesUpToThreeCourses() {
        Teacher teacher = new Teacher(3);
        teacher.addCoursesTaught(); //This adds courses to my list, and then I can get the number of Courses
        assertEquals("Teacher can teach 3 or more courses - Teacher EMPLOYED", principal.employTeachers(teacher));
    }


    @Test
    void employTeachersWithNoOfCoursesLessThanThreeCourses() {
        ///to check a number of course less than my actual number of course, I have to override the
        ///previous number of course and set a new value for the test
        Teacher teacher = new Teacher(3) {
            @Override
            public int noOfCourse() {
                return 1;
            }
        };
        teacher.addCoursesTaught(); //This adds courses to my list, and then I can get the number of Courses
        assertEquals("Teacher can't teach up to 3 courses  - Teacher NOT EMPLOYED",principal.employTeachers(teacher));
    }

    @Test
    void employTeachersWithNoOfCoursesEqualToThree() {
        ///to check a number of course less than my actual number of course, I have to override the
        ///previous number of course and set a new value for the test
        Teacher teacher = new Teacher(3) {
            @Override
            public int noOfCourse() {
                return 3;
            }
        };
        teacher.addCoursesTaught(); //This adds courses to my list, and then I can get the number of Courses
        assertEquals("Teacher can teach 3 or more courses - Teacher EMPLOYED",principal.employTeachers(teacher));
    }

    ////////////////EXPEL STUDENTS TESTS////////////////////
    @Test
    void expelStudentsCheckIfCourseAverageIsAbove30() {
        Students student = new Students();
        student.addCoursesTaken(); //This adds courses to my list, and then I can get the number of Courses
        assertEquals("Students grades are Ok - Not Expelled", principal.expelStudents(student));
    }

    @Test
    void expelStudentsCheckIfCourseAverageIsBelow30() {
        Students student = new Students();
        student.addCoursesTaken(); //This adds courses to my list, and then I can get the number of Courses
        assertNotEquals("Student is expelled on basis of bad grades", principal.expelStudents(student));
    }
}