package mx.ipn.cic.biblioteca.AdminControl.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ipn.cic.biblioteca.AdminControl.model.DoctorModel;
import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IDoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private IDoctorRepository repository;

	public DoctorModel register(DoctorModel newDoctor) {

		return this.repository.save(newDoctor);

	}

	public DoctorModel findById(Long id) {

		Optional<DoctorModel> found = this.repository.findById(id);

		try {
			return found.get();
		} catch (NoSuchElementException e) {
			System.out.println("No se encontró el elemento");
		}

		return null;

	}

	public List<DoctorModel> findAll() {
		
		return this.repository.findAll();
		
	}

	public boolean delete(Long idToDelete) {

		this.repository.deleteById(idToDelete);

		return true;

	}

	public DoctorModel edit(DoctorModel doctorModel) {

		return this.repository.save(doctorModel);

	}

}
