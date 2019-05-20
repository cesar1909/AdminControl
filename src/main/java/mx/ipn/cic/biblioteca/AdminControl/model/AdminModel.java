package mx.ipn.cic.biblioteca.AdminControl.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Collection;

@Entity
@DiscriminatorValue(value = "admin")
public class AdminModel extends User{
    @Column(name = "fechaNac")
    private String birthdate;

    @Column(name = "genero")
    private String gender;

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AdminModel() { super(); }

    public AdminModel(String firstName, String lastNameP, String lastNameM, String email, String password, Collection<Role> roles, String birthdate, String gender) {
        super(firstName, lastNameP, lastNameM, email, password, roles);
        this.birthdate = birthdate;
        this.gender = gender;
    }
}
