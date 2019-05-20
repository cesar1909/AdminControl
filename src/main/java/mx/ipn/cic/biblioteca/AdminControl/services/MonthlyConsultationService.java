package mx.ipn.cic.biblioteca.AdminControl.services;

import java.util.*;

import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ipn.cic.biblioteca.AdminControl.model.MonthlyConsultation;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IMonthlyConsultationRepository;

@Service
public class MonthlyConsultationService {

	@Autowired
	private IMonthlyConsultationRepository repository;

	public MonthlyConsultation register(MonthlyConsultation newConsultation) {

		return this.repository.save(newConsultation);
	}

	public MonthlyConsultation findById(Integer id) {

		Optional<MonthlyConsultation> found = this.repository.findById(id);

		try {
			return found.get();
		} catch (NoSuchElementException e) {
			System.out.println("No se encontró el elemento");
		}

		return null;

	}

	public LinkedList<MonthlyConsultation> findByPatientId(PatientModel patientModel){
		return this.repository.findByIdpatientIn(patientModel);
	}

	public List<MonthlyConsultation> findAll() {

		return this.repository.findAll();

	}

	public boolean delete(Integer idToDelete) {

		this.repository.deleteById(idToDelete);

		return true;

	}

	public MonthlyConsultation edit(MonthlyConsultation bookModel) {

		return this.repository.save(bookModel);

	}

}