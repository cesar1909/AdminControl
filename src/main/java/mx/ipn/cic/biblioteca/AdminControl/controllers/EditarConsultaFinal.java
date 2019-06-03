package mx.ipn.cic.biblioteca.AdminControl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public  @ResponseBody String register(
//    	   @RequestParam(name = "idPatient") Integer idPatient,
//           @RequestParam(name = "dateOfRealization") String dateRealization,
//           @RequestParam(name = "albumin") String albumin,
//           @RequestParam(name = "serumCalcium") String serumCalcium,
//           @RequestParam(name = "lacticDehydrogenase") String lacticDehydrogenase,
//           @RequestParam(name = "hemoglobin") String hemoglobin,
//           @RequestParam(name = "hematocrit") String hematocrit,
//           @RequestParam(name = "leukocytes") String leukocytes,
//           @RequestParam(name = "lymphocytes") String lymphocytes,
//           @RequestParam(name = "neutrophils") String neutrophils,
//           @RequestParam(name = "platelets") String platelets,
//           @RequestParam(name = "igG") String igG,
//           @RequestParam(name = "igA") String igA,
//           @RequestParam(name = "igM") String igM,
//           @RequestParam(name = "lightChainsKappa") String lightChainsKappa,
//           @RequestParam(name = "lightChainsLambda") String lightChainsLambda,
//           @RequestParam(name = "celPlasmaticEnMedulaOsea") String celPlasmaticEnMedulaOsea,
//           @RequestParam(name = "electroForesisDeProteinasSuero") String electroForesisDeProteinasSuero,
//           @RequestParam(name = "electroForesisDeProteinasOrina") String electroForesisDeProteinasOrina,
//           @RequestParam(name = "inmFijacionTipoIg") String inmFijacionTipoIg,
//           @RequestParam(name = "inmFijacionTipoCll") String inmFijacionTipoCll,
//           @RequestParam(name = "enfermedadMinimaResidual") String enfermedadMinimaResidual,
//           @RequestParam(name = "repuestaATratamiento") String repuestaATratamiento,
//           @RequestParam(name = "comentariosExtrax") String comentariosExtrax,
//           @RequestParam(name = "dateOfTransplant", required = false) String dateOfTransplant,
//           @RequestParam(name = "numberOfCD34Infused", required = false) String numberOfCD34Infused,
//           @RequestParam(name = "myeloidGraftDate", required = false) String myeloidGraftDate,
//           @RequestParam(name = "datePlateletGraft", required = false) String datePlateletGraft,
//           @RequestParam(name = "toxicities", required = false) String toxicities
			@RequestBody FinalConsultation finalConsultation
           ){


        // Proceso de registro
        if(
			finalConsultation.getIdPatient()!=0 &
			finalConsultation.getDateOfTransplant()!=null &
			finalConsultation.getNumberOfCD34Infused()!=null &
			finalConsultation.getMyeloidGraftDate()!=null &
			finalConsultation.getDatePlateletGraft()!=null &
			finalConsultation.getToxHemtoRedSerie()!=null &
			finalConsultation.getToxHemtoNeutrophils()!=null &
			finalConsultation.getToxHemtoPlatelets()!=null &
			finalConsultation.getToxHepatics()!=null &
			finalConsultation.getToxRenal()!=null &
			finalConsultation.getToxGastroNausea()!=null &
			finalConsultation.getToxGastroDiarrhea()!=null &
			finalConsultation.getToxNeuroatiaPerif()!=null &
			finalConsultation.getToxInfectious()!=null
        	) {
			System.out.println("EDITAMOS CON LA OPCION DE TRANSPLANTE");
			System.out.println("ID DEL PACIENTE: " + finalConsultation.getIdPatient());
        	this.finalConsultationRepository.updateFinalConsult(
					finalConsultation.getIdPatient(),
					finalConsultation.getDateOfRealization(),
					finalConsultation.getAlbumin(),
            		finalConsultation.getSerumCalcium(),
					finalConsultation.getLacticDehydrogenase(),
					finalConsultation.getHemoglobin(),
                    finalConsultation.getHematocrit(),
					finalConsultation.getLeukocytes(),
                    finalConsultation.getLymphocytes(),
                    finalConsultation.getNeutrophils(),
                    finalConsultation.getPlatelets(),
                    finalConsultation.getIgG(),
					finalConsultation.getIgA(),
					finalConsultation.getIgM(),
                    finalConsultation.getLightChainsKappa(),
                    finalConsultation.getLightChainsLambda(),
					finalConsultation.getCelPlasmaticEnMedulaOsea(),
					finalConsultation.getElectroForesisDeProteinasSuero(),
					finalConsultation.getElectroForesisDeProteinasOrina(),
					finalConsultation.getInmFijacionTipoIg(),
					finalConsultation.getInmFijacionTipoCll(),
                    finalConsultation.getEnfermedadMinimaResidual(),
                    finalConsultation.getRepuestaATratamiento(),
                    finalConsultation.getComentariosExtrax(),
                    //nuevas
                    finalConsultation.getDateOfTransplant(),
                    finalConsultation.getNumberOfCD34Infused(),
                    finalConsultation.getMyeloidGraftDate(),
                    finalConsultation.getDatePlateletGraft(),
                    finalConsultation.getToxHemtoRedSerie(),
                    finalConsultation.getToxHemtoNeutrophils(),
                    finalConsultation.getToxHemtoPlatelets(),
                    finalConsultation.getToxHepatics(),
                    finalConsultation.getToxRenal(),
                    finalConsultation.getToxGastroNausea(),
                    finalConsultation.getToxGastroDiarrhea(),
                    finalConsultation.getToxNeuroatiaPerif(),
                    finalConsultation.getToxInfectious()
        			);
            }else {
			System.out.println("EDITAMOS SIN LA OPCION DE TRANSPLANTE");
			System.out.println("ID DEL PACIENTE: " + finalConsultation.getIdPatient());
			System.out.println("IG: " + finalConsultation.getInmFijacionTipoIg());
			System.out.println("CLL: " + finalConsultation.getInmFijacionTipoCll());
			System.out.println("Respuesta: " + finalConsultation.getRepuestaATratamiento());

			this.finalConsultationRepository.updateFinalConsultWithoutNewVariables(
						finalConsultation.getIdPatient(),
						finalConsultation.getDateOfRealization(),
						finalConsultation.getAlbumin(),
						finalConsultation.getSerumCalcium(),
						finalConsultation.getLacticDehydrogenase(),
						finalConsultation.getHemoglobin(),
						finalConsultation.getHematocrit(),
						finalConsultation.getLeukocytes(),
						finalConsultation.getLymphocytes(),
						finalConsultation.getNeutrophils(),
						finalConsultation.getPlatelets(),
						finalConsultation.getIgG(),
						finalConsultation.getIgA(),
						finalConsultation.getIgM(),
						finalConsultation.getLightChainsKappa(),
						finalConsultation.getLightChainsLambda(),
						finalConsultation.getCelPlasmaticEnMedulaOsea(),
						finalConsultation.getElectroForesisDeProteinasSuero(),
						finalConsultation.getElectroForesisDeProteinasOrina(),
						finalConsultation.getInmFijacionTipoIg(),
						finalConsultation.getInmFijacionTipoCll(),
						finalConsultation.getEnfermedadMinimaResidual(),
						finalConsultation.getRepuestaATratamiento(),
						finalConsultation.getComentariosExtrax()
            			);
            }

		return "todo bien";

    }
}
