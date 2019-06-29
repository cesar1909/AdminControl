package mx.ipn.cic.biblioteca.AdminControl.repositories;

import java.util.List;


import mx.ipn.cic.biblioteca.AdminControl.model.DoctorModel;
import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.String;

@Transactional
@Repository
public interface IPatientRepository extends JpaRepository<PatientModel, Integer> {

	List<PatientModel> findByNameContainingOrLastnamePContainingOrLastnameMContaining(
			String name,
			String lastnameP,
			String lastnameM
			);

	List<PatientModel> findByNameContaining(
	String name
	);

	List<PatientModel> findByIdDoctor(DoctorModel docotorModel);
	
	@Modifying
	@Query(value = "UPDATE paciente ci SET "
			+ "ci.nombre= :nombre, "
			+ "ci.appat = :appat, "
			+ "ci.apmat = :apmat, "
			+ "ci.fechanac = :fechanac, "
			+ "ci.edad = :edad, "
			+ "ci.genero = :genero, "
			+ "ci.talla = :talla, "
			+ "ci.peso = :peso, "
			+ "ci.imc = :imc, "
			+ "ci.supcorporal = :supcorporal, "
			+ "ci.fechainiciotratamiento = :fechainiciotratamiento, "
			+ "ci.creatinina_serica = :creatinina_serica, "
			+ "ci.dep_creatinina = :dep_creatinina, "
			+ "ci.ecog = :ecog, "
			+ "ci.lesiones_oseas = :lesiones_oseas, "
			+ "ci.numlesiones_oseas = :numlesiones_oseas, "
			+ "ci.plasmocitomas_extramedulares = :plasmocitomas_extramedulares, "
			+ "ci.num_plasmocitomas = :num_plasmocitomas, "
			+ "ci.activa = :activa, "
			+ "ci.cel_plasmatic_en_medula_osea = :cel_plasmatic_en_medula_osea, "
			+ "ci.cel_plasmatic_en_sangre_perif = :cel_plasmatic_en_sangre_perif, "
			+ "ci.igg = :igg, "
			+ "ci.iga = :iga, "
			+ "ci.igm = :igm, "
			+ "ci.inm_fijacion_tipo_ig= :inm_fijacion_tipo_ig, "
			+ "ci.inm_fijacion_tipo_cll= :inm_fijacion_tipo_cll, "
			+ "ci.cadenas_ligeras_kappa= :cadenas_ligeras_kappa, "
			+ "ci.cadenas_ligeras_lambda= :cadenas_ligeras_lambda, "
			+ "ci.electro_foresis_de_proteinas_suero= :electro_foresis_de_proteinas_suero, "
			+ "ci.electro_foresis_de_proteinas_orina= :electro_foresis_de_proteinas_orina, "
			+ "ci.proteinuria_de_bence_jones= :proteinuria_de_bence_jones, "
			+ "ci.amiloidosis_distemica= :amiloidosis_distemica, "
			+ "ci.b2microglobulina= :b2microglobulina, "
			+ "ci.albumina= :albumina, "
			+ "ci.calcio_serico= :calcio_serico, "
			+ "ci.deshidrogenasa_lactica= :deshidrogenasa_lactica, "
			+ "ci.hemoglobina= :hemoglobina, "
			+ "ci.hematocrito= :hematocrito, "
			+ "ci.linfocitos= :linfocitos, "
			+ "ci.leucocitos= :leucocitos, "
			+ "ci.neutrofilos= :neutrofilos, "
			+ "ci.plaquetas= :plaquetas, "
			+ "ci.delecion17p= :delecion17p, "
			+ "ci.translocacion4a14= :translocacion4a14, "
			+ "ci.translocacion14a16= :translocacion14a16 "
			+ "WHERE ci.idmedico = :idmedico AND ci.idpaciente = :idpaciente", nativeQuery=true
			)
	void updateInitialConsult(
			   @Param("idpaciente") Integer idpaciente,
		       @Param("nombre") String nombre,
		       @Param("appat") String appat,
		       @Param("apmat") String apmat,
		       @Param("fechanac") String fechanac,
		       @Param("edad") String edad,
		       @Param("genero") String genero,
		       @Param("talla") String talla,
		       @Param("peso") String peso,
		       @Param("imc") String imc,
		       @Param("supcorporal") String supcorporal,
		       
		       @Param("fechainiciotratamiento") String fechainiciotratamiento,
		       @Param("creatinina_serica") String creatinina_serica,
		       @Param("dep_creatinina") String dep_creatinina,
		       @Param("ecog") String ecog,
		       @Param("lesiones_oseas") String lesiones_oseas,
		       @Param("numlesiones_oseas") String numlesiones_oseas,
		       @Param("plasmocitomas_extramedulares") String plasmocitomas_extramedulares,
		       @Param("num_plasmocitomas") String num_plasmocitomas,
		       @Param("activa") String activa,
		       @Param("cel_plasmatic_en_medula_osea") String cel_plasmatic_en_medula_osea,
		       @Param("cel_plasmatic_en_sangre_perif") String cel_plasmatic_en_sangre_perif,
		       @Param("igg") String igg,
		       @Param("iga") String iga,
		       @Param("igm") String igm,
		       @Param("inm_fijacion_tipo_ig") String inm_fijacion_tipo_ig,
		       @Param("inm_fijacion_tipo_cll") String inm_fijacion_tipo_cll,
		       @Param("cadenas_ligeras_kappa") String cadenas_ligeras_kappa,
		       @Param("cadenas_ligeras_lambda") String cadenas_ligeras_lambda,
		       @Param("electro_foresis_de_proteinas_suero") String electro_foresis_de_proteinas_suero,
		       @Param("electro_foresis_de_proteinas_orina") String electro_foresis_de_proteinas_orina,
		       @Param("proteinuria_de_bence_jones") String proteinuria_de_bence_jones,
		       @Param("amiloidosis_distemica") String amiloidosis_distemica,
		       @Param("b2microglobulina") String b2microglobulina,
		       @Param("albumina") String albumina,
		       @Param("calcio_serico") String calcio_serico,
		       @Param("deshidrogenasa_lactica") String deshidrogenasa_lactica,
		       @Param("hemoglobina") String hemoglobina,
		       @Param("hematocrito") String hematocrito,
		       @Param("linfocitos") String linfocitos,
		       @Param("leucocitos") String leucocitos,
		       @Param("neutrofilos") String neutrofilos,
		       @Param("plaquetas") String plaquetas,
		       @Param("delecion17p") String delecion17p,
		       @Param("translocacion4a14") String translocacion4a14,
		       @Param("translocacion14a16") String translocacion14a16,
		       @Param("idmedico") Long idmedico
				);

}
