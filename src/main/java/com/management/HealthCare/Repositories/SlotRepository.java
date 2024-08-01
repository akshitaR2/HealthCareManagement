//package com.management.HealthCare.Repositories;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.management.HealthCare.Entities.Slots;
//
//@Repository
//public interface SlotRepository extends JpaRepository<Slots, Integer>{
//
//	List<Slots> findAllByIdEntityAndDateRange(Long idEntityId, LocalDate startDate, LocalDate plusDays);
//
//	List<Slots> findAllByIdEntityAndDateAndIsAvailable(String doctorId, LocalDate date, boolean b);
//
////	 List<Slots> findAllByIdEntityAndDateAndIsAvailable(Long idEntityId, LocalDate date, boolean isAvailable);
//	
////	 @Query("SELECT s FROM Slot s WHERE s.idEntity.id IN :ids AND s.isAvailable = :isAvailable")
////	    List<Slot> findAllByIdEntitiesAndAvailability(@Param("ids") List<Long> ids, @Param("isAvailable") boolean isAvailable);
////	    
////	    // Optionally, if you need to filter by date range as well:
////	    @Query("SELECT s FROM Slot s WHERE s.idEntity.id IN :ids AND s.isAvailable = :isAvailable AND s.date BETWEEN :startDate AND :endDate")
////	    List<Slot> findAllByIdEntitiesAndAvailabilityAndDateRange(
////	        @Param("ids") List<Long> ids, 
////	        @Param("isAvailable") boolean isAvailable,
////	        @Param("startDate") LocalDate startDate,
////	        @Param("endDate") LocalDate endDate
////	    );
//
//}
