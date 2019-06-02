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
import mx.ipn.cic.biblioteca.AdminControl.projections.FindFullNameByEmailResult;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IDoctorRepository;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IPatientRepository;
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

	@Autowired
	IPatientRepository patientRepository;

	@GetMapping(path = "")
	public String redirectToAll() {
		System.out.println("Redicreccionamiento correcto a PatientController");
		return "redirect:/login";
	}
	@GetMapping(path = "/allPatients")
	public ModelAndView allUsers() {
		List<FindPatientsByEmailResult> findAll = this.userRepository.findPatientsByEmail(this.userServiceImpl.getEmailUser());

		ModelAndView mav = new ModelAndView("patietnsListDoctor");
		//System.out.println("MAV QUERY: "+findAll);
		mav.addObject("patients", findAll);
		return mav;

	}


	@GetMapping(path = "/fullname")
	public @ResponseBody String nameUser() {
		String nombrec = null;
		List<FindFullNameByEmailResult> fullname = this.userRepository.findFullNameByEmail(this.userServiceImpl.getEmailUser());
		for (FindFullNameByEmailResult b : fullname) {
			nombrec = b.getNombreCompleto();
			System.out.println("b:::"+b.getNombreCompleto());
		}
		return nombrec;
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

	@GetMapping(path = "/verifyMonthly")
	public @ResponseBody String verifyMonthly(@RequestParam("idPaciente") Integer idPaciente){
		String respuesta = null;
		PatientModel userFound = this.userService.findById(idPaciente);
		LinkedList<MonthlyConsultation> monthlyConsultations = this.monthlyConsultationService.findByPatientId(userFound);
		if (monthlyConsultations.size() == 0){
			System.out.println("NO SE ENCONTRARON CONSULTAS MENSUALES");
			respuesta = "no data";
		}
		else {
			System.out.println("NUMERO DE CONSULTAS MENSUAJES: " + monthlyConsultations.size());
			respuesta = "<h5>Seleccione un ciclo para visualizar la información</h5>";
		}
		return respuesta;
	}

	@GetMapping(path = "/getMonthlyInfo")
	public @ResponseBody String getMonthlyInfo(@RequestParam("idConsulta") Integer idConsulta, @RequestParam("idPaciente") Integer idPaciente){
		String respuesta = "No data";
		System.out.println("NUESTO ID DE CONSULTA ES: " + idConsulta);
		System.out.println("NUESTRO ID DE PACIENTE ES: " + idPaciente);
		PatientModel userFound = this.userService.findById(idPaciente);
		LinkedList<MonthlyConsultation> monthlyConsultations = this.monthlyConsultationService.findByPatientId(userFound);
		MonthlyConsultation selectedConsultation = null;
		for(MonthlyConsultation tmp : monthlyConsultations){
			if (tmp.getTreatmentCycleNum().equals(idConsulta.toString())){
				selectedConsultation = tmp;
				break;
			}
			else {
				continue;
			}
		}
		if (selectedConsultation == null){
			respuesta = "<h3>NO SE LOCALIZO LA CONUSLTA CON ESE NUMERO DE TRATAMIENTO</h3>";
		}
		else {
			respuesta = "                                        <div class=\"row\">\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtFechaValoracionCiclo\">Fecha de Valoración</label>\n" +
					"                              <input type=\"text\" id=\"txtFechaValoracionCiclo\" class=\"form-control\" value =" + selectedConsultation.getDateOfRealization() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtAlbuminaCiclo\">Albumina (g/dL)</label>\n" +
					"                              <input type=\"text\" id=\"txtAlbuminaCiclo\" class=\"form-control\" value =" + selectedConsultation.getAlbumin() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtCalcioSericoCiclo\">Calcio sérico (mg/dL)</label>\n" +
					"                              <input type=\"text\" id=\"txtCalcioSericoCiclo\" class=\"form-control\" value =" + selectedConsultation.getSerumCalcium() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                    </div>\n" +
					"                    <br/>\n" +
					"                    <div class=\"row\">\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtDeshidrogenasaLacticaCiclo\">Deshidrogenasa Lactica (U/L)</label>\n" +
					"                              <input type=\"text\" id=\"txtDeshidrogenasaLacticaCiclo\" class=\"form-control\" value =" + selectedConsultation.getLacticDehydrogenase() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtHemoglobinaCiclo\">Hemoglobina (g/dL)</label>\n" +
					"                              <input type=\"text\" id=\"txtHemoglobinaCiclo\" class=\"form-control\" value =" + selectedConsultation.getHemoglobin() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtHematocritoCiclo\">Hematocrito (%)</label>\n" +
					"                              <input type=\"text\" id=\"txtHematocritoCiclo\" class=\"form-control\" value =" + selectedConsultation.getHematocrit() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                    </div>\n" +
					"                    <br />\n" +
					"                    <div class=\"row\">\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtLeucocitosCiclo\">Leucocitos (cels x 10(3)/uL)</label>\n" +
					"                              <input type=\"text\" id=\"txtLeucocitosCiclo\" class=\"form-control\" value =" + selectedConsultation.getLeukocytes() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtLinfocitosCiclo\">Linfocitos (cels x 10(3)/uL)</label>\n" +
					"                              <input type=\"text\" id=\"txtLinfocitosCiclo\" class=\"form-control\" value =" + selectedConsultation.getLymphocytes() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtNeutrofilosCiclo\">Neutrofilos (cels x 10(3)/uL)</label>\n" +
					"                              <input type=\"text\" id=\"txtNeutrofilosCiclo\" class=\"form-control\" value =" + selectedConsultation.getNeutrophils() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                    </div>\n" +
					"                    <br/>\n" +
					"                    <div class=\"row\">\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtPlaquetasCiclo\">Plaquetas (cels x 10(3)/uL)</label>\n" +
					"                              <input type=\"text\" id=\"txtPlaquetasCiclo\" class=\"form-control\" value =" + selectedConsultation.getPlatelets() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtIgGCiclo\">IgG (mg/dL)</label>\n" +
					"                              <input type=\"text\" id=\"txtIgGCiclo\" class=\"form-control\" value =" + selectedConsultation.getIgG() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtIgACiclo\">IgA (mg/dL)</label>\n" +
					"                              <input type=\"text\" id=\"txtIgACiclo\" class=\"form-control\" value =" + selectedConsultation.getIgA() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                    </div>\n" +
					"                    <br />\n" +
					"                    <div class=\"row\">\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtIgMCiclo\">IgM (mg/dL)</label>\n" +
					"                              <input type=\"text\" id=\"txtIgMCiclo\" class=\"form-control\" value =" + selectedConsultation.getIgM() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtCadenasKappaCiclo\">Cadenas Ligeras Kappa (mg/L)</label>\n" +
					"                              <input type=\"text\" id=\"txtCadenasKappaCiclo\" class=\"form-control\" value =" + selectedConsultation.getLightChainsKappa() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtCadenasLambdaCiclo\">Cadenas Ligeras Lambda (mg/L)</label>\n" +
					"                              <input type=\"text\" id=\"txtCadenasLambdaCiclo\" class=\"form-control\" value =" + selectedConsultation.getLightChainsLambda() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                    </div>\n" +
					"                    <br/>\n" +
					"                    <div class=\"row\">\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtToxicidadSerieRojaCiclo\">Toxicidad Hematologica - Serie Roja</label>\n" +
					"                              <input type=\"text\" id=\"txtToxicidadSerieRojaCiclo\" class=\"form-control\" value =" + selectedConsultation.getToxHemtoRedSerie() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtToxicidadNeutrofilosCiclo\">Toxicidad Hematologica - Neutrofilos</label>\n" +
					"                              <input type=\"text\" id=\"txtToxicidadNeutrofilosCiclo\" class=\"form-control\" value =" + selectedConsultation.getToxHemtoNeutrophils() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtToxicidadPlaquetasCiclo\">Toxicidad Hematologica - Plaquetas</label>\n" +
					"                              <input type=\"text\" id=\"txtToxicidadPlaquetasCiclo\" class=\"form-control\" value =" + selectedConsultation.getToxHemtoPlatelets() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                    </div>\n" +
					"                    <br/>\n" +
					"                    <div class=\"row\">\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtToxicidadHepaticaCiclo\">Toxicidad Hepática</label>\n" +
					"                              <input type=\"text\" id=\"txtToxicidadHepaticaCiclo\" class=\"form-control\" value =" + selectedConsultation.getToxHepatics() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtToxicidadRenalCiclo\">Toxicidad Renal</label>\n" +
					"                              <input type=\"text\" id=\"txtToxicidadRenalCiclo\" class=\"form-control\" value =" + selectedConsultation.getToxRenal() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtToxicidadInfecciosaCiclo\">Toxicidad Infecciosa</label>\n" +
					"                              <input type=\"text\" id=\"txtToxicidadInfecciosaCiclo\" class=\"form-control\" value =" + selectedConsultation.getToxInfectious() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                    </div>\n" +
					"                    <br/>\n" +
					"                    <div class=\"row\">\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtSitioInfeccionCiclo\">Sitio de infección</label>\n" +
					"                              <input type=\"text\" id=\"txtSitioInfeccionCiclo\" class=\"form-control\" value =" + selectedConsultation.getInfectionSite() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtToxicidadNauseaCiclo\">Toxicidad gastrointestinal - Nausea</label>\n" +
					"                              <input type=\"text\" id=\"txtToxicidadNauseaCiclo\" class=\"form-control\" value =" + selectedConsultation.getToxGastroNausea() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtToxicidadDiarreaCiclo\">Toxicidad gastrointestinal - Diarrea</label>\n" +
					"                              <input type=\"text\" id=\"txtToxicidadDiarreaCiclo\" class=\"form-control\" value =" + selectedConsultation.getToxGastroDiarrhea() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                    </div>\n" +
					"                    <br/>\n" +
					"                    <div class=\"row\">\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtToxicidadNeuropatiaCiclo\">Toxicidad neuropatía periférica</label>\n" +
					"                              <input type=\"text\" id=\"txtToxicidadNeuropatiaCiclo\" class=\"form-control\" value =" + selectedConsultation.getToxNeuroatiaPerif() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtReaccionMedicamentoCiclo\">Reacción a infusión de medicamentos</label>\n" +
					"                              <input type=\"text\" id=\"txtReaccionMedicamentoCiclo\" class=\"form-control\" value =" + selectedConsultation.getInfusionMedReaction() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"txtReaccionAdversaCiclo\">Reaccion adversa otra</label>\n" +
					"                              <input type=\"text\" id=\"txtReaccionAdversaCiclo\" class=\"form-control\" value =" + selectedConsultation.getAdverseReaction() + ">\n" +
					"                            </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                    </div>";
		}

		return respuesta;
	}

	@GetMapping(path = "/getFinalInfo")
	public @ResponseBody String getFinalInfo(@RequestParam("id") Integer id){

		String respuesta = null;

		//Probamos nuestra conexion con el cliente
		if (id == null){ System.out.println("NO SE RECIBIO ID"); }
		else { System.out.println("ID CON VALOR = " + id); }

		//Buscamos la consulta final
		FinalConsultation finalConsultation = this.finalConsultationService.findByPatientId(id);
		if (finalConsultation == null){
			respuesta = "no data";
		}
		else {
			respuesta = "                        <div class=\"row\">\n" +
					"                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                            <fieldset disabled>\n" +
					"                                <div class=\"form-group\">\n" +
					"                                  <label for=\"txtCalendar\">Fecha de Valoración Final</label>\n" +
					"                                  <input id=\"txtCalendar\" type=\"text\" class=\"mt10px input form-control\" name=\"dateOfRealization\" value =" +finalConsultation.getDateOfRealization() + " \">\n" +
					"                                </div>\n" +
					"                            </fieldset>\n" +
					"                          </div>\n" +
					"                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                            <fieldset disabled>\n" +
					"                                <div class=\"form-group\">\n" +
					"                                  <label for=\"Albumina\">Albumina (g/dL)</label>\n" +
					"                                  <input type=\"text\" class=\"form-control\" id=\"Albumina\" placeholder=\"g/dL\"name=\"albumin\" value =" +finalConsultation.getAlbumin() + " \">\n" +
					"                                </div>\n" +
					"                            </fieldset>\n" +
					"                          </div>\n" +
					"                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                            <fieldset disabled>\n" +
					"                                <div class=\"form-group\">\n" +
					"                                  <label for=\"Calcio_serico\">Calcio sérico (mg/dL)</label>\n" +
					"                                  <input type=\"text\" class=\"form-control\" id=\"Calcio_serico\" placeholder=\"mg/dL\" name=\"serumCalcium\" value =" +finalConsultation.getSerumCalcium() + " \">\n" +
					"                                </div>\n" +
					"                            </fieldset>\n" +
					"                          </div>\n" +
					"                      </div>\n" +
					"                      <br />\n" +
					"                      <div class=\"row\">\n" +
					"                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                            <fieldset disabled>\n" +
					"                                <div class=\"form-group\">\n" +
					"                                  <label for=\"Deshidrogenasa_Lactica\">Deshidrogenasa Lactica (U/L)</label>\n" +
					"                                  <input type=\"text\" class=\"form-control\" id=\"Deshidrogenasa_Lactica\" placeholder=\"U/L\" name=\"lacticDehydrogenase\" value =" +finalConsultation.getLacticDehydrogenase() + " \">\n" +
					"                                </div>\n" +
					"                            </fieldset>\n" +
					"                          </div>\n" +
					"                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                            <fieldset disabled>\n" +
					"                                <div class=\"form-group\">\n" +
					"                                  <label for=\"Hemoglobina\">Hemoglobina (g/dL)</label>\n" +
					"                                  <input type=\"text\" class=\"form-control\" id=\"Hemoglobina\" placeholder=\"g/dL\" name=\"hemoglobin\" value =" +finalConsultation.getHemoglobin() + " \">\n" +
					"                                </div>\n" +
					"                            </fieldset>\n" +
					"                          </div>\n" +
					"                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                            <fieldset disabled>\n" +
					"                                <div class=\"form-group\">\n" +
					"                                  <label for=\"Hematocrito\">Hematocrito (%)</label>\n" +
					"                                  <input type=\"text\" class=\"form-control\" id=\"Hematocrito\" placeholder=\"%\" name=\"hematocrit\" value =" +finalConsultation.getHematocrit() + " \">\n" +
					"                                </div>\n" +
					"                            </fieldset>\n" +
					"                          </div>\n" +
					"                      </div>\n" +
					"                      <br />\n" +
					"                      <div class=\"row\">\n" +
					"                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                            <fieldset disabled>\n" +
					"                                <div class=\"form-group\">\n" +
					"                                  <label for=\"Leucocitos\">Leucocitos (cels x 10(3)/uL)</label>\n" +
					"                                  <input type=\"text\" class=\"form-control\" id=\"Leucocitos\" placeholder=\"cels x 10(3)/uL\" name=\"leukocytes\" value =" +finalConsultation.getLeukocytes() + " \">\n" +
					"                                </div>\n" +
					"                            </fieldset>\n" +
					"                          </div>\n" +
					"                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                            <fieldset disabled>\n" +
					"                                <div class=\"form-group\">\n" +
					"                                  <label for=\"Linfocitos\">Linfocitos (cels x 10(3)/uL)</label>\n" +
					"                                  <input type=\"text\" class=\"form-control\" id=\"Linfocitos\" placeholder=\"cels x 10(3)/uL\" name=\"lymphocytes\" value =" +finalConsultation.getLymphocytes() + " \">\n" +
					"                                </div>\n" +
					"                            </fieldset>\n" +
					"                          </div>\n" +
					"                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                            <fieldset disabled>\n" +
					"                                <div class=\"form-group\">\n" +
					"                                  <label for=\"Neutrofilos\">Neutrofilos (cels x 10(3)/uL)</label>\n" +
					"                                  <input type=\"text\" class=\"form-control\" id=\"Neutrofilos\" placeholder=\"cels x 10(3)/uL\" name=\"neutrophils\" value =" +finalConsultation.getNeutrophils() + " \">\n" +
					"                                </div>\n" +
					"                            </fieldset>\n" +
					"                          </div>\n" +
					"                      </div>\n" +
					"                      <br />\n" +
					"                      <div class=\"row\">\n" +
					"                        <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                          <fieldset disabled>\n" +
					"                              <div class=\"form-group\">\n" +
					"                                <label for=\"Plaquetas\">Plaquetas (cels x 10(3)/uL)</label>\n" +
					"                                <input type=\"text\" class=\"form-control\" id=\"Plaquetas\" placeholder=\"cels x 10(3)/uL\" name=\"platelets\" value =" +finalConsultation.getPlatelets() + " \">\n" +
					"                              </div>\n" +
					"                          </fieldset>\n" +
					"                        </div>\n" +
					"                        <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                          <fieldset disabled>\n" +
					"                              <div class=\"form-group\">\n" +
					"                                <label for=\"IgG\">IgG (mg/dL)</label>\n" +
					"                                <input type=\"text\" class=\"form-control\" id=\"IgG\" placeholder=\"mg/dL\" name=\"igG\" value =" +finalConsultation.getIgG() + " \">\n" +
					"                              </div>\n" +
					"                          </fieldset>\n" +
					"                        </div>\n" +
					"                        <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                          <fieldset disabled>\n" +
					"                              <div class=\"form-group\">\n" +
					"                                <label for=\"IgA\">IgA (mg/dL)</label>\n" +
					"                                <input type=\"text\" class=\"form-control\" id=\"IgA\" placeholder=\"mg/dL\" name=\"igA\" value =" +finalConsultation.getIgA() + " \">\n" +
					"                              </div>\n" +
					"                          </fieldset>\n" +
					"                        </div>\n" +
					"                      </div>\n" +
					"                      <br />\n" +
					"                      <div class=\"row\">\n" +
					"                        <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                          <fieldset disabled>\n" +
					"                              <div class=\"form-group\">\n" +
					"                                <label for=\"IgM\">IgM (mg/dL)</label>\n" +
					"                                <input type=\"text\" class=\"form-control\" id=\"IgM\" placeholder=\"mg/dL\" name=\"igM\" value =" +finalConsultation.getIgM() + " \">\n" +
					"                              </div>\n" +
					"                          </fieldset>\n" +
					"                        </div>\n" +
					"                        <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                          <fieldset disabled>\n" +
					"                              <div class=\"form-group\">\n" +
					"                                <label for=\"Cadenas_Ligeras_Kappa\">Cadenas Ligeras Kappa (mg/L)</label>\n" +
					"                                <input type=\"text\" class=\"form-control\" id=\"Cadenas_Ligeras_Kappa\" placeholder=\"mg/dL\" name=\"lightChainsKappa\" value =" +finalConsultation.getLightChainsKappa() + " \">\n" +
					"                              </div>\n" +
					"                          </fieldset>\n" +
					"                        </div>\n" +
					"                        <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                          <fieldset disabled>\n" +
					"                              <div class=\"form-group\">\n" +
					"                                <label for=\"Cadenas_Ligeras_Lambda\">Cadenas Ligeras Lambda (mg/L)</label>\n" +
					"                                <input type=\"text\" class=\"form-control\" id=\"Cadenas_Ligeras_Lambda\" placeholder=\"%\" name=\"lightChainsLambda\" value =" +finalConsultation.getLightChainsLambda() + " \">\n" +
					"                              </div>\n" +
					"                          </fieldset>\n" +
					"                        </div>\n" +
					"                      </div>\n" +
					"                      <br />\n" +
					"                      <div class=\"row\">\n" +
					"                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                            <fieldset disabled>\n" +
					"                                <div class=\"form-group\">\n" +
					"                                  <label for=\"celplasmo\">Células plasmáticas en Médula ósea (%)</label>\n" +
					"                                  <input type=\"text\" class=\"form-control\" id=\"celplasmo\" placeholder=\"%\" name=\"celPlasmaticEnMedulaOsea\" value =" +finalConsultation.getCelPlasmaticEnMedulaOsea() + " \">\n" +
					"                                </div>\n" +
					"                            </fieldset>\n" +
					"                          </div>\n" +
					"                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                            <fieldset disabled>\n" +
					"                                <div class=\"form-group\">\n" +
					"                                  <label for=\"electroforesis\">Electroforesis de proteínas Suero</label>\n" +
					"                                  <input type=\"text\" class=\"form-control\" id=\"electroforesis\" placeholder=\"g/L\" name=\"electroForesisDeProteinasSuero\" value =" +finalConsultation.getElectroForesisDeProteinasSuero() + " \">\n" +
					"                                </div>\n" +
					"                            </fieldset>\n" +
					"                          </div>\n" +
					"                        <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                          <fieldset disabled>\n" +
					"                            <div class=\"form-group col-md-4\">\n" +
					"                              <label for=\"electroforesis2\">Electroforesis de proteínas Orina</label>\n" +
					"                              <input type=\"text\" class=\"form-control\" id=\"electroforesis2\" placeholder=\"g/L\" name=\"electroForesisDeProteinasOrina\" value =" +finalConsultation.getElectroForesisDeProteinasOrina() + " \">\n" +
					"                            </div>\n" +
					"                          </fieldset>\n" +
					"                        </div>\n" +
					"                      </div>\n" +
					"                      <br />\n" +
					"                      <div class=\"row\">\n" +
					"                        <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                          <fieldset disabled>\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"inmunofijacionig\">Inmunofijación Tipo Ig</label>\n" +
					"                              <select id=\"inmunofijacionig\" class=\"form-control\" name=\"inmFijacionTipoIg\" value =" +finalConsultation.getInmFijacionTipoIg() + " \">\n" +
					"                              <option selected value =" +finalConsultation.getInmFijacionTipoIg() + ">" +finalConsultation.getInmFijacionTipoIg() + "</option>\n" +
					"                              </select>\n" +
					"                            </div>\n" +
					"                          </fieldset>\n" +
					"                        </div>\n" +
					"                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                            <fieldset disabled>\n" +
					"                                <div class=\"form-group\">\n" +
					"                                  <label for=\"inmunofijacioncll\">Inmunofijacion Tipo CLL</label>\n" +
					"                                  <select id=\"inmunofijacioncll\" class=\"form-control\" name=\"inmFijacionTipoCll\" \">\n" +
					"                              <option selected value =" +finalConsultation.getInmFijacionTipoCll() + ">" +finalConsultation.getInmFijacionTipoCll() + "</option>\n" +
					"                                  </select>                                </div>\n" +
					"                            </fieldset>\n" +
					"                          </div>\n" +
					"                                                    <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                            <fieldset disabled>\n" +
					"                                <div class=\"form-group\">\n" +
					"                                  <label for=\"minres\">Enfermedad mínima residual (eventos x10(-7))</label>\n" +
					"                                  <input type=\"text\" class=\"form-control\" id=\"minres\" placeholder=\"0 - 1000\" name=\"enfermedadMinimaResidual\" value =" +finalConsultation.getEnfermedadMinimaResidual() + " \">\n" +
					"                                </div>\n" +
					"                            </fieldset>\n" +
					"                          </div>\n" +
					"                      </div>\n" +
					"                      <br />\n" +
					"                    <div class=\"row\">\n" +
					"                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
					"                        <fieldset disabled>\n" +
					"                          <div class=\"form-group\">\n" +
					"                            <label for=\"resTrat\">Respuesta a tratamiento</label>\n" +
					"                            <select id=\"resTrat\" class=\"form-control\" name=\"repuestaATratamiento\"  \">\n" +
					"                              <option selected value =" +finalConsultation.getRepuestaATratamiento() + ">" +finalConsultation.getRepuestaATratamiento() + "</option>\n" +
					"                            </select>                          </div>\n" +
					"                        </fieldset>\n" +
					"                      </div>\n" +
					"                    </div>\n" +
					"                      <div class=\"row\">\n" +
					"                          <div class=\"col-lg-12 col-md-12 col-sm-12\">\n" +
					"                            <div class=\"form-group\">\n" +
					"                              <label for=\"comment\"\n" +
					"                                >Observaciones</label\n" +
					"                              >\n" +
					"                              <textarea disabled id=\"comment\" rows=\"20\" class=\"form-control\" name=\"comentariosExtrax\">" + finalConsultation.getComentariosExtrax() + "</textarea>\n" +

					"                            </div>\n" +
					"                          </div>\n" +
					"                      </div>";
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
