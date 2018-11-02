package ue.app.ntpartner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class NtpartnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NtpartnerApplication.class, args);
	}
}
