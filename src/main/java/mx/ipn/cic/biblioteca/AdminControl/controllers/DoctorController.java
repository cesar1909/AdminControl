package mx.ipn.cic.biblioteca.AdminControl.controllers;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import mx.ipn.cic.biblioteca.AdminControl.projections.FindPatientsByEmailResult;
import mx.ipn.cic.biblioteca.AdminControl.repositories.UserRepository;
import mx.ipn.cic.biblioteca.AdminControl.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mx.ipn.cic.biblioteca.AdminControl.model.DoctorModel;
import mx.ipn.cic.biblioteca.AdminControl.model.MonitorModel;
import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;
import mx.ipn.cic.biblioteca.AdminControl.model.Role;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IDoctorRepository;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IRoleRepositoy;
import mx.ipn.cic.biblioteca.AdminControl.services.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserServiceImpl userServiceImpl;
	
    @Autowired
    IRoleRepositoy roleRepositoy;

	@GetMapping(path = "")
	public String redirectToAll() {
		return "redirect:/doctor/allPatients";
	}

	@GetMapping(path = "/allPatients")
	public ModelAndView allUsers() {
		List<FindPatientsByEmailResult> findAll = this.userRepository.findPatientsByEmail(this.userServiceImpl.getEmailUser());

		ModelAndView mav = new ModelAndView("patietnsListDoctor");
		//System.out.println("MAV QUERY: "+findAll);
		mav.addObject("patients", findAll);
		return mav;

	}

	@PostMapping(path = "/register")
	public String register(
			@RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastNameP") String lastNameP,
			@RequestParam(name = "lastNameM") String lastNameM,
			@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password,
			
			@RequestParam(name = "birthdate") String birthdate,
			@RequestParam(name = "gender") String gender,
	        @RequestParam(name = "phone") String phone,
	        @RequestParam(name = "mobilePhone") String mobilePhone,
	        @RequestParam(name = "professionalLicense") String professionalLicense,
			@RequestParam(name = "city") String city,
			@RequestParam(name = "hospital") String hospital
			//@RequestParam(name = "id") String identificador
			){
		String roles = "ROLE_DOCTOR";

		//Si se envia un password nulo, no se actualiza

		//MainPageDoctor
		//@GetMapping(path = "mainDoctor")
	      Role getRol = this.roleRepositoy.findByRol(roles);
	       
	      if(getRol == null) {
	  		DoctorModel dr = new DoctorModel(
					firstName,
					lastNameP,
					lastNameM,
					email,
					password,
					Arrays.asList(new Role(roles)),
					birthdate,
					gender,
					phone,
					mobilePhone,
					professionalLicense,
					city,
					hospital
					);

				System.out.println("REGISTRAMOS MEDICO");
				this.doctorService.register(dr);
	      
			} else{
		  		DoctorModel dr = new DoctorModel(
						firstName,
						lastNameP,
						lastNameM,
						email,
						password,
						Arrays.asList(getRol),
						birthdate,
						gender,
						phone,
						mobilePhone,
						professionalLicense,
						city,
						hospital
						);

					System.out.println("REGISTRAMOS MEDICO ROL CREADO");
					this.doctorService.register(dr);
			}
		return "redirect:/admin/mainAdmin";

	}

	//Nuevo Paciente Formulario
	@GetMapping(path = "/newPatientForm")
	public ModelAndView newUserForm() {


		//Recupera el correo electronico del usuario autenticado
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		System.out.println(name);


		ModelAndView mav = new ModelAndView("addPatient", "userModel", new PatientModel());
		return mav;
	}
	@GetMapping(path = "sucess1")
	public String sucess1l() {
		return "NewPatientSucess";
	}

	@GetMapping("/ajaxExample")
	public void ajaxExample(){

	}
	
}
