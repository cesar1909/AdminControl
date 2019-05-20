package mx.ipn.cic.biblioteca.AdminControl.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class PatientModel {
	
	// Propiedades privadas
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idpaciente")
	private Integer id;

	@Column(name = "nombre")
	private String name;

	@Column(name = "appat")
	private String lastnameP;

	@Column(name = "apmat")
	private String lastnameM;

	@Column(name = "fechanac")
	private String birthdate;

	@Column(name = "edad")
	private String age;

	@Column(name = "genero")
	private String gender;
	
	@Column(name = "talla")
	private String height;
	
	@Column(name = "peso")
	private String weight;
	
	@Column(name = "imc")
	private String bmi;
	
	@Column(name = "supcorporal")
	private String bodySup;
	
	@Column(name = "fechainiciotratamiento")
	private String startDateOfTreatment;

	@Column(name = "creatininaSerica")
	private String serumCreatinine;

	@Column(name = "depCreatinina")
	private String depCreatinine;

	@Column(name = "ecog")
	private String ecog;

	@Column(name = "lesionesOseas")
	private String boneInjuries;

	@Column(name = "numlesionesOseas")
	private String boneInjuriesNumber;

	@Column(name = "plasmocitomasExtramedulares")
	private String extramedullaryPlasmacytomas;

	@Column(name = "numPlasmocitomas")
	private String plasmacytomasNumber;

	@Column(name = "activa")
	private String active;

	@Column(name = "celPlasmaticEnMedulaOsea")
	private String plasmaCellsInBoneMarrow;

	@Column(name = "celPlasmaticEnSangrePerif")
	private String plasmaCellsInBloodPerif;

	@Column(name = "igG")

	private String igG;

	@Column(name = "igA")
	private String igA;

	@Column(name = "igM")
	private String igM;

	//Fin primera pantalla

	//Pantalla 2
	@Column(name = "inmFijacionTipoIg")
	private String inmIgTypeFixation;

	@Column(name = "inmFijacionTipoCll")
	private String inmCllTypeFixation;

	@Column(name = "cadenasLigerasKappa")
	private String lightChainsKappa;

	@Column(name = "cadenasLigerasLambda")
	private String lightChainsLambda;

	@Column(name = "electroForesisDeProteinasSuero")
	private String electroForesisDeProteinasSuero;

	@Column(name = "electroForesisDeProteinasOrina")
	private String electroForesisDeProteinasOrina;

	@Column(name = "proteinuriaDeBenceJones")
	private String benceJonesProteinuria;

	@Column(name = "amiloidosisDistemica")
	private String dystemicAmyloidosis;

	@Column(name = "b2Microglobulina")
	private String b2Microglobulin;

	@Column(name = "albumina")
	private String albumin;

	@Column(name = "calcioSerico")
	private String serumCalcium;
	//Fin segunda pantalla

	// Pantalla 3
	@Column(name = "deshidrogenasaLactica")
	private String lacticDehydrogenase;

	@Column(name = "hemoglobina")
	private String hemoglobin;

	@Column(name = "hematocrito")
	private String hematocrit;

	@Column(name = "Linfocitos")
	private String lymphocytes;

	@Column(name = "leucocitos")
	private String leukocytes;

	@Column(name = "neutrofilos")
	private String neutrophils;
	
	@Column(name = "plaquetas")
	private String platelets;

	@Column(name = "delecion17P")
	private String deletionSeventeenP;

	@Column(name = "translocacion4a14")
	private String translocationFourToFourteen;

	@Column(name = "translocacion14a16")
	private String translocationFourteenToSixteen;
	
  @ManyToOne(/*cascade = CascadeType.ALL*/)
  @JoinColumn(name="idmedico")
	private DoctorModel idDoctor;

public PatientModel() {
	super();
}

public PatientModel(Integer id, String name, String lastnameP, String lastnameM, String birthdate, String age,
					String gender, String height, String weight, String bmi, String bodySup, String startDateOfTreatment,
					String serumCreatinine, String depCreatinine, String ecog, String boneInjuries, String boneInjuriesNumber,
					String extramedullaryPlasmacytomas, String plasmacytomasNumber, String active,
					String plasmaCellsInBoneMarrow, String plasmaCellsInBloodPerif, String igG, String igA, String igM,
					String inmIgTypeFixation, String inmCllTypeFixation, String lightChainsKappa, String lightChainsLambda,
					String electroForesisDeProteinasSuero, String electroForesisDeProteinasOrina, String benceJonesProteinuria,
					String dystemicAmyloidosis, String b2Microglobulin, String albumin, String serumCalcium,
					String lacticDehydrogenase, String hemoglobin, String hematocrit, String lymphocytes, String leukocytes,
					String neutrophils, String platelets, String deletionSeventeenP, String translocationFourToFourteen,
					String translocationFourteenToSixteen, DoctorModel idDoctor) {
	super();
	this.id = id;
	this.name = name;
	this.lastnameP = lastnameP;
	this.lastnameM = lastnameM;
	this.birthdate = birthdate;
	this.age = age;
	this.gender = gender;
	this.height = height;
	this.weight = weight;
	this.bmi = bmi;
	this.bodySup = bodySup;
	this.startDateOfTreatment = startDateOfTreatment;
	this.serumCreatinine = serumCreatinine;
	this.depCreatinine = depCreatinine;
	this.ecog = ecog;
	this.boneInjuries = boneInjuries;
	this.boneInjuriesNumber = boneInjuriesNumber;
	this.extramedullaryPlasmacytomas = extramedullaryPlasmacytomas;
	this.plasmacytomasNumber = plasmacytomasNumber;
	this.active = active;
	this.plasmaCellsInBoneMarrow = plasmaCellsInBoneMarrow;
	this.plasmaCellsInBloodPerif = plasmaCellsInBloodPerif;
	this.igG = igG;
	this.igA = igA;
	this.igM = igM;
	this.inmIgTypeFixation = inmIgTypeFixation;
	this.inmCllTypeFixation = inmCllTypeFixation;
	this.lightChainsKappa = lightChainsKappa;
	this.lightChainsLambda = lightChainsLambda;
	this.electroForesisDeProteinasSuero = electroForesisDeProteinasSuero;
	this.electroForesisDeProteinasOrina = electroForesisDeProteinasOrina;
	this.benceJonesProteinuria = benceJonesProteinuria;
	this.dystemicAmyloidosis = dystemicAmyloidosis;
	this.b2Microglobulin = b2Microglobulin;
	this.albumin = albumin;
	this.serumCalcium = serumCalcium;
	this.lacticDehydrogenase = lacticDehydrogenase;
	this.hemoglobin = hemoglobin;
	this.hematocrit = hematocrit;
	this.lymphocytes = lymphocytes;
	this.leukocytes = leukocytes;
	this.neutrophils = neutrophils;
	this.platelets = platelets;
	this.deletionSeventeenP = deletionSeventeenP;
	this.translocationFourToFourteen = translocationFourToFourteen;
	this.translocationFourteenToSixteen = translocationFourteenToSixteen;
	this.idDoctor = idDoctor;
}

public PatientModel(String name, String lastnameP, String lastnameM, String birthdate, String age, String gender,
					String height, String weight, String bmi, String bodySup, String startDateOfTreatment, String serumCreatinine,
					String depCreatinine, String ecog, String boneInjuries, String boneInjuriesNumber,
					String extramedullaryPlasmacytomas, String plasmacytomasNumber, String active,
					String plasmaCellsInBoneMarrow, String plasmaCellsInBloodPerif, String igG, String igA, String igM,
					String inmIgTypeFixation, String inmCllTypeFixation, String lightChainsKappa, String lightChainsLambda,
					String electroForesisDeProteinasSuero, String electroForesisDeProteinasOrina, String benceJonesProteinuria,
					String dystemicAmyloidosis, String b2Microglobulin, String albumin, String serumCalcium,
					String lacticDehydrogenase, String hemoglobin, String hematocrit, String lymphocytes, String leukocytes,
					String neutrophils, String platelets, String deletionSeventeenP, String translocationFourToFourteen,
					String translocationFourteenToSixteen, DoctorModel idDoctor) {
	super();
	this.name = name;
	this.lastnameP = lastnameP;
	this.lastnameM = lastnameM;
	this.birthdate = birthdate;
	this.age = age;
	this.gender = gender;
	this.height = height;
	this.weight = weight;
	this.bmi = bmi;
	this.bodySup = bodySup;
	this.startDateOfTreatment = startDateOfTreatment;
	this.serumCreatinine = serumCreatinine;
	this.depCreatinine = depCreatinine;
	this.ecog = ecog;
	this.boneInjuries = boneInjuries;
	this.boneInjuriesNumber = boneInjuriesNumber;
	this.extramedullaryPlasmacytomas = extramedullaryPlasmacytomas;
	this.plasmacytomasNumber = plasmacytomasNumber;
	this.active = active;
	this.plasmaCellsInBoneMarrow = plasmaCellsInBoneMarrow;
	this.plasmaCellsInBloodPerif = plasmaCellsInBloodPerif;
	this.igG = igG;
	this.igA = igA;
	this.igM = igM;
	this.inmIgTypeFixation = inmIgTypeFixation;
	this.inmCllTypeFixation = inmCllTypeFixation;
	this.lightChainsKappa = lightChainsKappa;
	this.lightChainsLambda = lightChainsLambda;
	this.electroForesisDeProteinasSuero = electroForesisDeProteinasSuero;
	this.electroForesisDeProteinasOrina = electroForesisDeProteinasOrina;
	this.benceJonesProteinuria = benceJonesProteinuria;
	this.dystemicAmyloidosis = dystemicAmyloidosis;
	this.b2Microglobulin = b2Microglobulin;
	this.albumin = albumin;
	this.serumCalcium = serumCalcium;
	this.lacticDehydrogenase = lacticDehydrogenase;
	this.hemoglobin = hemoglobin;
	this.hematocrit = hematocrit;
	this.lymphocytes = lymphocytes;
	this.leukocytes = leukocytes;
	this.neutrophils = neutrophils;
	this.platelets = platelets;
	this.deletionSeventeenP = deletionSeventeenP;
	this.translocationFourToFourteen = translocationFourToFourteen;
	this.translocationFourteenToSixteen = translocationFourteenToSixteen;
	this.idDoctor = idDoctor;
}

public String getFullName(){
	return name + " " + lastnameP + " " + lastnameM;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLastnameP() {
	return lastnameP;
}

public void setLastnameP(String lastnameP) {
	this.lastnameP = lastnameP;
}

public String getLastnameM() {
	return lastnameM;
}

public void setLastnameM(String lastnameM) {
	this.lastnameM = lastnameM;
}

public String getBirthdate() {
	return birthdate;
}

public void setBirthdate(String birthdate) {
	this.birthdate = birthdate;
}

public String getAge() {
	return age;
}

public void setAge(String age) {
	this.age = age;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getHeight() {
	return height;
}

public void setHeight(String height) {
	this.height = height;
}

public String getWeight() {
	return weight;
}

public void setWeight(String weight) {
	this.weight = weight;
}

public String getBmi() {
	return bmi;
}

public void setBmi(String bmi) {
	this.bmi = bmi;
}

public String getBodySup() {
	return bodySup;
}

public void setBodySup(String bodySup) {
	this.bodySup = bodySup;
}

public String getStartDateOfTreatment() {
	return startDateOfTreatment;
}

public void setStartDateOfTreatment(String startDateOfTreatment) {
	this.startDateOfTreatment = startDateOfTreatment;
}

public String getSerumCreatinine() {
	return serumCreatinine;
}

public void setSerumCreatinine(String serumCreatinine) {
	this.serumCreatinine = serumCreatinine;
}

public String getDepCreatinine() {
	return depCreatinine;
}

public void setDepCreatinine(String depCreatinine) {
	this.depCreatinine = depCreatinine;
}

public String getEcog() {
	return ecog;
}

public void setEcog(String ecog) {
	this.ecog = ecog;
}

public String getBoneInjuries() {
	return boneInjuries;
}

public void setBoneInjuries(String boneInjuries) {
	this.boneInjuries = boneInjuries;
}

public String getBoneInjuriesNumber() {
	return boneInjuriesNumber;
}

public void setBoneInjuriesNumber(String boneInjuriesNumber) {
	this.boneInjuriesNumber = boneInjuriesNumber;
}

public String getExtramedullaryPlasmacytomas() {
	return extramedullaryPlasmacytomas;
}

public void setExtramedullaryPlasmacytomas(String extramedullaryPlasmacytomas) {
	this.extramedullaryPlasmacytomas = extramedullaryPlasmacytomas;
}

public String getPlasmacytomasNumber() {
	return plasmacytomasNumber;
}

public void setPlasmacytomasNumber(String plasmacytomasNumber) {
	this.plasmacytomasNumber = plasmacytomasNumber;
}

public String getActive() {
	return active;
}

public void setActive(String active) {
	this.active = active;
}

public String getPlasmaCellsInBoneMarrow() {
	return plasmaCellsInBoneMarrow;
}

public void setPlasmaCellsInBoneMarrow(String plasmaCellsInBoneMarrow) {
	this.plasmaCellsInBoneMarrow = plasmaCellsInBoneMarrow;
}

public String getPlasmaCellsInBloodPerif() {
	return plasmaCellsInBloodPerif;
}

public void setPlasmaCellsInBloodPerif(String plasmaCellsInBloodPerif) {
	this.plasmaCellsInBloodPerif = plasmaCellsInBloodPerif;
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

public String getInmIgTypeFixation() {
	return inmIgTypeFixation;
}

public void setInmIgTypeFixation(String inmIgTypeFixation) {
	this.inmIgTypeFixation = inmIgTypeFixation;
}

public String getInmCllTypeFixation() {
	return inmCllTypeFixation;
}

public void setInmCllTypeFixation(String inmCllTypeFixation) {
	this.inmCllTypeFixation = inmCllTypeFixation;
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

public String getBenceJonesProteinuria() {
	return benceJonesProteinuria;
}

public void setBenceJonesProteinuria(String benceJonesProteinuria) {
	this.benceJonesProteinuria = benceJonesProteinuria;
}

public String getDystemicAmyloidosis() {
	return dystemicAmyloidosis;
}

public void setDystemicAmyloidosis(String dystemicAmyloidosis) {
	this.dystemicAmyloidosis = dystemicAmyloidosis;
}

public String getB2Microglobulin() {
	return b2Microglobulin;
}

public void setB2Microglobulin(String b2Microglobulin) {
	this.b2Microglobulin = b2Microglobulin;
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

public String getLymphocytes() {
	return lymphocytes;
}

public void setLymphocytes(String lymphocytes) {
	this.lymphocytes = lymphocytes;
}

public String getLeukocytes() {
	return leukocytes;
}

public void setLeukocytes(String leukocytes) {
	this.leukocytes = leukocytes;
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

public String getDeletionSeventeenP() {
	return deletionSeventeenP;
}

public void setDeletionSeventeenP(String deletionSeventeenP) {
	this.deletionSeventeenP = deletionSeventeenP;
}

public String getTranslocationFourToFourteen() {
	return translocationFourToFourteen;
}

public void setTranslocationFourToFourteen(String translocationFourToFourteen) {
	this.translocationFourToFourteen = translocationFourToFourteen;
}

public String getTranslocationFourteenToSixteen() {
	return translocationFourteenToSixteen;
}

public void setTranslocationFourteenToSixteen(String translocationFourteenToSixteen) {
	this.translocationFourteenToSixteen = translocationFourteenToSixteen;
}

public DoctorModel getIdDoctor() {
	return idDoctor;
}

public void setIdDoctor(DoctorModel idDoctor) {
	this.idDoctor = idDoctor;
}

  
  
  
//
//	// Propiedades privadas
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "idpaciente")
//	private Integer id;
//
//	@Column(name = "nombre")
//	private String name;
//
//	@Column(name = "appat")
//	private String lastnameP;
//
//	@Column(name = "apmat")
//	private String lastnameM;
//
//	@Column(name = "fechanac")
//	private String birthdate;
//
//	@Column(name = "edad")
//	private String age;
//
//	@Column(name = "genero")
//	private String gender;
//	
//	@Column(name = "talla")
//	private String height;
//	
//	@Column(name = "peso")
//	private String weight;
//	
//	@Column(name = "imc")
//	private String bmi;
//	
//	@Column(name = "supcorporal")
//	private String bodySup;
//	
//	@Column(name = "fechainiciotratamiento")
//	private String startDateOfTreatment;
//
//	@Column(name = "creatininaSerica")
//	private String serumCreatinine;
//
//	@Column(name = "depCreatinina")
//	private String depCreatinine;
//
//	@Column(name = "ecog")
//	private String ecog;
//
//	@Column(name = "lesionesOseas")
//	private String boneInjuries;
//
//	@Column(name = "numlesionesOseas")
//	private String boneInjuriesNumber;
//
//	@Column(name = "plasmocitomasExtramedulares")
//	private String extramedullaryPlasmacytomas;
//
//	@Column(name = "numPlasmocitomas")
//	private String plasmacytomasNumber;
//
//	@Column(name = "activa")
//	private String active;
//
//	@Column(name = "celPlasmaticEnMedulaOsea")
//	private String plasmaCellsInBoneMarrow;
//
//	@Column(name = "celPlasmaticEnSangrePerif")
//	private String plasmaCellsInBloodPerif;
//
//	@Column(name = "igG")
//
//	private String igG;
//
//	@Column(name = "igA")
//	private String igA;
//
//	@Column(name = "igM")
//	private String igM;
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
//	private String lightChainsKappa;
//
//	@Column(name = "cadenasLigerasLambda")
//	private String lightChainsLambda;
//
//	@Column(name = "electroForesisDeProteinasSuero")
//	private String electroForesisDeProteinasSuero;
//
//	@Column(name = "electroForesisDeProteinasOrina")
//	private String electroForesisDeProteinasOrina;
//
//	@Column(name = "proteinuriaDeBenceJones")
//	private String benceJonesProteinuria;
//
//	@Column(name = "amiloidosisDistemica")
//	private String dystemicAmyloidosis;
//
//	@Column(name = "b2Microglobulina")
//	private String b2Microglobulin;
//
//	@Column(name = "albumina")
//	private String albumin;
//
//	@Column(name = "calcioSerico")
//	private String serumCalcium;
//	//Fin segunda pantalla
//
//	// Pantalla 3
//	@Column(name = "deshidrogenasaLactica")
//	private String lacticDehydrogenase;
//
//	@Column(name = "hemoglobina")
//	private String hemoglobin;
//
//	@Column(name = "hematocrito")
//	private String hematocrit;
//
//	@Column(name = "Linfocitos")
//	private String lymphocytes;
//
//	@Column(name = "leucocitos")
//	private String leukocytes;
//
//	@Column(name = "neutrofilos")
//	private String neutrophils;
//	
//	@Column(name = "plaquetas")
//	private String platelets;
//
//	@Column(name = "delecion17P")
//	private String deletionSeventeenP;
//
//	@Column(name = "translocacion4a14")
//	private String translocationFourToFourteen;
//
//	@Column(name = "translocacion14a16")
//	private String translocationFourteenToSixteen;
//	
//    @ManyToOne//(cascade = CascadeType.ALL)
//    @JoinColumn(name="idmedico")
//	private DoctorModel idDoctor;
//	
//	// Constructores
//	
//	public PatientModel() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//	public PatientModel(Integer id, String name, String lastnameP, String lastnameM, String birthdate, String age,
//			String gender, String height, String weight, String bmi, String bodySup, String startDateOfTreatment,
//			String serumCreatinine, String depCreatinine, String ecog, String boneInjuries, String boneInjuriesNumber,
//			String extramedullaryPlasmacytomas, String plasmacytomasNumber, String active,
//			String plasmaCellsInBoneMarrow, String plasmaCellsInBloodPerif, String igG, String igA, String igM,
//			String inmIgTypeFixation, String inmCllTypeFixation, String lightChainsKappa, String lightChainsLambda,
//			String electroForesisDeProteinasSuero, String electroForesisDeProteinasOrina, String benceJonesProteinuria,
//			String dystemicAmyloidosis, String b2Microglobulin, String albumin, String serumCalcium,
//			String lacticDehydrogenase, String hemoglobin, String hematocrit, String lymphocytes, String leukocytes,
//			String neutrophils, String platelets, String deletionSeventeenP, String translocationFourToFourteen,
//			String translocationFourteenToSixteen, DoctorModel idDoctor) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.lastnameP = lastnameP;
//		this.lastnameM = lastnameM;
//		this.birthdate = birthdate;
//		this.age = age;
//		this.gender = gender;
//		this.height = height;
//		this.weight = weight;
//		this.bmi = bmi;
//		this.bodySup = bodySup;
//		this.startDateOfTreatment = startDateOfTreatment;
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
//		this.idDoctor = idDoctor;
//	}
//
//	public PatientModel(String name, String lastnameP, String lastnameM, String birthdate, String age, String gender,
//			String height, String weight, String bmi, String bodySup, String startDateOfTreatment,
//			String serumCreatinine, String depCreatinine, String ecog, String boneInjuries, String boneInjuriesNumber,
//			String extramedullaryPlasmacytomas, String plasmacytomasNumber, String active,
//			String plasmaCellsInBoneMarrow, String plasmaCellsInBloodPerif, String igG, String igA, String igM,
//			String inmIgTypeFixation, String inmCllTypeFixation, String lightChainsKappa, String lightChainsLambda,
//			String electroForesisDeProteinasSuero, String electroForesisDeProteinasOrina, String benceJonesProteinuria,
//			String dystemicAmyloidosis, String b2Microglobulin, String albumin, String serumCalcium,
//			String lacticDehydrogenase, String hemoglobin, String hematocrit, String lymphocytes, String leukocytes,
//			String neutrophils, String platelets, String deletionSeventeenP, String translocationFourToFourteen,
//			String translocationFourteenToSixteen, DoctorModel idDoctor) {
//		super();
//		this.name = name;
//		this.lastnameP = lastnameP;
//		this.lastnameM = lastnameM;
//		this.birthdate = birthdate;
//		this.age = age;
//		this.gender = gender;
//		this.height = height;
//		this.weight = weight;
//		this.bmi = bmi;
//		this.bodySup = bodySup;
//		this.startDateOfTreatment = startDateOfTreatment;
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
//		this.idDoctor = idDoctor;
//	}
//
//	// Definir edad
////	LocalDate birthdate2 = new LocalDate (1970, 1, 20);
////	LocalDate now = new LocalDate();
////	Years age = Years.yearsBetween(birthdate2, now);
//
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getLastnameP() {
//		return lastnameP;
//	}
//
//	public void setLastnameP(String lastnameP) {
//		this.lastnameP = lastnameP;
//	}
//
//	public String getLastnameM() {
//		return lastnameM;
//	}
//
//	public void setLastnameM(String lastnameM) {
//		this.lastnameM = lastnameM;
//	}
//
//	public String getBirthdate() {
//		return birthdate;
//	}
//
//	public void setBirthdate(String birthdate) {
//		this.birthdate = birthdate;
//	}
//
//	public String getAge() {
//		return age;
//	}
//
//	public void setAge(String age) {
//		this.age = age;
//	}
//
//	public String getGender() {
//		return gender;
//	}
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//
//	public String getHeight() {
//		return height;
//	}
//
//	public void setHeight(String height) {
//		this.height = height;
//	}
//
//	public String getWeight() {
//		return weight;
//	}
//
//	public void setWeight(String weight) {
//		this.weight = weight;
//	}
//
//	public String getBmi() {
//		return bmi;
//	}
//
//	public void setBmi(String bmi) {
//		this.bmi = bmi;
//	}
//
//	public String getBodySup() {
//		return bodySup;
//	}
//
//	public void setBodySup(String bodySup) {
//		this.bodySup = bodySup;
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
//	public String getSerumCreatinine() {
//		return serumCreatinine;
//	}
//
//	public void setSerumCreatinine(String serumCreatinine) {
//		this.serumCreatinine = serumCreatinine;
//	}
//
//	public String getDepCreatinine() {
//		return depCreatinine;
//	}
//
//	public void setDepCreatinine(String depCreatinine) {
//		this.depCreatinine = depCreatinine;
//	}
//
//	public String getEcog() {
//		return ecog;
//	}
//
//	public void setEcog(String ecog) {
//		this.ecog = ecog;
//	}
//
//	public String getBoneInjuries() {
//		return boneInjuries;
//	}
//
//	public void setBoneInjuries(String boneInjuries) {
//		this.boneInjuries = boneInjuries;
//	}
//
//	public String getBoneInjuriesNumber() {
//		return boneInjuriesNumber;
//	}
//
//	public void setBoneInjuriesNumber(String boneInjuriesNumber) {
//		this.boneInjuriesNumber = boneInjuriesNumber;
//	}
//
//	public String getExtramedullaryPlasmacytomas() {
//		return extramedullaryPlasmacytomas;
//	}
//
//	public void setExtramedullaryPlasmacytomas(String extramedullaryPlasmacytomas) {
//		this.extramedullaryPlasmacytomas = extramedullaryPlasmacytomas;
//	}
//
//	public String getPlasmacytomasNumber() {
//		return plasmacytomasNumber;
//	}
//
//	public void setPlasmacytomasNumber(String plasmacytomasNumber) {
//		this.plasmacytomasNumber = plasmacytomasNumber;
//	}
//
//	public String getActive() {
//		return active;
//	}
//
//	public void setActive(String active) {
//		this.active = active;
//	}
//
//	public String getPlasmaCellsInBoneMarrow() {
//		return plasmaCellsInBoneMarrow;
//	}
//
//	public void setPlasmaCellsInBoneMarrow(String plasmaCellsInBoneMarrow) {
//		this.plasmaCellsInBoneMarrow = plasmaCellsInBoneMarrow;
//	}
//
//	public String getPlasmaCellsInBloodPerif() {
//		return plasmaCellsInBloodPerif;
//	}
//
//	public void setPlasmaCellsInBloodPerif(String plasmaCellsInBloodPerif) {
//		this.plasmaCellsInBloodPerif = plasmaCellsInBloodPerif;
//	}
//
//	public String getIgG() {
//		return igG;
//	}
//
//	public void setIgG(String igG) {
//		this.igG = igG;
//	}
//
//	public String getIgA() {
//		return igA;
//	}
//
//	public void setIgA(String igA) {
//		this.igA = igA;
//	}
//
//	public String getIgM() {
//		return igM;
//	}
//
//	public void setIgM(String igM) {
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
//	public String getLightChainsKappa() {
//		return lightChainsKappa;
//	}
//
//	public void setLightChainsKappa(String lightChainsKappa) {
//		this.lightChainsKappa = lightChainsKappa;
//	}
//
//	public String getLightChainsLambda() {
//		return lightChainsLambda;
//	}
//
//	public void setLightChainsLambda(String lightChainsLambda) {
//		this.lightChainsLambda = lightChainsLambda;
//	}
//
//	public String getElectroForesisDeProteinasSuero() {
//		return electroForesisDeProteinasSuero;
//	}
//
//	public void setElectroForesisDeProteinasSuero(String electroForesisDeProteinasSuero) {
//		this.electroForesisDeProteinasSuero = electroForesisDeProteinasSuero;
//	}
//
//	public String getElectroForesisDeProteinasOrina() {
//		return electroForesisDeProteinasOrina;
//	}
//
//	public void setElectroForesisDeProteinasOrina(String electroForesisDeProteinasOrina) {
//		this.electroForesisDeProteinasOrina = electroForesisDeProteinasOrina;
//	}
//
//	public String getBenceJonesProteinuria() {
//		return benceJonesProteinuria;
//	}
//
//	public void setBenceJonesProteinuria(String benceJonesProteinuria) {
//		this.benceJonesProteinuria = benceJonesProteinuria;
//	}
//
//	public String getDystemicAmyloidosis() {
//		return dystemicAmyloidosis;
//	}
//
//	public void setDystemicAmyloidosis(String dystemicAmyloidosis) {
//		this.dystemicAmyloidosis = dystemicAmyloidosis;
//	}
//
//	public String getB2Microglobulin() {
//		return b2Microglobulin;
//	}
//
//	public void setB2Microglobulin(String b2Microglobulin) {
//		this.b2Microglobulin = b2Microglobulin;
//	}
//
//	public String getAlbumin() {
//		return albumin;
//	}
//
//	public void setAlbumin(String albumin) {
//		this.albumin = albumin;
//	}
//
//	public String getSerumCalcium() {
//		return serumCalcium;
//	}
//
//	public void setSerumCalcium(String serumCalcium) {
//		this.serumCalcium = serumCalcium;
//	}
//
//	public String getLacticDehydrogenase() {
//		return lacticDehydrogenase;
//	}
//
//	public void setLacticDehydrogenase(String lacticDehydrogenase) {
//		this.lacticDehydrogenase = lacticDehydrogenase;
//	}
//
//	public String getHemoglobin() {
//		return hemoglobin;
//	}
//
//	public void setHemoglobin(String hemoglobin) {
//		this.hemoglobin = hemoglobin;
//	}
//
//	public String getHematocrit() {
//		return hematocrit;
//	}
//
//	public void setHematocrit(String hematocrit) {
//		this.hematocrit = hematocrit;
//	}
//
//	public String getLymphocytes() {
//		return lymphocytes;
//	}
//
//	public void setLymphocytes(String lymphocytes) {
//		this.lymphocytes = lymphocytes;
//	}
//
//	public String getLeukocytes() {
//		return leukocytes;
//	}
//
//	public void setLeukocytes(String leukocytes) {
//		this.leukocytes = leukocytes;
//	}
//
//	public String getNeutrophils() {
//		return neutrophils;
//	}
//
//	public void setNeutrophils(String neutrophils) {
//		this.neutrophils = neutrophils;
//	}
//
//	public String getPlatelets() {
//		return platelets;
//	}
//
//	public void setPlatelets(String platelets) {
//		this.platelets = platelets;
//	}
//
//	public String getDeletionSeventeenP() {
//		return deletionSeventeenP;
//	}
//
//	public void setDeletionSeventeenP(String deletionSeventeenP) {
//		this.deletionSeventeenP = deletionSeventeenP;
//	}
//
//	public String getTranslocationFourToFourteen() {
//		return translocationFourToFourteen;
//	}
//
//	public void setTranslocationFourToFourteen(String translocationFourToFourteen) {
//		this.translocationFourToFourteen = translocationFourToFourteen;
//	}
//
//	public String getTranslocationFourteenToSixteen() {
//		return translocationFourteenToSixteen;
//	}
//
//	public void setTranslocationFourteenToSixteen(String translocationFourteenToSixteen) {
//		this.translocationFourteenToSixteen = translocationFourteenToSixteen;
//	}
//	
//	public DoctorModel getIdDoctor() {
//		return idDoctor;
//	}
//
//	public void setIdDoctor(DoctorModel idDoctor) {
//		this.idDoctor = idDoctor;
//	}
//
//	// Método toString optimizado
//	@Override
//	public String toString() {
//		return String.format("PatientModel [id=%s, name=%s, lastnameP=%s, lastnameM=%s, birthdate=%s, age=%s, gender=%s, height=%s, weight=%s, bmi=%s, bodySup=%s, startDate=%s]", id, name,
//				lastnameP, lastnameM, birthdate, age, gender, height, weight, bmi, bodySup, startDateOfTreatment);
//	}
//
//
}
