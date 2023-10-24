package org.school.schoolproject.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Teacher extends Staffs{

    private String Qualification;
    public int minNoOfCourse;

    public Teacher(int minNoOfCourse) {
        this.minNoOfCourse = minNoOfCourse;
    }
}
