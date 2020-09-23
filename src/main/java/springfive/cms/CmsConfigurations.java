package springfive.cms;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
@PropertySource("classpath:foo.properties")
public class CmsConfigurations {


    @Bean(name = "pkbddfEncoder")
    public PasswordEncoder passwordEncoder(){
        return new Pbkdf2PasswordEncoder();
    }

}
