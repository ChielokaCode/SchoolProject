package org.school.schoolproject.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.*;
import org.school.schoolproject.entities.enums.Roles;
import org.school.schoolproject.entities.enums.StaffSalary;

@Data  ///This helps us with getters and setters, constructors, to-string, equals and hash code, without me actually creating them
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Staffs extends User{

    private int idNumber;
    private LocalDate dateOfEmployment;
    private StaffSalary salary;
    private Roles role;



    public BigDecimal getSalary() {
        return BigDecimal.valueOf(Long.parseLong(salary.name().replaceAll("N_|T_|P|_", "")));
    }

}
