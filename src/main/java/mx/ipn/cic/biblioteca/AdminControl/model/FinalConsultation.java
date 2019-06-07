package mx.ipn.cic.biblioteca.AdminControl.model;

import javax.persistence.*;

@Entity
@Table(name = "ConsultaFinal")
public class FinalConsultation {

    // Propiedades privadas
    @Id
    @Column(name = "idpaciente")
    private Integer idPatient;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idpaciente")
    private PatientModel patientModel;

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

    @Column(name = "Linfocitos")
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

    @Column(name = "celPlasmaticEnMedulaOsea")
    private String celPlasmaticEnMedulaOsea;

    @Column(name = "electroForesisDeProteinasSuero")
    private String electroForesisDeProteinasSuero;

    @Column(name = "electroForesisDeProteinasOrina")
    private String electroForesisDeProteinasOrina;

    @Column(name = "inmFijacionTipoIg")
    private String inmFijacionTipoIg;

    @Column(name = "inmFijacionTipoCll")
    private String inmFijacionTipoCll;

    @Column(name = "enfermedadMinimaResidual")
    private String enfermedadMinimaResidual;

    @Column(name = "repuestaATratamiento")
    private String repuestaATratamiento;

    @Column(name = "comentariosExtrax")
    private String comentariosExtrax;

	//Nuevas variables 29 del abril
    @Column(name ="fechaDeTrasplante")
    private String dateOfTransplant;
    
    @Column(name ="numCD34Infundidas")
    private String numberOfCD34Infused;
    
    @Column(name ="fechaInjertoMieloide")
    private String myeloidGraftDate;
    
    @Column(name ="fechaInjertoPlaquetario")
    private String datePlateletGraft;
    
    //Toxicidades
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

