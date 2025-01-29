package in.vtech.springboot.web.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username, String password) {
		boolean isValidUsername = username.equalsIgnoreCase("vtech");
		boolean isValidPassword = password.equalsIgnoreCase("123");
		return isValidUsername && isValidPassword;
	}

}
