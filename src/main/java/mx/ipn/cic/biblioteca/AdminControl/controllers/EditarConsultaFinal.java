package mx.ipn.cic.biblioteca.AdminControl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.ipn.cic.biblioteca.AdminControl.model.FinalConsultation;
import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IFinalConsultationRepository;
import mx.ipn.cic.biblioteca.AdminControl.services.PatientService;

@Controller
@RequestMapping("/editpatientconsult")
public class EditarConsultaFinal {
	
	@Autowired
	private PatientService userService;
	@Autowired
	private IFinalConsultationRepository finalConsultationRepository;

    @PostMapping(path = "/final")
    public String register(
    	   @RequestParam(name = "idPatient") Integer idPatient,
           @RequestParam(name = "dateOfRealization") String dateRealization,
           @RequestParam(name = "albumin") String albumin,
           @RequestParam(name = "serumCalcium") String serumCalcium,
           @RequestParam(name = "lacticDehydrogenase") String lacticDehydrogenase,
           @RequestParam(name = "hemoglobin") String hemoglobin,
           @RequestParam(name = "hematocrit") String hematocrit,
           @RequestParam(name = "leukocytes") String leukocytes,
           @RequestParam(name = "lymphocytes") String lymphocytes,
           @RequestParam(name = "neutrophils") String neutrophils,
           @RequestParam(name = "platelets") String platelets,
           @RequestParam(name = "igG") String igG,
           @RequestParam(name = "igA") String igA,
           @RequestParam(name = "igM") String igM,
           @RequestParam(name = "lightChainsKappa") String lightChainsKappa,
           @RequestParam(name = "lightChainsLambda") String lightChainsLambda,
           @RequestParam(name = "celPlasmaticEnMedulaOsea") String celPlasmaticEnMedulaOsea,
           @RequestParam(name = "electroForesisDeProteinasSuero") String electroForesisDeProteinasSuero,
           @RequestParam(name = "electroForesisDeProteinasOrina") String electroForesisDeProteinasOrina,
           @RequestParam(name = "inmFijacionTipoIg") String inmFijacionTipoIg,
           @RequestParam(name = "inmFijacionTipoCll") String inmFijacionTipoCll,
           @RequestParam(name = "enfermedadMinimaResidual") String enfermedadMinimaResidual,
           @RequestParam(name = "repuestaATratamiento") String repuestaATratamiento,
           @RequestParam(name = "comentariosExtrax") String comentariosExtrax,
           @RequestParam(name = "dateOfTransplant", required = false) String dateOfTransplant,
           @RequestParam(name = "numberOfCD34Infused", required = false) String numberOfCD34Infused,
           @RequestParam(name = "myeloidGraftDate", required = false) String myeloidGraftDate,
           @RequestParam(name = "datePlateletGraft", required = false) String datePlateletGraft,
           @RequestParam(name = "toxicities", required = false) String toxicities
           ){

        // Proceso de registro
        if(idPatient!=0 & dateOfTransplant!=null & numberOfCD34Infused!=null &
            myeloidGraftDate!=null & datePlateletGraft!=null & toxicities!=null) {
        	
        	System.out.println("NUEVO UPDATE CON VARIABLES");
        	System.out.println("idPatient:: "+idPatient);
        	System.out.println("dateRealization:: "+dateRealization);
        	System.out.println("albumin:: "+albumin);
        	System.out.println("serumCalcium:: "+serumCalcium);
        	
        	this.finalConsultationRepository.updateFinalConsult(
        			idPatient,
            		dateRealization,
            		albumin,
            		serumCalcium,
                    lacticDehydrogenase,
                    hemoglobin,
                    hematocrit,
                    leukocytes,
                    lymphocytes,
                    neutrophils,
                    platelets,
                    igG,
                    igA,
                    igM,
                    lightChainsKappa,
                    lightChainsLambda,
                    celPlasmaticEnMedulaOsea,
                    electroForesisDeProteinasSuero,
                    electroForesisDeProteinasOrina,
                    inmFijacionTipoIg,inmFijacionTipoCll,
                    enfermedadMinimaResidual,
                    repuestaATratamiento,
                    comentariosExtrax,
                    //nuevas
                    dateOfTransplant,
                    numberOfCD34Infused,
                    myeloidGraftDate,
                    datePlateletGraft,
                    toxicities        			
        			);
            }else if(idPatient!=0) {
            	System.out.println("NUEVO UPDATE CON VARIABLES");
            	System.out.println("NUEVO UPDATE CON VARIABLES");
            	System.out.println("idPatient:: "+idPatient);
            	System.out.println("dateRealization:: "+dateRealization);
            	System.out.println("albumin:: "+albumin);
            	System.out.println("serumCalcium:: "+serumCalcium);
            	
               	this.finalConsultationRepository.updateFinalConsultWithoutNewVariables(
            			idPatient,
                		dateRealization,
                		albumin,
                		serumCalcium,
                        lacticDehydrogenase,
                        hemoglobin,
                        hematocrit,
                        leukocytes,
                        lymphocytes,
                        neutrophils,
                        platelets,
                        igG,
                        igA,
                        igM,
                        lightChainsKappa,
                        lightChainsLambda,
                        celPlasmaticEnMedulaOsea,
                        electroForesisDeProteinasSuero,
                        electroForesisDeProteinasOrina,
                        inmFijacionTipoIg,inmFijacionTipoCll,
                        enfermedadMinimaResidual,
                        repuestaATratamiento,
                        comentariosExtrax       			
            			);
            }
        else {
            	
                return "redirect:/doctor/allPatients";
            }
        
        return "redirect:/doctor/allPatients";

    }
}
