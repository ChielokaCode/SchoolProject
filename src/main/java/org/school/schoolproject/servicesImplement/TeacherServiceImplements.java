package org.school.schoolproject.servicesImplement;

import org.school.schoolproject.entities.Courses;
import org.school.schoolproject.entities.Students;
import org.school.schoolproject.entities.Teacher;
import org.school.schoolproject.services.TeacherServices;

public class TeacherServiceImplements implements TeacherServices {

    ///TEACHER PASS OR FAIL STUDENTS BASED ON COURSE AVERAGE///
    @Override
    public String passOrFailStudents(Courses courses) {

        if (courses.calCourseAverage() >= 80  && courses.calCourseAverage() <= 100) {
            return "Student got A";
        }else if (courses.calCourseAverage() >= 70 && courses.calCourseAverage() < 80){
            return "Student got B";
        }else if (courses.calCourseAverage() >= 50 && courses.calCourseAverage() < 70){
            return "Student got C";
        } else if(courses.calCourseAverage() >= 30 && courses.calCourseAverage() < 50){
            return "Student got D";
        }else if (courses.calCourseAverage() >= 0 && courses.calCourseAverage() < 30){
            return "Student got F - Student fails Course";
        }else {
            return "Invalid Mark";
        }

    }

}
