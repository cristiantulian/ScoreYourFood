
package com.ScoreYourFood.demo.Configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(1)
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)

public class securityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
     protected void configure(HttpSecurity http) throws Exception {
         
        System.out.println("===================================================");
         http.headers().frameOptions().sameOrigin().and()
             .authorizeRequests()
                 .antMatchers("/css/", "/js/","/img/", "/*").permitAll()		
             .and().formLogin()
                 .loginPage("/login") // Que formulario esta mi login
                     .loginProcessingUrl("/logincheck")
                     .usernameParameter("username") // Como viajan los datos del logueo
                     .passwordParameter("password")// Como viajan los datos del logueo
                     .defaultSuccessUrl("/inicio") // A que URL viaja 
                     .permitAll()
                 .and().logout() // Aca configuro la salida
                     .logoutUrl("/logout")
                     .logoutSuccessUrl("/login?logout")
                     .permitAll().and().csrf().disable();
    }

}
