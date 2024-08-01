package com.management.HealthCare.Service;

import com.management.HealthCare.Models.LoginDTO;
import com.management.HealthCare.Models.RegisterDTO;

public interface AuthService {

	String registerUser(RegisterDTO dto);

	String loginUser(LoginDTO dto);

}
