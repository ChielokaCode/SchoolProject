package org.school;

import org.school.schoolproject.entities.Courses;
import org.school.schoolproject.entities.Students;
import org.school.schoolproject.entities.Teacher;
import org.school.schoolproject.servicesImplement.CourseServiceImplements;
import org.school.schoolproject.servicesImplement.PrincipalServiceImplements;
import org.school.schoolproject.servicesImplement.TeacherServiceImplements;


public class Main {
    public static void main(String[] args) {

        PrincipalServiceImplements principalService = new PrincipalServiceImplements();
        TeacherServiceImplements teacherService = new TeacherServiceImplements();
        CourseServiceImplements courseService = new CourseServiceImplements();
        Students student = new Students();
        Teacher teacher = new Teacher(3);
        Courses courses = new Courses();


        //////SCHOOL SYSTEM STARTS/////////////
        System.out.println("Bright International Secondary School Management App Start...!");

        /////COURSES TEACHER TEACHES AND IF TEACHER IS EMPLOYABLE OR NOT
        System.out.println();
        courseService.coursesTaughtByTeacher(courses);
        System.out.println(principalService.employTeachers(courses));

        //COURSES STUDENT TAKES
        System.out.println();
        courseService.courseStudentTakes(courses);

        //TO CHECK IF STUDENT PASSES OR FAILS COURSE BASED ON COURSE AVERAGE
        System.out.println();
        System.out.println("Student Course Average is "+ courses.calCourseAverage() + "%");
        System.out.println(teacherService.passOrFailStudents(courses));

        //TO EXPEL A STUDENT IF COURSE AVERAGE IS BELOW 30%
        System.out.println(principalService.expelStudents(courses));

        //TO ADMIT A STUDENT BASED ON AGE
        System.out.println();
        System.out.println(principalService.admitApplicants(15));












    }
}