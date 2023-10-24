package org.school.schoolproject.servicesImplement;

import org.school.schoolproject.entities.Courses;
import org.school.schoolproject.entities.Students;
import org.school.schoolproject.entities.Teacher;
import org.school.schoolproject.services.TeacherServices;

public class TeacherServiceImplements implements TeacherServices {

    private int totalCourseMark;

    //COURSES TEACHER CAN TEACH
    @Override
    public boolean coursesTaughtByTeacher(Teacher teacher) {
        teacher.addCoursesTaught();
        teacher.displayCoursesTeacherTeach();

        return true;

    }

    ///TEACHER PASS OR FAIL STUDENTS BASED ON COURSE AVERAGE///
    @Override
    public String passOrFailStudents(Students students) {

        if (students.calCourseAverage() >= 80  && students.calCourseAverage() <= 100) {
            return "Student got A";
        }else if (students.calCourseAverage() >= 70 && students.calCourseAverage() < 80){
            return "Student got B";
        }else if (students.calCourseAverage() >= 50 && students.calCourseAverage() < 70){
            return "Student got C";
        } else if(students.calCourseAverage() >= 30 && students.calCourseAverage() < 50){
            return "Student got D";
        }else if (students.calCourseAverage() >= 0 && students.calCourseAverage() < 30){
            return "Student got F - Student fails Course";
        }else {
            return "Invalid Mark";
        }

    }

}
