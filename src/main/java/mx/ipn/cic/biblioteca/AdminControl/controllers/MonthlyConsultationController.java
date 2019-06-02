package mx.ipn.cic.biblioteca.AdminControl.controllers;

import mx.ipn.cic.biblioteca.AdminControl.model.MonthlyConsultation;
import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;
import mx.ipn.cic.biblioteca.AdminControl.services.MonthlyConsultationService;
import mx.ipn.cic.biblioteca.AdminControl.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/monthlyconsult")
public class MonthlyConsultationController {

    @Autowired
    private MonthlyConsultationService consultationService;
    @Autowired
    private PatientService userService;

    @GetMapping(path = "")
    public String redirectToAll() {
        System.out.println("Redireccionamiento corrrecto a Monthly");
        return "redirect:/login";
    }


    //mapea la vista de la primera consulta mensual
    @GetMapping(path = "/newMonthlyConsult")
    public ModelAndView newConsultationForm(@RequestParam(name = "id") Integer id) {
        System.out.println(id);
        PatientModel patientModel = this.userService.findById(id);
        ModelAndView mav = new ModelAndView("addMonthlyConsultation", "monthlyConsultationModel", new MonthlyConsultation());
        List<MonthlyConsultation> monthly= this.consultationService.findByPatientId(patientModel);
        mav.addObject("paciente", patientModel);
        mav.addObject("monthly", monthly);
        return mav;
    }
    //post del registro
    @PostMapping(path = "/register/")
    public String register(
				    	   @RequestParam(name = "treatmentCycleNum") String treatmentCycleNum,
				    	   @RequestParam(name = "dateOfRealization") String dateOfRealization,
                           @RequestParam(name = "albumin") String albumin,
                           @RequestParam(name = "serumCalcium") String serumCalcium,
                           @RequestParam(name = "lacticDehydrogenase") String lacticDehydrogenase,
                           @RequestParam(name = "hemoglobin") String hemoglobin,
                           @RequestParam(name = "hematocrit") String hematocrit,
                           @RequestParam(name = "leukocytes") String leukocytes,
                           @RequestParam(name = "lymphocytes") String lymphocytes,
                           @RequestParam(name = "neutrophils") String neutrophils,
                           @RequestParam(name = "platelets") String platelets,
                           @RequestParam(name = "igG") String igG,
                           @RequestParam(name = "igA") String igA,
                           @RequestParam(name = "igM") String igM,
                           @RequestParam(name = "lightChainsKappa") String lightChainsKappa,
                           @RequestParam(name = "lightChainsLambda") String lightChainsLambda,
                           @RequestParam(name = "toxHemtoRedSerie") String toxHemtoRedSerie,
                           @RequestParam(name = "toxHemtoNeutrophils") String toxHemtoNeutrophils,
                           @RequestParam(name = "toxHemtoPlatelets") String toxHemtoPlatelets,
                           @RequestParam(name = "toxHepatics") String toxHepatics,
                           @RequestParam(name = "toxRenal") String toxRenal,
                           @RequestParam(name = "toxGastroNausea") String toxGastroNausea,
                           @RequestParam(name = "toxGastroDiarrhea") String toxGastroDiarrhea,
                           @RequestParam(name = "toxNeuroatiaPerif") String toxNeuroatiaPerif,
                           @RequestParam(name = "toxInfectious") String toxInfectious,
                           @RequestParam(name = "infectionSite") String infectionSite,
                           @RequestParam(name = "infusionMedReaction") String infusionMedReaction,
                           @RequestParam(name ="adverseReaction") String adverseReaction,
                           @RequestParam(name = "idMonthlyConsultation", required = false) Integer idMonthlyConsultation,
                           @RequestParam(name = "idpatient") Integer idpatient) {

        // Proceso de registro

        if (idpatient != 0) {
            //Buscamos al paciente dentro de la BD
            PatientModel userFound = this.userService.findById(idpatient);
            if (userFound != null) {

                MonthlyConsultation consultation = new MonthlyConsultation(
                		idMonthlyConsultation,
                		userFound,
                		treatmentCycleNum,
                		dateOfRealization,
                		albumin,
                		serumCalcium,
                		lacticDehydrogenase,
                		hemoglobin,
                		hematocrit,
                		leukocytes,
                		lymphocytes,
                		neutrophils,
                		platelets,
                		igG,
                		igA,
                		igM,
                		lightChainsKappa,
                		lightChainsLambda,
                		toxHemtoRedSerie,
                		toxHemtoNeutrophils,
                		toxHemtoPlatelets,
                		toxHepatics,
                		toxRenal,
                		toxGastroNausea,
                		toxGastroDiarrhea,
                		toxNeuroatiaPerif,
                		toxInfectious,
                		infectionSite,
                		infusionMedReaction,
                		adverseReaction
                		);
                this.consultationService.register(consultation);
            } else {
                return "redirect:/doctor/allPatients";
            }
        }
        return "redirect:/doctor/allPatients";
    }

    //el dr puede editar consultas
    //No puede pero no afecta tenerlo
    @GetMapping(path = "/edit/{idMonthlyConsultation}")
    public ModelAndView edit(@PathVariable("idMonthlyConsultation") Integer identificador) {
        MonthlyConsultation userFound = this.consultationService.findById(identificador);
        ModelAndView mav = new ModelAndView("editMonthlyConsultation", "monthlyConsultationModel", userFound);
        return mav;
    }

    //el dr puede borrar consultas? dejo el metodo
    //No puede pero no afecta tenerlo
    @GetMapping(path = "/delete/{idMonthlyConsultation}")
    public String delete(@PathVariable("idMonthlyConsultation") Integer idToDelete) {

        this.consultationService.delete(idToDelete);

        return "redirect:/patient/all";

    }

}