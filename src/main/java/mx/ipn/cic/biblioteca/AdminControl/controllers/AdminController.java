package mx.ipn.cic.biblioteca.AdminControl.controllers;


import mx.ipn.cic.biblioteca.AdminControl.model.*;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IAdminRepository;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IMonitorRepository;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IRoleRepositoy;
import mx.ipn.cic.biblioteca.AdminControl.repositories.UserBaseRepository;
import mx.ipn.cic.biblioteca.AdminControl.services.MonitorService;
import mx.ipn.cic.biblioteca.AdminControl.projections.FindPatientsByEmailResult;
import mx.ipn.cic.biblioteca.AdminControl.repositories.UserRepository;
import mx.ipn.cic.biblioteca.AdminControl.services.DoctorService;
import mx.ipn.cic.biblioteca.AdminControl.services.PatientService;
import mx.ipn.cic.biblioteca.AdminControl.services.UserServiceImpl;
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
            for (int i = 0; allPatients.size() > i; i++){
                PatientModel tmp = allPatients.get(i);
                XSSFRow row= sheet.createRow(i+2);
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
            }

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