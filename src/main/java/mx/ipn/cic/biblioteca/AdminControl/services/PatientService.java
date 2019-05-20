package mx.ipn.cic.biblioteca.AdminControl.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ipn.cic.biblioteca.AdminControl.repositories.IPatientRepository;

@Service
public class PatientService {

	@Autowired
	private IPatientRepository repository;

	public PatientModel register(PatientModel newUser) {

		return this.repository.save(newUser);

	}

	public PatientModel findById(Integer id) {

		Optional<PatientModel> found = this.repository.findById(id);

		try {
			return found.get();
		} catch (NoSuchElementException e) {
			System.out.println("No se encontró el elemento");
		}

		return null;

	}
	
	public List<PatientModel> findAll() {
		
		return this.repository.findAll();
		
	}

	public boolean delete(Integer idToDelete) {

		this.repository.deleteById(idToDelete);

		return true;

	}

	public PatientModel edit(PatientModel bookModel) {

		return this.repository.save(bookModel);

	}
	
	public List<PatientModel> search(
			String name, 
			String lastnameP,
			String lastnameM){
				
		return this
				.repository
				.findByNameContainingOrLastnamePContainingOrLastnameMContaining(
						name.length() > 0 ? name : " ", 
						lastnameP.length() > 0 ? lastnameP : " ",
						lastnameM.length() > 0 ? lastnameM : " ");

	}
	public List<PatientModel> search(String name){
		return this.repository.findByNameContaining(name.length() > 0 ? name : " ");
	}

}
