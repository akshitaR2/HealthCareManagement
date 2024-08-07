package com.management.HealthCare.ServiceImpls;

import java.time.DayOfWeek;
//import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.HealthCare.Entities.Appointements;
import com.management.HealthCare.Entities.Doctors;
import com.management.HealthCare.Entities.MedicalRecords;
import com.management.HealthCare.Entities.Patients;
import com.management.HealthCare.Mappers.MapperConfig;
import com.management.HealthCare.Models.AppointmentDTO;
import com.management.HealthCare.Models.MedicalRecordsDTO;
import com.management.HealthCare.Repositories.AppointementRepo;
import com.management.HealthCare.Repositories.DoctorsRepo;
import com.management.HealthCare.Repositories.MedicalRecordsRepo;
import com.management.HealthCare.Repositories.PatientsRepo;
import com.management.HealthCare.Repositories.UserRepo;
//import com.management.HealthCare.SecuredLogin.Repository.UserRepo;
import com.management.HealthCare.Service.AppointmentService;

import org.springframework.transaction.annotation.Transactional;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	PatientsRepo patRepo;
	
	@Autowired
	AppointementRepo appRepo;
	
	@Autowired
	DoctorsRepo docRepo;
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	MapperConfig mapper;
	
	@Autowired
	MedicalRecordsRepo medRepo;
	
