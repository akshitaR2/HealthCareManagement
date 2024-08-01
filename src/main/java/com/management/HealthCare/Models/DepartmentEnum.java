package com.management.HealthCare.Models;

	public enum DepartmentEnum {
	    CARDIOLOGY(1, "Cardiology"),
	    NEUROLOGY(2, "Neurology"),
	    ORTHOPEDICS(3, "Orthopedics"),
	    PEDIATRICS(4, "Pediatrics"),
	    GENERAL_MEDICINE(5, "General Medicine");

	    private final int id;
	    private final String displayName;

	    DepartmentEnum(int id, String displayName) {
	        this.id = id;
	        this.displayName = displayName;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getDisplayName() {
	        return displayName;
	    }

	    public static DepartmentEnum fromId(int id) {
	        for (DepartmentEnum department : values()) {
	            if (department.getId() == id) {
	                return department;
	            }
	        }
	        throw new IllegalArgumentException("No department with id " + id);
	    }

	    public static DepartmentEnum fromDisplayName(String displayName) {
	        for (DepartmentEnum department : values()) {
	            if (department.getDisplayName().equalsIgnoreCase(displayName)) {
	                return department;
	            }
	        }
	        throw new IllegalArgumentException("No department with display name " + displayName);
	    }
	}
