package org.school.schoolproject.example;

import org.school.schoolproject.enums.Roles;
public class VAD<String> {

    public void doSomething(){
        //Company<Roles> companyRoles = new Company<>();
        //companyRoles.setRoles((Roles) org.school.schoolproject.enums.Roles.JUNIOR_STUDENT);
        Company<Integer> comp1 = new Company<>();
        comp1.setRoles(1);
        System.out.println(comp1.getRoles());
    }

}
