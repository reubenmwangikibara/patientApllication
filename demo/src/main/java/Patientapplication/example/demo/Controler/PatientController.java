package Patientapplication.example.demo.Controler;

import Patientapplication.example.demo.Entity.Patient;
import Patientapplication.example.demo.Service.PatientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "api/v1/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

//    public PatientController(PatientService patientService) {
//        this.patientService = patientService;
//        //return null;
//    }
    @GetMapping
    public List<Patient>getAllPatient(){
        return patientService.getPatient();
    }
    @PostMapping
    public void registerNewPatient(@RequestBody Patient patient ){
       patientService.addNewPatient(patient);

    }

}
