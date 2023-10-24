package org.school.schoolproject.entities;

import lombok.Data;
import org.school.schoolproject.entities.enums.Gender;
import java.util.Objects;

@Data
public abstract class User {

    private String fullName;
    private String emailAddress;
    private Long phoneNumber;
    private Gender gender;
    private int age;
    private Address houseAddress;

}
