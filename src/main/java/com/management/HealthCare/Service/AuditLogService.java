package com.management.HealthCare.Service;

import java.security.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.HealthCare.Entities.AuditLogs;
import com.management.HealthCare.Repositories.AuditLogRepo;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepo auditLogRepository;

    public void logAction(String tables, String columns, String action, String details,
			 String userID) {
        AuditLogs auditLog = new AuditLogs(tables,  columns,  action,  details, userID);
        auditLogRepository.save(auditLog);
    }


}

