package org.school.schoolproject.entities;

import org.school.schoolproject.entities.enums.NonAcademicRoles;
import java.util.Objects;


public class NonAcademicStaff extends Staffs{
    private NonAcademicRoles roles;


    /////////GETTERS AND SETTERS////////////
    public NonAcademicRoles getRoles() {
        return roles;
    }

    public void setRoles(NonAcademicRoles roles) {
        this.roles = roles;
    }


/////////////HASH AND EQUALS//////////////////////////////////
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NonAcademicStaff that = (NonAcademicStaff) o;
        return roles == that.roles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roles);
    }
}
