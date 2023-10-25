package org.school.schoolproject.servicesImplement;

import org.school.schoolproject.entities.Courses;
import org.school.schoolproject.services.CourseService;

public class CourseServiceImplements implements CourseService {

    //COURSES TEACHER CAN TEACH
    @Override
    public boolean coursesTaughtByTeacher(Courses courses) {
        courses.addCoursesToList();
        courses.displayCoursesTeacherTeach();

        return true;

    }

    /////COURSES STUDENT TAKES//
    @Override
    public boolean courseStudentTakes(Courses courses) {
        courses.addCoursesToList();
        courses.displayStudentCourses();

        return true;
    }

}
