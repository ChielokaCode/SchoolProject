package org.school.schoolproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.school.schoolproject.enums.Roles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestList {
    private Person person;
    private String bookName;

    @Override
    public String toString(){
        return "Request Type: " + person.getRole() +
                ", Book Title: " + bookName;
    }
}
