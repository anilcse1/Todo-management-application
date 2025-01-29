package in.vtech.springboot.web.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

// @Controller
// @SessionAttributes("name")
public class LoginController {

//	private AuthenticationService authenticationService;
//
//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}

//	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// /login => LoginController => login1.jsp

	// http://localhost:8081/login
//	@RequestMapping("/login")
//	public String gotoLoginPage() {
//		return "login1";
//	}

	// http://localhost:8081/login?name=Suraj
//	@RequestMapping("/login")
//	public String gotoLoginPage(@RequestParam String name) {
//		// NOT RECOMMENDED FOR PRODUCTION CODE
//		System.out.println("Request param is: " + name);
//		return "login1";
//	}

	// Model // EL
	// http://localhost:8081/login?name=Suraj
//	@RequestMapping("/login")
//	public String gotoLoginPage(@RequestParam String name, ModelMap model) {
//		// NOT RECOMMENDED FOR PRODUCTION CODE
//		// System.out.println("Request param is: " + name);
//
//		model.put("name", name);
//
////		logger.debug("Request param is: " + name);
////		logger.info("I want this printed at info level");
////		logger.warn("I want this printed at warn level");
//
//		return "login2";
//	}

	// http://localhost:8081/login?name=Suraj&password=123
//	@RequestMapping("/login")
//	public String gotoLoginPage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		// NOT RECOMMENDED FOR PRODUCTION CODE
//		// System.out.println("Request param is: " + name);
//		// System.out.println("Request param is: " + password);
//
//		model.put("name", name);
//		model.put("password", password);
//
//		return "login3";
//	}

	// http://localhost:8081/login
//	@RequestMapping("/login")
//	public String gotoLoginPage() {
//		return "login4";
//	}

	// http://localhost:8081/login
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String gotoLoginPage() {
//		return "login";
//	}

	// This code has been moved to WelcomeController.java
	// GET REQUEST
	// http://localhost:8081/
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String gotoWelcomePage() {
//		return "welcome";
//	}

	// http://localhost:8081/login
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		// Authentication
//		// name - vtech // password - 123
//
//		if (authenticationService.authenticate(name, password)) {
//			model.put("name", name);
//			model.put("password", password);
//			return "welcome";
//		} else {
//			model.put("errorMessage", "Invalid Credentials! Please try again.");
//			return "login";
//		}
//
//	}

}
