package mx.ipn.cic.biblioteca.AdminControl.repositories;

import mx.ipn.cic.biblioteca.AdminControl.model.MonitorModel;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IMonitorRepository extends UserBaseRepository<MonitorModel>{
    @Query(value="SELECT * FROM user WHERE email = :email",nativeQuery = true)
    public Long findIdByEmail(@Param("email") String email);
    
    
    @Modifying
	@Query(value = "UPDATE user u SET u.first_name = :firstName, u.last_namep = :lastNameP, u.last_namem = :lastNameM, " +
			"u.email = :email, u.fecha_nac = :birthdate, u.genero = :gender, u.telefono_fijo = :phone, u.telefono_movil = :mobilePhone, " +
			"WHERE u.id = :id", nativeQuery=true)
	void updateMonitorWithoutPassword(@Param("id") Long id, @Param("firstName") String firstName, @Param("lastNameP") String lastNameP,
								   @Param("lastNameM") String lastNameM, @Param("email") String email, @Param("birthdate") String birthdate,
								   @Param("gender") String gender, @Param("phone") String phone, @Param("mobilePhone") String mobilePhone);

	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE user u SET u.first_name = :firstName, u.last_namep = :lastNameP, u.last_namem = :lastNameM, " +
			"u.email = :email, u.fecha_nac = :birthdate, u.genero = :gender, u.telefono_fijo = :phone, u.telefono_movil = :mobilePhone, " +
			"u.password = :password WHERE u.id = :id", nativeQuery=true)
	void updateMonitor(@Param("id") Long id, @Param("firstName") String firstName, @Param("lastNameP") String lastNameP,
					@Param("lastNameM") String lastNameM, @Param("email") String email, @Param("birthdate") String birthdate,
					@Param("gender") String gender, @Param("phone") String phone, @Param("mobilePhone") String mobilePhone,
					   @Param("password") String password);
}
