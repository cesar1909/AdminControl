//package mx.ipn.cic.biblioteca.AdminControl.model;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;
//@Entity
//@Table(name = "ConsultaInicial")
//public class InitialConsultation {
//
//	//Primera pantalla
//	
//	@Id
//	@Column(name = "idpaciente")
//	private Integer idPatient;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "idpaciente")
//	private PatientModel patientModel;
//	
//	@Column(name = "fechaRealizacion")
//	private String dateRealization;
//
//	@Column(name = "creatininaSerica")
//	private float serumCreatinine;
//
//	@Column(name = "depCreatinina")
//	private float depCreatinine;
//
//	@Column(name = "ecog")
//	private float ecog;
//
//	@Column(name = "lesionesOseas")
//	private Integer boneInjuries;
//
//	@Column(name = "numlesionesOseas")
//	private Integer boneInjuriesNumber;
//
//	@Column(name = "plasmocitomasExtramedulares")
//	private Integer extramedullaryPlasmacytomas;
//
//	@Column(name = "numPlasmocitomas")
//	private Integer plasmacytomasNumber;
//
//	@Column(name = "activa")
//	private Integer active;
//
//	@Column(name = "celPlasmaticEnMedulaOsea")
//	private Integer plasmaCellsInBoneMarrow;
//
//	@Column(name = "celPlasmaticEnSangrePerif")
//	private Integer plasmaCellsInBloodPerif;
//
//	@Column(name = "igG")
//
//	private Integer igG;
//
//	@Column(name = "igA")
//	private Integer igA;
//
//	@Column(name = "igM")
//	private Integer igM;
//
//	//Fin primera pantalla
//
//	//Pantalla 2
//	@Column(name = "inmFijacionTipoIg")
//	private String inmIgTypeFixation;
//
//	@Column(name = "inmFijacionTipoCll")
//	private String inmCllTypeFixation;
//
//	@Column(name = "cadenasLigerasKappa")
//	private Integer lightChainsKappa;
//
//	@Column(name = "cadenasLigerasLambda")
//	private Integer lightChainsLambda;
//
//	@Column(name = "electroForesisDeProteinasSuero")
//	private Integer electroForesisDeProteinasSuero;
//
//	@Column(name = "electroForesisDeProteinasOrina")
//	private Integer electroForesisDeProteinasOrina;
//
//	@Column(name = "proteinuriaDeBenceJones")
//	private Integer benceJonesProteinuria;
//
//	@Column(name = "amiloidosisDistemica")
//	private Integer dystemicAmyloidosis;
//
//	@Column(name = "b2Microglobulina")
//	private float b2Microglobulin;
//
//	@Column(name = "albumina")
//	private float albumin;
//
//	@Column(name = "calcioSerico")
//	private Integer serumCalcium;
//	//Fin segunda pantalla
//
//	// Pantalla 3
//	@Column(name = "deshidrogenasaLactica")
//	private Integer lacticDehydrogenase;
//
//	@Column(name = "hemoglobina")
//	private Integer hemoglobin;
//
//	@Column(name = "hematocrito")
//	private Integer hematocrit;
//
//	@Column(name = "Linfocitos")
//	private Integer lymphocytes;
//
//	@Column(name = "leucocitos")
//	private Integer leukocytes;
//
//	@Column(name = "neutrofilos")
//	private Integer neutrophils;
//	
//	@Column(name = "plaquetas")
//	private Integer platelets;
//
//	@Column(name = "delecion17P")
//	private Integer deletionSeventeenP;
//
//	@Column(name = "translocacion4a14")
//	private Integer translocationFourToFourteen;
//
//	@Column(name = "translocacion14a16")
//	private Integer translocationFourteenToSixteen;
//	
//	@Column(name = "fechaInicioTratamiento")
//	private String startDateOfTreatment;
//	
//	public InitialConsultation() {
//		super();
//	}
//
//	public InitialConsultation(int idPatient, PatientModel patientModel, String dateRealization, float serumCreatinine,
//			float depCreatinine, float ecog, int boneInjuries, int boneInjuriesNumber, int extramedullaryPlasmacytomas,
//			int plasmacytomasNumber, int active, int plasmaCellsInBoneMarrow, int plasmaCellsInBloodPerif, int igG,
//			int igA, int igM, String inmIgTypeFixation, String inmCllTypeFixation, int lightChainsKappa,
//			int lightChainsLambda, int electroForesisDeProteinasSuero, int electroForesisDeProteinasOrina,
//			int benceJonesProteinuria, int dystemicAmyloidosis, float b2Microglobulin, float albumin, int serumCalcium,
//			int lacticDehydrogenase, int hemoglobin, int hematocrit, int lymphocytes, int leukocytes, int neutrophils,
//			int platelets, int deletionSeventeenP, int translocationFourToFourteen, int translocationFourteenToSixteen,
//			String startDateOfTreatment) {
//		super();
//		this.idPatient = idPatient;
//		this.patientModel = patientModel;
//		this.dateRealization = dateRealization;
//		this.serumCreatinine = serumCreatinine;
//		this.depCreatinine = depCreatinine;
//		this.ecog = ecog;
//		this.boneInjuries = boneInjuries;
//		this.boneInjuriesNumber = boneInjuriesNumber;
//		this.extramedullaryPlasmacytomas = extramedullaryPlasmacytomas;
//		this.plasmacytomasNumber = plasmacytomasNumber;
//		this.active = active;
//		this.plasmaCellsInBoneMarrow = plasmaCellsInBoneMarrow;
//		this.plasmaCellsInBloodPerif = plasmaCellsInBloodPerif;
//		this.igG = igG;
//		this.igA = igA;
//		this.igM = igM;
//		this.inmIgTypeFixation = inmIgTypeFixation;
//		this.inmCllTypeFixation = inmCllTypeFixation;
//		this.lightChainsKappa = lightChainsKappa;
//		this.lightChainsLambda = lightChainsLambda;
//		this.electroForesisDeProteinasSuero = electroForesisDeProteinasSuero;
//		this.electroForesisDeProteinasOrina = electroForesisDeProteinasOrina;
//		this.benceJonesProteinuria = benceJonesProteinuria;
//		this.dystemicAmyloidosis = dystemicAmyloidosis;
//		this.b2Microglobulin = b2Microglobulin;
//		this.albumin = albumin;
//		this.serumCalcium = serumCalcium;
//		this.lacticDehydrogenase = lacticDehydrogenase;
//		this.hemoglobin = hemoglobin;
//		this.hematocrit = hematocrit;
//		this.lymphocytes = lymphocytes;
//		this.leukocytes = leukocytes;
//		this.neutrophils = neutrophils;
//		this.platelets = platelets;
//		this.deletionSeventeenP = deletionSeventeenP;
//		this.translocationFourToFourteen = translocationFourToFourteen;
//		this.translocationFourteenToSixteen = translocationFourteenToSixteen;
//		this.startDateOfTreatment = startDateOfTreatment;
//	}
///*
//	public InitialConsultation(PatientModel patientModel, String dateRealization, float serumCreatinine,
//			float depCreatinine, float ecog, int boneInjuries, int boneInjuriesNumber, int extramedullaryPlasmacytomas,
//			int plasmacytomasNumber, int active, int plasmaCellsInBoneMarrow, int plasmaCellsInBloodPerif, int igG,
//			int igA, int igM, String inmIgTypeFixation, String inmCllTypeFixation, int lightChainsKappa,
//			int lightChainsLambda, int electroForesisDeProteinasSuero, int electroForesisDeProteinasOrina,
//			int benceJonesProteinuria, int dystemicAmyloidosis, float b2Microglobulin, float albumin, int serumCalcium,
//			int lacticDehydrogenase, int hemoglobin, int hematocrit, int lymphocytes, int leukocytes, int neutrophils,
//			int platelets, int deletionSeventeenP, int translocationFourToFourteen, int translocationFourteenToSixteen,
//			String startDateOfTreatment) {
//		super();
//		this.patientModel = patientModel;
//		this.dateRealization = dateRealization;
//		this.serumCreatinine = serumCreatinine;
//		this.depCreatinine = depCreatinine;
//		this.ecog = ecog;
//		this.boneInjuries = boneInjuries;
//		this.boneInjuriesNumber = boneInjuriesNumber;
//		this.extramedullaryPlasmacytomas = extramedullaryPlasmacytomas;
//		this.plasmacytomasNumber = plasmacytomasNumber;
//		this.active = active;
//		this.plasmaCellsInBoneMarrow = plasmaCellsInBoneMarrow;
//		this.plasmaCellsInBloodPerif = plasmaCellsInBloodPerif;
//		this.igG = igG;
//		this.igA = igA;
//		this.igM = igM;
//		this.inmIgTypeFixation = inmIgTypeFixation;
//		this.inmCllTypeFixation = inmCllTypeFixation;
//		this.lightChainsKappa = lightChainsKappa;
//		this.lightChainsLambda = lightChainsLambda;
//		this.electroForesisDeProteinasSuero = electroForesisDeProteinasSuero;
//		this.electroForesisDeProteinasOrina = electroForesisDeProteinasOrina;
//		this.benceJonesProteinuria = benceJonesProteinuria;
//		this.dystemicAmyloidosis = dystemicAmyloidosis;
//		this.b2Microglobulin = b2Microglobulin;
//		this.albumin = albumin;
//		this.serumCalcium = serumCalcium;
//		this.lacticDehydrogenase = lacticDehydrogenase;
//		this.hemoglobin = hemoglobin;
//		this.hematocrit = hematocrit;
//		this.lymphocytes = lymphocytes;
//		this.leukocytes = leukocytes;
//		this.neutrophils = neutrophils;
//		this.platelets = platelets;
//		this.deletionSeventeenP = deletionSeventeenP;
//		this.translocationFourToFourteen = translocationFourToFourteen;
//		this.translocationFourteenToSixteen = translocationFourteenToSixteen;
//		this.startDateOfTreatment = startDateOfTreatment;
//	}
//*/
//	public int getIdPatient() {
//		return idPatient;
//	}
//
//	public void setIdPatient(int idPatient) {
//		this.idPatient = idPatient;
//	}
//
//	public PatientModel getPatientModel() {
//		return patientModel;
//	}
//
//	public void setPatientModel(PatientModel patientModel) {
//		this.patientModel = patientModel;
//	}
//
//	public String getDateRealization() {
//		return dateRealization;
//	}
//
//	public void setDateRealization(String dateRealization) {
//		this.dateRealization = dateRealization;
//	}
//
//	public float getSerumCreatinine() {
//		return serumCreatinine;
//	}
//
//	public void setSerumCreatinine(float serumCreatinine) {
//		this.serumCreatinine = serumCreatinine;
//	}
//
//	public float getDepCreatinine() {
//		return depCreatinine;
//	}
//
//	public void setDepCreatinine(float depCreatinine) {
//		this.depCreatinine = depCreatinine;
//	}
//
//	public float getEcog() {
//		return ecog;
//	}
//
//	public void setEcog(float ecog) {
//		this.ecog = ecog;
//	}
//
//	public int getBoneInjuries() {
//		return boneInjuries;
//	}
//
//	public void setBoneInjuries(int boneInjuries) {
//		this.boneInjuries = boneInjuries;
//	}
//
//	public int getBoneInjuriesNumber() {
//		return boneInjuriesNumber;
//	}
//
//	public void setBoneInjuriesNumber(int boneInjuriesNumber) {
//		this.boneInjuriesNumber = boneInjuriesNumber;
//	}
//
//	public int getExtramedullaryPlasmacytomas() {
//		return extramedullaryPlasmacytomas;
//	}
//
//	public void setExtramedullaryPlasmacytomas(int extramedullaryPlasmacytomas) {
//		this.extramedullaryPlasmacytomas = extramedullaryPlasmacytomas;
//	}
//
//	public int getPlasmacytomasNumber() {
//		return plasmacytomasNumber;
//	}
//
//	public void setPlasmacytomasNumber(int plasmacytomasNumber) {
//		this.plasmacytomasNumber = plasmacytomasNumber;
//	}
//
//	public int getActive() {
//		return active;
//	}
//
//	public void setActive(int active) {
//		this.active = active;
//	}
//
//	public int getPlasmaCellsInBoneMarrow() {
//		return plasmaCellsInBoneMarrow;
//	}
//
//	public void setPlasmaCellsInBoneMarrow(int plasmaCellsInBoneMarrow) {
//		this.plasmaCellsInBoneMarrow = plasmaCellsInBoneMarrow;
//	}
//
//	public int getPlasmaCellsInBloodPerif() {
//		return plasmaCellsInBloodPerif;
//	}
//
//	public void setPlasmaCellsInBloodPerif(int plasmaCellsInBloodPerif) {
//		this.plasmaCellsInBloodPerif = plasmaCellsInBloodPerif;
//	}
//
//	public int getIgG() {
//		return igG;
//	}
//
//	public void setIgG(int igG) {
//		this.igG = igG;
//	}
//
//	public int getIgA() {
//		return igA;
//	}
//
//	public void setIgA(int igA) {
//		this.igA = igA;
//	}
//
//	public int getIgM() {
//		return igM;
//	}
//
//	public void setIgM(int igM) {
//		this.igM = igM;
//	}
//
//	public String getInmIgTypeFixation() {
//		return inmIgTypeFixation;
//	}
//
//	public void setInmIgTypeFixation(String inmIgTypeFixation) {
//		this.inmIgTypeFixation = inmIgTypeFixation;
//	}
//
//	public String getInmCllTypeFixation() {
//		return inmCllTypeFixation;
//	}
//
//	public void setInmCllTypeFixation(String inmCllTypeFixation) {
//		this.inmCllTypeFixation = inmCllTypeFixation;
//	}
//
//	public int getLightChainsKappa() {
//		return lightChainsKappa;
//	}
//
//	public void setLightChainsKappa(int lightChainsKappa) {
//		this.lightChainsKappa = lightChainsKappa;
//	}
//
//	public int getLightChainsLambda() {
//		return lightChainsLambda;
//	}
//
//	public void setLightChainsLambda(int lightChainsLambda) {
//		this.lightChainsLambda = lightChainsLambda;
//	}
//
//	public int getElectroForesisDeProteinasSuero() {
//		return electroForesisDeProteinasSuero;
//	}
//
//	public void setElectroForesisDeProteinasSuero(int electroForesisDeProteinasSuero) {
//		this.electroForesisDeProteinasSuero = electroForesisDeProteinasSuero;
//	}
//
//	public int getElectroForesisDeProteinasOrina() {
//		return electroForesisDeProteinasOrina;
//	}
//
//	public void setElectroForesisDeProteinasOrina(int electroForesisDeProteinasOrina) {
//		this.electroForesisDeProteinasOrina = electroForesisDeProteinasOrina;
//	}
//
//	public int getBenceJonesProteinuria() {
//		return benceJonesProteinuria;
//	}
//
//	public void setBenceJonesProteinuria(int benceJonesProteinuria) {
//		this.benceJonesProteinuria = benceJonesProteinuria;
//	}
//
//	public int getDystemicAmyloidosis() {
//		return dystemicAmyloidosis;
//	}
//
//	public void setDystemicAmyloidosis(int dystemicAmyloidosis) {
//		this.dystemicAmyloidosis = dystemicAmyloidosis;
//	}
//
//	public float getB2Microglobulin() {
//		return b2Microglobulin;
//	}
//
//	public void setB2Microglobulin(float b2Microglobulin) {
//		this.b2Microglobulin = b2Microglobulin;
//	}
//
//	public float getAlbumin() {
//		return albumin;
//	}
//
//	public void setAlbumin(float albumin) {
//		this.albumin = albumin;
//	}
//
//	public int getSerumCalcium() {
//		return serumCalcium;
//	}
//
//	public void setSerumCalcium(int serumCalcium) {
//		this.serumCalcium = serumCalcium;
//	}
//
//	public int getLacticDehydrogenase() {
//		return lacticDehydrogenase;
//	}
//
//	public void setLacticDehydrogenase(int lacticDehydrogenase) {
//		this.lacticDehydrogenase = lacticDehydrogenase;
//	}
//
//	public int getHemoglobin() {
//		return hemoglobin;
//	}
//
//	public void setHemoglobin(int hemoglobin) {
//		this.hemoglobin = hemoglobin;
//	}
//
//	public int getHematocrit() {
//		return hematocrit;
//	}
//
//	public void setHematocrit(int hematocrit) {
//		this.hematocrit = hematocrit;
//	}
//
//	public int getLymphocytes() {
//		return lymphocytes;
//	}
//
//	public void setLymphocytes(int lymphocytes) {
//		this.lymphocytes = lymphocytes;
//	}
//
//	public int getLeukocytes() {
//		return leukocytes;
//	}
//
//	public void setLeukocytes(int leukocytes) {
//		this.leukocytes = leukocytes;
//	}
//
//	public int getNeutrophils() {
//		return neutrophils;
//	}
//
//	public void setNeutrophils(int neutrophils) {
//		this.neutrophils = neutrophils;
//	}
//
//	public int getPlatelets() {
//		return platelets;
//	}
//
//	public void setPlatelets(int platelets) {
//		this.platelets = platelets;
//	}
//
//	public int getDeletionSeventeenP() {
//		return deletionSeventeenP;
//	}
//
//	public void setDeletionSeventeenP(int deletionSeventeenP) {
//		this.deletionSeventeenP = deletionSeventeenP;
//	}
//
//	public int getTranslocationFourToFourteen() {
//		return translocationFourToFourteen;
//	}
//
//	public void setTranslocationFourToFourteen(int translocationFourToFourteen) {
//		this.translocationFourToFourteen = translocationFourToFourteen;
//	}
//
//	public int getTranslocationFourteenToSixteen() {
//		return translocationFourteenToSixteen;
//	}
//
//	public void setTranslocationFourteenToSixteen(int translocationFourteenToSixteen) {
//		this.translocationFourteenToSixteen = translocationFourteenToSixteen;
//	}
//
//	public String getStartDateOfTreatment() {
//		return startDateOfTreatment;
//	}
//
//	public void setStartDateOfTreatment(String startDateOfTreatment) {
//		this.startDateOfTreatment = startDateOfTreatment;
//	}
//
//
//
//}
