package com.management.HealthCare.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.management.HealthCare.Entities.Doctors;
import com.management.HealthCare.Entities.MedicalRecords;

@Repository
public interface DoctorsRepo extends JpaRepository<Doctors,String> {



	@Query(value = "SELECT d.* FROM doctors_list d LEFT JOIN appointements a ON d.doctor_Unique_Id = a.doctor_Id WHERE a.status = 'open' AND d.department = :department AND d.location = :location", nativeQuery = true)
	List<Doctors> findAllByDepartmentAndLocationANDStatus(@Param("department") String department,@Param("location") String location);

	List<Doctors> findAllByDepartmentAndLocation(String department,String location);
	Doctors  findByDoctorId(String doctors_id);

	List<MedicalRecords> findMedicalRecordsByDoctorId(String id);


//	@Query(value = "SELECT d.* FROM doctors d LEFT JOIN appointments a ON d.doctorId = a.doctorId AND a.appointment_date = :appointment_date WHERE a.id IS NULL AND d.department = :department AND d.city = :city", nativeQuery = true)
//	List<Doctors> findAvailableDoctors(@Param("date") LocalDate date,@Param("department") String department,@Param("city") String city);
}
