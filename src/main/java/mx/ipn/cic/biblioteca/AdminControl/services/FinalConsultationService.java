package mx.ipn.cic.biblioteca.AdminControl.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

//import org.graalvm.compiler.virtual.phases.ea.PartialEscapeClosure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ipn.cic.biblioteca.AdminControl.model.FinalConsultation;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IFinalConsultationRepository;

@Service
public class FinalConsultationService {

    @Autowired
    private IFinalConsultationRepository repository;

    public FinalConsultation register(FinalConsultation newConsultation) {

        return this.repository.save(newConsultation);
    }

    public FinalConsultation findById(Integer id) {

        Optional<FinalConsultation> found = this.repository.findById(id);

        try {
            return found.get();
        } catch (NoSuchElementException e) {
            System.out.println("No se encontró el elemento");
        }

        return null;

    }

    public FinalConsultation findByPatientId(Integer id){
        return this.repository.findByIdPatient(id);

    }

    public List<FinalConsultation> findAll() {

        return this.repository.findAll();

    }

    public boolean delete(Integer idToDelete) {

        this.repository.deleteById(idToDelete);

        return true;

    }

    public FinalConsultation edit(FinalConsultation bookModel) {

        return this.repository.save(bookModel);

    }

}