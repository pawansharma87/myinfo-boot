package net.org.myinfo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@ComponentScan(basePackages = "net.org.myinfo")
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Value("${app.secret}")
	private String applicationSecret;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "contactus", "aboutus", "gallery", "signup").permitAll()
				.antMatchers("/user/register").permitAll()
				// .antMatchers("/user/reset-password").permitAll().antMatchers("/user/reset-password-change").permitAll()
				.antMatchers("/user/autologin")
				.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER') or hasRole('ROLE_USER')")
				.antMatchers("/user/delete").access("hasRole('ROLE_ADMIN')").antMatchers("/user/**")
				.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER') or hasRole('ROLE_USER')")
				.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')").antMatchers("/super/**")
				.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER')");
		http.formLogin().failureUrl("/login?error").defaultSuccessUrl("/user/home").loginPage("/login").permitAll()
				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
				.permitAll().and().exceptionHandling().accessDeniedPage("/403").and().csrf().and().rememberMe()
				.key(applicationSecret).tokenValiditySeconds(31536000);

	}
}