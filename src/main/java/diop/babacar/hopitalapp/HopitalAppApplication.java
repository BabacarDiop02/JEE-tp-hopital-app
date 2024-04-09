package diop.babacar.hopitalapp;

import diop.babacar.hopitalapp.entities.Patient;
import diop.babacar.hopitalapp.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class HopitalAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HopitalAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(PatientRepository patientRepository) {
        return args -> {
            Patient p1 = new Patient();
            p1.setNom("Diop");
            p1.setPrenom("Babacar");
            p1.setDateNaissance(new Date());
            p1.setScore(320);
            p1.setMalade(true);

            Patient p2 = new Patient(null, "Fall", "Maman", new Date(), false, 234);

            Patient p3 = Patient.builder()
                    .nom("Diop")
                    .malade(false)
                    .score(123)
                    .build();

            patientRepository.save(p1);
            patientRepository.save(p2);
            patientRepository.save(p3);

            patientRepository.findAll().forEach(System.out::println);
        };
    }
}
