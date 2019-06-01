package mx.ipn.cic.biblioteca.AdminControl.repositories;

import java.util.List;

import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;
import mx.ipn.cic.biblioteca.AdminControl.projections.FindPatientsByEmailResult;
import mx.ipn.cic.biblioteca.AdminControl.projections.FindFullNameByEmailResult;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.String;

@Repository
public interface IPatientRepository extends JpaRepository<PatientModel, Integer> {

	List<PatientModel> findByNameContainingOrLastnamePContainingOrLastnameMContaining(
			String name,
			String lastnameP,
			String lastnameM
			);
	List<PatientModel> findByNameContaining(
	String name
	);
}
