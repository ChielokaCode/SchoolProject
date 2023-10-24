package org.school.schoolproject.entities;

import lombok.Data;
import lombok.Getter;

import java.util.Objects;

@Getter
@Data
public class Courses {
    //////GETTERS AND SETTERS///////
    private String courseName;
    private int courseNumber;
    private int courseMark;


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
