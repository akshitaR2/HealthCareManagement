package com.management.HealthCare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.HealthCare.Entities.MedicalRecords;

@Repository
public interface MedicalRecordsRepo extends JpaRepository<MedicalRecords, Integer>{

}
