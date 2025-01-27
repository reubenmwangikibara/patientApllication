package Patientapplication.example.demo.Repository;
import Patientapplication.example.demo.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import com.example.demo.entity.Patient;



@Repository
public interface PatientRepository
        extends JpaRepository<Patient, Long>{

}


