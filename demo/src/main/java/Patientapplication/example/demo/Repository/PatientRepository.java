package Patientapplication.example.demo.Repository;
import Patientapplication.example.demo.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//import com.example.demo.entity.Patient;

@Repository
public interface PatientRepository
        extends JpaRepository<Patient, Long>{
    //@Query("SELECT S FROM Patient S WHERE S.email=?1")
    Optional<Patient> findStudentByEmail(String email);

}


