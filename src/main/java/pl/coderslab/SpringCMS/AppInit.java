package pl.coderslab.SpringCMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "pl.coderslab")
public class AppInit {
    public static void main(String[] args) {
        SpringApplication.run(AppInit.class, args);
    }

}
