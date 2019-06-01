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

    @PostMapping(path = "/editFinalConsultation")
    public @ResponseBody String testForm(@RequestBody FinalConsultation finalConsultation) throws Exception{
        if (finalConsultation == null){
            System.out.println("El parametro no llegó");
        }
        else {
            System.out.println(finalConsultation.getIdPatient());
            System.out.println(finalConsultation.getDateOfRealization());
            System.out.println(finalConsultation.getAlbumin());
            System.out.println(finalConsultation.getComentariosExtrax());
        }
        return "todo bien";
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
                    "                              <select id=\"inmunofijacionig\" class=\"form-control\" name=\"inmFijacionTipoIg\" value =" +finalConsultation.getInmFijacionTipoIg() + " \">\n" +
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
                    "                                  <select id=\"inmunofijacioncll\" class=\"form-control\" name=\"inmFijacionTipoCll\" value =" +finalConsultation.getInmFijacionTipoCll() + " \">\n" +
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
                    "                            <select id=\"resTrat\" class=\"form-control\" name=\"repuestaATratamiento\" value =" +finalConsultation.getRepuestaATratamiento() + " \">\n" +
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
        return respuesta;
    }



}
