package mx.ipn.cic.biblioteca.AdminControl.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value="medico")
//@Table(name = "medico")
public class DoctorModel extends User{
	
	@Column(name = "fechaNac")
	private String birthdate;
	
	@Column(name = "genero")
	private String gender;
	
	@Column(name = "telefonoFijo")
	private String phone;
	
	@Column(name = "telefonoMovil")
	private String mobilePhone;
	
	@Column(name = "cedProf")
	private String professionalLicense;

	@Column(name = "city")
	private String city;

	@Column(name = "hospital")
	private String hospital;
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

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

	public String getProfessionalLicense() {
		return professionalLicense;
	}

	public void setProfessionalLicense(String professionalLicense) {
		this.professionalLicense = professionalLicense;
	}

    public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public Long getId() {
       return super.getId();
    }

    public String getFullName(){
		return getFirstName() + " " + getLastNameP() + " " + getLastNameM();
	}
    
//    public void setId(Long id) {
//       this.id = id;
//    }
	    
	public DoctorModel() {
		super();
	}


	public DoctorModel(String firstName, String lastNameP, String lastNameM, String email, String password,
			Collection<Role> roles, String birthdate, String gender, String phone, String mobilePhone, String professionalLicense,
					   String city, String hospital) {
		super(firstName, lastNameP, lastNameM, email, password, roles);
		this.birthdate = birthdate;
		this.gender = gender;
		this.phone = phone;
		this.mobilePhone = mobilePhone;
		this.professionalLicense = professionalLicense;
		this.city = city;
		this.hospital = hospital;
	}


	public DoctorModel(String firstName, String lastNameP, String lastNameM, String email, String password,
			String birthdate, String gender, String phone, String mobilePhone, String professionalLicense) {
		super(firstName, lastNameP, lastNameM, email, password);
		this.birthdate = birthdate;
		this.gender = gender;
		this.phone = phone;
		this.mobilePhone = mobilePhone;
		this.professionalLicense = professionalLicense;
	}

	public DoctorModel(String birthdate, String gender, String phone, String mobilePhone, String professionalLicense) {
		super();
		this.birthdate = birthdate;
		this.gender = gender;
		this.phone = phone;
		this.mobilePhone = mobilePhone;
		this.professionalLicense = professionalLicense;
	}


}
