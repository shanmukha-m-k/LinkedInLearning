package buyandsell.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class BuyAndSellApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyAndSellApplication.class, args);
	}

}
