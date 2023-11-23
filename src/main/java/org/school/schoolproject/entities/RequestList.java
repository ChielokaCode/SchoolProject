package org.school.schoolproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
