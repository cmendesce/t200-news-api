package br.unifor.news.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests().antMatchers("/admin/**/**").authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(STATELESS)
                .and()
                .httpBasic()
                .and()
                .authorizeRequests().anyRequest().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder.inMemoryAuthentication()
                .withUser("carlos")
                .password("{noop}pass")
                .roles("USER")
                .and()
                .withUser("aluno")
                .password("{noop}pass1")
                .roles("USER");
    }
}
