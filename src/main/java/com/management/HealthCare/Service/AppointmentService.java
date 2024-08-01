package com.management.HealthCare.Service;

import java.util.List;

import com.management.HealthCare.Models.AppointmentDTO;

public interface AppointmentService {

	AppointmentDTO bookAppointment(AppointmentDTO dto);

//	String bookAppointment(String patient_id, String specialty, String city);


	List<AppointmentDTO> getPatientAppointments(String patient_id);

	List<AppointmentDTO> getDoctorsAppointments(String doctors_id);

	List<AppointmentDTO> getPatientPastRecords(String patient_id, String status);

	String updateAppointment(String id, String status);


}
