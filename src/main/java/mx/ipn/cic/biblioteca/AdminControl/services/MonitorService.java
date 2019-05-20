package mx.ipn.cic.biblioteca.AdminControl.services;

import mx.ipn.cic.biblioteca.AdminControl.model.MonitorModel;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IMonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MonitorService {
    @Autowired
    private IMonitorRepository monitorRepository;

    public MonitorModel register(MonitorModel newMonitor){
        return this.monitorRepository.save(newMonitor);
    }

    public MonitorModel findById(Long identificador){
        Optional<MonitorModel> found = this.monitorRepository.findById(identificador);
        try{
            return found.get();
        }catch (NoSuchElementException e){
            System.out.println("No se encontró el elemento");
        }
        return null;
    }

    public List<MonitorModel> findAll(){
        return this.monitorRepository.findAll();
    }

    public boolean delete(Long idToDelete){
        this.monitorRepository.deleteById(idToDelete);
        return true;
    }

    public MonitorModel edit(MonitorModel monitorModel){
        return this.monitorRepository.save(monitorModel);
    }


}
