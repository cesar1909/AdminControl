package mx.ipn.cic.biblioteca.AdminControl.repositories;
import mx.ipn.cic.biblioteca.AdminControl.model.User;
import mx.ipn.cic.biblioteca.AdminControl.projections.FindPatientsByEmailResult;
import mx.ipn.cic.biblioteca.AdminControl.repositories.UserBaseRepository;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Transactional
public interface UserRepository extends UserBaseRepository <User> {
	@Query(value="SELECT id FROM user WHERE email = :email",nativeQuery = true)
	public Long findIdByEmail(@Param("email") String email);
	
	@Query(value="SELECT "	+		
			"p.idpaciente, " + 
			"p.nombre, " + 
			"p.appat, " + 
			"p.apmat, " + 
			"p.edad, " + 
			"p.genero " + 
			"FROM paciente p "+
			"JOIN user u ON p.idmedico = u.id "+
			"WHERE u.email = :email",nativeQuery=true)
	public List<FindPatientsByEmailResult> findPatientsByEmail(@Param("email") String email);
	 
}