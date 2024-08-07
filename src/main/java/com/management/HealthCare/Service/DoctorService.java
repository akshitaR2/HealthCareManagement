package com.management.HealthCare.Service;

import java.util.List;

import com.management.HealthCare.Models.DoctorsDTO;
import com.management.HealthCare.Models.MedicalRecordsDTO;

public interface DoctorService {

	DoctorsDTO getDoctorsInfo(String id);

	List<MedicalRecordsDTO> getMedicalRecords(String id);

}
