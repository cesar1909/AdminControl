package mx.ipn.cic.biblioteca.AdminControl.repositories;
import mx.ipn.cic.biblioteca.AdminControl.model.User;
import mx.ipn.cic.biblioteca.AdminControl.projections.FindPatientsByEmailResult;
import mx.ipn.cic.biblioteca.AdminControl.projections.FindFullNameByEmailResult;
import mx.ipn.cic.biblioteca.AdminControl.repositories.UserBaseRepository;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Transactional
public interface UserRepository extends UserBaseRepository <User>{
	
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

	@Modifying
	@Query(value = "UPDATE user u SET u.city = :city WHERE u.id = :id", nativeQuery=true)
	void updateCity(@Param("city") String city, @Param("id") Long id);

	@Modifying
	@Query(value = "UPDATE user u SET u.first_name = :firstName, u.last_namep = :lastNameP, u.last_namem = :lastNameM, " +
			"u.email = :email, u.fecha_nac = :birthdate, u.genero = :gender, u.telefono_fijo = :phone, u.telefono_movil = :mobilePhone, " +
			"u.ced_prof = :professionalLicense, u.city = :city, u.hospital = :hospital WHERE u.id = :id", nativeQuery=true)
	void updateUserWithoutPassword(@Param("id") Long id, @Param("firstName") String firstName, @Param("lastNameP") String lastNameP,
								   @Param("lastNameM") String lastNameM, @Param("email") String email, @Param("birthdate") String birthdate,
								   @Param("gender") String gender, @Param("phone") String phone, @Param("mobilePhone") String mobilePhone,
								   @Param("professionalLicense") String professionalLicense, @Param("city") String city,
								   @Param("hospital") String hospital);

	@Modifying
	@Query(value = "UPDATE user u SET u.first_name = :firstName, u.last_namep = :lastNameP, u.last_namem = :lastNameM, " +
			"u.email = :email, u.fecha_nac = :birthdate, u.genero = :gender, u.telefono_fijo = :phone, u.telefono_movil = :mobilePhone, " +
			"u.ced_prof = :professionalLicense, u.city = :city, u.hospital = :hospital, u.password = :password WHERE u.id = :id", nativeQuery=true)
	void updateUser(@Param("id") Long id, @Param("firstName") String firstName, @Param("lastNameP") String lastNameP,
								   @Param("lastNameM") String lastNameM, @Param("email") String email, @Param("birthdate") String birthdate,
								   @Param("gender") String gender, @Param("phone") String phone, @Param("mobilePhone") String mobilePhone,
								   @Param("professionalLicense") String professionalLicense, @Param("city") String city,
								   @Param("hospital") String hospital, @Param("password") String password);

	@Transactional
	@Query(value="SELECT "	+		
			"u.first_name as nombre, " + 
			"u.last_namem as apmat, " + 
			"u.last_namep as appat " + 
			"FROM user u "+
			"WHERE u.email = :email",nativeQuery=true)//= :email
	public List<FindFullNameByEmailResult> findFullNameByEmail(@Param("email") String email);
	
//	@Modifying
//	@Query(value = "UPDATE user u SET u.first_name = :firstName, u.last_namep = :lastNameP, u.last_namem = :lastNameM, " +
//			"u.email = :email, u.fecha_nac = :birthdate, u.genero = :gender, u.telefono_fijo = :phone, u.telefono_movil = :mobilePhone, " +
//			"WHERE u.id = :id", nativeQuery=true)
//	void updateMonitorWithoutPassword(@Param("id") Long id, @Param("firstName") String firstName, @Param("lastNameP") String lastNameP,
//								   @Param("lastNameM") String lastNameM, @Param("email") String email, @Param("birthdate") String birthdate,
//								   @Param("gender") String gender, @Param("phone") String phone, @Param("mobilePhone") String mobilePhone);
//
//	@Modifying
//	@Query(value = "UPDATE user u SET u.first_name = :firstName, u.last_namep = :lastNameP, u.last_namem = :lastNameM, " +
//			"u.email = :email, u.fecha_nac = :birthdate, u.genero = :gender, u.telefono_fijo = :phone, u.telefono_movil = :mobilePhone, " +
//			"u.password = :password WHERE u.id = :id", nativeQuery=true)
//	void updateMonitor(@Param("id") Long id, @Param("firstName") String firstName, @Param("lastNameP") String lastNameP,
//					@Param("lastNameM") String lastNameM, @Param("email") String email, @Param("birthdate") String birthdate,
//					@Param("gender") String gender, @Param("phone") String phone, @Param("mobilePhone") String mobilePhone,
//					   @Param("password") String password);
}