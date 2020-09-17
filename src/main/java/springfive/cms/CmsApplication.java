package springfive.cms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import springfive.cms.domain.resources.CategoryResource;
import springfive.cms.domain.services.StorageProperties;
import springfive.cms.domain.services.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class CmsApplication {
	private static final Logger logger = LogManager.getLogger(CmsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);

	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			//storageService.deleteAll();
			storageService.init();
		};
	}
}  
