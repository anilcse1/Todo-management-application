package in.vtech.springboot.web.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	// LDAP or Database
	// In Memory

	// InMemoryUserDetailsManager
	// InMemoryUserDetailsManager(UserDetails... users)

//	@Bean
//	public InMemoryUserDetailsManager createUserDetailsManager() {
//		UserDetails userDetails = User.withDefaultPasswordEncoder()
//
//				.username("vtech")
//
//				.password("123")
//
//				.roles("USER", "ADMIN")
//
//				.build();
//
//		return new InMemoryUserDetailsManager(userDetails);
//	}

//	@Bean
//	public InMemoryUserDetailsManager createUserDetailsManager() {
//		Function<String, String> passwordEncoder
//
//				= input -> passwordEncoder().encode(input);
//
//		UserDetails userDetails = User.builder()
//
//				.passwordEncoder(passwordEncoder)
//
//				.username("vtech")
//
//				.password("123")
//
//				.roles("USER", "ADMIN")
//
//				.build();
//
//		return new InMemoryUserDetailsManager(userDetails);
//	}

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails1 = createNewUser("vtech", "123");
		UserDetails userDetails2 = createNewUser("admin", "123");
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder

				= input -> passwordEncoder().encode(input);

		UserDetails userDetails = User.builder()

				.passwordEncoder(passwordEncoder)

				.username(username)

				.password(password)

				.roles("USER", "ADMIN")

				.build();

		return userDetails;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// SecurityFilterChain
	// Defines a filter chain matched against every request
	// When we override SecurityFilterChain
	// we need to define entire chain again!
	
	// X-Frame-Options enabled => Frames cannot be used
	// h2-console uses frames => Disable X-Frame-Opetions header
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(
				
				auth -> auth.anyRequest().authenticated()
				
				);
		http.formLogin(Customizer.withDefaults());
		
		// http.csrf().disable(); // deprecated
		http.csrf(csrf -> csrf.disable());
		
		// http.headers().frameOptions().disable(); // deprecated
//		http.headers(
//				
//				headers -> headers.frameOptions(
//						
//						frameOptions -> frameOptions.disable()
//						
//						)
//				
//				);
		
		http.headers(
				
				headers -> headers.frameOptions(
						
						frameOptions -> frameOptions.sameOrigin()
						
						)
				
				);
		
		return http.build();
	}

}
