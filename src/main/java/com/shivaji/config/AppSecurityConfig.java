package com.shivaji.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.SneakyThrows;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager inMemoryUsers() {
		UserDetails u1 = User.withDefaultPasswordEncoder()
							.username("ganesh")
								.password("gaitonde")
									.roles("USER")
										.build();
		
		UserDetails u2 = User.withDefaultPasswordEncoder()
							.username("deepak")
								.password("dogla")
									.roles("USER")
										.build();
		
		return new InMemoryUserDetailsManager(u1,u2);
	}
	
	

	@Bean
	@SneakyThrows
	public SecurityFilterChain security(HttpSecurity httpSecurity) {

//		httpSecurity.authorizeHttpRequests( (req) -> {
//			req.requestMatchers("/contact")
//				.permitAll()
//					.anyRequest()
//						.authenticated();
//		});
//		return httpSecurity.build();

		httpSecurity
			.authorizeHttpRequests((req) -> req.requestMatchers("/greet")
				.permitAll()
					.anyRequest()
						.authenticated())
							.httpBasic(Customizer.withDefaults())
								.formLogin(Customizer.withDefaults());

		return httpSecurity.build();
	}
}
