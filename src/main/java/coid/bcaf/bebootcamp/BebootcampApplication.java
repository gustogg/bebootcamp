package coid.bcaf.bebootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "coid.bcaf.bebootcamp")
public class BebootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(BebootcampApplication.class, args);
	}
//.
}
