package org.school.schoolproject.servicesImplement;

import org.junit.jupiter.api.Test;
import org.school.schoolproject.entities.Courses;
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
    void employTeachersWithNoOfCoursesMoreThanThreeCourses() {
        Courses courses = new Courses();
        courses.addCoursesToList(); //This adds courses to my list, and then I can get the number of Courses
        assertEquals("Teacher can teach 3 or more courses - Teacher EMPLOYED", principal.employTeachers(courses));
    }


    @Test
    void employTeachersWithNoOfCoursesLessThanThreeCourses() {
        ///to check a number of course less than my actual number of course, I have to override the
        ///previous number of course and set a new value for the test
        Courses courses = new Courses() {
            @Override
            public int noOfCourse() {
                return 1;
            }
        };
        courses.addCoursesToList(); //This adds courses to my list, and then I can get the number of Courses
        assertEquals("Teacher can't teach up to 3 courses  - Teacher NOT EMPLOYED",principal.employTeachers(courses));
    }

    @Test
    void employTeachersWithNoOfCoursesEqualToThree() {
        ///to check a number of course less than my actual number of course, I have to override the
        ///previous number of course and set a new value for the test
        Courses courses = new Courses() {
            @Override
            public int noOfCourse() {
                return 3;
            }
        };
        courses.addCoursesToList(); //This adds courses to my list, and then I can get the number of Courses
        assertEquals("Teacher can teach 3 or more courses - Teacher EMPLOYED",principal.employTeachers(courses));
    }

    ////////////////EXPEL STUDENTS TESTS////////////////////
    @Test
    void expelStudentsCheckIfCourseAverageIsAbove30() {
        Courses courses = new Courses();
        courses.addCoursesToList(); //This adds courses to my list, and then I can get the number of Courses
        assertEquals("Students grades are Ok - Not Expelled", principal.expelStudents(courses));
    }

    @Test
    void expelStudentsCheckIfCourseAverageIsBelow30() {
        Courses courses = new Courses();
        courses.addCoursesToList(); //This adds courses to my list, and then I can get the number of Courses
        assertNotEquals("Student is expelled on basis of bad grades", principal.expelStudents(courses));
    }
}