package com.management.HealthCare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.HealthCare.Entities.AuditLogs;

@Repository
public interface AuditLogRepo extends JpaRepository<AuditLogs, Integer>{

}
