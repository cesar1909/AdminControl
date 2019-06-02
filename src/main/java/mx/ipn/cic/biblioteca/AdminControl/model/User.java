package mx.ipn.cic.biblioteca.AdminControl.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@DiscriminatorColumn(name="tipo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public abstract class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastNameP;
    private String lastNameM;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)//, cascade = CascadeType.ALL
    @JoinTable(
		name = "users_roles",
		joinColumns = @JoinColumn(
		name = "user_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(
		name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User() {

    }

	public User(String firstName, String lastNameP, String lastNameM, String email, String password,
			Collection<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastNameP = lastNameP;
		this.lastNameM = lastNameM;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public User(String firstName, String lastNameP, String lastNameM, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastNameP = lastNameP;
		this.lastNameM = lastNameM;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNameP() {
		return lastNameP;
	}

	public void setLastNameP(String lastNameP) {
		this.lastNameP = lastNameP;
	}

	public String getLastNameM() {
		return lastNameM;
	}

	public void setLastNameM(String lastNameM) {
		this.lastNameM = lastNameM;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

}