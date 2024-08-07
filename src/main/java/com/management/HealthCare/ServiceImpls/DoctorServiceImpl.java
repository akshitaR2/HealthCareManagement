package com.management.HealthCare.ServiceImpls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.HealthCare.Entities.MedicalRecords;
import com.management.HealthCare.Mappers.MapperConfig;
import com.management.HealthCare.Models.DoctorsDTO;
import com.management.HealthCare.Models.MedicalRecordsDTO;
import com.management.HealthCare.Repositories.DoctorsRepo;
import com.management.HealthCare.Service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	DoctorsRepo repo;
	
	@Autowired
	MapperConfig mapper;
	
	
	@Override
	public DoctorsDTO getDoctorsInfo(String id) {
	DoctorsDTO dto= mapper.doctorsEntitytoDto(repo.findByDoctorId(id));
		return dto;
	}

	@Override
	public List<MedicalRecordsDTO> getMedicalRecords(String id) {
		List<MedicalRecords> medRecords=repo.findMedicalRecordsByDoctorId(id);
		List<MedicalRecordsDTO> medDtoRecords = new ArrayList<MedicalRecordsDTO>(); ;
		medRecords.stream().forEach(record->{
			medDtoRecords.add(mapper.getMedRecordsDto(record));
		});
			return medDtoRecords;
		}

}
