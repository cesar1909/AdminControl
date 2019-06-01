package mx.ipn.cic.biblioteca.AdminControl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.ipn.cic.biblioteca.AdminControl.model.DoctorModel;
import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IPatientRepository;

@Controller
@RequestMapping("/editpatientinitialconsult")
public class EditarConsultaInicial {
	
	@Autowired
	IPatientRepository patientRepository;

	
	@PostMapping(path = "/inicial")
	public String register(
			@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "name") String name,
			@RequestParam(name = "lastnameP") String lastnameP,
			@RequestParam(name = "lastnameM") String lastnameM,
			@RequestParam(name = "birthdate") String birthdate,
			@RequestParam(name = "age") String age,
			@RequestParam(name = "gender") String gender,
			@RequestParam(name = "height") String height,
			@RequestParam(name = "weight") String weight,
	        @RequestParam(name = "bmi") String bmi,
	        @RequestParam(name = "bodySup") String bodySup,

			@RequestParam(name = "startDateOfTreatment") String startDateOfTreatment,
			@RequestParam(name = "serumCreatinine") String serumCreatinine,
			@RequestParam(name = "depCreatinine") String depCreatinine,
			@RequestParam(name = "ecog") String ecog,
			@RequestParam(name = "boneInjuries") String boneInjuries,
			@RequestParam(name = "boneInjuriesNumber") String boneInjuriesNumber,
			@RequestParam(name = "extramedullaryPlasmacytomas") String extramedullaryPlasmacytomas,
	        @RequestParam(name = "plasmacytomasNumber") String plasmacytomasNumber,
	        @RequestParam(name = "active") String active,
			@RequestParam(name = "plasmaCellsInBoneMarrow") String plasmaCellsInBoneMarrow,
			@RequestParam(name = "plasmaCellsInBloodPerif") String plasmaCellsInBloodPerif,
			@RequestParam(name = "igG") String igG,
			@RequestParam(name = "igA") String igA,
			@RequestParam(name = "igM") String igM,
			@RequestParam(name = "inmIgTypeFixation") String inmIgTypeFixation,
	        @RequestParam(name = "inmCllTypeFixation") String inmCllTypeFixation,
	        @RequestParam(name = "lightChainsKappa") String lightChainsKappa,
	        @RequestParam(name = "lightChainsLambda") String lightChainsLambda,
	        @RequestParam(name = "electroForesisDeProteinasSuero") String electroForesisDeProteinasSuero,
	        @RequestParam(name = "electroForesisDeProteinasOrina") String electroForesisDeProteinasOrina,
			@RequestParam(name = "benceJonesProteinuria") String benceJonesProteinuria,
			@RequestParam(name = "dystemicAmyloidosis") String dystemicAmyloidosis,
			@RequestParam(name = "b2Microglobulin") String b2Microglobulin,
			@RequestParam(name = "albumin") String albumin,
			@RequestParam(name = "serumCalcium") String serumCalcium,
			@RequestParam(name = "lacticDehydrogenase") String lacticDehydrogenase,
	        @RequestParam(name = "hemoglobin") String hemoglobin,
			@RequestParam(name = "hematocrit") String hematocrit,
			@RequestParam(name = "lymphocytes") String lymphocytes,
			@RequestParam(name = "leukocytes") String leukocytes,
	        @RequestParam(name = "neutrophils") String neutrophils,
	        @RequestParam(name = "platelets") String platelets,
			@RequestParam(name = "deletionSeventeenP") String deletionSeventeenP,
			@RequestParam(name = "translocationFourToFourteen") String translocationFourToFourteen,
			@RequestParam(name = "translocationFourteenToSixteen") String translocationFourteenToSixteen,
			@RequestParam(name = "idDoctor", required = false) String idDoctor
			) {
		Long iddoc = Long.parseLong(idDoctor);

		if(id!=0) {
			//idDoctor e id (paciente)
			this.patientRepository.updateInitialConsult(
			id,
			name,
			lastnameP,
			lastnameM,
			birthdate,
			age,
			gender,
			height,
			weight,
			bmi,
			bodySup,
			//consultainicial
			startDateOfTreatment,
			serumCreatinine,
			depCreatinine,
			ecog,
			boneInjuries,
			boneInjuriesNumber,
			extramedullaryPlasmacytomas,
			plasmacytomasNumber,
			active,
			plasmaCellsInBoneMarrow,
			plasmaCellsInBloodPerif,
			igG,
			igA,
			igM,
			inmIgTypeFixation,
			inmCllTypeFixation,
			lightChainsKappa,
			lightChainsLambda,
			electroForesisDeProteinasSuero,
			electroForesisDeProteinasOrina,
			benceJonesProteinuria,
			dystemicAmyloidosis,
			b2Microglobulin,
			albumin,
			serumCalcium,
			lacticDehydrogenase,
			hemoglobin,
			hematocrit,
			lymphocytes,
			leukocytes,
			neutrophils,
			platelets,
			deletionSeventeenP,
			translocationFourToFourteen,
			translocationFourteenToSixteen,
			iddoc
			);			
		}else{
			return "redirect:/doctor/allPatients";
		}
		return "redirect:/doctor/allPatients";

		}

	
}
