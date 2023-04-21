package com.CENIGRAF.GestorMateriales.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.CENIGRAF.GestorMateriales.ServiceCRUD.UsuarioService;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity( prePostEnabled = true )
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UsuarioService usuarioservice;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(usuarioservice).passwordEncoder(passwordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/CSS/**","/js/**","/images/**").permitAll()
                                    .antMatchers("/admin").hasRole("ADMIN")
                                    .antMatchers("api/**").hasAuthority("ADMIN")
                                    .antMatchers("/rolalmacen","/rolalmacen/**","/almacen/**").hasAnyRole("ALMACEN")
                                    .antMatchers("/personal","/personal/**").hasAnyRole("PERSONAL")
                                    .anyRequest().authenticated()
                                    .and()
                                    .formLogin().loginPage("/login").permitAll()
                                    .and()
                                    .logout()
                                    .invalidateHttpSession(true)
                                    .clearAuthentication(true)
                                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                    .logoutSuccessUrl("/login?logout")
                                    .permitAll();                                
    }
    
    
}
