package mx.ipn.cic.biblioteca.AdminControl.config;

//import mx.ipn.cic.biblioteca.AdminControl.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import mx.ipn.cic.biblioteca.AdminControl.services.DoctorService;
import mx.ipn.cic.biblioteca.AdminControl.services.SimpleAuthenticationSuccessHandler;
import mx.ipn.cic.biblioteca.AdminControl.services.UserServiceImpl;
import mx.ipn.cic.biblioteca.AdminControl.config.PasswordEncoderTest;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userService;
    
    @Autowired
    private DoctorService doctorService;
    
	@Autowired
	private SimpleAuthenticationSuccessHandler successHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(
                        "/registration**",
                        "/js/**",
                        "/css/**",
                        "/img/**",
                        "/webjars/**").permitAll()
                .antMatchers("/patient/**","/monthlyconsult/**","/finalconsult/**").hasAnyRole("ADMIN","DOCTOR","MONITOR")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/monitor/**").hasAnyRole("ADMIN","MONITOR")
                .antMatchers("/doctor/**").hasAnyRole("ADMIN","DOCTOR")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/success",true)
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }


// 	//Habilita las peticiones de terceros
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
////        httpSecurity.authorizeRequests().antMatchers("/").permitAll();
//    	httpSecurity.csrf().disable();
//    }

    //Test que simula el passwordecoder sin usar bcrypt

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new PasswordEncoderTest();
    }

    //Bcrypt implementado
    /*
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
*/
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
//        auth.setUserDetailsService(doctorService);
        //descomentar para bcrypt
//        auth.setPasswordEncoder(passwordEncoder());
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

}
