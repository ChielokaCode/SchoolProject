package org.school.schoolproject.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teacher extends Staffs{
    public static List<Courses> listOfCoursesTaught;
    public int minNoOfCourse;

    public Teacher(int minNoOfCourse) {
        this.minNoOfCourse = minNoOfCourse;
    }

    public void setMinNoOfCourse(int minNoOfCourse) {
        this.minNoOfCourse = minNoOfCourse;
    }

    /////////////METHOD TO GET NUMBER OF COURSES TEACHER TEACHES
    public int noOfCourse() {
        //if(listOfCoursesTaught == null) return 0;
        return listOfCoursesTaught.size();
    }

    /////////////////METHOD TO ADD COURSES TO LIST/////////
    public void addCoursesTaught() {
        Courses courses1 = new Courses();
        Courses courses2 = new Courses();
        Courses courses3 = new Courses();
        Courses courses4 = new Courses();

        courses1.setCourseName("COMPUTER");
        courses1.setCourseNumber(301);

        courses2.setCourseName("PHYSIC");
        courses2.setCourseNumber(302);

        courses3.setCourseName("GOVERNMENT");
        courses3.setCourseNumber(303);

        courses4.setCourseName("ARTS");
        courses4.setCourseNumber(304);

        listOfCoursesTaught = new ArrayList<>(Arrays.asList(courses1, courses2, courses3, courses4));
    }

    public void displayCoursesTeacherTeach() {
        System.out.println("Teacher can teach "+ listOfCoursesTaught.size() +" courses: ");
        for (Courses c : listOfCoursesTaught){
            System.out.println(c.getCourseName());
        }
    }

}
