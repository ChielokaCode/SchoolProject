package org.school.schoolproject.entities;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Data
public class Courses {

    public static List<Courses> listOfCourses;
    private String courseName;
    private int courseNumber;
    private int courseMark;

    public int totalCourseMark;



    public int noOfCourse() {
        //if(listOfCoursesTaught == null) return 0;
        return listOfCourses.size();
    }


    /////////////////METHOD TO ADD COURSES TO LIST/////////
    public void addCoursesToList() {
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

        listOfCourses = new ArrayList<>(Arrays.asList(courses1, courses2, courses3, courses4));
    }

    public void displayCoursesTeacherTeach() {
        System.out.println("Teacher can teach "+ listOfCourses.size() +" courses: ");
        for (Courses c : listOfCourses){
            System.out.println(c.getCourseName());
        }
    }

    public void displayCoursesStudentTakes() {
        System.out.println("Student takes "+ listOfCourses.size() +" courses: ");
        for (Courses c : listOfCourses){
            System.out.println(c);
        }
    }

    public int calCourseAverage() {
        this.totalCourseMark = 0;
        for (Courses c : listOfCourses) {
            this.totalCourseMark += c.getCourseMark();
        }
        return this.totalCourseMark / this.noOfCourse();
    }


    public void setCourseName(String courseName) { this.courseName = courseName;}

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setCourseMark(int courseMark) {
        this.courseMark = courseMark;
    }


    //////////////TO-STRING//////////////////////////////////
    public String toString() {
        return "Course Name: " + courseName + ", Course Code: " + courseNumber + ", Course Mark: " + courseMark;
    }

}
