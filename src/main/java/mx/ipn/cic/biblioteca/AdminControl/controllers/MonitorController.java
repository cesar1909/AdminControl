package mx.ipn.cic.biblioteca.AdminControl.controllers;

import mx.ipn.cic.biblioteca.AdminControl.model.*;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IRoleRepositoy;
import mx.ipn.cic.biblioteca.AdminControl.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/monitor")
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientService userService;

    @Autowired
    private FinalConsultationService finalConsultationService;

    @Autowired
    private MonthlyConsultationService monthlyConsultationService;
    
    @Autowired
    IRoleRepositoy roleRepositoy;

    @GetMapping(path = "")
    public String redirectToAll() {
        return "redirect:/monitor/allPatients";
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
            @RequestParam(name = "mobilePhone") String mobilePhone
    ){
        String roles = "ROLE_MONITOR";
        Role getRol = this.roleRepositoy.findByRol(roles);

        if(getRol == null) {
  	        MonitorModel monitor = new MonitorModel(
  	                firstName,
  	                lastNameP,
  	                lastNameM,
  	                email,
  	                password,
  	                Arrays.asList(new Role(roles)),
  	                birthdate,
  	                gender,
  	                phone,
  	                mobilePhone);

  	              System.out.println("REGISTRAMOS MONITOR CREAMOS ROL");
  	              this.monitorService.register(monitor);
  	      
  			} else{
  	  	        MonitorModel monitor = new MonitorModel(
  	  	                firstName,
  	  	                lastNameP,
  	  	                lastNameM,
  	  	                email,
  	  	                password,
  	  	                Arrays.asList(getRol),
  	  	                birthdate,
  	  	                gender,
  	  	                phone,
  	  	                mobilePhone);

  	  	              System.out.println("REGISTRAMOS MONITOR ROL YA CREADO, SOLO ASIGNADO");
  	  	              this.monitorService.register(monitor);
  	  	      
  			}

        return "redirect:/admin/mainAdmin";
    }
    
    

	@GetMapping(path="/allmonitors")
	public ModelAndView getMonitors(){

		List<MonitorModel> searchResult = this.monitorService.findAll();

		ModelAndView mav = new ModelAndView("mainAdmin");

		mav.addObject("monitors", searchResult);
		return mav;
	}
//
//	@GetMapping(path = "/edit/{id}")
//	public ModelAndView edit(@PathVariable("id") Long identificador) {
//
//		MonitorModel userFound = this.monitorService.findById(identificador);
//		ModelAndView mav = new ModelAndView("edit", "monitorModel", userFound);
//		return mav;
//
//	}
	
//	@GetMapping(path = "/delete/{id}")
//	public String delete(@PathVariable("id") Long idToDelete) {
//
//		this.monitorService.delete(idToDelete);
//
//		return "redirect:/patient/all";
//
//	}

	@GetMapping(path = "/allPatients")
    public ModelAndView all(){
        List<PatientModel> findAll = this.patientService.findAll();
        ModelAndView mav = new ModelAndView("patientsAndDoctorsList");
        mav.addObject("patients",findAll);
        return mav;
    }

    @GetMapping(path = "/editPatient")
    public ModelAndView edit(@RequestParam(name = "id") Integer identificador) {
        PatientModel userFound = this.userService.findById(identificador);
        ModelAndView mav = new ModelAndView("editPatient", "user", userFound);
        LinkedList<MonthlyConsultation> monthlyConsultations = this.monthlyConsultationService.findByPatientId(userFound);
        FinalConsultation finalConsultation = this.finalConsultationService.findByPatientId(identificador);
        mav.addObject("monthly", monthlyConsultations);
        mav.addObject("final", finalConsultation);
        return mav;

    }

}
