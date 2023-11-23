package org.school.schoolproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashMap;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    public static Map<String, Integer> bookAvailable = new HashMap<>();
    private String name;
    private Integer quantity;




    @Override
    public String toString(){
        return "Book Name: " + name +
                ", Book Quantity: " + quantity;
     }
}
