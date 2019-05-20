package mx.ipn.cic.biblioteca.AdminControl.model;

import javax.persistence.*;

@Entity
@Table(name = "ConsultaMensual")
public class MonthlyConsultation {

    // Propiedades privadas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConsultaMensual")
    private Integer idMonthlyConsultation;

    @Column(name = "numCicloTratamiento")
    private String treatmentCycleNum;

    //FKey 'fk_idpaciente'
    //@Column(name = "idpaciente")
    //private Integer idpatient;

    @ManyToOne//(mappedBy = "n",cascade = CascadeType.ALL)
    @JoinColumn(name="idpaciente")
    private PatientModel idpatient;
    //
    // private PatientModel idpatient;
    //private PatientModel patientModel;
    //@Column(name = "idpaciente")
    //private Integer idpatient;

    @Column(name = "fechaRealizacion")
    private String dateOfRealization;

    @Column(name = "albumina")
    private String albumin;

    @Column(name = "calcioSerico")
    private String serumCalcium;

    //esta en la base pero no en las pantallas
    @Column(name = "deshidrogenasaLactica")
    private String lacticDehydrogenase;

    @Column(name = "hemoglobina")
    private String hemoglobin;

    @Column(name = "hematocrito")
    private String hematocrit;

    //estaba en la pantalla pero no en la base
    @Column(name = "leucocitos")
    private String leukocytes;

    @Column(name = "linfocitos")
    private String lymphocytes;

    @Column(name = "neutrofilos")
    private String neutrophils;

    @Column(name = "plaquetas")
    private String platelets;

    @Column(name = "igG")
    private String igG;

    @Column(name = "igA")
    private String igA;

    @Column(name = "igM")
    private String igM;

    @Column(name = "cadenasLigerasKappa")
    private String lightChainsKappa;

    @Column(name = "cadenasLigerasLambda")
    private String lightChainsLambda;

    @Column(name = "toxHemtoSerieRoja")
    private String toxHemtoRedSerie;

    @Column(name = "toxHemtoNeutrofilos")
    private String toxHemtoNeutrophils;

    @Column(name = "toxHemtoPlaquetas")
    private String toxHemtoPlatelets;

    @Column(name = "toxHepatics")
    private String toxHepatics;

    @Column(name = "toxRenal")
    private String toxRenal;

    @Column(name = "toxGastroNausea")
    private String toxGastroNausea;

    @Column(name = "toxGastoDiarrea")
    private String toxGastroDiarrhea;

    @Column(name = "toxNeuroatiaPerif")
    private String toxNeuroatiaPerif;

    @Column(name = "toxInfecciosa")
    private String toxInfectious;

    @Column(name = "sitioInfeccion")
    private String infectionSite;

    @Column(name = "reacInfuciondeMedic")
    private String infusionMedReaction;

    @Column(name = "reccionAdversa")
    private String adverseReaction;

    // Constructores

    public MonthlyConsultation() {
        super();
        // TODO Auto-generated constructor stub
    }
    //Con base en testing

    //public MonthlyConsultation(Integer idMonthlyConsultation, Integer treatmentCycleNum, Integer idpatient,
    //                           String dateOfRealization, Float albumin, Integer serumCalcium, Integer lacticDehydrogenase,
    //                           Integer hemoglobin, Integer hematocrit,Integer leukocytes, Integer lymphocytes, Integer neutrophils,
    //                           Integer platelets, Integer igG, Integer igA, Integer igM, Integer lightChainsKappa,
    //                           Integer lightChainsLambda, Integer toxHemtoRedSerie, Integer toxHemtoNeutrophils,
    //                           Integer toxHemtoPlatelets, Integer toxHepatics, Integer toxRenal, Integer toxGastroNausea,
    //                           Integer toxGastroDiarrhea, Integer toxNeuroatiaPerif, Integer toxInfectious, String infectionSite,
    //                           Integer infusionMedReaction, String adverseReaction)

