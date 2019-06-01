package mx.ipn.cic.biblioteca.AdminControl.repositories;

import mx.ipn.cic.biblioteca.AdminControl.model.PatientModel;
import mx.ipn.cic.biblioteca.AdminControl.services.PatientService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.cic.biblioteca.AdminControl.model.MonthlyConsultation;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface IMonthlyConsultationRepository extends JpaRepository<MonthlyConsultation, Integer>{
    LinkedList<MonthlyConsultation> findByIdpatientIn(PatientModel patientModel);
    
	@Modifying
	@Query(value = "UPDATE consulta_mensual cm SET "
			+ "cm.fecha_realizacion = :fecha_realizacion,"
			+ "cm.albumina = :albumina,"
			+ "cm.calcio_serico = :calcio_serico,"
			+ "cm.deshidrogenasa_lactica = :deshidrogenasa_lactica,"
			+ "cm.hemoglobina = :hemoglobina,"
			+ "cm.hematocrito = :hematocrito,"
			+ "cm.leucocitos = :leucocitos,"
			+ "cm.linfocitos = :linfocitos,"
			+ "cm.neutrofilos = :neutrofilos,"
			+ "cm.plaquetas = :plaquetas,"
			+ "cm.igg = :igg,"
			+ "cm.iga = :iga,"
			+ "cm.igm = :igm,"
			+ "cm.cadenas_ligeras_kappa = :cadenas_ligeras_kappa,"
			+ "cm.cadenas_ligeras_lambda = :cadenas_ligeras_lambda,"
			+ "cm.tox_hemto_serie_roja= :tox_hemto_serie_roja,"
			+ "cm.tox_hemto_neutrofilos= :tox_hemto_neutrofilos,"
			+ "cm.tox_hemto_plaquetas= :tox_hemto_plaquetas,"
			+ "cm.tox_hepatics= :tox_hepatics,"
			+ "cm.tox_renal= :tox_renal,"
			+ "cm.tox_gastro_nausea= :tox_gastro_nausea,"
			+ "cm.tox_gasto_diarrea= :tox_gasto_diarrea,"
			+ "cm.tox_neuroatia_perif= :tox_neuroatia_perif,"
			+ "cm.tox_infecciosa= :tox_infecciosa,"
			+ "cm.sitio_infeccion= :sitio_infeccion,"
			+ "cm.reac_infucionde_medic= :reac_infucionde_medic,"
			+ "cm.reccion_adversa= :reccion_adversa"
		    + " WHERE cm.num_ciclo_tratamiento = :num_ciclo_tratamiento AND"
		    + " cm.idpaciente =:idpaciente", nativeQuery=true
			)
	void updateMonthlyConsult(
			   @Param("num_ciclo_tratamiento") String num_ciclo_tratamiento,
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
		       @Param("tox_hemto_serie_roja") String tox_hemto_serie_roja,
		       @Param("tox_hemto_neutrofilos") String tox_hemto_neutrofilos,
		       @Param("tox_hemto_plaquetas") String tox_hemto_plaquetas,
		       @Param("tox_hepatics") String tox_hepatics,
		       @Param("tox_renal") String tox_renal,
		       @Param("tox_gastro_nausea") String tox_gastro_nausea,
		       @Param("tox_gasto_diarrea") String tox_gasto_diarrea,
		       @Param("tox_neuroatia_perif") String tox_neuroatia_perif,
		       @Param("tox_infecciosa") String tox_infecciosa,
		       @Param("sitio_infeccion") String sitio_infeccion,
		       @Param("reac_infucionde_medic") String reac_infucionde_medic,
		       @Param("reccion_adversa") String reccion_adversa,
		       @Param("idpaciente") Integer idpaciente 
			);
}