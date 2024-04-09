package diop.babacar.hopitalapp.repository;


import diop.babacar.hopitalapp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
