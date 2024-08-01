package com.management.HealthCare.Service;

import com.management.HealthCare.Models.DoctorsDTO;
import com.management.HealthCare.Models.PatientsDTO;
import com.management.HealthCare.Models.RegisterDTO;

public interface StaffRegisterService {

	String addDoctor(DoctorsDTO dto);

	Boolean addPatient(PatientsDTO dto);

	Boolean addUser(RegisterDTO dto);

}
