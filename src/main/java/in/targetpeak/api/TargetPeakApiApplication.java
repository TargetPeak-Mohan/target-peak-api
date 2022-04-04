package in.targetpeak.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TargetPeakApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TargetPeakApiApplication.class, args);
		System.out.println("Initialization Completed...");
	}

}
