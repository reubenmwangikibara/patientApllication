package Patientapplication.example.demo.Controler;

import Patientapplication.example.demo.Entity.Patient;
import Patientapplication.example.demo.Service.PatientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path= "api/v1/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

//    public PatientController(PatientService patientService) {
//    this.patientService = patientService;
//       //return null;
//  }
    @GetMapping
    public List<Patient> getAllPatient() {
        return patientService.getPatient();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Optional<Patient> patient = patientService.getPatientById(id);
        return patient.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public void registerNewPatient(@RequestBody Patient patient) {
        patientService.addNewPatient(patient);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatedPatient(
            @PathVariable Long id,
            @RequestBody Patient patient) {
        Patient updatedPatient = patientService.updatePatient(id,patient);
        return ResponseEntity.ok(updatedPatient);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient with ID "+id+" has been deleted");
    }


}
