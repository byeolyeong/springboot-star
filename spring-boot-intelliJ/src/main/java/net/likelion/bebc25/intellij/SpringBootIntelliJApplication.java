package net.likelion.bebc25.intellij;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootIntelliJApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootIntelliJApplication.class, args);
        Driver driver = context.getBean(Driver.class);
        driver.driveCar(80);
        context.close();
    }

}
