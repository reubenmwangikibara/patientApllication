package Patientapplication.example.demo.Service;

import Patientapplication.example.demo.Repository.PatientRepository;
import org.springframework.stereotype.Service;
@Service
public class PatientService {

//creating a variable and then generating its constructor
// also for dependency injection
private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
}
