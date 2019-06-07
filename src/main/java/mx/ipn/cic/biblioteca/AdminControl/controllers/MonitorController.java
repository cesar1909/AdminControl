package mx.ipn.cic.biblioteca.AdminControl.controllers;

import mx.ipn.cic.biblioteca.AdminControl.model.*;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IRoleRepositoy;
import mx.ipn.cic.biblioteca.AdminControl.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

        if(getRol != null) {

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
  	  	      
  			}else {
				System.out.println("NO HAY ROLES REGISTRADOS");
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

//    @PostMapping(path = "/editFinalConsultation")
//    public @ResponseBody String testForm(@RequestBody FinalConsultation finalConsultation) throws Exception{
//        if (finalConsultation == null){
//            System.out.println("El parametro no llegó");
//        }
//        else {
//            System.out.println(finalConsultation.getIdPatient());
//            System.out.println(finalConsultation.getDateOfRealization());
//            System.out.println(finalConsultation.getAlbumin());
//            System.out.println(finalConsultation.getComentariosExtrax());
//        }
//        return "todo bien";
//    }




    @GetMapping(path = "/getMonthlyInfotoEdit")
    public @ResponseBody String getMonthlyInfotoEdit(@RequestParam("idConsulta") Integer idConsulta, @RequestParam("idPaciente") Integer idPaciente){
        String respuesta = "No data";
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
            respuesta = "<input type=\"text\" id=\"numCiclo\" class=\"form-control\" hidden=\"true\" name=\"ciclo\" value =" +selectedConsultation.getTreatmentCycleNum() + ">\n " +
                    "<input type=\"text\" id=\"idPatient\" class=\"form-control\" hidden=\"true\" name=\"id\" value =" +selectedConsultation.getIdpatient() + ">\n  " +
                    "          <div class=\"row\">\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"txtFechaValoracionCiclo\">Fecha de Valoración</label>\n" +
                    "                              <input type=\"text\" id=\"txtFechaValoracionCiclo\" class=\"form-control\" value =" + selectedConsultation.getDateOfRealization() + ">\n" +
                    "                            </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"txtAlbuminaCiclo\">Albumina (g/dL)</label>\n" +
                    "                              <input type=\"text\" id=\"txtAlbuminaCiclo\" class=\"form-control\" value =" + selectedConsultation.getAlbumin() + ">\n" +
                    "                            </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
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
                    "                        <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"txtDeshidrogenasaLacticaCiclo\">Deshidrogenasa Lactica (U/L)</label>\n" +
                    "                              <input type=\"text\" id=\"txtDeshidrogenasaLacticaCiclo\" class=\"form-control\" value =" + selectedConsultation.getLacticDehydrogenase() + ">\n" +
                    "                            </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"txtHemoglobinaCiclo\">Hemoglobina (g/dL)</label>\n" +
                    "                              <input type=\"text\" id=\"txtHemoglobinaCiclo\" class=\"form-control\" value =" + selectedConsultation.getHemoglobin() + ">\n" +
                    "                            </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
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
                    "                        <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"txtLeucocitosCiclo\">Leucocitos (cels x 10(3)/uL)</label>\n" +
                    "                              <input type=\"text\" id=\"txtLeucocitosCiclo\" class=\"form-control\" value =" + selectedConsultation.getLeukocytes() + ">\n" +
                    "                            </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"txtLinfocitosCiclo\">Linfocitos (cels x 10(3)/uL)</label>\n" +
                    "                              <input type=\"text\" id=\"txtLinfocitosCiclo\" class=\"form-control\" value =" + selectedConsultation.getLymphocytes() + ">\n" +
                    "                            </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
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
                    "                        <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"txtPlaquetasCiclo\">Plaquetas (cels x 10(3)/uL)</label>\n" +
                    "                              <input type=\"text\" id=\"txtPlaquetasCiclo\" class=\"form-control\" value =" + selectedConsultation.getPlatelets() + ">\n" +
                    "                            </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"txtIgGCiclo\">IgG (mg/dL)</label>\n" +
                    "                              <input type=\"text\" id=\"txtIgGCiclo\" class=\"form-control\" value =" + selectedConsultation.getIgG() + ">\n" +
                    "                            </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
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
                    "                        <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"txtIgMCiclo\">IgM (mg/dL)</label>\n" +
                    "                              <input type=\"text\" id=\"txtIgMCiclo\" class=\"form-control\" value =" + selectedConsultation.getIgM() + ">\n" +
                    "                            </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"txtCadenasKappaCiclo\">Cadenas Ligeras Kappa (mg/L)</label>\n" +
                    "                              <input type=\"text\" id=\"txtCadenasKappaCiclo\" class=\"form-control\" value =" + selectedConsultation.getLightChainsKappa() + ">\n" +
                    "                            </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
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
                    "                        <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"txtToxicidadSerieRojaCiclo\">Toxicidad Hematologica - Serie Roja</label>\n" +
                    "                              <input type=\"text\" id=\"txtToxicidadSerieRojaCiclo\" class=\"form-control\" value =" + selectedConsultation.getToxHemtoRedSerie() + ">\n" +
                    "                            </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"txtToxicidadNeutrofilosCiclo\">Toxicidad Hematologica - Neutrofilos</label>\n" +
                    "                              <input type=\"text\" id=\"txtToxicidadNeutrofilosCiclo\" class=\"form-control\" value =" + selectedConsultation.getToxHemtoNeutrophils() + ">\n" +
                    "                            </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
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
                    "                        <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"txtToxicidadHepaticaCiclo\">Toxicidad Hepática</label>\n" +
                    "                              <input type=\"text\" id=\"txtToxicidadHepaticaCiclo\" class=\"form-control\" value =" + selectedConsultation.getToxHepatics() + ">\n" +
                    "                            </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"txtToxicidadRenalCiclo\">Toxicidad Renal</label>\n" +
                    "                              <input type=\"text\" id=\"txtToxicidadRenalCiclo\" class=\"form-control\" value =" + selectedConsultation.getToxRenal() + ">\n" +
                    "                            </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
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
                    "                        <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"txtSitioInfeccionCiclo\">Sitio de infección</label>\n" +
                    "                              <input type=\"text\" id=\"txtSitioInfeccionCiclo\" class=\"form-control\" value =" + selectedConsultation.getInfectionSite() + ">\n" +
                    "                            </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"txtToxicidadNauseaCiclo\">Toxicidad gastrointestinal - Nausea</label>\n" +
                    "                              <input type=\"text\" id=\"txtToxicidadNauseaCiclo\" class=\"form-control\" value =" + selectedConsultation.getToxGastroNausea() + ">\n" +
                    "                            </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
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
                    "                        <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"txtToxicidadNeuropatiaCiclo\">Toxicidad neuropatía periférica</label>\n" +
                    "                              <input type=\"text\" id=\"txtToxicidadNeuropatiaCiclo\" class=\"form-control\" value =" + selectedConsultation.getToxNeuroatiaPerif() + ">\n" +
                    "                            </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"txtReaccionMedicamentoCiclo\">Reacción a infusión de medicamentos</label>\n" +
                    "                              <input type=\"text\" id=\"txtReaccionMedicamentoCiclo\" class=\"form-control\" value =" + selectedConsultation.getInfusionMedReaction() + ">\n" +
                    "                            </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +
                    "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                        <fieldset enabled>\n" +
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



    @GetMapping(path = "/getFinalInfoToEdit")
    public @ResponseBody String getFinalInfotoEdit(@RequestParam("id") Integer id){

        String respuesta = null;

        //Probamos nuestra conexion con el cliente
        if (id == null){ System.out.println("NO SE RECIBIO ID"); }
        else { System.out.println("ID CON VALOR = " + id); }

        //Buscamos la consulta final
        FinalConsultation finalConsultation = this.finalConsultationService.findByPatientId(id);
        if (finalConsultation == null){
            respuesta = "no data";
        }
        else if (finalConsultation.getMyeloidGraftDate() == null){
            respuesta = "                         <input type=\"text\" id=\"idPatient\" class=\"form-control\" hidden=\"true\" name=\"id\" value =" +finalConsultation.getIdPatient() + "\">\n " +
                    "                    <div class=\"row\">\n" +
                    "                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
                    "                                <div class=\"form-group\">\n" +
                    "                                  <label for=\"txtCalendar\">Fecha de Valoración Final</label>\n" +
                    "                                  <input id=\"txtCalendar\" type=\"text\" class=\"mt10px input form-control\" name=\"dateOfRealization\" value =" +finalConsultation.getDateOfRealization() + " \">\n" +
                    "                                </div>\n" +
                    "                            </fieldset>\n" +
                    "                          </div>\n" +
                    "                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
                    "                                <div class=\"form-group\">\n" +
                    "                                  <label for=\"Albumina\">Albumina (g/dL)</label>\n" +
                    "                                  <input type=\"text\" class=\"form-control\" id=\"Albumina\" placeholder=\"g/dL\"name=\"albumin\" value =" +finalConsultation.getAlbumin() + " \">\n" +
                    "                                </div>\n" +
                    "                            </fieldset>\n" +
                    "                          </div>\n" +
                    "                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
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
                    "                            <fieldset enabled>\n" +
                    "                                <div class=\"form-group\">\n" +
                    "                                  <label for=\"Deshidrogenasa_Lactica\">Deshidrogenasa Lactica (U/L)</label>\n" +
                    "                                  <input type=\"text\" class=\"form-control\" id=\"Deshidrogenasa_Lactica\" placeholder=\"U/L\" name=\"lacticDehydrogenase\" value =" +finalConsultation.getLacticDehydrogenase() + " \">\n" +
                    "                                </div>\n" +
                    "                            </fieldset>\n" +
                    "                          </div>\n" +
                    "                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
                    "                                <div class=\"form-group\">\n" +
                    "                                  <label for=\"Hemoglobina\">Hemoglobina (g/dL)</label>\n" +
                    "                                  <input type=\"text\" class=\"form-control\" id=\"Hemoglobina\" placeholder=\"g/dL\" name=\"hemoglobin\" value =" +finalConsultation.getHemoglobin() + " \">\n" +
                    "                                </div>\n" +
                    "                            </fieldset>\n" +
                    "                          </div>\n" +
                    "                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
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
                    "                            <fieldset enabled>\n" +
                    "                                <div class=\"form-group\">\n" +
                    "                                  <label for=\"Leucocitos\">Leucocitos (cels x 10(3)/uL)</label>\n" +
                    "                                  <input type=\"text\" class=\"form-control\" id=\"Leucocitos\" placeholder=\"cels x 10(3)/uL\" name=\"leukocytes\" value =" +finalConsultation.getLeukocytes() + " \">\n" +
                    "                                </div>\n" +
                    "                            </fieldset>\n" +
                    "                          </div>\n" +
                    "                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
                    "                                <div class=\"form-group\">\n" +
                    "                                  <label for=\"Linfocitos\">Linfocitos (cels x 10(3)/uL)</label>\n" +
                    "                                  <input type=\"text\" class=\"form-control\" id=\"Linfocitos\" placeholder=\"cels x 10(3)/uL\" name=\"lymphocytes\" value =" +finalConsultation.getLymphocytes() + " \">\n" +
                    "                                </div>\n" +
                    "                            </fieldset>\n" +
                    "                          </div>\n" +
                    "                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
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
                    "                          <fieldset enabled>\n" +
                    "                              <div class=\"form-group\">\n" +
                    "                                <label for=\"Plaquetas\">Plaquetas (cels x 10(3)/uL)</label>\n" +
                    "                                <input type=\"text\" class=\"form-control\" id=\"Plaquetas\" placeholder=\"cels x 10(3)/uL\" name=\"platelets\" value =" +finalConsultation.getPlatelets() + " \">\n" +
                    "                              </div>\n" +
                    "                          </fieldset>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                          <fieldset enabled>\n" +
                    "                              <div class=\"form-group\">\n" +
                    "                                <label for=\"IgG\">IgG (mg/dL)</label>\n" +
                    "                                <input type=\"text\" class=\"form-control\" id=\"IgG\" placeholder=\"mg/dL\" name=\"igG\" value =" +finalConsultation.getIgG() + " \">\n" +
                    "                              </div>\n" +
                    "                          </fieldset>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                          <fieldset enabled>\n" +
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
                    "                          <fieldset enabled>\n" +
                    "                              <div class=\"form-group\">\n" +
                    "                                <label for=\"IgM\">IgM (mg/dL)</label>\n" +
                    "                                <input type=\"text\" class=\"form-control\" id=\"IgM\" placeholder=\"mg/dL\" name=\"igM\" value =" +finalConsultation.getIgM() + " \">\n" +
                    "                              </div>\n" +
                    "                          </fieldset>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                          <fieldset enabled>\n" +
                    "                              <div class=\"form-group\">\n" +
                    "                                <label for=\"Cadenas_Ligeras_Kappa\">Cadenas Ligeras Kappa (mg/L)</label>\n" +
                    "                                <input type=\"text\" class=\"form-control\" id=\"Cadenas_Ligeras_Kappa\" placeholder=\"mg/dL\" name=\"lightChainsKappa\" value =" +finalConsultation.getLightChainsKappa() + " \">\n" +
                    "                              </div>\n" +
                    "                          </fieldset>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                          <fieldset enabled>\n" +
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
                    "                            <fieldset enabled>\n" +
                    "                                <div class=\"form-group\">\n" +
                    "                                  <label for=\"celplasmo\">Células plasmáticas en Médula ósea (%)</label>\n" +
                    "                                  <input type=\"text\" class=\"form-control\" id=\"celplasmo\" placeholder=\"%\" name=\"celPlasmaticEnMedulaOsea\" value =" +finalConsultation.getCelPlasmaticEnMedulaOsea() + " \">\n" +
                    "                                </div>\n" +
                    "                            </fieldset>\n" +
                    "                          </div>\n" +
                    "                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
                    "                                <div class=\"form-group\">\n" +
                    "                                  <label for=\"electroforesis\">Electroforesis de proteínas Suero</label>\n" +
                    "                                  <input type=\"text\" class=\"form-control\" id=\"electroforesis\" placeholder=\"g/L\" name=\"electroForesisDeProteinasSuero\" value =" +finalConsultation.getElectroForesisDeProteinasSuero() + " \">\n" +
                    "                                </div>\n" +
                    "                            </fieldset>\n" +
                    "                          </div>\n" +
                    "                        <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                          <fieldset enabled>\n" +
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
                    "                          <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"inmunofijacionig\">Inmunofijación Tipo Ig</label>\n" +
                    "                              <select id=\"inmunofijacionig\" class=\"form-control\" name=\"inmFijacionTipoIg\" \">\n" +
                    "                              <option selected hidden value =" +finalConsultation.getInmFijacionTipoIg() + ">" +finalConsultation.getInmFijacionTipoIg() + "</option>\n" +
                    "                                <option value=\"Negativa\">Negativa</option>\n" +
                    "                                <option value=\"IgA\">IgA</option>\n" +
                    "                                <option value=\"IgG\">IgG</option>\n" +
                    "                                <option value=\"No secretor\">No secretor</option>\n" +
                    "                              </select>\n" +
                    "                            </div>\n" +
                    "                          </fieldset>\n" +
                    "                        </div>\n" +
                    "                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
                    "                                <div class=\"form-group\">\n" +
                    "                                  <label for=\"inmunofijacioncll\">Inmunofijacion Tipo CLL</label>\n" +
                    "                                  <select id=\"inmunofijacioncll\" class=\"form-control\" name=\"inmFijacionTipoCll\" \">\n" +
                    "                              <option selected hidden value =" +finalConsultation.getInmFijacionTipoCll() + ">" +finalConsultation.getInmFijacionTipoCll() + "</option>\n" +
                    "                                    <option value=\"Negativo\">Negativa</option>\n" +
                    "                                    <option value=\"Lambda\">Lambda</option>\n" +
                    "                                    <option value=\"Kappa\">Kappa</option>\n" +
                    "                                    <option value=\"No secretor\">No secretor</option>\n" +
                    "                                  </select>                                </div>\n" +
                    "                            </fieldset>\n" +
                    "                          </div>\n" +
                    "                                                    <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
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
                    "                        <fieldset enabled>\n" +
                    "                          <div class=\"form-group\">\n" +
                    "                            <label for=\"resTrat\">Respuesta a tratamiento</label>\n" +
                    "                            <select id=\"resTrat\" class=\"form-control\" name=\"repuestaATratamiento\" \">\n" +
                    "                              <option selected hidden value =" +finalConsultation.getRepuestaATratamiento() + ">" +finalConsultation.getRepuestaATratamiento() + "</option>\n" +
                    "                              <option value=\"RCs\">RCs</option>\n" +
                    "                              <option value=\"RC\">RC</option>\n" +
                    "                              <option value=\"MBRP\">MBRP</option>\n" +
                    "                              <option value=\"RP\">RP</option>\n" +
                    "                              <option value=\"EE\">EE</option>\n" +
                    "                              <option value=\"PE\">PE</option>\n" +
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
                    "                              <textarea enabled id=\"comment\" rows=\"20\" class=\"form-control\" name=\"comentariosExtrax\">" + finalConsultation.getComentariosExtrax() + "</textarea>\n" +

                    "                            </div>\n" +
                    "                          </div>\n" +
                    "                      </div>";
        }
        else {
            respuesta = "                         <input type=\"text\" id=\"idPatient\" class=\"form-control\" hidden=\"true\" name=\"id\" value =" +finalConsultation.getIdPatient() + "\">\n " +
                    "                    <div class=\"row\">\n" +
                    "                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
                    "                                <div class=\"form-group\">\n" +
                    "                                  <label for=\"txtCalendar\">Fecha de Valoración Final</label>\n" +
                    "                                  <input id=\"txtCalendar\" type=\"text\" class=\"mt10px input form-control\" name=\"dateOfRealization\" value =" +finalConsultation.getDateOfRealization() + " \">\n" +
                    "                                </div>\n" +
                    "                            </fieldset>\n" +
                    "                          </div>\n" +
                    "                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
                    "                                <div class=\"form-group\">\n" +
                    "                                  <label for=\"Albumina\">Albumina (g/dL)</label>\n" +
                    "                                  <input type=\"text\" class=\"form-control\" id=\"Albumina\" placeholder=\"g/dL\"name=\"albumin\" value =" +finalConsultation.getAlbumin() + " \">\n" +
                    "                                </div>\n" +
                    "                            </fieldset>\n" +
                    "                          </div>\n" +
                    "                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
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
                    "                            <fieldset enabled>\n" +
                    "                                <div class=\"form-group\">\n" +
                    "                                  <label for=\"Deshidrogenasa_Lactica\">Deshidrogenasa Lactica (U/L)</label>\n" +
                    "                                  <input type=\"text\" class=\"form-control\" id=\"Deshidrogenasa_Lactica\" placeholder=\"U/L\" name=\"lacticDehydrogenase\" value =" +finalConsultation.getLacticDehydrogenase() + " \">\n" +
                    "                                </div>\n" +
                    "                            </fieldset>\n" +
                    "                          </div>\n" +
                    "                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
                    "                                <div class=\"form-group\">\n" +
                    "                                  <label for=\"Hemoglobina\">Hemoglobina (g/dL)</label>\n" +
                    "                                  <input type=\"text\" class=\"form-control\" id=\"Hemoglobina\" placeholder=\"g/dL\" name=\"hemoglobin\" value =" +finalConsultation.getHemoglobin() + " \">\n" +
                    "                                </div>\n" +
                    "                            </fieldset>\n" +
                    "                          </div>\n" +
                    "                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
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
                    "                            <fieldset enabled>\n" +
                    "                                <div class=\"form-group\">\n" +
                    "                                  <label for=\"Leucocitos\">Leucocitos (cels x 10(3)/uL)</label>\n" +
                    "                                  <input type=\"text\" class=\"form-control\" id=\"Leucocitos\" placeholder=\"cels x 10(3)/uL\" name=\"leukocytes\" value =" +finalConsultation.getLeukocytes() + " \">\n" +
                    "                                </div>\n" +
                    "                            </fieldset>\n" +
                    "                          </div>\n" +
                    "                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
                    "                                <div class=\"form-group\">\n" +
                    "                                  <label for=\"Linfocitos\">Linfocitos (cels x 10(3)/uL)</label>\n" +
                    "                                  <input type=\"text\" class=\"form-control\" id=\"Linfocitos\" placeholder=\"cels x 10(3)/uL\" name=\"lymphocytes\" value =" +finalConsultation.getLymphocytes() + " \">\n" +
                    "                                </div>\n" +
                    "                            </fieldset>\n" +
                    "                          </div>\n" +
                    "                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
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
                    "                          <fieldset enabled>\n" +
                    "                              <div class=\"form-group\">\n" +
                    "                                <label for=\"Plaquetas\">Plaquetas (cels x 10(3)/uL)</label>\n" +
                    "                                <input type=\"text\" class=\"form-control\" id=\"Plaquetas\" placeholder=\"cels x 10(3)/uL\" name=\"platelets\" value =" +finalConsultation.getPlatelets() + " \">\n" +
                    "                              </div>\n" +
                    "                          </fieldset>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                          <fieldset enabled>\n" +
                    "                              <div class=\"form-group\">\n" +
                    "                                <label for=\"IgG\">IgG (mg/dL)</label>\n" +
                    "                                <input type=\"text\" class=\"form-control\" id=\"IgG\" placeholder=\"mg/dL\" name=\"igG\" value =" +finalConsultation.getIgG() + " \">\n" +
                    "                              </div>\n" +
                    "                          </fieldset>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                          <fieldset enabled>\n" +
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
                    "                          <fieldset enabled>\n" +
                    "                              <div class=\"form-group\">\n" +
                    "                                <label for=\"IgM\">IgM (mg/dL)</label>\n" +
                    "                                <input type=\"text\" class=\"form-control\" id=\"IgM\" placeholder=\"mg/dL\" name=\"igM\" value =" +finalConsultation.getIgM() + " \">\n" +
                    "                              </div>\n" +
                    "                          </fieldset>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                          <fieldset enabled>\n" +
                    "                              <div class=\"form-group\">\n" +
                    "                                <label for=\"Cadenas_Ligeras_Kappa\">Cadenas Ligeras Kappa (mg/L)</label>\n" +
                    "                                <input type=\"text\" class=\"form-control\" id=\"Cadenas_Ligeras_Kappa\" placeholder=\"mg/dL\" name=\"lightChainsKappa\" value =" +finalConsultation.getLightChainsKappa() + " \">\n" +
                    "                              </div>\n" +
                    "                          </fieldset>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                          <fieldset enabled>\n" +
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
                    "                            <fieldset enabled>\n" +
                    "                                <div class=\"form-group\">\n" +
                    "                                  <label for=\"celplasmo\">Células plasmáticas en Médula ósea (%)</label>\n" +
                    "                                  <input type=\"text\" class=\"form-control\" id=\"celplasmo\" placeholder=\"%\" name=\"celPlasmaticEnMedulaOsea\" value =" +finalConsultation.getCelPlasmaticEnMedulaOsea() + " \">\n" +
                    "                                </div>\n" +
                    "                            </fieldset>\n" +
                    "                          </div>\n" +
                    "                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
                    "                                <div class=\"form-group\">\n" +
                    "                                  <label for=\"electroforesis\">Electroforesis de proteínas Suero</label>\n" +
                    "                                  <input type=\"text\" class=\"form-control\" id=\"electroforesis\" placeholder=\"g/L\" name=\"electroForesisDeProteinasSuero\" value =" +finalConsultation.getElectroForesisDeProteinasSuero() + " \">\n" +
                    "                                </div>\n" +
                    "                            </fieldset>\n" +
                    "                          </div>\n" +
                    "                        <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                          <fieldset enabled>\n" +
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
                    "                          <fieldset enabled>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"inmunofijacionig\">Inmunofijación Tipo Ig</label>\n" +
                    "                              <select id=\"inmunofijacionig\" class=\"form-control\" name=\"inmFijacionTipoIg\" \">\n" +
                    "                              <option selected hidden value =" +finalConsultation.getInmFijacionTipoIg() + ">" +finalConsultation.getInmFijacionTipoIg() + "</option>\n" +
                    "                                <option value=\"Negativa\">Negativa</option>\n" +
                    "                                <option value=\"IgA\">IgA</option>\n" +
                    "                                <option value=\"IgG\">IgG</option>\n" +
                    "                                <option value=\"No secretor\">No secretor</option>\n" +
                    "                              </select>\n" +
                    "                            </div>\n" +
                    "                          </fieldset>\n" +
                    "                        </div>\n" +
                    "                          <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
                    "                                <div class=\"form-group\">\n" +
                    "                                  <label for=\"inmunofijacioncll\">Inmunofijacion Tipo CLL</label>\n" +
                    "                                  <select id=\"inmunofijacioncll\" class=\"form-control\" name=\"inmFijacionTipoCll\" \">\n" +
                    "                              <option selected hidden value =" +finalConsultation.getInmFijacionTipoCll() + ">" +finalConsultation.getInmFijacionTipoCll() + "</option>\n" +
                    "                                    <option value=\"Negativo\">Negativa</option>\n" +
                    "                                    <option value=\"Lambda\">Lambda</option>\n" +
                    "                                    <option value=\"Kappa\">Kappa</option>\n" +
                    "                                    <option value=\"No secretor\">No secretor</option>\n" +
                    "                                  </select>                                </div>\n" +
                    "                            </fieldset>\n" +
                    "                          </div>\n" +
                    "                                                    <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
                    "                            <fieldset enabled>\n" +
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
                    "                        <fieldset enabled>\n" +
                    "                          <div class=\"form-group\">\n" +
                    "                            <label for=\"resTrat\">Respuesta a tratamiento</label>\n" +
                    "                            <select id=\"resTrat\" class=\"form-control\" name=\"repuestaATratamiento\" \">\n" +
                    "                              <option selected hidden value =" +finalConsultation.getRepuestaATratamiento() + ">" +finalConsultation.getRepuestaATratamiento() + "</option>\n" +
                    "                              <option value=\"RCs\">RCs</option>\n" +
                    "                              <option value=\"RC\">RC</option>\n" +
                    "                              <option value=\"MBRP\">MBRP</option>\n" +
                    "                              <option value=\"RP\">RP</option>\n" +
                    "                              <option value=\"EE\">EE</option>\n" +
                    "                              <option value=\"PE\">PE</option>\n" +
                    "                            </select>                          </div>\n" +
                    "                        </fieldset>\n" +
                    "                      </div>\n" +

                    "						<div class=\"form-group col-md-4\">\n" +
                    "                              <label for=\"txtDateTrasplante\">Fecha de Trasplante</label>\n" +
                    "                              <input id=\"txtDateTrasplante\" type=\"text\" class=\"mt10px input form-control\" name=\"dateOfTransplant\" value=\" \"  value =" +finalConsultation.getDateOfTransplant() + " > \n" +
                    "                       </div>"+
                    "                    </div>\n" +
                    "					<div class=\"form-row\">\n" +
                    "                                                        <div class=\"form-group col-md-4\">\n" +
                    "                                                            <label for=\"celCD34\">Número de CD34 infundidas</label>\n" +
                    "                                                            <input id=\"celCD34\" type=\"number\" class=\"form-control\" placeholder=\"x10(6)\" name=\"numberOfCD34Infused\" value =" +finalConsultation.getNumberOfCD34Infused() + " >\n" +
                    "                                                        </div>\n" +
                    "                                                        <div class=\"form-group col-md-4\">\n" +
                    "                                                            <label for=\"txtDateInjertoMie\">Fecha injerto mieloide</label>\n" +
                    "                                                            <input id=\"txtDateInjertoMie\" type=\"text\" class=\"mt10px input form-control\" name=\"myeloidGraftDate\" value =" +finalConsultation.getMyeloidGraftDate() + " ><!-- th:field=\"*{}\"-->\n" +
                    "                                                        </div>\n" +
                    "                                                        <div class=\"form-group col-md-4\">\n" +
                    "                                                            <label for=\"txtDateInjertoPla\">Fecha injerto plaquetario</label>\n" +
                    "                                                            <input id=\"txtDateInjertoPla\" type=\"text\" class=\"mt10px input form-control\" name=\"datePlateletGraft\" value =" +finalConsultation.getDatePlateletGraft() + " ><!-- th:field=\"*{}\"-->\n" +
                    "                                                        </div>\n" +
                    "\n" +
                    "                 </div>"+
                    "                <div class=\"form-row\">\n" +
                    "                                                        <div class=\"form-group col-md-4\">\n" +
                    "                                                            <label for=\"Toxicidad_Hematologica_Plaquetas\">Toxicidad Hematológica - Plaquetas</label>\n" +
                    "                                                            <select id=\"Toxicidad_Hematologica_Plaquetas\" class=\"form-control\"  name=\"toxHemtoPlatelets\" value =" +finalConsultation.getToxHemtoPlatelets() + " ><!-- th:field=\"*{toxHemtoPlatelets}\"-->\n" +
                    "                                                                <option value=\"0\" selected>0</option>\n" +
                    "                                                                <option value=\"1\">1</option>\n" +
                    "                                                                <option value=\"2\">2</option>\n" +
                    "                                                                <option value=\"3\">3</option>\n" +
                    "                                                                <option value=\"4\">4</option>\n" +
                    "                                                                <option value=\"5\">5</option>\n" +
                    "                                                            </select>\n" +
                    "                                                        </div>\n" +
                    "                                                        <div class=\"form-group col-md-4\">\n" +
                    "                                                            <label for=\"Toxicidad_Hepatica\">Toxicidad Hepática</label >\n" +
                    "                                                            <select id=\"Toxicidad_Hepatica\" class=\"form-control\"  name=\"toxHepatics\" value =" +finalConsultation.getToxHepatics() + " ><!-- th:field=\"*{toxHepatics}\"-->\n" +
                    "                                                                <option value=\"0\" selected>0</option>\n" +
                    "                                                                <option value=\"1\">1</option>\n" +
                    "                                                                <option value=\"2\">2</option>\n" +
                    "                                                                <option value=\"3\">3</option>\n" +
                    "                                                                <option value=\"4\">4</option>\n" +
                    "                                                                <option value=\"5\">5</option>\n" +
                    "                                                            </select>\n" +
                    "                                                        </div>\n" +
                    "                                                        <div class=\"form-group col-md-4\">\n" +
                    "                                                            <label for=\"Toxicidad_Renal\">Toxicidad Renal</label>\n" +
                    "                                                            <select id=\"Toxicidad_Renal\" class=\"form-control\"  name=\"toxRenal\" value =" +finalConsultation.getToxRenal() + " ><!-- th:field=\"*{toxRenal}\"-->\n" +
                    "                                                                <option value=\"0\" selected>0</option>\n" +
                    "                                                                <option value=\"1\">1</option>\n" +
                    "                                                                <option value=\"2\">2</option>\n" +
                    "                                                                <option value=\"3\">3</option>\n" +
                    "                                                                <option value=\"4\">4</option>\n" +
                    "                                                                <option value=\"5\">5</option>\n" +
                    "                                                            </select>\n" +
                    "                                                        </div>\n" +
                    "                         </div>\n" +
                    "                                                    <br>"+
                    "                         <div class=\"form-row\">\n" +
                    "                                                        <div class=\"form-group col-md-4\">\n" +
                    "                                                            <label for=\"Toxicidad_Hematologica_Serie_Roja\">Toxicidad Hematológica - Serie Roja</label>\n" +
                    "                                                            <select id=\"Toxicidad_Hematologica_Serie_Roja\" class=\"form-control\" name=\"toxHemtoRedSerie\" value =" +finalConsultation.getToxHemtoRedSerie() + " ><!-- th:field=\"*{toxHemtoRedSerie}\"-->\n" +
                    "                                                                <option value=\"0\" selected>0</option>\n" +
                    "                                                                <option value=\"1\">1</option>\n" +
                    "                                                                <option value=\"2\">2</option>\n" +
                    "                                                                <option value=\"3\">3</option>\n" +
                    "                                                                <option value=\"4\">4</option>\n" +
                    "                                                                <option value=\"5\">5</option>\n" +
                    "                                                            </select>\n" +
                    "                                                        </div>\n" +
                    "                                                        <div class=\"form-group col-md-4\">\n" +
                    "                                                            <label for=\"Toxicidad_Hematologica_Neutrofilos\">Toxicidad Hematológica - Neutrofilos</label>\n" +
                    "                                                            <select id=\"Toxicidad_Hematologica_Neutrofilos\" class=\"form-control\" name=\"toxHemtoNeutrophils\" value =" +finalConsultation.getToxHemtoNeutrophils() + " ><!-- th:field=\"*{toxHemtoNeutrophils}\"-->\n" +
                    "                                                                <option value=\"0\" selected>0</option>\n" +
                    "                                                                <option value=\"1\">1</option>\n" +
                    "                                                                <option value=\"2\">2</option>\n" +
                    "                                                                <option value=\"3\">3</option>\n" +
                    "                                                                <option value=\"4\">4</option>\n" +
                    "                                                                <option value=\"5\">5</option>\n" +
                    "                                                            </select>\n" +
                    "                                                        </div>\n" +
                    "                                                        <div class=\"form-group col-md-4\">\n" +
                    "                                                            <label for=\"Toxicidad_neuropatia_periferica\">Toxicidad neuropatía periférica</label>\n" +
                    "                                                            <select id=\"Toxicidad_neuropatia_periferica\" class=\"form-control\"  name=\"toxNeuroatiaPerif\" value =" +finalConsultation.getToxNeuroatiaPerif() + " ><!-- th:field=\"*{toxNeuroatiaPerif}\">-->\n" +
                    "                                                                <option value=\"0\" selected>0</option>\n" +
                    "                                                                <option value=\"1\">1</option>\n" +
                    "                                                                <option value=\"2\">2</option>\n" +
                    "                                                                <option value=\"3\">3</option>\n" +
                    "                                                                <option value=\"4\">4</option>\n" +
                    "                                                                <option value=\"5\">5</option>\n" +
                    "                                                            </select>\n" +
                    "                                                        </div>\n" +
                    "\n" +
                    "                              </div>\n" +
                    "                              <br>"+
                    "								<div class=\"form-row\">\n" +
                    "                                                        <div class=\"form-group col-md-4\">\n" +
                    "                                                            <label for=\"Sitio_de_infeccion\">Sitio de infección</label>\n" +
                    "                                                            <select id=\"Sitio_de_infeccion\" class=\"form-control\"  name=\"infectionSite\" value =" +finalConsultation.getInfectionSite() + " ><!-- th:field=\"*{infectionSite}\">-->\n" +
                    "                                                                <option value=\"Ninguna\" selected>Ninguna</option>\n" +
                    "                                                                <option value=\"Vias respiratorias altas\">Vías respiratorias altas</option>\n" +
                    "                                                                <option value=\"Neumonia\">Neumonía</option>\n" +
                    "                                                                <option value=\"Abdominal\">Abdominal</option>\n" +
                    "                                                                <option value=\"Tejidos blandos\">Tejidos blandos</option>\n" +
                    "                                                                <option value=\"Urinaria\">Urinaria</option>\n" +
                    "                                                            </select>\n" +
                    "                                                        </div>\n" +
                    "                                                        <div class=\"form-group col-md-4\">\n" +
                    "                                                            <label for=\"Toxicidad_Infecciosa\">Toxicidad Infecciosa</label>\n" +
                    "                                                            <select id=\"Toxicidad_Infecciosa\" class=\"form-control\"  name=\"toxInfectious\" value =" +finalConsultation.getToxInfectious() + " ><!-- th:field=\"*{toxInfectious}\">-->\n" +
                    "                                                                <option value=\"0\" selected>0</option>\n" +
                    "                                                                <option value=\"1\">1</option>\n" +
                    "                                                                <option value=\"2\">2</option>\n" +
                    "                                                                <option value=\"3\">3</option>\n" +
                    "                                                                <option value=\"4\">4</option>\n" +
                    "                                                                <option value=\"5\">5</option>\n" +
                    "                                                            </select>\n" +
                    "                                                        </div>\n" +
                    "                                                        <div class=\"form-group col-md-4\">\n" +
                    "                                                            <label for=\"Toxicidad_Gastrointestinal-Nausea\">Toxicidad Gastrointestinal-Nausea</label>\n" +
                    "                                                            <select id=\"Toxicidad_Gastrointestinal-Nausea\" class=\"form-control\" name=\"toxGastroNausea\" value =" +finalConsultation.getToxGastroNausea() + " ><!-- th:field=\"*{toxGastroNausea}\">-->\n" +
                    "                                                                <option value=\"0\" selected>0</option>\n" +
                    "                                                                <option value=\"1\">1</option>\n" +
                    "                                                                <option value=\"2\">2</option>\n" +
                    "                                                                <option value=\"3\">3</option>\n" +
                    "                                                                <option value=\"4\">4</option>\n" +
                    "                                                                <option value=\"5\">5</option>\n" +
                    "                                                            </select>\n" +
                    "                                                        </div>\n" +
                    "\n" +
                    "                                     </div>\n" +
                    "                                     <br>"+
                    "						<div class=\"form-row\">\n" +
                    "                                                        <div class=\"form-group col-md-4\">\n" +
                    "                                                            <label for=\"Toxicidad_Gastrointestinal-Diarrea\">Toxicidad Gastrointestinal-Diarrea</label>\n" +
                    "                                                            <select id=\"Toxicidad_Gastrointestinal-Diarrea\" class=\"form-control\"  name=\"toxGastroDiarrhea\" value =" +finalConsultation.getToxGastroDiarrhea() + " ><!-- th:field=\"*{toxGastroDiarrhea}\">-->\n" +
                    "                                                                <option value=\"0\" selected>0</option>\n" +
                    "                                                                <option value=\"1\">1</option>\n" +
                    "                                                                <option value=\"2\">2</option>\n" +
                    "                                                                <option value=\"3\">3</option>\n" +
                    "                                                                <option value=\"4\">4</option>\n" +
                    "                                                                <option value=\"5\">5</option>\n" +
                    "                                                            </select>\n" +
                    "                                                        </div>\n" +
                    "\n" +
                    "                                                        <div class=\"form-group col-md-4\">\n" +
                    "                                                            <label for=\"Reaccion_a_infusion_de_medicamentos\">Reacción a infusión de medicamentos</label>\n" +
                    "                                                            <select id=\"Reaccion_a_infusion_de_medicamentos\" class=\"form-control\"  name=\"infusionMedReaction\" value =" +finalConsultation.getInfusionMedReaction() + " ><!-- th:field=\"*{infusionMedReaction}\">-->\n" +
                    "                                                                <option value=\"0\" selected>0</option>\n" +
                    "                                                                <option value=\"1\">1</option>\n" +
                    "                                                                <option value=\"2\">2</option>\n" +
                    "                                                                <option value=\"3\">3</option>\n" +
                    "                                                                <option value=\"4\">4</option>\n" +
                    "                                                                <option value=\"5\">5</option>\n" +
                    "                                                            </select>\n" +
                    "                                                        </div>\n" +
                    "\n" +
                    "                                  </div>\n" +
                    "                                  <br>"+
                    "                      <div class=\"row\">\n" +
                    "                          <div class=\"col-lg-12 col-md-12 col-sm-12\">\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                              <label for=\"comment\"\n" +
                    "                                >Observaciones</label\n" +
                    "                              >\n" +
                    "                              <textarea  id=\"comment\" rows=\"20\" class=\"form-control\" name=\"comentariosExtrax\">" + finalConsultation.getComentariosExtrax() + "</textarea>\n" +

                    "                            </div>\n" +
                    "                          </div>\n" +
                    "                      </div>";
        }
        return respuesta;
    }



}
