package org.school.schoolproject.entities;

import lombok.Data;
import org.school.schoolproject.entities.enums.State;

@Data
public class Address {
    private String city;
    private String town;
    private State state;

}
