package mx.ipn.cic.biblioteca.AdminControl.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import mx.ipn.cic.biblioteca.AdminControl.model.User;
//import mx.ipn.cic.biblioteca.AdminControl.web.dto.UserRegistrationDto;

@NoRepositoryBean
public interface UserBaseRepository<T extends User>extends JpaRepository<T, Long> {
	public T findByEmail(String email);
	//public T getIdByEmail(String email);
	//public T save(UserRegistrationDto registration);
}
