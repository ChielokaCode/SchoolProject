package org.school.schoolproject.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import lombok.*;
import org.school.schoolproject.entities.enums.Roles;
import org.school.schoolproject.entities.enums.StaffSalary;

import javax.management.relation.Role;


@Data  ///This helps us with getters and setters, constructors, to-string, equals and hash code, without me actually creating them
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Staffs extends User{

    private int idNumber;
    private LocalDate dateOfEmployment;
    //private BigDecimal staffSalary;
    private StaffSalary salary;
    private Roles role;
    //private static final BigDecimal SALARY_1 = new BigDecimal(40000);
   // private static final BigDecimal SALARY_2 = new BigDecimal(15000);
   // private static final BigDecimal SALARY_3 = new BigDecimal(15000);


    public BigDecimal getSalary() {
        return BigDecimal.valueOf(Long.parseLong(salary.name().replaceAll("N_|T_|P|_", "")));
    }

//    public void setStaffSalary(BigDecimal staffSalary) {
//        this.staffSalary = staffSalary;
//    }
//
//    public void setSalary(StaffSalary salary) {
//        this.salary = salary;
//    }
}
