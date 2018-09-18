package com.njsecnet.fhcp.image;

import com.njsecnet.fhcp.image.util.SpringContextUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(App.class);
		ConfigurableApplicationContext  applicationContext =  application.run(args);
		SpringContextUtils.setApplicationContext(applicationContext);
	}
}
