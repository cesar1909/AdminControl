package mx.ipn.cic.biblioteca.AdminControl.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Collection;

@Entity
@DiscriminatorValue(value = "monitor")
public class MonitorModel extends User{
    @Column(name = "fechaNac")
    private String birthdate;

    @Column(name = "genero")
    private String gender;

    @Column(name = "telefonoFijo")
    private String phone;

    @Column(name = "telefonoMovil")
    private String mobilePhone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public MonitorModel() {
        super();
    }

    public MonitorModel(String birthdate, String gender, String phone, String mobilePhone) {
        this.birthdate = birthdate;
        this.gender = gender;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
    }

    public MonitorModel(String firstName, String lastNameP, String lastNameM, String email, String password, Collection<Role> roles, String birthdate, String gender, String phone, String mobilePhone) {
        super(firstName, lastNameP, lastNameM, email, password, roles);
        this.birthdate = birthdate;
        this.gender = gender;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
    }
    public String getFullName(){
        return getFirstName() + " " + getLastNameP() + " " + getLastNameM();
    }

}
