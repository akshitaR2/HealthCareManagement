package com.management.HealthCare.ServiceImpls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.management.HealthCare.Entities.Doctors;
import com.management.HealthCare.Entities.Patients;
import com.management.HealthCare.Entities.User;
import com.management.HealthCare.Mappers.MapperConfig;
import com.management.HealthCare.Models.DoctorsDTO;
import com.management.HealthCare.Models.PatientsDTO;
import com.management.HealthCare.Models.RegisterDTO;
import com.management.HealthCare.Models.UserDto;
import com.management.HealthCare.Repositories.DoctorsRepo;
import com.management.HealthCare.Repositories.PatientsRepo;
import com.management.HealthCare.Repositories.UserRepo;
import com.management.HealthCare.Service.AuditLogService;
import com.management.HealthCare.Service.StaffRegisterService;

@Service
public class StaffRegisterServiceImpl implements StaffRegisterService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AuditLogService auditService;

	@Autowired
	MapperConfig mapper;
	
	@Autowired
	PatientsRepo patRepo;

	@Autowired
	DoctorsRepo doctorsRepo;


	private static final Logger logger = LoggerFactory.getLogger(StaffRegisterServiceImpl.class);
	
	
	@Override
	@Transactional
	public String addDoctor(DoctorsDTO dto) {
		if (userRepo.existsByUniqueId(dto.getDoctorId()))
			return "already exists";
				userRepo.save(mapper.getUserFromDoctorDto(dto));
				Doctors doc=mapper.doctorsDTOtoEntity(dto);
				doctorsRepo.save(doc);
				auditService.logAction("user,doctor", "entity", "add",null,"userid");
				logger.info("new user added - doctor");
				return "Doctor details added";
		
	}

	@Override
	@Transactional
	public Boolean addPatient(PatientsDTO dto) {
				if (userRepo.existsByUniqueId(dto.getPatientId()))
					return false;
				
					User entity = mapper.getUserFromPatientDto(dto);
					Patients patients= mapper.patientsDTOtoEntity(dto);
					userRepo.save(entity);
					patRepo.save(patients);
					auditService.logAction("user,doctor", "entity", "add",null,"userid");
					logger.info("new user added -patient");
					return true;
				
		
	}

	@Override
	public Boolean addUser(RegisterDTO dto) {
			if (userRepo.existsByUniqueId(dto.getUniqueId())) {
				logger.info("register user declines since user already exist");
				return false;
			}
				User entity = mapper.getUser(dto);
				userRepo.save(entity);
				auditService.logAction("user", "entity", "add",null,"userid");
				logger.info("new user added ");
				return true;
		
	}
	
	
	

}
