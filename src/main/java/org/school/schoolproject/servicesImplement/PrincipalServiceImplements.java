package org.school.schoolproject.servicesImplement;

import org.school.schoolproject.entities.Courses;
import org.school.schoolproject.entities.Students;
import org.school.schoolproject.entities.Teacher;
import org.school.schoolproject.services.PrincipalServices;


public class PrincipalServiceImplements implements PrincipalServices {


    ///PRINCIPAL ADMITS APPLICANTS(STUDENTS) BASED ON AGE//
    @Override
    public String admitApplicants(int age) {
        boolean isPastAge = age > 18;
        boolean isSenior = age >= 14;
        boolean isJunior = age >= 10;
        return isPastAge ? "Student is over age - Can't be admitted" : isSenior ? "Student is admitted to Senior class" : isJunior ? "Student is admitted to junior class" : "Student is not of required age - can't be admitted";

    }

    ///Principal admit applicants (Teachers) based on a minimum amount of courses the teacher can teach
    ///The teacher is employable if the teacher can teach 3 or more courses
    //The teacher won't be employed if the teacher cannot teach up to 3 courses
    @Override
    public String employTeachers(Teacher teacher) {
        if (teacher.noOfCourse() >= teacher.minNoOfCourse) {
            return "Teacher can teach 3 or more courses - Teacher EMPLOYED";
        }else {
            return "Teacher can't teach up to 3 courses  - Teacher NOT EMPLOYED";
        }
    }


    //PRINCIPAL EXPELS STUDENTS BASED ON POOR GRADES BELOW 20%//
    @Override
    public String expelStudents(Students students) {
        students.totalCourseMark = 0;
        for (Courses c : Students.coursesList) {
            students.totalCourseMark += c.getCourseMark();
        }

        int courseAverage = students.totalCourseMark / students.noOfCourseTaken();
        return (courseAverage < 20) ? "Student is expelled on basis of bad grades" : "Students grades are Ok - Not Expelled";


    }

}
