//package mx.ipn.cic.biblioteca.AdminControl.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import mx.ipn.cic.biblioteca.AdminControl.model.InitialConsultation;
//import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;
//import mx.ipn.cic.biblioteca.AdminControl.services.ConsultationService;
//import mx.ipn.cic.biblioteca.AdminControl.services.PatientService;
//
//@Controller
//@RequestMapping("/consult")
//public class InitialConsultationController {
//
//	@Autowired
//	private ConsultationService consultationService;
//	
//	@Autowired
//	private PatientService userService;
//	
//	@GetMapping(path = "")
//	public String redirectToAll() {
//		return "redirect:/consult/home";
//	}
//	
////	@GetMapping(path = "/all")
////	public ModelAndView allConsults() {
////
////		List<InitialConsultation> findAll = this.consultationService.findAll();
////
////		ModelAndView mav = new ModelAndView("initialConsultation_1");
////		mav.addObject("consults", findAll);
////
////		return mav;
////
////	}
//	
//	@GetMapping(path = "/newForm")
//	public ModelAndView newConsultForm() {
//
//		ModelAndView mav = new ModelAndView("initialConsultation_1", "consulModel", new InitialConsultation());
//		return mav;
//	}
//
///*
//	@GetMapping(path = "/all")
//	public ModelAndView allUsers() {
//
//		List<PatientModel> findAll = this.userService.findAll();
//
//		ModelAndView mav = new ModelAndView("patientsList");
//		mav.addObject("users", findAll);
//
//		return mav;
//
//	}
//*/
//		
//	@PostMapping(path = "/register/")
//	public String register(
//			@RequestParam(name = "id") int idPatient,
//			@RequestParam(name = "dateRealization") String dateRealization,
//			@RequestParam(name = "serumCreatinine") float serumCreatinine,
//			@RequestParam(name = "depCreatinine") float depCreatinine,
//			@RequestParam(name = "ecog") float ecog,
//			@RequestParam(name = "boneInjuries") int boneInjuries,
//			@RequestParam(name = "boneInjuriesNumber") int boneInjuriesNumber,
//			@RequestParam(name = "extramedullaryPlasmacytomas") int extramedullaryPlasmacytomas,
//	        @RequestParam(name = "plasmacytomasNumber") int plasmacytomasNumber,
//	        @RequestParam(name = "active") int active,
//			@RequestParam(name = "plasmaCellsInBoneMarrow") int plasmaCellsInBoneMarrow,
//			@RequestParam(name = "plasmaCellsInBloodPerif") int plasmaCellsInBloodPerif,
//			@RequestParam(name = "igG") int igG,
//			@RequestParam(name = "igA") int igA,
//			@RequestParam(name = "igM") int igM,
//			@RequestParam(name = "inmIgTypeFixation") String inmIgTypeFixation,
//	        @RequestParam(name = "inmCllTypeFixation") String inmCllTypeFixation,
//	        @RequestParam(name = "lightChainsKappa") int lightChainsKappa,
//	        @RequestParam(name = "lightChainsLambda") int lightChainsLambda,
//	        @RequestParam(name = "electroForesisDeProteinasSuero") int electroForesisDeProteinasSuero,
//	        @RequestParam(name = "electroForesisDeProteinasOrina") int electroForesisDeProteinasOrina,
//			@RequestParam(name = "benceJonesProteinuria") int benceJonesProteinuria,
//			@RequestParam(name = "dystemicAmyloidosis") int dystemicAmyloidosis,
//			@RequestParam(name = "b2Microglobulin") float b2Microglobulin,
//			@RequestParam(name = "albumin") float albumin,
//			@RequestParam(name = "serumCalcium") int serumCalcium,
//			@RequestParam(name = "lacticDehydrogenase") int lacticDehydrogenase,
//	        @RequestParam(name = "hemoglobin") int hemoglobin,
//			@RequestParam(name = "hematocrit") int hematocrit,
//			@RequestParam(name = "lymphocytes") int lymphocytes,
//			@RequestParam(name = "leukocytes") int leukocytes,
//	        @RequestParam(name = "neutrophils") int neutrophils,
//	        @RequestParam(name = "platelets") int platelets,
//			@RequestParam(name = "deletionSeventeenP") int deletionSeventeenP,
//			@RequestParam(name = "translocationFourToFourteen") int translocationFourToFourteen,
//			@RequestParam(name = "translocationFourteenToSixteen") int translocationFourteenToSixteen,
//			@RequestParam(name = "startDateOfTreatment") String startDateOfTreatment//,
//	        //@RequestParam(name = "idPatient", required = false) Integer idPatient	        
//	        ){
//
//		// Proceso de registro
//		//idPatientURL
//		
//		if(idPatient!=0) {
//			//Buscamos al paciente dentro de la BD 
//			PatientModel userFound = this.userService.findById(idPatient);
//			if(userFound!=null) {
//				
//				InitialConsultation consultation = new InitialConsultation(
//						idPatient,
//						userFound,
//						dateRealization,
//						serumCreatinine,
//						depCreatinine,
//						ecog,
//						boneInjuries,
//						boneInjuriesNumber,
//						extramedullaryPlasmacytomas,
//						plasmacytomasNumber,
//						active,
//						plasmaCellsInBoneMarrow,
//						plasmaCellsInBloodPerif,
//						igG,
//						igA,
//						igM,
//						inmIgTypeFixation,
//						inmCllTypeFixation,
//						lightChainsKappa,
//						lightChainsLambda,
//						electroForesisDeProteinasSuero,
//						electroForesisDeProteinasOrina,
//						benceJonesProteinuria,
//						dystemicAmyloidosis,
//						b2Microglobulin,
//						albumin,
//						serumCalcium,
//						lacticDehydrogenase,
//						hemoglobin,
//						hematocrit,
//						lymphocytes,
//						leukocytes,
//						neutrophils,
//						platelets,
//						deletionSeventeenP,
//						translocationFourToFourteen,
//						translocationFourteenToSixteen,
//						startDateOfTreatment
//						);
//				this.consultationService.register(consultation);
//			}else {
//				return "redirect:/consult/home";
//			}
//		}
//		
//		return "redirect:/consult/home";
//
//	}
//
//}
//
