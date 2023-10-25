package org.school.schoolproject.entities;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Data
public class Classes {
    private String className;
    private LocalTime classStartTime;
    private LocalTime classStopTime;


    ///////GETTERS AND SETTERS////////
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public LocalTime getClassStartTime() {
        return classStartTime;
    }

    public void setClassStartTime(LocalTime classStartTime) {
        this.classStartTime = classStartTime;
    }

    public LocalTime getClassStopTime() {
        return classStopTime;
    }

    public void setClassStopTime(LocalTime classStopTime) {
        this.classStopTime = classStopTime;
    }


////////////HASH AND EQUALS///////////////////////////////////////////////
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classes classes = (Classes) o;
        return Objects.equals(className, classes.className) && Objects.equals(classStartTime, classes.classStartTime) && Objects.equals(classStopTime, classes.classStopTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className, classStartTime, classStopTime);
    }
}
