package mx.ipn.cic.biblioteca.AdminControl.controllers;


import mx.ipn.cic.biblioteca.AdminControl.model.*;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IAdminRepository;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IMonitorRepository;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IRoleRepositoy;
import mx.ipn.cic.biblioteca.AdminControl.repositories.UserBaseRepository;
import mx.ipn.cic.biblioteca.AdminControl.services.*;
import mx.ipn.cic.biblioteca.AdminControl.projections.FindPatientsByEmailResult;
import mx.ipn.cic.biblioteca.AdminControl.repositories.UserRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Statement;
import java.util.Arrays;
import java.util.LinkedList;
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
    
    @Autowired
    IMonitorRepository monitorRepository;

    @Autowired
    MonthlyConsultationService monthlyConsultationService;

    @Autowired
    FinalConsultationService finalConsultationService;
    
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
        
        System.out.println("IDENTIFICADOR:: "+identificador);
        System.out.println("EDITAMOS MONITOR NUEVA FORMA");
        if (password.equals("")){
            System.out.println("Contraseña vacia");
            this.monitorRepository.updateMonitorWithoutPassword(id, firstName, lastNameP, lastNameM, email, birthdate,
                    gender, phone, mobilePhone);
        }else{
            System.out.println("Nuevo Password: " + password);
            this.monitorRepository.updateMonitor(id, firstName, lastNameP, lastNameM, email, birthdate,
                    gender, phone, mobilePhone, password);
        }

        return "redirect:/admin/mainAdmin";
    }

    @GetMapping(path = "/expediente")
    public ResponseEntity<Resource> getExpedienteGeneral() throws IOException{
        try{
            //Lee el archivo de excel que está en el path del proyecto
            FileInputStream fis = new FileInputStream(new File("formato.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook (fis);
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Elimina los registros previos del excel
            for(int i=2; i<= sheet.getLastRowNum(); i++){
                Row row = sheet.getRow(i);
                sheet.removeRow(row);
            }

            //Crea filas dinamicamente segun los pacientes registrados
            List<PatientModel> allPatients = this.patientService.findAll();
            XSSFRow row = null;
            for (int i = 0; allPatients.size() > i; i++) {
                PatientModel tmp = allPatients.get(i);
                row = sheet.createRow(i + 2);
                row.createCell(0).setCellValue(tmp.getFullName());
                row.createCell(1).setCellValue(tmp.getGender());
                row.createCell(2).setCellValue(tmp.getBirthdate());
                row.createCell(3).setCellValue(tmp.getAge());
                row.createCell(4).setCellValue(tmp.getStartDateOfTreatment());
                row.createCell(5).setCellValue(tmp.getHeight());
                row.createCell(6).setCellValue(tmp.getWeight());
                row.createCell(7).setCellValue(tmp.getBmi());
                row.createCell(8).setCellValue(tmp.getBodySup());
                row.createCell(9).setCellValue(tmp.getSerumCalcium());
                row.createCell(10).setCellValue(tmp.getDepCreatinine());
                row.createCell(11).setCellValue(tmp.getEcog());
                row.createCell(12).setCellValue(tmp.getBoneInjuries());
                row.createCell(13).setCellValue(tmp.getBoneInjuriesNumber());
                row.createCell(14).setCellValue(tmp.getExtramedullaryPlasmacytomas());
                row.createCell(15).setCellValue(tmp.getPlasmacytomasNumber());
                row.createCell(16).setCellValue(tmp.getActive());
                row.createCell(17).setCellValue(tmp.getPlasmaCellsInBoneMarrow());
                row.createCell(18).setCellValue(tmp.getPlasmaCellsInBloodPerif());
                row.createCell(19).setCellValue(tmp.getIgG());
                row.createCell(20).setCellValue(tmp.getIgA());
                row.createCell(21).setCellValue(tmp.getIgM());
                row.createCell(22).setCellValue(tmp.getInmIgTypeFixation());
                row.createCell(23).setCellValue(tmp.getInmCllTypeFixation());
                row.createCell(24).setCellValue(tmp.getLightChainsKappa());
                row.createCell(25).setCellValue(tmp.getLightChainsLambda());
                row.createCell(26).setCellValue(tmp.getElectroForesisDeProteinasSuero());
                row.createCell(27).setCellValue(tmp.getElectroForesisDeProteinasOrina());
                row.createCell(28).setCellValue(tmp.getBenceJonesProteinuria());
                row.createCell(29).setCellValue(tmp.getDystemicAmyloidosis());
                row.createCell(30).setCellValue(tmp.getB2Microglobulin());
                row.createCell(31).setCellValue(tmp.getAlbumin());
                row.createCell(32).setCellValue(tmp.getSerumCalcium());
                row.createCell(33).setCellValue(tmp.getLacticDehydrogenase());
                row.createCell(34).setCellValue(tmp.getHemoglobin());
                row.createCell(35).setCellValue(tmp.getHematocrit());
                row.createCell(36).setCellValue(tmp.getLeukocytes());
                row.createCell(37).setCellValue(tmp.getLymphocytes());
                row.createCell(38).setCellValue(tmp.getNeutrophils());
                row.createCell(39).setCellValue(tmp.getPlatelets());
                row.createCell(40).setCellValue(tmp.getDeletionSeventeenP());
                row.createCell(41).setCellValue(tmp.getTranslocationFourToFourteen());
                row.createCell(42).setCellValue(tmp.getTranslocationFourteenToSixteen());

                //CCONSULTAS MENSUALES
                List<MonthlyConsultation> monthlyConsultations = this.monthlyConsultationService.findByPatientId(tmp);
                System.out.println("El numero de consultas mensuales es: " + monthlyConsultations.size() + " del paciente " + tmp.getFullName());

                //Crea filas con las consultas mensuales
                try {
                    //Pirmera consulta mensual
                    row.createCell(43).setCellValue(monthlyConsultations.get(0).getTreatmentCycleNum());
                    row.createCell(44).setCellValue(monthlyConsultations.get(0).getDateOfRealization());
                    row.createCell(45).setCellValue(monthlyConsultations.get(0).getAlbumin());
                    row.createCell(46).setCellValue(monthlyConsultations.get(0).getSerumCalcium());
                    row.createCell(47).setCellValue(monthlyConsultations.get(0).getLacticDehydrogenase());
                    row.createCell(48).setCellValue(monthlyConsultations.get(0).getHemoglobin());
                    row.createCell(49).setCellValue(monthlyConsultations.get(0).getHematocrit());
                    row.createCell(50).setCellValue(monthlyConsultations.get(0).getLeukocytes());
                    row.createCell(51).setCellValue(monthlyConsultations.get(0).getLymphocytes());
                    row.createCell(52).setCellValue(monthlyConsultations.get(0).getNeutrophils());
                    row.createCell(53).setCellValue(monthlyConsultations.get(0).getPlatelets());
                    row.createCell(54).setCellValue(monthlyConsultations.get(0).getIgG());
                    row.createCell(55).setCellValue(monthlyConsultations.get(0).getIgA());
                    row.createCell(56).setCellValue(monthlyConsultations.get(0).getIgM());
                    row.createCell(57).setCellValue(monthlyConsultations.get(0).getLightChainsKappa());
                    row.createCell(58).setCellValue(monthlyConsultations.get(0).getLightChainsLambda());
                    row.createCell(59).setCellValue(monthlyConsultations.get(0).getToxHemtoRedSerie());
                    row.createCell(60).setCellValue(monthlyConsultations.get(0).getToxHemtoNeutrophils());
                    row.createCell(61).setCellValue(monthlyConsultations.get(0).getToxHemtoPlatelets());
                    row.createCell(62).setCellValue(monthlyConsultations.get(0).getToxHepatics());
                    row.createCell(63).setCellValue(monthlyConsultations.get(0).getToxRenal());
                    row.createCell(64).setCellValue(monthlyConsultations.get(0).getToxGastroNausea());
                    row.createCell(65).setCellValue(monthlyConsultations.get(0).getToxGastroDiarrhea());
                    row.createCell(66).setCellValue(monthlyConsultations.get(0).getToxNeuroatiaPerif());
                    row.createCell(67).setCellValue(monthlyConsultations.get(0).getToxInfectious());
                    row.createCell(68).setCellValue(monthlyConsultations.get(0).getInfectionSite());
                    row.createCell(69).setCellValue(monthlyConsultations.get(0).getInfusionMedReaction());
                    row.createCell(70).setCellValue(monthlyConsultations.get(0).getAdverseReaction());


                    //Segunda consulta mensual
                    row.createCell(71).setCellValue(monthlyConsultations.get(1).getTreatmentCycleNum());
                    row.createCell(72).setCellValue(monthlyConsultations.get(1).getDateOfRealization());
                    row.createCell(73).setCellValue(monthlyConsultations.get(1).getAlbumin());
                    row.createCell(74).setCellValue(monthlyConsultations.get(1).getSerumCalcium());
                    row.createCell(75).setCellValue(monthlyConsultations.get(1).getLacticDehydrogenase());
                    row.createCell(76).setCellValue(monthlyConsultations.get(1).getHemoglobin());
                    row.createCell(77).setCellValue(monthlyConsultations.get(1).getHematocrit());
                    row.createCell(78).setCellValue(monthlyConsultations.get(1).getLeukocytes());
                    row.createCell(79).setCellValue(monthlyConsultations.get(1).getLymphocytes());
                    row.createCell(80).setCellValue(monthlyConsultations.get(1).getNeutrophils());
                    row.createCell(81).setCellValue(monthlyConsultations.get(1).getPlatelets());
                    row.createCell(82).setCellValue(monthlyConsultations.get(1).getIgG());
                    row.createCell(83).setCellValue(monthlyConsultations.get(1).getIgA());
                    row.createCell(84).setCellValue(monthlyConsultations.get(1).getIgM());
                    row.createCell(85).setCellValue(monthlyConsultations.get(1).getLightChainsKappa());
                    row.createCell(86).setCellValue(monthlyConsultations.get(1).getLightChainsLambda());
                    row.createCell(87).setCellValue(monthlyConsultations.get(1).getToxHemtoRedSerie());
                    row.createCell(88).setCellValue(monthlyConsultations.get(1).getToxHemtoNeutrophils());
                    row.createCell(89).setCellValue(monthlyConsultations.get(1).getToxHemtoPlatelets());
                    row.createCell(90).setCellValue(monthlyConsultations.get(1).getToxHepatics());
                    row.createCell(91).setCellValue(monthlyConsultations.get(1).getToxRenal());
                    row.createCell(92).setCellValue(monthlyConsultations.get(1).getToxGastroNausea());
                    row.createCell(93).setCellValue(monthlyConsultations.get(1).getToxGastroDiarrhea());
                    row.createCell(94).setCellValue(monthlyConsultations.get(0).getToxNeuroatiaPerif());
                    row.createCell(95).setCellValue(monthlyConsultations.get(1).getToxInfectious());
                    row.createCell(96).setCellValue(monthlyConsultations.get(1).getInfectionSite());
                    row.createCell(97).setCellValue(monthlyConsultations.get(1).getInfusionMedReaction());
                    row.createCell(98).setCellValue(monthlyConsultations.get(1).getAdverseReaction());

                    //Tercer Consulta Mensual
                    row.createCell(99).setCellValue(monthlyConsultations.get(2).getTreatmentCycleNum());
                    row.createCell(100).setCellValue(monthlyConsultations.get(2).getDateOfRealization());
                    row.createCell(101).setCellValue(monthlyConsultations.get(2).getAlbumin());
                    row.createCell(102).setCellValue(monthlyConsultations.get(2).getSerumCalcium());
                    row.createCell(103).setCellValue(monthlyConsultations.get(2).getLacticDehydrogenase());
                    row.createCell(104).setCellValue(monthlyConsultations.get(2).getHemoglobin());
                    row.createCell(105).setCellValue(monthlyConsultations.get(2).getHematocrit());
                    row.createCell(106).setCellValue(monthlyConsultations.get(2).getLeukocytes());
                    row.createCell(107).setCellValue(monthlyConsultations.get(2).getLymphocytes());
                    row.createCell(108).setCellValue(monthlyConsultations.get(2).getNeutrophils());
                    row.createCell(109).setCellValue(monthlyConsultations.get(2).getPlatelets());
                    row.createCell(110).setCellValue(monthlyConsultations.get(2).getIgG());
                    row.createCell(111).setCellValue(monthlyConsultations.get(2).getIgA());
                    row.createCell(112).setCellValue(monthlyConsultations.get(2).getIgM());
                    row.createCell(113).setCellValue(monthlyConsultations.get(2).getLightChainsKappa());
                    row.createCell(114).setCellValue(monthlyConsultations.get(2).getLightChainsLambda());
                    row.createCell(115).setCellValue(monthlyConsultations.get(2).getToxHemtoRedSerie());
                    row.createCell(116).setCellValue(monthlyConsultations.get(2).getToxHemtoNeutrophils());
                    row.createCell(117).setCellValue(monthlyConsultations.get(2).getToxHemtoPlatelets());
                    row.createCell(118).setCellValue(monthlyConsultations.get(2).getToxHepatics());
                    row.createCell(119).setCellValue(monthlyConsultations.get(2).getToxRenal());
                    row.createCell(120).setCellValue(monthlyConsultations.get(2).getToxGastroNausea());
                    row.createCell(121).setCellValue(monthlyConsultations.get(2).getToxGastroDiarrhea());
                    row.createCell(122).setCellValue(monthlyConsultations.get(0).getToxNeuroatiaPerif());
                    row.createCell(123).setCellValue(monthlyConsultations.get(2).getToxInfectious());
                    row.createCell(124).setCellValue(monthlyConsultations.get(2).getInfectionSite());
                    row.createCell(125).setCellValue(monthlyConsultations.get(2).getInfusionMedReaction());
                    row.createCell(126).setCellValue(monthlyConsultations.get(2).getAdverseReaction());

                    //Cuarta consulta mensual
                    row.createCell(127).setCellValue(monthlyConsultations.get(3).getTreatmentCycleNum());
                    row.createCell(128).setCellValue(monthlyConsultations.get(3).getDateOfRealization());
                    row.createCell(129).setCellValue(monthlyConsultations.get(3).getAlbumin());
                    row.createCell(130).setCellValue(monthlyConsultations.get(3).getSerumCalcium());
                    row.createCell(131).setCellValue(monthlyConsultations.get(3).getLacticDehydrogenase());
                    row.createCell(132).setCellValue(monthlyConsultations.get(3).getHemoglobin());
                    row.createCell(133).setCellValue(monthlyConsultations.get(3).getHematocrit());
                    row.createCell(134).setCellValue(monthlyConsultations.get(3).getLeukocytes());
                    row.createCell(135).setCellValue(monthlyConsultations.get(3).getLymphocytes());
                    row.createCell(136).setCellValue(monthlyConsultations.get(3).getNeutrophils());
                    row.createCell(137).setCellValue(monthlyConsultations.get(3).getPlatelets());
                    row.createCell(138).setCellValue(monthlyConsultations.get(3).getIgG());
                    row.createCell(139).setCellValue(monthlyConsultations.get(3).getIgA());
                    row.createCell(140).setCellValue(monthlyConsultations.get(3).getIgM());
                    row.createCell(141).setCellValue(monthlyConsultations.get(3).getLightChainsKappa());
                    row.createCell(142).setCellValue(monthlyConsultations.get(3).getLightChainsLambda());
                    row.createCell(143).setCellValue(monthlyConsultations.get(3).getToxHemtoRedSerie());
                    row.createCell(144).setCellValue(monthlyConsultations.get(3).getToxHemtoNeutrophils());
                    row.createCell(145).setCellValue(monthlyConsultations.get(3).getToxHemtoPlatelets());
                    row.createCell(146).setCellValue(monthlyConsultations.get(3).getToxHepatics());
                    row.createCell(147).setCellValue(monthlyConsultations.get(3).getToxRenal());
                    row.createCell(148).setCellValue(monthlyConsultations.get(3).getToxGastroNausea());
                    row.createCell(149).setCellValue(monthlyConsultations.get(3).getToxGastroDiarrhea());
                    row.createCell(150).setCellValue(monthlyConsultations.get(0).getToxNeuroatiaPerif());
                    row.createCell(151).setCellValue(monthlyConsultations.get(3).getToxInfectious());
                    row.createCell(152).setCellValue(monthlyConsultations.get(3).getInfectionSite());
                    row.createCell(153).setCellValue(monthlyConsultations.get(3).getInfusionMedReaction());
                    row.createCell(154).setCellValue(monthlyConsultations.get(3).getAdverseReaction());

                    //Quinta consulta mensual
                    row.createCell(155).setCellValue(monthlyConsultations.get(4).getTreatmentCycleNum());
                    row.createCell(156).setCellValue(monthlyConsultations.get(4).getDateOfRealization());
                    row.createCell(157).setCellValue(monthlyConsultations.get(4).getAlbumin());
                    row.createCell(158).setCellValue(monthlyConsultations.get(4).getSerumCalcium());
                    row.createCell(159).setCellValue(monthlyConsultations.get(4).getLacticDehydrogenase());
                    row.createCell(160).setCellValue(monthlyConsultations.get(4).getHemoglobin());
                    row.createCell(161).setCellValue(monthlyConsultations.get(4).getHematocrit());
                    row.createCell(162).setCellValue(monthlyConsultations.get(4).getLeukocytes());
                    row.createCell(163).setCellValue(monthlyConsultations.get(4).getLymphocytes());
                    row.createCell(164).setCellValue(monthlyConsultations.get(4).getNeutrophils());
                    row.createCell(165).setCellValue(monthlyConsultations.get(4).getPlatelets());
                    row.createCell(166).setCellValue(monthlyConsultations.get(4).getIgG());
                    row.createCell(167).setCellValue(monthlyConsultations.get(4).getIgA());
                    row.createCell(168).setCellValue(monthlyConsultations.get(4).getIgM());
                    row.createCell(169).setCellValue(monthlyConsultations.get(4).getLightChainsKappa());
                    row.createCell(170).setCellValue(monthlyConsultations.get(4).getLightChainsLambda());
                    row.createCell(171).setCellValue(monthlyConsultations.get(4).getToxHemtoRedSerie());
                    row.createCell(172).setCellValue(monthlyConsultations.get(4).getToxHemtoNeutrophils());
                    row.createCell(173).setCellValue(monthlyConsultations.get(4).getToxHemtoPlatelets());
                    row.createCell(174).setCellValue(monthlyConsultations.get(4).getToxHepatics());
                    row.createCell(175).setCellValue(monthlyConsultations.get(4).getToxRenal());
                    row.createCell(176).setCellValue(monthlyConsultations.get(4).getToxGastroNausea());
                    row.createCell(177).setCellValue(monthlyConsultations.get(4).getToxGastroDiarrhea());
                    row.createCell(178).setCellValue(monthlyConsultations.get(0).getToxNeuroatiaPerif());
                    row.createCell(179).setCellValue(monthlyConsultations.get(4).getToxInfectious());
                    row.createCell(180).setCellValue(monthlyConsultations.get(4).getInfectionSite());
                    row.createCell(181).setCellValue(monthlyConsultations.get(4).getInfusionMedReaction());
                    row.createCell(182).setCellValue(monthlyConsultations.get(4).getAdverseReaction());

                    //Sexta consulta mensual
                    row.createCell(183).setCellValue(monthlyConsultations.get(5).getTreatmentCycleNum());
                    row.createCell(184).setCellValue(monthlyConsultations.get(5).getDateOfRealization());
                    row.createCell(185).setCellValue(monthlyConsultations.get(5).getAlbumin());
                    row.createCell(186).setCellValue(monthlyConsultations.get(5).getSerumCalcium());
                    row.createCell(187).setCellValue(monthlyConsultations.get(5).getLacticDehydrogenase());
                    row.createCell(188).setCellValue(monthlyConsultations.get(5).getHemoglobin());
                    row.createCell(189).setCellValue(monthlyConsultations.get(5).getHematocrit());
                    row.createCell(190).setCellValue(monthlyConsultations.get(5).getLeukocytes());
                    row.createCell(191).setCellValue(monthlyConsultations.get(5).getLymphocytes());
                    row.createCell(192).setCellValue(monthlyConsultations.get(5).getNeutrophils());
                    row.createCell(193).setCellValue(monthlyConsultations.get(5).getPlatelets());
                    row.createCell(194).setCellValue(monthlyConsultations.get(5).getIgG());
                    row.createCell(195).setCellValue(monthlyConsultations.get(5).getIgA());
                    row.createCell(196).setCellValue(monthlyConsultations.get(5).getIgM());
                    row.createCell(197).setCellValue(monthlyConsultations.get(5).getLightChainsKappa());
                    row.createCell(198).setCellValue(monthlyConsultations.get(5).getLightChainsLambda());
                    row.createCell(199).setCellValue(monthlyConsultations.get(5).getToxHemtoRedSerie());
                    row.createCell(200).setCellValue(monthlyConsultations.get(5).getToxHemtoNeutrophils());
                    row.createCell(201).setCellValue(monthlyConsultations.get(5).getToxHemtoPlatelets());
                    row.createCell(202).setCellValue(monthlyConsultations.get(5).getToxHepatics());
                    row.createCell(203).setCellValue(monthlyConsultations.get(5).getToxRenal());
                    row.createCell(204).setCellValue(monthlyConsultations.get(5).getToxGastroNausea());
                    row.createCell(205).setCellValue(monthlyConsultations.get(5).getToxGastroDiarrhea());
                    row.createCell(206).setCellValue(monthlyConsultations.get(0).getToxNeuroatiaPerif());
                    row.createCell(207).setCellValue(monthlyConsultations.get(5).getToxInfectious());
                    row.createCell(208).setCellValue(monthlyConsultations.get(5).getInfectionSite());
                    row.createCell(209).setCellValue(monthlyConsultations.get(5).getInfusionMedReaction());
                    row.createCell(210).setCellValue(monthlyConsultations.get(5).getAdverseReaction());

                    //Septima consulta mensual
                    row.createCell(211).setCellValue(monthlyConsultations.get(6).getTreatmentCycleNum());
                    row.createCell(212).setCellValue(monthlyConsultations.get(6).getDateOfRealization());
                    row.createCell(213).setCellValue(monthlyConsultations.get(6).getAlbumin());
                    row.createCell(214).setCellValue(monthlyConsultations.get(6).getSerumCalcium());
                    row.createCell(215).setCellValue(monthlyConsultations.get(6).getLacticDehydrogenase());
                    row.createCell(216).setCellValue(monthlyConsultations.get(6).getHemoglobin());
                    row.createCell(217).setCellValue(monthlyConsultations.get(6).getHematocrit());
                    row.createCell(218).setCellValue(monthlyConsultations.get(6).getLeukocytes());
                    row.createCell(219).setCellValue(monthlyConsultations.get(6).getLymphocytes());
                    row.createCell(220).setCellValue(monthlyConsultations.get(6).getNeutrophils());
                    row.createCell(221).setCellValue(monthlyConsultations.get(6).getPlatelets());
                    row.createCell(222).setCellValue(monthlyConsultations.get(6).getIgG());
                    row.createCell(223).setCellValue(monthlyConsultations.get(6).getIgA());
                    row.createCell(224).setCellValue(monthlyConsultations.get(6).getIgM());
                    row.createCell(225).setCellValue(monthlyConsultations.get(6).getLightChainsKappa());
                    row.createCell(226).setCellValue(monthlyConsultations.get(6).getLightChainsLambda());
                    row.createCell(227).setCellValue(monthlyConsultations.get(6).getToxHemtoRedSerie());
                    row.createCell(228).setCellValue(monthlyConsultations.get(6).getToxHemtoNeutrophils());
                    row.createCell(229).setCellValue(monthlyConsultations.get(6).getToxHemtoPlatelets());
                    row.createCell(230).setCellValue(monthlyConsultations.get(6).getToxHepatics());
                    row.createCell(231).setCellValue(monthlyConsultations.get(6).getToxRenal());
                    row.createCell(232).setCellValue(monthlyConsultations.get(6).getToxGastroNausea());
                    row.createCell(233).setCellValue(monthlyConsultations.get(6).getToxGastroDiarrhea());
                    row.createCell(234).setCellValue(monthlyConsultations.get(0).getToxNeuroatiaPerif());
                    row.createCell(235).setCellValue(monthlyConsultations.get(6).getToxInfectious());
                    row.createCell(236).setCellValue(monthlyConsultations.get(6).getInfectionSite());
                    row.createCell(237).setCellValue(monthlyConsultations.get(6).getInfusionMedReaction());
                    row.createCell(238).setCellValue(monthlyConsultations.get(6).getAdverseReaction());

                    //Octava consulta mensual
                    row.createCell(239).setCellValue(monthlyConsultations.get(7).getTreatmentCycleNum());
                    row.createCell(240).setCellValue(monthlyConsultations.get(7).getDateOfRealization());
                    row.createCell(241).setCellValue(monthlyConsultations.get(7).getAlbumin());
                    row.createCell(242).setCellValue(monthlyConsultations.get(7).getSerumCalcium());
                    row.createCell(243).setCellValue(monthlyConsultations.get(7).getLacticDehydrogenase());
                    row.createCell(244).setCellValue(monthlyConsultations.get(7).getHemoglobin());
                    row.createCell(245).setCellValue(monthlyConsultations.get(7).getHematocrit());
                    row.createCell(246).setCellValue(monthlyConsultations.get(7).getLeukocytes());
                    row.createCell(247).setCellValue(monthlyConsultations.get(7).getLymphocytes());
                    row.createCell(248).setCellValue(monthlyConsultations.get(7).getNeutrophils());
                    row.createCell(249).setCellValue(monthlyConsultations.get(7).getPlatelets());
                    row.createCell(250).setCellValue(monthlyConsultations.get(7).getIgG());
                    row.createCell(251).setCellValue(monthlyConsultations.get(7).getIgA());
                    row.createCell(252).setCellValue(monthlyConsultations.get(7).getIgM());
                    row.createCell(253).setCellValue(monthlyConsultations.get(7).getLightChainsKappa());
                    row.createCell(254).setCellValue(monthlyConsultations.get(7).getLightChainsLambda());
                    row.createCell(255).setCellValue(monthlyConsultations.get(7).getToxHemtoRedSerie());
                    row.createCell(256).setCellValue(monthlyConsultations.get(7).getToxHemtoNeutrophils());
                    row.createCell(257).setCellValue(monthlyConsultations.get(7).getToxHemtoPlatelets());
                    row.createCell(258).setCellValue(monthlyConsultations.get(7).getToxHepatics());
                    row.createCell(259).setCellValue(monthlyConsultations.get(7).getToxRenal());
                    row.createCell(260).setCellValue(monthlyConsultations.get(7).getToxGastroNausea());
                    row.createCell(261).setCellValue(monthlyConsultations.get(7).getToxGastroDiarrhea());
                    row.createCell(262).setCellValue(monthlyConsultations.get(0).getToxNeuroatiaPerif());
                    row.createCell(263).setCellValue(monthlyConsultations.get(7).getToxInfectious());
                    row.createCell(264).setCellValue(monthlyConsultations.get(7).getInfectionSite());
                    row.createCell(265).setCellValue(monthlyConsultations.get(7).getInfusionMedReaction());
                    row.createCell(266).setCellValue(monthlyConsultations.get(7).getAdverseReaction());

                }catch (Exception e){
                    System.out.println("Excepcion encontrada en consultas mensuales: " + e);
                }

                //CONSULTA FINAL
                FinalConsultation finalConsultation = this.finalConsultationService.findByPatientId(tmp.getId());
                try {
                    if (finalConsultation != null){
                        System.out.println("El suario " + tmp.getFullName() + " tiene si tiene consulta final");
                        //Agrega la consulta final
                        row.createCell(267).setCellValue(finalConsultation.getDateOfRealization());
                        row.createCell(268).setCellValue(finalConsultation.getAlbumin());
                        row.createCell(269).setCellValue(finalConsultation.getSerumCalcium());
                        row.createCell(270).setCellValue(finalConsultation.getLacticDehydrogenase());
                        row.createCell(271).setCellValue(finalConsultation.getHemoglobin());
                        row.createCell(272).setCellValue(finalConsultation.getHematocrit());
                        row.createCell(273).setCellValue(finalConsultation.getLeukocytes());
                        row.createCell(274).setCellValue(finalConsultation.getLymphocytes());
                        row.createCell(275).setCellValue(finalConsultation.getNeutrophils());
                        row.createCell(276).setCellValue(finalConsultation.getPlatelets());
                        row.createCell(277).setCellValue(finalConsultation.getIgG());
                        row.createCell(278).setCellValue(finalConsultation.getIgA());
                        row.createCell(279).setCellValue(finalConsultation.getIgM());
                        row.createCell(280).setCellValue(finalConsultation.getLightChainsKappa());
                        row.createCell(281).setCellValue(finalConsultation.getLightChainsLambda());
                        row.createCell(282).setCellValue(finalConsultation.getCelPlasmaticEnMedulaOsea());
                        row.createCell(283).setCellValue(finalConsultation.getElectroForesisDeProteinasSuero());
                        row.createCell(284).setCellValue(finalConsultation.getElectroForesisDeProteinasOrina());
                        row.createCell(285).setCellValue(finalConsultation.getInmFijacionTipoIg());
                        row.createCell(286).setCellValue(finalConsultation.getInmFijacionTipoCll());
                        row.createCell(287).setCellValue(finalConsultation.getEnfermedadMinimaResidual());
                        row.createCell(288).setCellValue(finalConsultation.getRepuestaATratamiento());
                        row.createCell(289).setCellValue(finalConsultation.getComentariosExtrax());
                        row.createCell(290).setCellValue(finalConsultation.getDateOfTransplant());
                        row.createCell(291).setCellValue(finalConsultation.getNumberOfCD34Infused());
                        row.createCell(292).setCellValue(finalConsultation.getMyeloidGraftDate());
                        row.createCell(293).setCellValue(finalConsultation.getDatePlateletGraft());
                        row.createCell(294).setCellValue(finalConsultation.getToxHemtoRedSerie());
                        row.createCell(295).setCellValue(finalConsultation.getToxHemtoNeutrophils());
                        row.createCell(296).setCellValue(finalConsultation.getToxHemtoPlatelets());
                        row.createCell(297).setCellValue(finalConsultation.getToxHepatics());
                        row.createCell(298).setCellValue(finalConsultation.getToxRenal());
                        row.createCell(299).setCellValue(finalConsultation.getToxGastroNausea());
                        row.createCell(300).setCellValue(finalConsultation.getToxGastroDiarrhea());
                        row.createCell(301).setCellValue(finalConsultation.getToxNeuroatiaPerif());
                        row.createCell(302).setCellValue(finalConsultation.getToxInfectious());
                    }
                    else {
                        System.out.println("El suario " + tmp.getFullName() + " no tiene consulta final registrada");
                    }
                }catch (Exception e){
                    System.out.println("Excepcion encontrada al procesar la consulta final:" + e);
                }
            }
//            for (int i = 0; allPatients.size() > i; i++) {
//                //row = sheet.createRow(i+2);
//                PatientModel tmp = allPatients.get(i);
//                List<MonthlyConsultation> monthlyConsultations = this.monthlyConsultationService.findByPatientId(tmp);
//                System.out.println("El numero de consultas mensuales es: " + monthlyConsultations.size() + " del usuario " + tmp.getFullName());
//                if (monthlyConsultations.size() == 1 || monthlyConsultations.size() == 2 || monthlyConsultations.size() == 3 ||
//                        monthlyConsultations.size() == 4 || monthlyConsultations.size() ==5 || monthlyConsultations.size() == 6 ||
//                monthlyConsultations.size() == 7 || monthlyConsultations.size() == 8){
//                    row.createCell(43).setCellValue(monthlyConsultations.get(0).getTreatmentCycleNum());
//                    row.createCell(44).setCellValue(monthlyConsultations.get(0).getDateOfRealization());
//                }
//            }
            //Escribe las filas en el arhivo
            fis.close();
            FileOutputStream fos =new FileOutputStream(new File("formato.xlsx"));
            workbook.write(fos);
            fos.close();
            System.out.println("formato.xlsx written successfully");
        }catch (IOException e){
            System.out.println("No se pudo generar el excel, excepcion:  " + e);
        }


            //Descarga el archivo de excel
            File file = new File("formato.xlsx");
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    //.header('Content-Disposition: attachment; filename="name_of_excel_file.xls"')
                    .contentLength(file.length())
                    .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                    .body(resource);




    }

    public void fillRows(){
        List<PatientModel> allPatients = this.patientService.findAll();
        for (PatientModel tmp : allPatients){

        }
    }


}