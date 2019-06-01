package mx.ipn.cic.biblioteca.AdminControl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.ipn.cic.biblioteca.AdminControl.model.MonthlyConsultation;
import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IMonthlyConsultationRepository;

@Controller
@RequestMapping("/editpatientinitialconsult")
public class EditarConsultaMensual {

	@Autowired
	IMonthlyConsultationRepository monthlyConsultationRepository;
	
    @PostMapping(path = "/mensual/")
    public String register(
	   @RequestParam(name = "treatmentCycleNum") String treatmentCycleNum,
	   @RequestParam(name = "dateOfRealization") String dateOfRealization,
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
       @RequestParam(name = "toxHemtoRedSerie") String toxHemtoRedSerie,
       @RequestParam(name = "toxHemtoNeutrophils") String toxHemtoNeutrophils,
       @RequestParam(name = "toxHemtoPlatelets") String toxHemtoPlatelets,
       @RequestParam(name = "toxHepatics") String toxHepatics,
       @RequestParam(name = "toxRenal") String toxRenal,
       @RequestParam(name = "toxGastroNausea") String toxGastroNausea,
       @RequestParam(name = "toxGastroDiarrhea") String toxGastroDiarrhea,
       @RequestParam(name = "toxNeuroatiaPerif") String toxNeuroatiaPerif,
       @RequestParam(name = "toxInfectious") String toxInfectious,
       @RequestParam(name = "infectionSite") String infectionSite,
       @RequestParam(name = "infusionMedReaction") String infusionMedReaction,
       @RequestParam(name ="adverseReaction") String adverseReaction,
      // @RequestParam(name = "idMonthlyConsultation", required = false) Integer idMonthlyConsultation,
       @RequestParam(name = "idpatient") Integer idpatient) {

        // Proceso de registro

    		if(idpatient!=0) {
    			System.out.println("idpatient:: "+idpatient);
    			System.out.println("treatmentCycleNum:: "+treatmentCycleNum);
    			System.out.println("dateOfRealization:: "+dateOfRealization);

    			this.monthlyConsultationRepository.updateMonthlyConsult(
                		treatmentCycleNum,
                		dateOfRealization,
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
                		toxHemtoRedSerie,
                		toxHemtoNeutrophils,
                		toxHemtoPlatelets,
                		toxHepatics,
                		toxRenal,
                		toxGastroNausea,
                		toxGastroDiarrhea,
                		toxNeuroatiaPerif,
                		toxInfectious,
                		infectionSite,
                		infusionMedReaction,
                		adverseReaction,
                		idpatient
                		);
            } else {
                return "redirect:/doctor/allPatients";
            }
        return "redirect:/doctor/allPatients";
    }


}
