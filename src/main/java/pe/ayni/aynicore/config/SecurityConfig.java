package pe.ayni.aynicore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import pe.ayni.aynicore.seguridad.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*
	@Autowired
	private DataSource myDataSource;
	*/
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and()
		.authorizeRequests()
		.antMatchers("/api/**").permitAll() // 2) front end + rest api version
		//.antMatchers("/api/**").authenticated() // 1) single server version
		.and()
		.httpBasic().and()
		.csrf().disable()  // 2) front end + rest api version
		//.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // 1) single server version
		//.and()
		//.logout()
		//	.logoutUrl("logout")
			
		;
	}
	
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add our users for in memory authentication
		
		@SuppressWarnings("deprecation")
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
			.withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));
	}*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// use jdbc authentication
		//auth.jdbcAuthentication().dataSource(myDataSource);
		auth.userDetailsService(userDetailsService);
	}
	
}
