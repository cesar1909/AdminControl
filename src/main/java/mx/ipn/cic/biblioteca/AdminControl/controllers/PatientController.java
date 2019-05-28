package mx.ipn.cic.biblioteca.AdminControl.controllers;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

//import com.sun.org.apache.xpath.internal.operations.Mod;
import mx.ipn.cic.biblioteca.AdminControl.model.FinalConsultation;
import mx.ipn.cic.biblioteca.AdminControl.model.MonthlyConsultation;
import mx.ipn.cic.biblioteca.AdminControl.services.FinalConsultationService;
import mx.ipn.cic.biblioteca.AdminControl.services.MonthlyConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;
import mx.ipn.cic.biblioteca.AdminControl.services.DoctorService;
//import mx.ipn.cic.biblioteca.AdminControl.services.MySpringUser;
import mx.ipn.cic.biblioteca.AdminControl.services.PatientService;
import mx.ipn.cic.biblioteca.AdminControl.model.User;
import mx.ipn.cic.biblioteca.AdminControl.projections.FindPatientsByEmailResult;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IDoctorRepository;
import mx.ipn.cic.biblioteca.AdminControl.repositories.UserRepository;
//import mx.ipn.cic.biblioteca.AdminControl.ResultQueries.findPatientsByEmailResult;
import mx.ipn.cic.biblioteca.AdminControl.model.DoctorModel;
import mx.ipn.cic.biblioteca.AdminControl.services.UserServiceImpl;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService userService;
	@Autowired
	private MonthlyConsultationService monthlyConsultationService;
	@Autowired
	private FinalConsultationService finalConsultationService;

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	IDoctorRepository iDoctorRepository;

	@GetMapping(path = "")
	public String redirectToAll() {
		System.out.println("Redicreccionamiento correcto a PatientController");
		return "redirect:/login";
	}

	// @RequestMapping(path = "/newUserForm",
	// method = RequestMethod.GET)
//	@GetMapping(path = "/newForm")
//	public ModelAndView newUserForm() {
//
//
//		//Recupera el correo electronico del usuario autenticado
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		String name = auth.getName();
//		System.out.println(name);
//
//
//		ModelAndView mav = new ModelAndView("addPatient", "userModel", new PatientModel());
//			return mav;
//	}


