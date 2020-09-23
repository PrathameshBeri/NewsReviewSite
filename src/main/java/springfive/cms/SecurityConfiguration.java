package springfive.cms;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import springfive.cms.domain.services.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LogManager.getLogger(SecurityConfiguration.class);

    @Autowired
    @Qualifier("bCrypt")
    PasswordEncoder passwordEncoder;

    @Autowired
    MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        logger.info("Using password encoder " + passwordEncoder.getClass());
        auth.userDetailsService(userDetailsService);


    }



    @Bean(name ="bCrypt")
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.authorizeRequests()
                .antMatchers( "/**", "/index", "/authenticate", "/login").permitAll()
               // .antMatchers("/**").hasRole("ADMIN")
                .and().httpBasic()
                .and().logout().logoutSuccessUrl("/index").permitAll()
                .and().csrf().disable()
                .rememberMe().alwaysRemember(true).rememberMeCookieName("rememberlogin")
                .tokenValiditySeconds(100);

    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
