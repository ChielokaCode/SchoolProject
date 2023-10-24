package org.school.schoolproject.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Students extends User{
    public static List<Courses> coursesList = new ArrayList<>();
    public int totalCourseMark;



    ////////////METHOD TO GET NUMBER OF COURSES//////////
    public int noOfCourseTaken() {
        return coursesList.size();
    }

    /////////////METHOD TO ADD COURSES DETAILS TO LIST//////////////
    public void addCoursesTaken() {
        Courses courses1 = new Courses();
        Courses courses2 = new Courses();
        Courses courses3 = new Courses();
        Courses courses4 = new Courses();

        courses1.setCourseName("Mathematics");
        courses1.setCourseNumber(101);
        courses1.setCourseMark(90);

        courses2.setCourseName("English");
        courses2.setCourseNumber(102);
        courses2.setCourseMark(70);

        courses3.setCourseName("Civic");
        courses3.setCourseNumber(103);
        courses3.setCourseMark(85);

        courses4.setCourseName("Arts");
        courses4.setCourseNumber(104);
        courses4.setCourseMark(95);

        coursesList = new ArrayList<>(Arrays.asList(courses1, courses2, courses3, courses4));
    }

    public void displayCoursesStudentTakes() {
        System.out.println("Student takes "+ coursesList.size() +" courses: ");
        for (Courses c : coursesList){
            System.out.println(c);
        }
    }

    public int calCourseAverage() {
        this.totalCourseMark = 0;
        for (Courses c : Students.coursesList) {
            this.totalCourseMark += c.getCourseMark();
        }
        return this.totalCourseMark / this.noOfCourseTaken();
    }



}
