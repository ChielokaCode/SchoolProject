package org.school.schoolproject.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.school.schoolproject.enums.Gender;
import org.school.schoolproject.enums.Roles;
import org.school.schoolproject.enums.StaffSalary;

import javax.management.relation.Role;
import java.time.LocalDate;
import java.util.Comparator;


@Data
@SuperBuilder
@NoArgsConstructor

public class Person{


    private String ID;
    private Roles role;
    private Integer gradeLevel;
    private String emailAddress;
    private String guardianEmail1;
    private String guardianEmail2;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Integer age;
    private Address houseAddress;
    private LocalDate dateOfEmployment;
    private StaffSalary salary;
    private String isArchived;
    private String isDeleted;

    public Person(String firstName, Roles role){
        this.firstName = firstName;
        this.role = role;
    }




    @Override
    public String toString() {
        return "ID: " + ID +
                " , GradeLevel: " + gradeLevel +
                " , EmailAddress: " + emailAddress +
                " , GuardianEmail1: " + guardianEmail1 +
                " , GuardianEmail2: " + guardianEmail2 +
                " , FirstName: " + firstName +
                " , LastName: " + lastName +
                " , IsArchived: " + isArchived +
                " , IsDeleted: " + isDeleted +
                " , Role: " + role;
    }

//    @Override
//    public int compareTo(Person o) {
//        return this.role.compareTo(o.role);
//    }



//    @Override
//    public String toString() {
//        return ID +
//                "," + gradeLevel +
//                "," + emailAddress +
//                "," + guardianEmail1 +
//                "," + guardianEmail2 +
//                "," + firstName +
//                "," + lastName +
//                "," + isArchived +
//                "," + isDeleted +
//                "," + role;
//    }

}
