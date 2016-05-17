package edu.eci.cosw.Go2U;

import edu.eci.cosw.Go2U.services.user.ServiceUser;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

@SpringBootApplication
@EnableJpaRepositories("edu.eci.cosw.Go2U.persistence")
@EntityScan("edu.eci.cosw.Go2U.model")
public class Go2uApplication {

    public static void main(String[] args) {
        SpringApplication.run(Go2uApplication.class, args);
    }

    @Configuration
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        
        @Autowired
        @Qualifier("customUserDetailsService")
        UserDetailsService userDetailsService;
        
        
        @Override
        protected void configure(AuthenticationManagerBuilder builder) throws Exception {
            //builder.inMemoryAuthentication().withUser("user").password("password").roles("USER");
            builder.userDetailsService(userDetailsService);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .httpBasic()
                        .and()
                    .authorizeRequests()
                        .antMatchers("/app/**").permitAll()
                        .antMatchers("/api/uni/add","/api/user/add","/api/stu/add").permitAll()
                        .antMatchers("/api/uni/**").hasRole("UNI")
                        .antMatchers("/api/stu/**").hasRole("STU")
                        .anyRequest().authenticated()
                        .and()
                    .logout()
                        .logoutSuccessUrl("/")
                        .and()
                    .csrf()
                        .csrfTokenRepository(csrfTokenRepository())
                        .and()
                    .addFilterAfter(csrfHeaderFilter(), CsrfFilter.class);
        }

        private Filter csrfHeaderFilter() {
            return new OncePerRequestFilter() {
                @Override
                protected void doFilterInternal(HttpServletRequest request,
                        HttpServletResponse response, FilterChain filterChain)
                        throws ServletException, IOException {
                    CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class
                            .getName());
                    if (csrf != null) {
                        Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
                        String token = csrf.getToken();
                        if (cookie == null || token != null
                                && !token.equals(cookie.getValue())) {
                            cookie = new Cookie("XSRF-TOKEN", token);
                            cookie.setPath("/");
                            response.addCookie(cookie);
                        }
                    }
                    filterChain.doFilter(request, response);
                }
            };
        }

        private CsrfTokenRepository csrfTokenRepository() {
            HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
            repository.setHeaderName("X-XSRF-TOKEN");
            return repository;
        }

    }
}

//curl -H "Content-Type: application/json" -X POST -d '{"desc":"hola","prio":1}' http://localhost:8080/Task/postTask
//curl -H "Content-Type: application/json" -X GET http://localhost:8080/Task/getTasks
