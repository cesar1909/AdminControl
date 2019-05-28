package mx.ipn.cic.biblioteca.AdminControl.controllers;


import mx.ipn.cic.biblioteca.AdminControl.model.*;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IAdminRepository;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IRoleRepositoy;
import mx.ipn.cic.biblioteca.AdminControl.repositories.UserBaseRepository;
import mx.ipn.cic.biblioteca.AdminControl.services.MonitorService;
import mx.ipn.cic.biblioteca.AdminControl.projections.FindPatientsByEmailResult;
import mx.ipn.cic.biblioteca.AdminControl.repositories.UserRepository;
import mx.ipn.cic.biblioteca.AdminControl.services.DoctorService;
import mx.ipn.cic.biblioteca.AdminControl.services.PatientService;
import mx.ipn.cic.biblioteca.AdminControl.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    PatientService patientService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    MonitorService monitorService;

    @Autowired
    IAdminRepository adminRepository;
    
    @Autowired
    IRoleRepositoy roleRepositoy;
    
    @PostMapping(path = "/register")
    public String register(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastNameP") String lastNameP,
            @RequestParam(name = "lastNameM") String lastNameM,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password,

            @RequestParam(name = "birthdate") String birthdate,
            @RequestParam(name = "gender") String gender
    ){
        String roles = "ROLE_ADMIN";
        Role getRol = this.roleRepositoy.findByRol(roles);

	    if(getRol != null) {
        
	        AdminModel admin = new AdminModel(
	                firstName,
	                lastNameP,
	                lastNameM,
	                email,
	                password,
	                Arrays.asList(getRol),
	                birthdate,
	                gender
	        );
	        System.out.println("REGISTRAMOS ADMIN");
	        this.adminRepository.save(admin);
	    }
	    else {
	        System.out.println("NO HAY ROLES REGISTRADOS");	    	
	    	
	    }
	    


        return "redirect:/admin/mainAdmin";
    }


	@GetMapping(path = "")
	public String redirectToAll() {
		return "redirect:/admin/mainAdmin";
	}

    //MAIN PAGE ADMIN
    @GetMapping(path = "/mainAdmin")
    public ModelAndView admin() {
        //Sacamos todos los pacientes
        List<PatientModel> findAll = this.patientService.findAll();
        ModelAndView mav = new ModelAndView("mainAdmin");
        mav.addObject("patients", findAll);

        //Sacamos todos los medicos
        List<DoctorModel> allDoctors = this.doctorService.findAll();
        for (DoctorModel tmp: allDoctors) {
            System.out.println(tmp.getFirstName()+ tmp.getHospital());
        }
        mav.addObject("doctors", allDoctors);

        //Sacamos todos los monitores
        List<MonitorModel> allMonitors = this.monitorService.findAll();
        mav.addObject("monitors", allMonitors);

        return mav;
    }



    //CRUD PACIENTE
    @GetMapping(path = "/deletePatient")
    public String delete(@RequestParam(name = "id") Integer idToDelete) {
        this.patientService.delete(idToDelete);
        return "redirect:/admin/mainAdmin";
    }

    //CRUD MEDICO

    @GetMapping(path = "/newDoctorForm")
    public ModelAndView newDoctorForm(){
        ModelAndView mav = new ModelAndView("addDoctor", "doctorModel", new DoctorModel());
        return mav;
    }

    @GetMapping(path = "/doctorDetails")
    public ModelAndView doctorDetails(@RequestParam(name = "id") Long identificador){
        DoctorModel doctorModel = this.doctorService.findById(identificador);
        ModelAndView mav = new ModelAndView("DoctorDetails","doctor", doctorModel);
        return mav;
    }

    @GetMapping(path = "/editDoctor")
    public ModelAndView editDoctor(@RequestParam(name = "id") Long identificador){
        DoctorModel doctorModel = this.doctorService.findById(identificador);
        System.out.println("doctorModel:: "+doctorModel.getPassword());
        System.out.println(doctorModel.getFullName() + " " +doctorModel.getId());
        ModelAndView mav = new ModelAndView("editDoctor","doctor", doctorModel);
        return mav;
    }

    @GetMapping(path = "/deleteUser")
    public String deleteUser(@RequestParam(name = "id") Long identificador){
        this.userService.delete(identificador);
        return "redirect:/admin/mainAdmin";
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

	  @PostMapping(path = "/editCity")
      public String editCity(
              @RequestParam(name = "city") String city,
              @RequestParam(name = "id") String id
              ){
        Long identificador = Long.parseLong(id);
        this.userService.updateCity(city, identificador);
          System.out.println("PRUEBA EDITAR CIUDAD");

          return "redirect:/admin/mainAdmin";
      }
	  
    @PostMapping(path = "/editDoctor")
    public String editDoctor(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastNameP") String lastNameP,
            @RequestParam(name = "lastNameM") String lastNameM,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password", required = false) String password,

            @RequestParam(name = "birthdate") String birthdate,
            @RequestParam(name = "gender") String gender,
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "mobilePhone") String mobilePhone,
            @RequestParam(name = "professionalLicense") String professionalLicense,
            @RequestParam(name = "city") String city,
            @RequestParam(name = "hospital") String hospital,
            @RequestParam(name = "id") String identificador
    ){

        Long id = Long.parseLong(identificador);

        System.out.println("EDITAMOS MEDICO NUEVA FORMA");
        if (password.equals("")){
            System.out.println("Contraseña vacia");
            this.userService.updateDoctorWithoutPassword(id, firstName, lastNameP, lastNameM, email, birthdate,
                    gender, phone, mobilePhone, professionalLicense, city, hospital);
        }else{
            System.out.println("Nuevo Password: " + password);
            this.userService.updateDoctor(id, firstName, lastNameP, lastNameM, email, birthdate,
                    gender, phone, mobilePhone, professionalLicense, city, hospital, password);
        }

        return "redirect:/admin/mainAdmin";

    }



    //CRUD MONITOR
    @GetMapping(path = "/newMonitorForm")
    public ModelAndView newMonitorForm(){
        ModelAndView mav = new ModelAndView("addMonitor", "monitorModel", new MonitorModel());
        return mav;
    }

    @GetMapping(path = "/monitorDetails")
    public ModelAndView monitorDetails(@RequestParam(name = "id") Long identificador){
        MonitorModel monitorModel = this.monitorService.findById(identificador);
        ModelAndView mav = new ModelAndView("MonitorDetails","monitorModel", monitorModel);
        return mav;
    }

    @GetMapping(path = "/editMonitor")
    public ModelAndView editMonitor(@RequestParam(name = "id") Long identificador){
        MonitorModel monitorModel = this.monitorService.findById(identificador);
        ModelAndView mav = new ModelAndView("editMonitor","monitorModel", monitorModel);
        return mav;
    }

    @PostMapping(path = "/editMonitor")
    public String editMonitor(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastNameP") String lastNameP,
            @RequestParam(name = "lastNameM") String lastNameM,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password", required = false) String password,

            @RequestParam(name = "birthdate") String birthdate,
            @RequestParam(name = "gender") String gender,
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "mobilePhone") String mobilePhone,
            @RequestParam(name = "id") String identificador
    ){

        Long id = Long.parseLong(identificador);

        System.out.println("EDITAMOS MONITOR NUEVA FORMA");
        if (password.equals("")){
            System.out.println("Contraseña vacia");
            this.userService.updateMonitorWithoutPassword(id, firstName, lastNameP, lastNameM, email, birthdate,
                    gender, phone, mobilePhone);
        }else{
            System.out.println("Nuevo Password: " + password);
            this.userService.updateMonitor(id, firstName, lastNameP, lastNameM, email, birthdate,
                    gender, phone, mobilePhone, password);
        }

        return "redirect:/admin/mainAdmin";
    }

    @GetMapping(path = "/expediente")
    public void getExpedienteGeneral(){

    }


}