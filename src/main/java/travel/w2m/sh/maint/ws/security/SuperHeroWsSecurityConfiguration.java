package travel.w2m.sh.maint.ws.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SuperHeroWsSecurityConfiguration extends WebSecurityConfigurerAdapter {

  public SuperHeroWsSecurityConfiguration() {
    super();
  }
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
      .withUser("user").password("{noop}password").roles("USER")
      .and()
      .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .httpBasic()
      .and()
      .authorizeRequests()
      .antMatchers(HttpMethod.GET, "/api/superheros/**").hasRole("USER")
      .antMatchers(HttpMethod.PUT, "/api/superheros/**").hasRole("ADMIN")
      .antMatchers(HttpMethod.DELETE, "/api/superheros/**").hasRole("ADMIN")
      .and()
      .csrf().disable()
      .formLogin().disable();
  }

}