//	@GetMapping(path = "/all")
//	public ModelAndView allUsers() {
//		List<FindPatientsByEmailResult> findAll = this.userRepository.findPatientsByEmail(this.userServiceImpl.getEmailUser());
//
//		ModelAndView mav = new ModelAndView("patietnsListDoctor");
//		System.out.println("MAV QUERY: "+findAll);
//		mav.addObject("patients", findAll);
//		return mav;
//
//	}

	  @GetMapping(path = "/currently")
	  @ResponseBody
	  public Long currentUserName(Authentication authentication){
		  User usr = this.userServiceImpl.findByEmail(authentication.getName());

		  return usr.getId();
//		  String username = null;
//			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//			if (principal instanceof UserDetails) {
//				   username = ((UserDetails)principal).getUsername();
//				}
//			MyUser usr = this.userServiceImpl.findByEmail(username);
//			return usr.getId(); 
	  }

	  public static String getCurrentId() {
			String username;
			String nombre = null;
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				   username = ((UserDetails)principal).getUsername();
			    	System.out.println("username: "+username);
				   nombre = username;
			}

	    	System.out.println("nombre: "+nombre);
		  return nombre;
	  }


	@PostMapping(path = "/register")
	public String register(
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
//			@RequestParam(name = "translocationFourteenToSixteen") String translocationFourteenToSixteen
			//Principal principal,
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

		Long idUsr = null;
		if (idDoctor == null) {
			System.out.println("PREPARANDO PARA REGISTRAR");
			idUsr = this.userRepository.findIdByEmail(this.userServiceImpl.getEmailUser());
		} else {
			System.out.println("Preparando para EDITAR");
			idUsr = Long.parseLong(idDoctor);
		}
			DoctorModel drm = this.doctorService.findById(idUsr);


			// Proceso de registro
			PatientModel user = new PatientModel(
					//paciente
					id,
					name.replaceAll("[,]",""),
					lastnameP.replaceAll("[,]",""),
					lastnameM.replaceAll("[,]",""),
					birthdate.replaceAll("[,]",""),
					age.replaceAll("[,]",""),
					gender.replaceAll("[,]",""),
					height.replaceAll("[,]",""),
					weight.replaceAll("[,]",""),
					bmi.replaceAll("[,]",""),
					bodySup.replaceAll("[,]",""),
					//consultainicial
					startDateOfTreatment.replaceAll("[,]",""),
					serumCreatinine.replaceAll("[,]",""),
					depCreatinine.replaceAll("[,]",""),
					ecog.replaceAll("[,]",""),
					boneInjuries.replaceAll("[,]",""),
					boneInjuriesNumber.replaceAll("[,]",""),
					extramedullaryPlasmacytomas.replaceAll("[,]",""),
					plasmacytomasNumber.replaceAll("[,]",""),
					active.replaceAll("[,]",""),
					plasmaCellsInBoneMarrow.replaceAll("[,]",""),
					plasmaCellsInBloodPerif.replaceAll("[,]",""),
					igG.replaceAll("[,]",""),
					igA.replaceAll("[,]",""),
					igM.replaceAll("[,]",""),
					inmIgTypeFixation.replaceAll("[,]",""),
					inmCllTypeFixation.replaceAll("[,]",""),
					lightChainsKappa.replaceAll("[,]",""),
					lightChainsLambda.replaceAll("[,]",""),
					electroForesisDeProteinasSuero.replaceAll("[,]",""),
					electroForesisDeProteinasOrina.replaceAll("[,]",""),
					benceJonesProteinuria.replaceAll("[,]",""),
					dystemicAmyloidosis.replaceAll("[,]",""),
					b2Microglobulin.replaceAll("[,]",""),
					albumin.replaceAll("[,]",""),
					serumCalcium.replaceAll("[,]",""),
					lacticDehydrogenase.replaceAll("[,]",""),
					hemoglobin.replaceAll("[,]",""),
					hematocrit.replaceAll("[,]",""),
					lymphocytes.replaceAll("[,]",""),
					leukocytes.replaceAll("[,]",""),
					neutrophils.replaceAll("[,]",""),
					platelets.replaceAll("[,]",""),
					deletionSeventeenP.replaceAll("[,]",""),
					translocationFourToFourteen.replaceAll("[,]",""),
					translocationFourteenToSixteen.replaceAll("[,]",""),
					drm
			);

			if (id == null) {
				System.out.println("USER patient: " + user);
				this.userService.register(user);
				return "redirect:/doctor/sucess1";
			} else if (id != null) {
				System.out.println("EDITAMOS");
				this.userService.edit(user);
				return "redirect:/monitor/allPatients";
			}

			return "redirect:/doctor/allPatients";

		}


