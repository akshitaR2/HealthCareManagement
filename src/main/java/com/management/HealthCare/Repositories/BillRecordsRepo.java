package com.management.HealthCare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.HealthCare.Entities.BillRecords;

@Repository
public interface BillRecordsRepo extends JpaRepository<BillRecords, Integer> {

}
