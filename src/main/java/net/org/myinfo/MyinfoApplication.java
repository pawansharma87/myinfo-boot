package net.org.myinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableConfigurationProperties*/

@SpringBootApplication
public class MyinfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyinfoApplication.class, args);
	}

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MyinfoApplication.class);
	}*/
}
