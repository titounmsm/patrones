package ayudadoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ayudadoc.helpers.AyudocLog;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        AyudocLog.getInstance().log("debug", "Iniciando Spring Boot para Ayuda al Docente");
        SpringApplication.run(Main.class, args);
    }
}
