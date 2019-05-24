package mx.ipn.cic.biblioteca.AdminControl.services;
import mx.ipn.cic.biblioteca.AdminControl.model.User;
import mx.ipn.cic.biblioteca.AdminControl.model.Role;
import mx.ipn.cic.biblioteca.AdminControl.repositories.UserRepository;
//import mx.ipn.cic.biblioteca.AdminControl.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
  //descomentar para bcrypt
//    @Autowired
  //  private BCryptPasswordEncoder passwordEncoder;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    
    public Long findIdByEmail(String email) {
    	return userRepository.findIdByEmail(email);
    }

    
	  public String getCurrentUsername() {
		String username;
		String nombre = null; 
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			   username = ((UserDetails)principal).getUsername();
		    	System.out.println("username: "+username);
			   nombre = username;	
		}

    	System.out.println("nombre: "+nombre);
	  return nombre;
	  }

/*
    public User save(UserRegistrationDto registration){
        //User user = new User();
    	DoctorModel user = new DoctorModel();
        
        user.setFirstName(registration.getFirstName());
        user.setLastNameP(registration.getLastNameP());
        user.setLastNameM(registration.getLastNameM());
        user.setEmail(registration.getEmail());
        //descomentar para bcrypt
        //user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setPassword(registration.getPassword());
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }
*/
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	
        User user = userRepository.findByEmail(email);
        System.out.println("USER: "+user);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(
        		user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles
        		.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    public String getEmailUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        System.out.println(name);
        return name;
    }

    public boolean delete(Long idToDelete){
        this.userRepository.deleteById(idToDelete);
        return true;
    }

    public boolean updateCity(String city, Long id){
        this.userRepository.updateCity(city, id);
        return true;
    }

    public boolean updateDoctorWithoutPassword(Long id, String firstName, String lastNameP,
                                               String lastNameM, String email, String birthdate,
                                               String gender, String phone, String mobilePhone,
                                               String professionalLicense, String city,
                                               String hospital){
        this.userRepository.updateUserWithoutPassword(id, firstName, lastNameP, lastNameM, email, birthdate,
                gender, phone, mobilePhone, professionalLicense, city, hospital);
        return true;
    }

    public boolean updateDoctor(Long id, String firstName, String lastNameP,
                                               String lastNameM, String email, String birthdate,
                                               String gender, String phone, String mobilePhone,
                                               String professionalLicense, String city,
                                               String hospital, String password){
        this.userRepository.updateUser(id, firstName, lastNameP, lastNameM, email, birthdate,
                gender, phone, mobilePhone, professionalLicense, city, hospital, password);
        return true;
    }

    public boolean updateMonitorWithoutPassword(Long id, String firstName, String lastNameP,
                                               String lastNameM, String email, String birthdate,
                                               String gender, String phone, String mobilePhone){
        this.userRepository.updateMonitorWithoutPassword(id, firstName, lastNameP, lastNameM, email, birthdate,
                gender, phone, mobilePhone);
        return true;
    }

    public boolean updateMonitor(Long id, String firstName, String lastNameP,
                                String lastNameM, String email, String birthdate,
                                String gender, String phone, String mobilePhone,
                               String password){
        this.userRepository.updateMonitor(id, firstName, lastNameP, lastNameM, email, birthdate,
                gender, phone, mobilePhone, password);
        return true;
    }

}
