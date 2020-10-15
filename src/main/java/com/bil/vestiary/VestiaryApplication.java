package com.bil.vestiary;


import com.bil.vestiary.freemaker.FreeMakerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VestiaryApplication {

    @Autowired
    private FreeMakerServiceImpl freeMakerService;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(VestiaryApplication.class);
        app.setBannerMode(Banner.Mode.CONSOLE);
        app.run();
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> freeMakerService.loadTemplatesFromVestiary();
    }


}
