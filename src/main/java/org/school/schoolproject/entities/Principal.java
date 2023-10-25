package org.school.schoolproject.entities;

import lombok.Data;
import lombok.Getter;
import org.school.schoolproject.entities.enums.PrincipalRoles;
import java.util.Objects;

@Data
@Getter
public class Principal extends Staffs{

    private PrincipalRoles administrativeRoles;

    /////////GETTERS AND SETTERS///////////////
    public PrincipalRoles getAdministrativeRoles() {
        return administrativeRoles;
    }

    public void setAdministrativeRoles(PrincipalRoles administrativeRoles) {
        this.administrativeRoles = administrativeRoles;
    }

    ////////////////HASH AND EQUALS///////////////////////////////////////
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Principal principal = (Principal) o;
        return administrativeRoles == principal.administrativeRoles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), administrativeRoles);
    }
}