    //Acomode los campos
    public MonthlyConsultation(Integer idMonthlyConsultation/*,Integer idpatient,*/ , PatientModel idpatient, String treatmentCycleNum, String dateOfRealization,
                               String albumin, String serumCalcium,
                               String lacticDehydrogenase, String hemoglobin, String hematocrit, String leukocytes, String lymphocytes,
                               String neutrophils,
                               String platelets, String igG, String igA, String igM, String lightChainsKappa, String lightChainsLambda,
                               String toxHemtoRedSerie, String toxHemtoNeutrophils,
                               String toxHemtoPlatelets, String toxHepatics, String toxRenal, String toxGastroNausea,
                               String toxGastroDiarrhea, String toxNeuroatiaPerif, String toxInfectious,
                               String infectionSite, String infusionMedReaction, String adverseReaction){

        super();
        this.idMonthlyConsultation=idMonthlyConsultation;
        //this.idpatient=idpatient;
        this.idpatient = idpatient;
        this.treatmentCycleNum=treatmentCycleNum;
        this.dateOfRealization=dateOfRealization;
        this.leukocytes=leukocytes;
        this.serumCalcium=serumCalcium;
        this.albumin=albumin;
        this.neutrophils=neutrophils;
        this.lacticDehydrogenase=lacticDehydrogenase;
        this.hematocrit=hematocrit;
        this.lymphocytes=lymphocytes;
        this.hemoglobin=hemoglobin;
        this.platelets=platelets;
        this.lightChainsKappa=lightChainsKappa;
        this.lightChainsLambda=lightChainsLambda;
        this.igM=igM;
        this.igG=igG;
        this.igA=igA;
        this.toxHemtoRedSerie=toxHemtoRedSerie;
        this.toxHemtoNeutrophils=toxHemtoNeutrophils;
        this.toxHemtoPlatelets=toxHemtoPlatelets;
        this.toxHepatics=toxHepatics;
        this.toxRenal=toxRenal;
        this.toxInfectious=toxInfectious;
        this.toxNeuroatiaPerif=toxNeuroatiaPerif;
        this.toxGastroNausea=toxGastroNausea;
        this.toxGastroDiarrhea=toxGastroDiarrhea;
        this.infectionSite=infectionSite;
        this.infusionMedReaction=infusionMedReaction;
        this.adverseReaction=adverseReaction;
    }


    // Métodos de acceso


    public Integer getIdMonthlyConsultation() {
        return idMonthlyConsultation;
    }

    public void setIdMonthlyConsultation(Integer idMonthlyConsultation) {
        this.idMonthlyConsultation = idMonthlyConsultation;
    }

    public String getTreatmentCycleNum() {
        return treatmentCycleNum;
    }

    public void setTreatmentCycleNum(String treatmentCycleNum) {
        this.treatmentCycleNum = treatmentCycleNum;
    }

    public PatientModel getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(PatientModel idpatient) {
        this.idpatient = idpatient;
    }

    public String getDateOfRealization() {
        return dateOfRealization;
    }

    public void setDateOfRealization(String dateOfRealization) {
        this.dateOfRealization = dateOfRealization;
    }

    public String getAlbumin() {
        return albumin;
    }

    public void setAlbumin(String albumin) {
        this.albumin = albumin;
    }

    public String getSerumCalcium() {
        return serumCalcium;
    }

    public void setSerumCalcium(String serumCalcium) {
        this.serumCalcium = serumCalcium;
    }

    public String getLacticDehydrogenase() {
        return lacticDehydrogenase;
    }

    public void setLacticDehydrogenase(String lacticDehydrogenase) {
        this.lacticDehydrogenase = lacticDehydrogenase;
    }