    @Column(name = "infusionMedReaction")
    private  String infusionMedReaction;
    // Constructores
    public FinalConsultation() {
        super();
        // TODO Auto-generated constructor stub
    }
    
//	public FinalConsultation(Integer idPatient, PatientModel patientModel, String dateOfRealization, String albumin,
//			String serumCalcium, String lacticDehydrogenase, String hemoglobin, String hematocrit, String leukocytes,
//			String lymphocytes, String neutrophils, String platelets, String igG, String igA, String igM,
//			String lightChainsKappa, String lightChainsLambda, String celPlasmaticEnMedulaOsea,
//			String electroForesisDeProteinasSuero, String electroForesisDeProteinasOrina, String inmFijacionTipoIg,
//			String inmFijacionTipoCll, String enfermedadMinimaResidual, String repuestaATratamiento,
//			String comentariosExtrax, String dateOfTransplant, String numberOfCD34Infused, String myeloidGraftDate,
//			String datePlateletGraft, String toxicities) {
//		super();
//		this.idPatient = idPatient;
//		this.patientModel = patientModel;
//		this.dateOfRealization = dateOfRealization;
//		this.albumin = albumin;
//		this.serumCalcium = serumCalcium;
//		this.lacticDehydrogenase = lacticDehydrogenase;
//		this.hemoglobin = hemoglobin;
//		this.hematocrit = hematocrit;
//		this.leukocytes = leukocytes;
//		this.lymphocytes = lymphocytes;
//		this.neutrophils = neutrophils;
//		this.platelets = platelets;
//		this.igG = igG;
//		this.igA = igA;
//		this.igM = igM;
//		this.lightChainsKappa = lightChainsKappa;
//		this.lightChainsLambda = lightChainsLambda;
//		this.celPlasmaticEnMedulaOsea = celPlasmaticEnMedulaOsea;
//		this.electroForesisDeProteinasSuero = electroForesisDeProteinasSuero;
//		this.electroForesisDeProteinasOrina = electroForesisDeProteinasOrina;
//		this.inmFijacionTipoIg = inmFijacionTipoIg;
//		this.inmFijacionTipoCll = inmFijacionTipoCll;
//		this.enfermedadMinimaResidual = enfermedadMinimaResidual;
//		this.repuestaATratamiento = repuestaATratamiento;
//		this.comentariosExtrax = comentariosExtrax;
//		this.dateOfTransplant = dateOfTransplant;
//		this.numberOfCD34Infused = numberOfCD34Infused;
//		this.myeloidGraftDate = myeloidGraftDate;
//		this.datePlateletGraft = datePlateletGraft;
//		this.toxicities = toxicities;
//	}

    
    public FinalConsultation(Integer idPatient, PatientModel patientModel, String dateOfRealization, String albumin,
                             String serumCalcium, String lacticDehydrogenase, String hemoglobin, String hematocrit, String leukocytes,
                             String lymphocytes, String neutrophils, String platelets, String igG, String igA, String igM,
                             String lightChainsKappa, String lightChainsLambda, String celPlasmaticEnMedulaOsea,
                             String electroForesisDeProteinasSuero, String electroForesisDeProteinasOrina, String inmFijacionTipoIg,
                             String inmFijacionTipoCll, String enfermedadMinimaResidual, String repuestaATratamiento,
                             String comentariosExtrax) {
        super();
        this.idPatient = idPatient;
        this.patientModel = patientModel;
        this.dateOfRealization = dateOfRealization;
        this.albumin = albumin;
        this.serumCalcium = serumCalcium;
        this.lacticDehydrogenase = lacticDehydrogenase;
        this.hemoglobin = hemoglobin;
        this.hematocrit = hematocrit;
        this.leukocytes = leukocytes;
        this.lymphocytes = lymphocytes;
        this.neutrophils = neutrophils;
        this.platelets = platelets;
        this.igG = igG;
        this.igA = igA;
        this.igM = igM;
        this.lightChainsKappa = lightChainsKappa;
        this.lightChainsLambda = lightChainsLambda;
        this.celPlasmaticEnMedulaOsea = celPlasmaticEnMedulaOsea;
        this.electroForesisDeProteinasSuero = electroForesisDeProteinasSuero;
        this.electroForesisDeProteinasOrina = electroForesisDeProteinasOrina;
        this.inmFijacionTipoIg = inmFijacionTipoIg;
        this.inmFijacionTipoCll = inmFijacionTipoCll;
        this.enfermedadMinimaResidual = enfermedadMinimaResidual;
        this.repuestaATratamiento = repuestaATratamiento;
        this.comentariosExtrax = comentariosExtrax;
    }
    
    

    
    public FinalConsultation(Integer idPatient, PatientModel patientModel, String dateOfRealization, String albumin,
			String serumCalcium, String lacticDehydrogenase, String hemoglobin, String hematocrit, String leukocytes,
			String lymphocytes, String neutrophils, String platelets, String igG, String igA, String igM,
			String lightChainsKappa, String lightChainsLambda, String celPlasmaticEnMedulaOsea,
			String electroForesisDeProteinasSuero, String electroForesisDeProteinasOrina, String inmFijacionTipoIg,
			String inmFijacionTipoCll, String enfermedadMinimaResidual, String repuestaATratamiento,
			String comentariosExtrax, String dateOfTransplant, String numberOfCD34Infused, String myeloidGraftDate,
			String datePlateletGraft, String toxHemtoRedSerie, String toxHemtoNeutrophils, String toxHemtoPlatelets,
			String toxHepatics, String toxRenal, String toxGastroNausea, String toxGastroDiarrhea,
			String toxNeuroatiaPerif, String toxInfectious, String infectionSite, String infusionMedReaction) {
		super();
		this.idPatient = idPatient;
		this.patientModel = patientModel;
		this.dateOfRealization = dateOfRealization;
		this.albumin = albumin;
		this.serumCalcium = serumCalcium;
		this.lacticDehydrogenase = lacticDehydrogenase;
		this.hemoglobin = hemoglobin;
		this.hematocrit = hematocrit;
		this.leukocytes = leukocytes;
		this.lymphocytes = lymphocytes;
		this.neutrophils = neutrophils;
		this.platelets = platelets;
		this.igG = igG;
		this.igA = igA;
		this.igM = igM;
		this.lightChainsKappa = lightChainsKappa;
		this.lightChainsLambda = lightChainsLambda;
		this.celPlasmaticEnMedulaOsea = celPlasmaticEnMedulaOsea;
		this.electroForesisDeProteinasSuero = electroForesisDeProteinasSuero;
		this.electroForesisDeProteinasOrina = electroForesisDeProteinasOrina;
		this.inmFijacionTipoIg = inmFijacionTipoIg;
		this.inmFijacionTipoCll = inmFijacionTipoCll;
		this.enfermedadMinimaResidual = enfermedadMinimaResidual;
		this.repuestaATratamiento = repuestaATratamiento;
		this.comentariosExtrax = comentariosExtrax;
		//nuevas variables
		this.dateOfTransplant = dateOfTransplant;
		this.numberOfCD34Infused = numberOfCD34Infused;
		this.myeloidGraftDate = myeloidGraftDate;
		this.datePlateletGraft = datePlateletGraft;
		this.toxHemtoRedSerie = toxHemtoRedSerie;
		this.toxHemtoNeutrophils = toxHemtoNeutrophils;
		this.toxHemtoPlatelets = toxHemtoPlatelets;
		this.toxHepatics = toxHepatics;
		this.toxRenal = toxRenal;
		this.toxGastroNausea = toxGastroNausea;
		this.toxGastroDiarrhea = toxGastroDiarrhea;
		this.toxNeuroatiaPerif = toxNeuroatiaPerif;
		this.toxInfectious = toxInfectious;
		this.infectionSite = infectionSite;
		this.infusionMedReaction = infusionMedReaction;
	}

