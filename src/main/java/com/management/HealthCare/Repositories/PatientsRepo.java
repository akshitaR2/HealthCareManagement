package com.management.HealthCare.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.management.HealthCare.Entities.MedicalRecords;
import com.management.HealthCare.Entities.Patients;
import com.management.HealthCare.Models.PatientsDTO;

@Repository
public interface PatientsRepo extends JpaRepository<Patients, String>{



	Patients findByPatientId(String patient_id);

	@Query(value = "select p.* from patients_list p LEFT JOIN appointments a ON p.sno = a.patient_Id where a.status = 'closed'",nativeQuery = true)
	Patients findByPatientIdAndStatus(@Param("patient_id") String patient_id,@Param("status") String status);
	boolean existsByPatientId(String patient_id);
	List<MedicalRecords> findMedicalRecordsByPatientId(String patientId);

	
}
