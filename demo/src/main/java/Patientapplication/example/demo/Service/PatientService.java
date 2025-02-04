package Patientapplication.example.demo.Service;

import Patientapplication.example.demo.Entity.Patient;
import Patientapplication.example.demo.Repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
//creating a variable and then generating its constructor
// also for dependency injection
private PatientRepository patientRepository;

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
            throw new IllegalStateException("The email " + patient.getEmail()+" is in use");
        }
        else if(patient.getName()==null)
        {
            throw new IllegalStateException("The name cannot be empty ");
        }
        else if(patient.getPhonnumber()==null)
        {
            throw new IllegalStateException("Please enter phone number ");
        }
        else if(patient.getDOB()==null)
        {
            throw new IllegalStateException("date of birth cannot be empty ");
        }
        else{
        patientRepository.save(patient);}
    }

    public Patient updatePatient(Long id, Patient updatedPatient)
    {
        Optional<Patient> existingPatientOptional = patientRepository.findById(id);

        if (existingPatientOptional.isPresent()) {
            Patient existingPatient = existingPatientOptional.get();
            // Update only if the new values are not null
            if(updatedPatient.getEmail()!=null){
                existingPatient.setEmail(updatedPatient.getEmail());
            }
            if(updatedPatient.getName()!=null)
            {

                existingPatient.setName(updatedPatient.getName());
            }
            if (updatedPatient.getPhonnumber()!=null) {
                existingPatient.setPhonnumber(updatedPatient.getPhonnumber());
            }
            return patientRepository.save(existingPatient);
        }
        else {
            throw new EntityNotFoundException("patient with id "+ id +" not found");
        }

    }
    public void deletePatient(Long id){
        if (patientRepository.existsById(id)){
            patientRepository.deleteById(id);
        }
        else
        {
            throw new EntityNotFoundException("Patient with ID " + id + " not found.");
        }

    }


}
