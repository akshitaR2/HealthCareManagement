package com.management.HealthCare.Mappers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.management.HealthCare.Entities.Appointements;
import com.management.HealthCare.Entities.Doctors;
import com.management.HealthCare.Entities.MedicalRecords;
import com.management.HealthCare.Entities.Patients;
import com.management.HealthCare.Entities.Role;
import com.management.HealthCare.Entities.User;
import com.management.HealthCare.Models.AppointmentDTO;
import com.management.HealthCare.Models.DoctorsDTO;
import com.management.HealthCare.Models.MedicalRecordsDTO;
import com.management.HealthCare.Models.PatientsDTO;
import com.management.HealthCare.Models.RegisterDTO;
import com.management.HealthCare.Models.UserDto;
import com.management.HealthCare.Repositories.RolesRepo;
//import com.management.HealthCare.SecuredLogin.Models.Role;
//import com.management.HealthCare.SecuredLogin.Models.User;
//import com.management.HealthCare.SecuredLogin.Repository.RoleRepo;

@Component
public class MapperConfig {
	 private static ModelMapper modelMapper = new ModelMapper();
	 @Autowired
	 RolesRepo roleRepo;
	 
	 @Autowired
		PasswordEncoder encoder;
	
	 private Set<Role> roles(String roles){
		 
		 
		 
		 Set<Role> r= new HashSet<Role>();
		Arrays.stream(roles.split(",")).forEach(role->{
			Role userrole=roleRepo.findByAuthority(role).get();
			r.add(userrole);
		});
		return r;
	 }
		
//	 public List<PatientsDTO> patientsEntityMapToDtoList(List<Patients> patients) {	
//			return patients.stream().map(info->modelMapper.map(info,PatientsDTO.class))
//					.collect(Collectors.toList());
//		}
//		
		  public PatientsDTO patientsEntitytoDto(Patients entity) {
		    	return modelMapper.map(entity, PatientsDTO.class);
		    }
//
		    public Patients patientsDTOtoEntity(PatientsDTO dto) {
		    	return modelMapper.map(dto, Patients.class);
		    }
//		
		  public DoctorsDTO doctorsEntitytoDto(Doctors entity) {
		    	return modelMapper.map(entity, DoctorsDTO.class);

		    }

		    public Doctors doctorsDTOtoEntity(DoctorsDTO dto) {
		    	
		    	return modelMapper.map(dto,Doctors.class);
		    }
	
//		    public UserDto userEntitytoDto(User entity) {
//		    	UserDto dto = new UserDto();
//		        dto.setUsername(entity.getUsername());
////		        dto.setEmailId(entity.getEmailId());
////		        dto.setUniqueId(entity.getUsername());
//		        return dto;
//		    }
		    
		    public AppointmentDTO AppointementEntitytoDTO(Appointements entity) {
		    	AppointmentDTO dto=new AppointmentDTO();
		    	dto.setDoctorAddress(entity.getDoctor().getAddress());
				dto.setDoctorName(entity.getDoctor().getDocName());
				dto.setStartdate(entity.getStartTime());
				dto.setStatus(entity.getStatus());
				dto.setReason(entity.getReason());
				dto.setStatus(entity.getStatus());
				dto.setAppointmentId(entity.getId());
		    	return dto;

		    }
		    
		    public AppointmentDTO AppointementEntitytoDocAppDto(Appointements entity) {
		    	AppointmentDTO dto=new AppointmentDTO();
		    	dto.setPatientId(entity.getPatient().getPatientId());
//		    	dto.setPatient_address(entity.getPatient().getAddress());
		    	dto.setPatients_name(entity.getPatient().getPatientName());
		    	dto.setReason(entity.getReason());
		    	dto.setStatus(entity.getStatus());
		    	dto.setStartdate(entity.getStartTime());
		    	dto.setPatients_contact_info(entity.getPatient().getContact_info());
		    	dto.setAppointmentId(entity.getId());
		    	return dto;

		    }
		    
		    public User getUser(RegisterDTO dto) {
				 User entity = new User();
			    	entity.setEmailId(dto.getEmailId());
			    	entity.setPassword(encoder.encode(dto.getPassword()));
			    	entity.setUniqueId(dto.getUniqueId());
			    	entity.setUsername(dto.getUsername());
			    	entity.setAuthorities(roles(dto.getRole()));
//			    	entity.setRole(dto.getRole());
			        return entity; 
			 }


			public User getUserFromPatientDto(PatientsDTO dto) {
				User entity = new User();
		    	entity.setEmailId(dto.getEmailId());
		    	entity.setPassword(encoder.encode(dto.getPassword()));
		    	entity.setUniqueId(dto.getPatientId());
		    	entity.setUsername(dto.getUsername());
		    	entity.setAuthorities(roles(dto.getRole()));
//		    	entity.setRole(dto.getRole());
		        return entity; 
			}


			public User getUserFromDoctorDto(DoctorsDTO dto) {
				User entity = new User();
		    	entity.setEmailId(dto.getEmailId());
		    	entity.setPassword(encoder.encode(dto.getPassword()));
		    	entity.setUniqueId(dto.getDoctorId());
		    	entity.setUsername(dto.getUsername());
		    	entity.setAuthorities(roles(dto.getRole()));
//		    	entity.setRole(dto.getRole());
		        return entity; 
			}

			public MedicalRecordsDTO getMedRecordsDto(MedicalRecords record) {
				MedicalRecordsDTO dto=new MedicalRecordsDTO();
				dto.setDoctorsName(record.getDoctor().getDocName());
				dto.setDiagnosis(record.getDiagnosis());
				dto.setNotes(record.getNotes());
				dto.setPrescriptions(record.getPrescriptions());
				dto.setTreatment(dto.getTreatment());
				dto.setStatus(dto.getStatus());
				dto.setVisitDate(record.getVisit_date().toString());
				return null;
			}



//			public Patients getPatientEntity(PatientsDTO dto) {
//				// TODO Auto-generated method stub
//				return null;
//			}
		    
	
		  
}
