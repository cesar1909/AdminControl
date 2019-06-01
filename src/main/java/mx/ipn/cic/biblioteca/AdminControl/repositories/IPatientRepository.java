package mx.ipn.cic.biblioteca.AdminControl.repositories;

import java.util.List;

import javax.transaction.Transactional;

import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;
import mx.ipn.cic.biblioteca.AdminControl.projections.FindPatientsByEmailResult;
import mx.ipn.cic.biblioteca.AdminControl.projections.FindFullNameByEmailResult;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
	
//	@Modifying
//	@Query(value = "UPDATE paciente cf SET "
//			+ "cf.fecha_realizacion = :fecha_realizacion,"
//			+ "cf.albumina = :albumina,"
//			+ "cf.calcio_serico = :calcio_serico,"
//			+ "cf.deshidrogenasa_lactica = :deshidrogenasa_lactica,"
//			+ "cf.hemoglobina = :hemoglobina,"
//			+ "cf.hematocrito = :hematocrito,"
//			+ "cf.leucocitos = :leucocitos,"
//			+ "cf.linfocitos = :linfocitos,"
//			+ "cf.neutrofilos = :neutrofilos,"
//			+ "cf.plaquetas = :plaquetas,"
//			+ "cf.igg = :igg,"
//			+ "cf.iga = :iga,"
//			+ "cf.igm = :igm,"
//			+ "cf.cadenas_ligeras_kappa = :cadenas_ligeras_kappa,"
//			+ "cf.cadenas_ligeras_lambda = :cadenas_ligeras_lambda,"
//			+ "cf.cel_plasmatic_en_medula_osea = :cel_plasmatic_en_medula_osea,"
//			+ "cf.electro_foresis_de_proteinas_suero = :electro_foresis_de_proteinas_suero,"
//			+ "cf.electro_foresis_de_proteinas_orina = :electro_foresis_de_proteinas_orina,"
//			+ "cf.inm_fijacion_tipo_ig = :inm_fijacion_tipo_ig,"
//			+ "cf.inm_fijacion_tipo_cll = :inm_fijacion_tipo_cll,"
//			+ "cf.enfermedad_minima_residual = :enfermedad_minima_residual,"
//			+ "cf.repuestaatratamiento = :repuestaatratamiento,"
//			+ "cf.comentarios_extrax = :comentarios_extrax "
//			+ "WHERE cf.idpaciente = :idpatient", nativeQuery=true
//			)
//	void updateFinalConsultWithoutNewVariables(
//			   @Param("idpatient") Integer idpatient,
//		       @Param("fecha_realizacion") String fecha_realizacion,
//		       @Param("albumina") String albumina,
//		       @Param("calcio_serico") String calcio_serico,
//		       @Param("deshidrogenasa_lactica") String deshidrogenasa_lactica,
//		       @Param("hemoglobina") String hemoglobina,
//		       @Param("hematocrito") String hematocrito,
//		       @Param("leucocitos") String leucocitos,
//		       @Param("linfocitos") String linfocitos,
//		       @Param("neutrofilos") String neutrofilos,
//		       @Param("plaquetas") String platelets,
//		       @Param("igg") String igg,
//		       @Param("iga") String iga,
//		       @Param("igm") String igm,
//		       @Param("cadenas_ligeras_kappa") String cadenas_ligeras_kappa,
//		       @Param("cadenas_ligeras_lambda") String cadenas_ligeras_lambda,
//		       @Param("cel_plasmatic_en_medula_osea") String cel_plasmatic_en_medula_osea,
//		       @Param("electro_foresis_de_proteinas_suero") String electro_foresis_de_proteinas_suero,
//		       @Param("electro_foresis_de_proteinas_orina") String electro_foresis_de_proteinas_orina,
//		       @Param("inm_fijacion_tipo_ig") String inm_fijacion_tipo_ig,
//		       @Param("inm_fijacion_tipo_cll") String inm_fijacion_tipo_cll,
//		       @Param("enfermedad_minima_residual") String enfermedad_minima_residual,
//		       @Param("repuestaatratamiento") String repuestaatratamiento,
//		       @Param("comentarios_extrax") String comentarios_extrax
//		      
//			);
	
}
