package sec.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // you can access the h2-console through /h2-console
        
        //http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
        
        http.authorizeRequests()
                .antMatchers("/h2-console/*").permitAll()
                
                //.anyRequest().authenticated();
        
                //PROTECTS FROM BROKEN AUTHENTICATION as requires authentication to all pages.
                //.anyRequest().authenticated();
                //VULNERABILITY, as we have missed to write "done" and also the plain /events, allowing any user
                //to access events list without logging in. At least in this context this is very stupid to 
                //start writing all of these paths separately, but this was done only for demonstrating broken access control
                //OWASP issue.
                .antMatchers("/", "/home", "/form", "/events/*").authenticated();
                
        
        //copy paste official doceista, jotta voitaisiin jotenkin handlata login ja logout
        http.formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
                
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}