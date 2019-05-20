package mx.ipn.cic.biblioteca.AdminControl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.ipn.cic.biblioteca.AdminControl.model.FinalConsultation;
import java.lang.Integer;
import java.util.List;
import java.util.Optional;

@Repository
public interface IFinalConsultationRepository extends JpaRepository<FinalConsultation, Integer>{
    FinalConsultation findByIdPatient(Integer id);

}