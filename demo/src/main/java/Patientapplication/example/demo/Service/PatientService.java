package Patientapplication.example.demo.Service;

import Patientapplication.example.demo.Entity.Patient;
import Patientapplication.example.demo.Repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PatientService {

//creating a variable and then generating its constructor
// also for dependency injection
private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatient() {
        return patientRepository.findAll();
    }
    public Patient AddPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void addNewPatient(Patient patient) {

        //System.out.println(patient);
        Optional<Patient>patientOptional= patientRepository.
                findStudentByEmail(patient.getEmail());
        if (patientOptional.isPresent()){
            throw new IllegalStateException("The email " + patient.getEmail() + "is in use");
        }
        patientRepository.save(patient);
    }

//    public void addNewPatient(Patient patient) {
//        Optional<Patient> studentOptional= patientRepository.
//                findPatientByEmail(patient.getEmail());
//        if (patientOptional.isPresent()){
//            throw new IllegalStateException("the email already exist!!");
//        }
//        patientRepository.save(patient);
//    }
}
