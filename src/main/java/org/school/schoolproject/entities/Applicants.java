package org.school.schoolproject.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Applicants extends User{
    private LocalDate enrollmentDate;
    private String courseToStudy;


    //////GETTERS AND SETTERS////////
    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
    public void setCourseToStudy(String courseToStudy) {
        this.courseToStudy = courseToStudy;
    }
    public String getCourseToStudy(){
        return courseToStudy;
    }


///////////////HASH AND EQUALS//////////////////////////////////////////
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Applicants that = (Applicants) o;
        return Objects.equals(enrollmentDate, that.enrollmentDate) && Objects.equals(courseToStudy, that.courseToStudy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enrollmentDate, courseToStudy);
    }
}