    public String getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(String hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public String getHematocrit() {
        return hematocrit;
    }

    public void setHematocrit(String hematocrit) {
        this.hematocrit = hematocrit;
    }

    public String getLeukocytes() {
        return leukocytes;
    }

    public void setLeukocytes(String leukocytes) {
        this.leukocytes = leukocytes;
    }

    public String getLymphocytes() {
        return lymphocytes;
    }

    public void setLymphocytes(String lymphocytes) {
        this.lymphocytes = lymphocytes;
    }

    public String getNeutrophils() {
        return neutrophils;
    }

    public void setNeutrophils(String neutrophils) {
        this.neutrophils = neutrophils;
    }

    public String getPlatelets() {
        return platelets;
    }

    public void setPlatelets(String platelets) {
        this.platelets = platelets;
    }

    public String getIgG() {
        return igG;
    }

    public void setIgG(String igG) {
        this.igG = igG;
    }

    public String getIgA() {
        return igA;
    }

    public void setIgA(String igA) {
        this.igA = igA;
    }

    public String getIgM() {
        return igM;
    }

    public void setIgM(String igM) {
        this.igM = igM;
    }

    public String getLightChainsKappa() {
        return lightChainsKappa;
    }

    public void setLightChainsKappa(String lightChainsKappa) {
        this.lightChainsKappa = lightChainsKappa;
    }

    public String getLightChainsLambda() {
        return lightChainsLambda;
    }

    public void setLightChainsLambda(String lightChainsLambda) {
        this.lightChainsLambda = lightChainsLambda;
    }

    public String getToxHemtoRedSerie() {
        return toxHemtoRedSerie;
    }

    public void setToxHemtoRedSerie(String toxHemtoRedSerie) {
        this.toxHemtoRedSerie = toxHemtoRedSerie;
    }

    public String getToxHemtoNeutrophils() {
        return toxHemtoNeutrophils;
    }

    public void setToxHemtoNeutrophils(String toxHemtoNeutrophils) {
        this.toxHemtoNeutrophils = toxHemtoNeutrophils;
    }

    public String getToxHemtoPlatelets() {
        return toxHemtoPlatelets;
    }

    public void setToxHemtoPlatelets(String toxHemtoPlatelets) {
        this.toxHemtoPlatelets = toxHemtoPlatelets;
    }

    public String getToxHepatics() {
        return toxHepatics;
    }

    public void setToxHepatics(String toxHepatics) {
        this.toxHepatics = toxHepatics;
    }

    public String getToxRenal() {
        return toxRenal;
    }

    public void setToxRenal(String toxRenal) {
        this.toxRenal = toxRenal;
    }

    public String getToxGastroNausea() {
        return toxGastroNausea;
    }

    public void setToxGastroNausea(String toxGastroNausea) {
        this.toxGastroNausea = toxGastroNausea;
    }

    public String getToxGastroDiarrhea() {
        return toxGastroDiarrhea;
    }

    public void setToxGastroDiarrhea(String toxGastroDiarrhea) {
        this.toxGastroDiarrhea = toxGastroDiarrhea;
    }

    public String getToxNeuroatiaPerif() {
        return toxNeuroatiaPerif;
    }

    public void setToxNeuroatiaPerif(String toxNeuroatiaPerif) {
        this.toxNeuroatiaPerif = toxNeuroatiaPerif;
    }

    public String getToxInfectious() {
        return toxInfectious;
    }

    public void setToxInfectious(String toxInfectious) {
        this.toxInfectious = toxInfectious;
    }

    public String getInfectionSite() {
        return infectionSite;
    }

    public void setInfectionSite(String infectionSite) {
        this.infectionSite = infectionSite;
    }

    public String getInfusionMedReaction() {
        return infusionMedReaction;
    }

    public void setInfusionMedReaction(String infusionMedReaction) {
        this.infusionMedReaction = infusionMedReaction;
    }

    public String getAdverseReaction() {
        return adverseReaction;
    }

    public void setAdverseReaction(String adverseReaction) {
        this.adverseReaction = adverseReaction;
    }
}