//	@GetMapping(path = "/edit")
//	public ModelAndView edit(@RequestParam(name = "id") Integer identificador) {
//
//		PatientModel userFound = this.userService.findById(identificador);
//		ModelAndView mav = new ModelAndView("editPatientv2", "user", userFound);
//		LinkedList<MonthlyConsultation> monthlyConsultations = this.monthlyConsultationService.findByPatientId(userFound);
//		FinalConsultation finalConsultation = this.finalConsultationService.findByPatientId(identificador);
//		mav.addObject("monthly", monthlyConsultations);
//		mav.addObject("final", finalConsultation);
//		return mav;
//
//	}

	@GetMapping(path = "/info")
	public ModelAndView info(@RequestParam(name = "id") Integer identificador){
		System.out.println(identificador);

		//Busamos el paciente por el identifiacor que se va a pasar desde la lista de pacientes
		PatientModel userFound = this.userService.findById(identificador);

		//ModelAndVIew con el objeto paciente llamado patientModel, que se envia al HTML infoPatient
		ModelAndView mav = new ModelAndView("patientDetails", "user", userFound);

//		Buscamos las consultas mensuales y finales ligadas con ese paciente y las agregamos al Model and View

		LinkedList<MonthlyConsultation> monthlyConsultations = this.monthlyConsultationService.findByPatientId(userFound);
		FinalConsultation finalConsultation = this.finalConsultationService.findByPatientId(identificador);
		if(finalConsultation ==null){
			System.out.println("CONSULTA FINAL NULA");
		}else if (finalConsultation == null){
			System.out.println("CONSULTA FINAL VACIA");
		}else {
			System.out.println();
		}
//		for(MonthlyConsultation tmp : monthlyConsultations){
//			System.out.println(tmp.getDateOfRealization());
//			System.out.println(tmp.getIdMonthlyConsultation());
//			System.out.println(tmp.getIdpatient() + "\n\n\n");
//
//		}

		mav.addObject("monthly", monthlyConsultations);
		mav.addObject("final", finalConsultation);

		return mav;
	}

	@GetMapping(path = "/finalInfo")
	public @ResponseBody String finalInfo(){
		String ajaxString = "<br>String traido de un controlador con Ajax<br>";
		return ajaxString;
	}

	//@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(path = "/getFinalInfo")
	public @ResponseBody String getFinalInfo(@RequestParam("id") Integer id){
		System.out.println(id);
		String respuesta = null;
		if (id == null){
			System.out.println("NO SE RECIBIO ID");
			respuesta =  "<br>Llamada correcta al controlador<br>";
		}
		else {
			System.out.println("NO SE RECIBIO ID");
			respuesta =  "<br>Llamada correcta al controlador<br>";
			System.out.println("ID CON VALOR = " + id);
			respuesta = "<br>Llamada fallida al controlador<br>";
		}
		return respuesta;
	}

//	@GetMapping(path = "/editv2/{id}")
//	public ModelAndView editv2(@PathVariable("id") Integer identificador){
//		PatientModel userFound = this.userService.findById(identificador);
//		ModelAndView mav = new ModelAndView("editPatient", "patientModel", userFound);
//		List<MonthlyConsultation> monthlyConsultations = this.monthlyConsultationService.findByPatientId(identificador);
//		FinalConsultation finalConsultation = this.finalConsultationService.findByPatientId(identificador);
//		mav.addObject("monthly", monthlyConsultations);
//		mav.addObject("final", finalConsultation);
//		return mav;
//	}




//	@GetMapping(path = "/delete/{id}")
//	public String delete(@PathVariable("id") Integer idToDelete) {
//
//		this.userService.delete(idToDelete);
//
//		return "redirect:/patient/all";
//
//	}

	@GetMapping(path="/search")
	public ModelAndView search(
			@RequestParam(name="name", required=false) String name,
			@RequestParam(name="lastnameP", required=false) String lastnameP,
			@RequestParam(name="lastnameM", required=false) String lastnameM
			) {
				
		List<PatientModel> searchResult =
				this.userService.search(name, lastnameP, lastnameM);

		ModelAndView mav = new ModelAndView("patientsList");
		mav.addObject("users", searchResult);

		return mav;
		
	}

	@GetMapping(path="/searchv2")
	public  ModelAndView search(@RequestParam(name="name", required = false) String name){

		List<PatientModel> searchResult = this.userService.search(name);

		ModelAndView mav = new ModelAndView("patientsList");

		mav.addObject("users", searchResult);
		return mav;
	}
	
//	//Recupera todo lo que hay en el modelo Patient
//	@GetMapping(path="/allpatients")
//	public ModelAndView getPatients(){
//
//		List<PatientModel> searchResult = this.userService.findAll();
//
//		ModelAndView mav = new ModelAndView("patientList");
//
//		mav.addObject("patients", searchResult);
//		return mav;
//	}
}