	// Métodos de acceso


    public String getInfusionMedReaction() {
        return infusionMedReaction;
    }

    public void setInfusionMedReaction(String infusionMedReaction) {
        this.infusionMedReaction = infusionMedReaction;
    }

    public String getInfectionSite() {
        return infectionSite;
    }

    public void setInfectionSite(String infectionSite) {
        this.infectionSite = infectionSite;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

	public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
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

    public String getCelPlasmaticEnMedulaOsea() {
        return celPlasmaticEnMedulaOsea;
    }

    public void setCelPlasmaticEnMedulaOsea(String celPlasmaticEnMedulaOsea) {
        this.celPlasmaticEnMedulaOsea = celPlasmaticEnMedulaOsea;
    }

    public String getElectroForesisDeProteinasSuero() {
        return electroForesisDeProteinasSuero;
    }

    public void setElectroForesisDeProteinasSuero(String electroForesisDeProteinasSuero) {
        this.electroForesisDeProteinasSuero = electroForesisDeProteinasSuero;
    }

    public String getElectroForesisDeProteinasOrina() {
        return electroForesisDeProteinasOrina;
    }

    public void setElectroForesisDeProteinasOrina(String electroForesisDeProteinasOrina) {
        this.electroForesisDeProteinasOrina = electroForesisDeProteinasOrina;
    }

    public String getInmFijacionTipoIg() {
        return inmFijacionTipoIg;
    }

    public void setInmFijacionTipoIg(String inmFijacionTipoIg) {
        this.inmFijacionTipoIg = inmFijacionTipoIg;
    }

    public String getInmFijacionTipoCll() {
        return inmFijacionTipoCll;
    }

    public void setInmFijacionTipoCll(String inmFijacionTipoCll) {
        this.inmFijacionTipoCll = inmFijacionTipoCll;
    }

    public String getEnfermedadMinimaResidual() {
        return enfermedadMinimaResidual;
    }

    public void setEnfermedadMinimaResidual(String enfermedadMinimaResidual) {
        this.enfermedadMinimaResidual = enfermedadMinimaResidual;
    }

    public String getRepuestaATratamiento() {
        return repuestaATratamiento;
    }

    public void setRepuestaATratamiento(String repuestaATratamiento) {
        this.repuestaATratamiento = repuestaATratamiento;
    }

    public String getComentariosExtrax() {
        return comentariosExtrax;
    }

    public void setComentariosExtrax(String comentariosExtrax) {
        this.comentariosExtrax = comentariosExtrax;
    }

//	public PatientModel getPatientModel() {
//		return patientModel;
//	}
//
//	public void setPatientModel(PatientModel patientModel) {
//		this.patientModel = patientModel;
//	}

    //NUEVAS
	public String getDateOfTransplant() {
		return dateOfTransplant;
	}

	public void setDateOfTransplant(String dateOfTransplant) {
		this.dateOfTransplant = dateOfTransplant;
	}

	public String getNumberOfCD34Infused() {
		return numberOfCD34Infused;
	}

	public void setNumberOfCD34Infused(String numberOfCD34Infused) {
		this.numberOfCD34Infused = numberOfCD34Infused;
	}

	public String getMyeloidGraftDate() {
		return myeloidGraftDate;
	}

	public void setMyeloidGraftDate(String myeloidGraftDate) {
		this.myeloidGraftDate = myeloidGraftDate;
	}

	public String getDatePlateletGraft() {
		return datePlateletGraft;
	}

	public void setDatePlateletGraft(String datePlateletGraft) {
		this.datePlateletGraft = datePlateletGraft;
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

}