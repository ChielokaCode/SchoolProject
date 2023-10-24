package org.school;

import org.school.schoolproject.entities.Students;
import org.school.schoolproject.entities.Teacher;
import org.school.schoolproject.servicesImplement.PrincipalServiceImplements;
import org.school.schoolproject.servicesImplement.StudentServiceImplements;
import org.school.schoolproject.servicesImplement.TeacherServiceImplements;


public class Main {
    public static void main(String[] args) {

        PrincipalServiceImplements principalService = new PrincipalServiceImplements();
        TeacherServiceImplements teacherService = new TeacherServiceImplements();
        StudentServiceImplements studentService = new StudentServiceImplements();
        Students student = new Students();
        Teacher teacher = new Teacher(3);


        //////SCHOOL SYSTEM STARTS/////////////
        System.out.println("Bright International Secondary School Management App Start...!");

        /////COURSES TEACHER TEACHES AND IF TEACHER IS EMPLOYABLE OR NOT
        System.out.println();
        teacherService.coursesTaughtByTeacher(teacher);
        System.out.println(principalService.employTeachers(teacher));

        //COURSES STUDENT TAKES
        System.out.println();
        studentService.courseStudentTakes(student);

        //TO CHECK IF STUDENT PASSES OR FAILS COURSE BASED ON COURSE AVERAGE
        System.out.println();
        System.out.println("Student Course Average is "+ student.calCourseAverage() + "%");
        System.out.println(teacherService.passOrFailStudents(student));

        //TO EXPEL A STUDENT IF COURSE AVERAGE IS BELOW 30%
        System.out.println(principalService.expelStudents(student));

        //TO ADMIT A STUDENT BASED ON AGE
        System.out.println();
        System.out.println(principalService.admitApplicants(15));












    }
}