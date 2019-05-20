package mx.ipn.cic.biblioteca.AdminControl.repositories;

import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;
import mx.ipn.cic.biblioteca.AdminControl.services.PatientService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.ipn.cic.biblioteca.AdminControl.model.MonthlyConsultation;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public interface IMonthlyConsultationRepository extends JpaRepository<MonthlyConsultation, Integer>{
    LinkedList<MonthlyConsultation> findByIdpatientIn(PatientModel patientModel);
}