//package mx.ipn.cic.biblioteca.AdminControl.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import mx.ipn.cic.biblioteca.AdminControl.model.DoctorModel;
//import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;
//
//@Controller
//@RequestMapping("/edit")
//public class EditarPacienteCI {
//
//	
//	@PostMapping(path = "/register")
//	public String register(
//			@RequestParam(name = "id", required = false) Integer id,
//			@RequestParam(name = "name") String name,
//			@RequestParam(name = "lastnameP") String lastnameP,
//			@RequestParam(name = "lastnameM") String lastnameM,
//			@RequestParam(name = "birthdate") String birthdate,
//			@RequestParam(name = "age") String age,
//			@RequestParam(name = "gender") String gender,
//			@RequestParam(name = "height") String height,
//			@RequestParam(name = "weight") String weight,
//	        @RequestParam(name = "bmi") String bmi,
//	        @RequestParam(name = "bodySup") String bodySup,
//
//			@RequestParam(name = "startDateOfTreatment") String startDateOfTreatment,
//			@RequestParam(name = "serumCreatinine") String serumCreatinine,
//			@RequestParam(name = "depCreatinine") String depCreatinine,
//			@RequestParam(name = "ecog") String ecog,
//			@RequestParam(name = "boneInjuries") String boneInjuries,
//			@RequestParam(name = "boneInjuriesNumber") String boneInjuriesNumber,
//			@RequestParam(name = "extramedullaryPlasmacytomas") String extramedullaryPlasmacytomas,
//	        @RequestParam(name = "plasmacytomasNumber") String plasmacytomasNumber,
//	        @RequestParam(name = "active") String active,
//			@RequestParam(name = "plasmaCellsInBoneMarrow") String plasmaCellsInBoneMarrow,
//			@RequestParam(name = "plasmaCellsInBloodPerif") String plasmaCellsInBloodPerif,
//			@RequestParam(name = "igG") String igG,
//			@RequestParam(name = "igA") String igA,
//			@RequestParam(name = "igM") String igM,
//			@RequestParam(name = "inmIgTypeFixation") String inmIgTypeFixation,
//	        @RequestParam(name = "inmCllTypeFixation") String inmCllTypeFixation,
//	        @RequestParam(name = "lightChainsKappa") String lightChainsKappa,
//	        @RequestParam(name = "lightChainsLambda") String lightChainsLambda,
//	        @RequestParam(name = "electroForesisDeProteinasSuero") String electroForesisDeProteinasSuero,
//	        @RequestParam(name = "electroForesisDeProteinasOrina") String electroForesisDeProteinasOrina,
//			@RequestParam(name = "benceJonesProteinuria") String benceJonesProteinuria,
//			@RequestParam(name = "dystemicAmyloidosis") String dystemicAmyloidosis,
//			@RequestParam(name = "b2Microglobulin") String b2Microglobulin,
//			@RequestParam(name = "albumin") String albumin,
//			@RequestParam(name = "serumCalcium") String serumCalcium,
//			@RequestParam(name = "lacticDehydrogenase") String lacticDehydrogenase,
//	        @RequestParam(name = "hemoglobin") String hemoglobin,
//			@RequestParam(name = "hematocrit") String hematocrit,
//			@RequestParam(name = "lymphocytes") String lymphocytes,
//			@RequestParam(name = "leukocytes") String leukocytes,
//	        @RequestParam(name = "neutrophils") String neutrophils,
//	        @RequestParam(name = "platelets") String platelets,
//			@RequestParam(name = "deletionSeventeenP") String deletionSeventeenP,
//			@RequestParam(name = "translocationFourToFourteen") String translocationFourToFourteen,
//			@RequestParam(name = "translocationFourteenToSixteen") String translocationFourteenToSixteen,
//			@RequestParam(name = "idDoctor", required = false) String idDoctor
//			) {
//
//		Long idUsr = null;
//		if (idDoctor == null) {
//			System.out.println("PREPARANDO PARA REGISTRAR");
//			idUsr = this.userRepository.findIdByEmail(this.userServiceImpl.getEmailUser());
//		} else {
//			System.out.println("Preparando para EDITAR");
//			idUsr = Long.parseLong(idDoctor);
//		}
//			DoctorModel drm = this.doctorService.findById(idUsr);
//
//
//			// Proceso de registro
//			PatientModel user = new PatientModel(
//					//paciente
//					id,
//					name.replaceAll("[,]",""),
//					lastnameP.replaceAll("[,]",""),
//					lastnameM.replaceAll("[,]",""),
//					birthdate.replaceAll("[,]",""),
//					age.replaceAll("[,]",""),
//					gender.replaceAll("[,]",""),
//					height.replaceAll("[,]",""),
//					weight.replaceAll("[,]",""),
//					bmi.replaceAll("[,]",""),
//					bodySup.replaceAll("[,]",""),
//					//consultainicial
//					startDateOfTreatment.replaceAll("[,]",""),
//					serumCreatinine.replaceAll("[,]",""),
//					depCreatinine.replaceAll("[,]",""),
//					ecog.replaceAll("[,]",""),
//					boneInjuries.replaceAll("[,]",""),
//					boneInjuriesNumber.replaceAll("[,]",""),
//					extramedullaryPlasmacytomas.replaceAll("[,]",""),
//					plasmacytomasNumber.replaceAll("[,]",""),
//					active.replaceAll("[,]",""),
//					plasmaCellsInBoneMarrow.replaceAll("[,]",""),
//					plasmaCellsInBloodPerif.replaceAll("[,]",""),
//					igG.replaceAll("[,]",""),
//					igA.replaceAll("[,]",""),
//					igM.replaceAll("[,]",""),
//					inmIgTypeFixation.replaceAll("[,]",""),
//					inmCllTypeFixation.replaceAll("[,]",""),
//					lightChainsKappa.replaceAll("[,]",""),
//					lightChainsLambda.replaceAll("[,]",""),
//					electroForesisDeProteinasSuero.replaceAll("[,]",""),
//					electroForesisDeProteinasOrina.replaceAll("[,]",""),
//					benceJonesProteinuria.replaceAll("[,]",""),
//					dystemicAmyloidosis.replaceAll("[,]",""),
//					b2Microglobulin.replaceAll("[,]",""),
//					albumin.replaceAll("[,]",""),
//					serumCalcium.replaceAll("[,]",""),
//					lacticDehydrogenase.replaceAll("[,]",""),
//					hemoglobin.replaceAll("[,]",""),
//					hematocrit.replaceAll("[,]",""),
//					lymphocytes.replaceAll("[,]",""),
//					leukocytes.replaceAll("[,]",""),
//					neutrophils.replaceAll("[,]",""),
//					platelets.replaceAll("[,]",""),
//					deletionSeventeenP.replaceAll("[,]",""),
//					translocationFourToFourteen.replaceAll("[,]",""),
//					translocationFourteenToSixteen.replaceAll("[,]",""),
//					drm
//			);
//
//			if (id == null) {
//				System.out.println("USER patient: " + user);
//				this.userService.register(user);
//				return "redirect:/doctor/sucess1";
//			} else if (id != null) {
//				System.out.println("EDITAMOS");
//				this.userService.edit(user);
//				return "redirect:/monitor/allPatients";
//			}
//
//			return "redirect:/doctor/allPatients";
//
//		}
//	
//
//			
//			
//}
