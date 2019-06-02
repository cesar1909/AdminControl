package mx.ipn.cic.biblioteca.AdminControl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import mx.ipn.cic.biblioteca.AdminControl.model.MonthlyConsultation;
import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IMonthlyConsultationRepository;

@Controller
@RequestMapping("/editpatientmothlyconsult")
public class EditarConsultaMensual {

	@Autowired
	IMonthlyConsultationRepository monthlyConsultationRepository;
	
    @PostMapping(path = "/mensual")
    public @ResponseBody String register(
//	   @RequestParam(name = "treatmentCycleNum") String treatmentCycleNum,
//	   @RequestParam(name = "dateOfRealization") String dateOfRealization,
//       @RequestParam(name = "albumin") String albumin,
//       @RequestParam(name = "serumCalcium") String serumCalcium,
//       @RequestParam(name = "lacticDehydrogenase") String lacticDehydrogenase,
//       @RequestParam(name = "hemoglobin") String hemoglobin,
//       @RequestParam(name = "hematocrit") String hematocrit,
//       @RequestParam(name = "leukocytes") String leukocytes,
//       @RequestParam(name = "lymphocytes") String lymphocytes,
//       @RequestParam(name = "neutrophils") String neutrophils,
//       @RequestParam(name = "platelets") String platelets,
//       @RequestParam(name = "igG") String igG,
//       @RequestParam(name = "igA") String igA,
//       @RequestParam(name = "igM") String igM,
//       @RequestParam(name = "lightChainsKappa") String lightChainsKappa,
//       @RequestParam(name = "lightChainsLambda") String lightChainsLambda,
//       @RequestParam(name = "toxHemtoRedSerie") String toxHemtoRedSerie,
//       @RequestParam(name = "toxHemtoNeutrophils") String toxHemtoNeutrophils,
//       @RequestParam(name = "toxHemtoPlatelets") String toxHemtoPlatelets,
//       @RequestParam(name = "toxHepatics") String toxHepatics,
//       @RequestParam(name = "toxRenal") String toxRenal,
//       @RequestParam(name = "toxGastroNausea") String toxGastroNausea,
//       @RequestParam(name = "toxGastroDiarrhea") String toxGastroDiarrhea,
//       @RequestParam(name = "toxNeuroatiaPerif") String toxNeuroatiaPerif,
//       @RequestParam(name = "toxInfectious") String toxInfectious,
//       @RequestParam(name = "infectionSite") String infectionSite,
//       @RequestParam(name = "infusionMedReaction") String infusionMedReaction,
//       @RequestParam(name ="adverseReaction") String adverseReaction,
//      // @RequestParam(name = "idMonthlyConsultation", required = false) Integer idMonthlyConsultation,
//       @RequestParam(name = "idpatient") Integer idpatient
			@RequestBody MonthlyConsultation monthlyConsultation
	) {

        // Proceso de registro

    		if(monthlyConsultation.getIdMonthlyConsultation()!=0) {
				System.out.println("Editamos la consulta mensual: " + monthlyConsultation.getTreatmentCycleNum());
				System.out.println("Del paciente: " + monthlyConsultation.getIdMonthlyConsultation());
    			this.monthlyConsultationRepository.updateMonthlyConsult(
                		monthlyConsultation.getTreatmentCycleNum(),
						monthlyConsultation.getDateOfRealization(),
						monthlyConsultation.getAlbumin(),
						monthlyConsultation.getSerumCalcium(),
                		monthlyConsultation.getLacticDehydrogenase(),
						monthlyConsultation.getHemoglobin(),
						monthlyConsultation.getHematocrit(),
						monthlyConsultation.getLeukocytes(),
						monthlyConsultation.getLymphocytes(),
						monthlyConsultation.getNeutrophils(),
						monthlyConsultation.getPlatelets(),
						monthlyConsultation.getIgG(),
						monthlyConsultation.getIgA(),
						monthlyConsultation.getIgM(),
						monthlyConsultation.getLightChainsKappa(),
						monthlyConsultation.getLightChainsLambda(),
						monthlyConsultation.getToxHemtoRedSerie(),
						monthlyConsultation.getToxHemtoNeutrophils(),
						monthlyConsultation.getToxHemtoPlatelets(),
						monthlyConsultation.getToxHepatics(),
						monthlyConsultation.getToxRenal(),
						monthlyConsultation.getToxGastroNausea(),
						monthlyConsultation.getToxGastroDiarrhea(),
						monthlyConsultation.getToxNeuroatiaPerif(),
						monthlyConsultation.getToxInfectious(),
						monthlyConsultation.getInfectionSite(),
						monthlyConsultation.getInfusionMedReaction(),
						monthlyConsultation.getAdverseReaction(),
                		monthlyConsultation.getIdMonthlyConsultation()
                		);
            } else {
				System.out.println("ERROR EN EL OBJETO PASADO A EDITAR CONSULTA MENSUAL");
            }
        return "todo bien";
    }


}
