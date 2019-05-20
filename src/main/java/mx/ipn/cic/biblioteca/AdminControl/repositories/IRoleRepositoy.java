package mx.ipn.cic.biblioteca.AdminControl.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import mx.ipn.cic.biblioteca.AdminControl.model.AdminModel;
import mx.ipn.cic.biblioteca.AdminControl.model.Role;

@Transactional
public interface IRoleRepositoy extends JpaRepository<Role,Long> {

	@Query(value="SELECT * FROM role WHERE name = :name",nativeQuery = true)
	public Role findByRol(@Param("name") String name);
}