//	 private static final int MAX_TIME_OF_SLOT = 30; // Define slot duration in minutes
//	 private static final Duration SLOT_DURATION = Duration.ofMinutes(MAX_TIME_OF_SLOT);
	private static final int SLOT_DURATION_IN_MINUTES =30;
	private static final int MAX_DAYS_TO_CHECK = 30;

	
	

	@Override
	@Transactional
	public AppointmentDTO bookAppointment(AppointmentDTO dto) {
		try {
		Patients patEntity= patRepo.findByPatientId(dto.getPatientId());
		List<Doctors> docIds= docRepo.findAllByDepartmentAndLocation(dto.getDepartment(),dto.getLocation());
		Optional<Map.Entry<Doctors, LocalDateTime>> firstEntry = getAvailableSlotsForDoc(docIds).entrySet().stream().findFirst();
		Doctors doc=firstEntry.get().getKey();
			Appointements createAppointment= new Appointements();
			createAppointment.setPatient(patEntity);
			createAppointment.setDoctor(doc);
			createAppointment.setStartTime(firstEntry.get().getValue());
			createAppointment.setEndTime(firstEntry.get().getValue().plusMinutes(SLOT_DURATION_IN_MINUTES));
			createAppointment.setReason(dto.getReason());
			createAppointment.setStatus("open");
		appRepo.save(createAppointment);
		dto.setDoctorAddress(doc.getAddress());
		dto.setDoctorName(doc.getDocName());
		dto.setStartdate(firstEntry.get().getValue());
		dto.setStatus("open");
		dto.setPatients_contact_info(patEntity.getContact_info());
		dto.setPatients_name(patEntity.getPatientName());
		return dto;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	
	private Map<Doctors, LocalDateTime> getAvailableSlotsForDoc(List<Doctors> docIds) {
	 LocalDate today = LocalDate.now();
	 Map<Doctors,LocalDateTime> availableSlots= new HashMap<Doctors, LocalDateTime>();
	 for(Doctors doc:docIds) {
		 boolean foundAvailableSlot=false;
        LocalDate dateToCheck = today;

		 List<Appointements> appointments= doc.getAppointements();
		 if(appointments.isEmpty()) {
			 availableSlots.put(doc, calculatePotentialSlots(doc.getWorkStartTime(), doc.getWorkEndTime(), today.plusDays(2), SLOT_DURATION_IN_MINUTES).get(0));
			 break;
		 }
        
		 while(!foundAvailableSlot && !dateToCheck.isAfter(today.plusDays(MAX_DAYS_TO_CHECK)) ) {
			 if (dateToCheck.getDayOfWeek() != DayOfWeek.SATURDAY && dateToCheck.getDayOfWeek() != DayOfWeek.SUNDAY) {
			 
	            Set<LocalTime> bookedSlots = appointments.stream().filter(app->app.getStatus().matches("open"))
	                    .map(appointment -> appointment.getStartTime().toLocalTime())
	                    .collect(Collectors.toSet());
			 
	         // Use a PriorityQueue to store and access potential slots efficiently
               PriorityQueue<LocalDateTime> potentialSlots = new PriorityQueue<>(calculatePotentialSlots(
                   doc.getWorkStartTime(), doc.getWorkEndTime(),dateToCheck, SLOT_DURATION_IN_MINUTES
               ));
            // Remove booked slots from the PriorityQueue
               potentialSlots.removeAll(bookedSlots);
               
               // Check for available slot
               if (!potentialSlots.isEmpty()) {
               	availableSlots.put(doc, potentialSlots.peek()); // Get the earliest available slot
                   foundAvailableSlot = true;
               } else {
                   // Move to the next day
                   dateToCheck = dateToCheck.plusDays(1);
               }
		 
		 }
	 }
	 }
	
	return availableSlots;
}


private List<LocalDateTime> calculatePotentialSlots(LocalTime workStartTime, LocalTime workEndTime, LocalDate date, int slotDuration) {
       List<LocalDateTime> slots = new ArrayList<>();
       LocalDateTime currentSlotStart = LocalDateTime.of(date, workStartTime);

       while (currentSlotStart.toLocalTime().isBefore(workEndTime)) {
           slots.add(currentSlotStart);
           currentSlotStart = currentSlotStart.plusMinutes(slotDuration);
       }

       return slots;
   } 
	

//--------------------------------- actual code since duration was throwing error above is modified -------------
//	private Map<Doctors, LocalDateTime> getAvailableSlotsForDoc(List<Doctors> docIds) {
//		 LocalDate today = LocalDate.now();
//		 Map<Doctors,LocalDateTime> availableSlots= new HashMap<Doctors, LocalDateTime>();
//		 for(Doctors doc:docIds) {
//			 boolean foundAvailableSlot=false;
//	         LocalDate dateToCheck = today;
//
//			 List<Appointements> appointments= doc.getAppointements();
//			 if(appointments.isEmpty()) {
//				 availableSlots.put(doc, calculatePotentialSlots(doc.getWorkStartTime(), doc.getWorkEndTime(), today.plusDays(2), SLOT_DURATION).get(0));
//				 break;
//			 }
//	         
//			 while(!foundAvailableSlot && !dateToCheck.isAfter(today.plusDays(MAX_DAYS_TO_CHECK)) ) {
//				 if (dateToCheck.getDayOfWeek() != DayOfWeek.SATURDAY && dateToCheck.getDayOfWeek() != DayOfWeek.SUNDAY) {
//				 
//		            Set<LocalTime> bookedSlots = appointments.stream().filter(app->app.getStatus().matches("open"))
//		                    .map(appointment -> appointment.getStartTime().toLocalTime())
//		                    .collect(Collectors.toSet());
//				 
//		         // Use a PriorityQueue to store and access potential slots efficiently
//	                PriorityQueue<LocalDateTime> potentialSlots = new PriorityQueue<>(calculatePotentialSlots(
//	                    doc.getWorkStartTime(), doc.getWorkEndTime(),dateToCheck, SLOT_DURATION
//	                ));
//	             // Remove booked slots from the PriorityQueue
//	                potentialSlots.removeAll(bookedSlots);
//	                
//	                // Check for available slot
//	                if (!potentialSlots.isEmpty()) {
//	                	availableSlots.put(doc, potentialSlots.peek()); // Get the earliest available slot
//	                    foundAvailableSlot = true;
//	                } else {
//	                    // Move to the next day
//	                    dateToCheck = dateToCheck.plusDays(1);
//	                }
//			 
//			 }
//		 }
//		 }
//		
//		return availableSlots;
//	}
//
//	
//	 private List<LocalDateTime> calculatePotentialSlots(LocalTime workStartTime, LocalTime workEndTime, LocalDate date, Duration slotDuration) {
//	        List<LocalDateTime> slots = new ArrayList<>();
//	        LocalDateTime currentSlotStart = LocalDateTime.of(date, workStartTime);
//
//	        while (currentSlotStart.toLocalTime().isBefore(workEndTime)) {
//	            slots.add(currentSlotStart);
//	            currentSlotStart = currentSlotStart.plus(slotDuration);
//	        }
//
//	        return slots;
//	    } 

	@Override
	public String cancelAppointment(int id) {
		
		Appointements app=appRepo.findById(id).get();
		app.setStatus("cancel");
		appRepo.save(app);
			return "Appointment is cancelled ";
		
	}
	
	@Override
	@Transactional
	public String  updateStatus(MedicalRecordsDTO dto) {
		Appointements app=appRepo.findById(dto.getAppointementId()).get();
		app.setStatus(dto.getStatus());
		MedicalRecords medRecords= new MedicalRecords();
		medRecords.setDiagnosis(dto.getDiagnosis());
		medRecords.setDoctor(app.getDoctor());
		medRecords.setNotes(dto.getNotes());
		medRecords.setPatient(app.getPatient());
		medRecords.setPrescriptions(dto.getPrescriptions());
		medRecords.setTreatment(dto.getTreatment());
		medRecords.setStatus(dto.getStatus());
		medRecords.setVisit_date(app.getStartTime());
		medRepo.save(medRecords);
		appRepo.save(app);
		
		return "medical records updated and appointment closed";
		
	}
   
//-------------------------------- NEW TRY USING APPOINT ENTITY--------------------------------------
	@Override
	public List<AppointmentDTO> getPatientAppointments(String patient_id) {
		List<AppointmentDTO> appoitmentsLists=new ArrayList<AppointmentDTO>(); 
		Optional<List<Appointements>> appointments=Optional.ofNullable(appRepo.findAllByPatientId(patient_id));
		appointments.ifPresent(appointment->{
			appointment.forEach(app->appoitmentsLists.add(mapper.AppointementEntitytoDTO(app)));
		});
		return appoitmentsLists;
	}
	

	@Override
	public List<AppointmentDTO> getDoctorsAppointments(String doctors_id) {
		  List<AppointmentDTO> appoitmentsLists=new ArrayList<AppointmentDTO>(); 
		  Optional<List<Appointements>> appointments=Optional.ofNullable(appRepo.findAllByDoctorId(doctors_id));
			appointments.ifPresent(appointment->{
				appointment.forEach(app->appoitmentsLists.add(mapper.AppointementEntitytoDocAppDto(app)));
			});	                
		      	
		return appoitmentsLists;
	}

	@Override
	public List<AppointmentDTO> getPatientPastAppointments(String patient_id, String status) {
		List<AppointmentDTO> appoitmentsLists=new ArrayList<AppointmentDTO>(); 
		Optional<List<Appointements>> appointments=Optional.ofNullable(appRepo.findAllByPatientIdAndStatus(patient_id,status));
		appointments.ifPresent(appointment->{
			appointment.forEach(app->appoitmentsLists.add(mapper.AppointementEntitytoDTO(app)));
		});
		return appoitmentsLists;
	}
	
//	-------------------------------------------- END OF THIS -------------------------------------------------------
	
}
