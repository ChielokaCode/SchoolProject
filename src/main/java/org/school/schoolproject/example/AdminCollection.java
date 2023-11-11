package org.school.schoolproject.example;

import org.school.schoolproject.enums.Roles;

import javax.management.relation.Role;
import java.util.List;

public class AdminCollection implements DefaultServices<List<Company>,String>{
//todo: We use GENERICS FOR CODE RE-USEABILITY
    //TODO: WE CAN SET THE RETURN/DATA TYPES AS ANY ALPHABET AND USE IT IN ANY CLASS AS WHAT WE WANT THE ALPHABET TO BE OF
    //TODO: IN THE INTERFACE I USED <P, C> BUT IN THIS CLASS I MADE P BECOME LIST<COMPANY> AND C AS STRING



    @Override
    public List<Company> addNewData(String person) {
        return null;
    }

    @Override
    public String setNewData(String s) {
        return null;
    }

}
