package mx.ipn.cic.biblioteca.AdminControl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import mx.ipn.cic.biblioteca.AdminControl.model.FinalConsultation;
import java.lang.Integer;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface IFinalConsultationRepository extends JpaRepository<FinalConsultation, Integer>{
    FinalConsultation findByIdPatient(Integer id);

	@Modifying
	@Query(value = "UPDATE consulta_final cf SET "
			+ "cf.fecha_realizacion = :fecha_realizacion, "
			+ "cf.albumina = :albumina, "
			+ "cf.calcio_serico = :calcio_serico, "
			+ "cf.deshidrogenasa_lactica = :deshidrogenasa_lactica, "
			+ "cf.hemoglobina = :hemoglobina, "
			+ "cf.hematocrito = :hematocrito, "
			+ "cf.leucocitos = :leucocitos, "
			+ "cf.linfocitos = :linfocitos, "
			+ "cf.neutrofilos = :neutrofilos, "
			+ "cf.plaquetas = :plaquetas, "
			+ "cf.igg = :igg, "
			+ "cf.iga = :iga, "
			+ "cf.igm = :igm, "
			+ "cf.cadenas_ligeras_kappa = :cadenas_ligeras_kappa, "
			+ "cf.cadenas_ligeras_lambda = :cadenas_ligeras_lambda, "
			+ "cf.cel_plasmatic_en_medula_osea = :cel_plasmatic_en_medula_osea, "
			+ "cf.electro_foresis_de_proteinas_suero = :electro_foresis_de_proteinas_suero, "
			+ "cf.electro_foresis_de_proteinas_orina = :electro_foresis_de_proteinas_orina, "
			+ "cf.inm_fijacion_tipo_ig = :inm_fijacion_tipo_ig, "
			+ "cf.inm_fijacion_tipo_cll = :inm_fijacion_tipo_cll, "
			+ "cf.enfermedad_minima_residual = :enfermedad_minima_residual, "
			+ "cf.repuestaatratamiento = :repuestaatratamiento, "
			+ "cf.comentarios_extrax = :comentarios_extrax, "
			+ "cf.fecha_de_trasplante = :fecha_de_trasplante, "
			+ "cf.numcd34infundidas = :numcd34infundidas, "
			+ "cf.fecha_injerto_mieloide = :fecha_injerto_mieloide, "
			+ "cf.fecha_injerto_plaquetario = :fecha_injerto_plaquetario, "
			+ "cf.toxicidades = :toxicidades "
			+ "WHERE cf.idpaciente = :idpatient", nativeQuery=true
			)
	void updateFinalConsult(
			   @Param("idpatient") Integer idpatient,
		       @Param("fecha_realizacion") String fecha_realizacion,
		       @Param("albumina") String albumina,
		       @Param("calcio_serico") String calcio_serico,
		       @Param("deshidrogenasa_lactica") String deshidrogenasa_lactica,
		       @Param("hemoglobina") String hemoglobina,
		       @Param("hematocrito") String hematocrito,
		       @Param("leucocitos") String leucocitos,
		       @Param("linfocitos") String linfocitos,
		       @Param("neutrofilos") String neutrofilos,
		       @Param("plaquetas") String platelets,
		       @Param("igg") String igg,
		       @Param("iga") String iga,
		       @Param("igm") String igm,
		       @Param("cadenas_ligeras_kappa") String cadenas_ligeras_kappa,
		       @Param("cadenas_ligeras_lambda") String cadenas_ligeras_lambda,
		       @Param("cel_plasmatic_en_medula_osea") String cel_plasmatic_en_medula_osea,
		       @Param("electro_foresis_de_proteinas_suero") String electro_foresis_de_proteinas_suero,
		       @Param("electro_foresis_de_proteinas_orina") String electro_foresis_de_proteinas_orina,
		       @Param("inm_fijacion_tipo_ig") String inm_fijacion_tipo_ig,
		       @Param("inm_fijacion_tipo_cll") String inm_fijacion_tipo_cll,
		       @Param("enfermedad_minima_residual") String enfermedad_minima_residual,
		       @Param("repuestaatratamiento") String repuestaatratamiento,
		       @Param("comentarios_extrax") String comentarios_extrax,
		       @Param("fecha_de_trasplante") String fecha_de_trasplante,
		       @Param("numcd34infundidas") String numcd34infundidas,
		       @Param("fecha_injerto_mieloide") String fecha_injerto_mieloide,
		       @Param("fecha_injerto_plaquetario") String fecha_injerto_plaquetario,
		       @Param("toxicidades") String toxicidades
			);
	
	@Modifying
	@Query(value = "UPDATE consulta_final cf SET "
			+ "cf.fecha_realizacion = :fecha_realizacion,"
			+ "cf.albumina = :albumina,"
			+ "cf.calcio_serico = :calcio_serico,"
			+ "cf.deshidrogenasa_lactica = :deshidrogenasa_lactica,"
			+ "cf.hemoglobina = :hemoglobina,"
			+ "cf.hematocrito = :hematocrito,"
			+ "cf.leucocitos = :leucocitos,"
			+ "cf.linfocitos = :linfocitos,"
			+ "cf.neutrofilos = :neutrofilos,"
			+ "cf.plaquetas = :plaquetas,"
			+ "cf.igg = :igg,"
			+ "cf.iga = :iga,"
			+ "cf.igm = :igm,"
			+ "cf.cadenas_ligeras_kappa = :cadenas_ligeras_kappa,"
			+ "cf.cadenas_ligeras_lambda = :cadenas_ligeras_lambda,"
			+ "cf.cel_plasmatic_en_medula_osea = :cel_plasmatic_en_medula_osea,"
			+ "cf.electro_foresis_de_proteinas_suero = :electro_foresis_de_proteinas_suero,"
			+ "cf.electro_foresis_de_proteinas_orina = :electro_foresis_de_proteinas_orina,"
			+ "cf.inm_fijacion_tipo_ig = :inm_fijacion_tipo_ig,"
			+ "cf.inm_fijacion_tipo_cll = :inm_fijacion_tipo_cll,"
			+ "cf.enfermedad_minima_residual = :enfermedad_minima_residual,"
			+ "cf.repuestaatratamiento = :repuestaatratamiento,"
			+ "cf.comentarios_extrax = :comentarios_extrax "
			+ "WHERE cf.idpaciente = :idpatient", nativeQuery=true
			)
	void updateFinalConsultWithoutNewVariables(
			   @Param("idpatient") Integer idpatient,
		       @Param("fecha_realizacion") String fecha_realizacion,
		       @Param("albumina") String albumina,
		       @Param("calcio_serico") String calcio_serico,
		       @Param("deshidrogenasa_lactica") String deshidrogenasa_lactica,
		       @Param("hemoglobina") String hemoglobina,
		       @Param("hematocrito") String hematocrito,
		       @Param("leucocitos") String leucocitos,
		       @Param("linfocitos") String linfocitos,
		       @Param("neutrofilos") String neutrofilos,
		       @Param("plaquetas") String platelets,
		       @Param("igg") String igg,
		       @Param("iga") String iga,
		       @Param("igm") String igm,
		       @Param("cadenas_ligeras_kappa") String cadenas_ligeras_kappa,
		       @Param("cadenas_ligeras_lambda") String cadenas_ligeras_lambda,
		       @Param("cel_plasmatic_en_medula_osea") String cel_plasmatic_en_medula_osea,
		       @Param("electro_foresis_de_proteinas_suero") String electro_foresis_de_proteinas_suero,
		       @Param("electro_foresis_de_proteinas_orina") String electro_foresis_de_proteinas_orina,
		       @Param("inm_fijacion_tipo_ig") String inm_fijacion_tipo_ig,
		       @Param("inm_fijacion_tipo_cll") String inm_fijacion_tipo_cll,
		       @Param("enfermedad_minima_residual") String enfermedad_minima_residual,
		       @Param("repuestaatratamiento") String repuestaatratamiento,
		       @Param("comentarios_extrax") String comentarios_extrax
		      
			);


}