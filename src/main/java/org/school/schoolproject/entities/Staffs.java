package org.school.schoolproject.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import lombok.*;
import org.school.schoolproject.entities.enums.Roles;
import org.school.schoolproject.entities.enums.StaffSalary;

@Data  ///This helps us with getters and setters, constructors, to-string, equals and hash code, without me actually creating them
public class Staffs extends User{

    private int idNumber;
    private LocalDate dateOfEmployment;
    private StaffSalary salary;
    private Roles role;
    private String qualification;



    public BigDecimal getSalary() {
        return BigDecimal.valueOf(Long.parseLong(salary.name().replaceAll("N_|T_|P|_", "")));
    }

    //////HASH AND EQUALS//////////
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Staffs staffs = (Staffs) o;
        return idNumber == staffs.idNumber && Objects.equals(dateOfEmployment, staffs.dateOfEmployment) && salary == staffs.salary && role == staffs.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idNumber, dateOfEmployment, salary, role);
    }
}
