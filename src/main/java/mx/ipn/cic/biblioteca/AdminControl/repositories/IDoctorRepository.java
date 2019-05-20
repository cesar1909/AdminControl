package mx.ipn.cic.biblioteca.AdminControl.repositories;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;


//import mx.ipn.cic.biblioteca.AdminControl.ResultQueries.findPatientsByEmailResult;
import mx.ipn.cic.biblioteca.AdminControl.model.DoctorModel;
import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;
import mx.ipn.cic.biblioteca.AdminControl.model.Role;
import mx.ipn.cic.biblioteca.AdminControl.model.User;

@Transactional
public interface IDoctorRepository extends UserBaseRepository<DoctorModel> {
	@Query(value="SELECT * FROM user WHERE email = :email",nativeQuery = true)
	public Role findIdByEmail(@Param("email") String email);
//	
//	@Modifying
//	@Query(value = "UPDATE user set EMAIL_VERIFICATION_STATUS =?1 where u.USER_ID = ?2",nativeQuery = true)
//	void updateAdmin(boolean emailVerificationStatus, String userId);
}
