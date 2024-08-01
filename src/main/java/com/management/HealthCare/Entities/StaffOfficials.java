package com.management.HealthCare.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "staff_details")
public class StaffOfficials {
	private int staff_id;
	private String first_name;
	private String last_name;
	private String role;
	private String contact_info;
	private String department_id;
	private String hire_date;
}
