package mx.ipn.cic.biblioteca.AdminControl.repositories;

import mx.ipn.cic.biblioteca.AdminControl.model.MonitorModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IMonitorRepository extends UserBaseRepository<MonitorModel>{
    @Query(value="SELECT * FROM user WHERE email = :email",nativeQuery = true)
    public Long findIdByEmail(@Param("email") String email);
}
