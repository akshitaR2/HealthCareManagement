package com.management.HealthCare.Service;

import java.util.List;

import com.management.HealthCare.Entities.MedicalRecords;
import com.management.HealthCare.Models.MedicalRecordsDTO;
import com.management.HealthCare.Models.PatientsDTO;

public interface Patientservice {

	PatientsDTO getPatientInfo(String patient_id);

	List<MedicalRecordsDTO> getMedicalRecords(String patientId);

	


	
}
