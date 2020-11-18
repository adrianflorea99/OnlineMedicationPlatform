package OMP.Controller;

import OMP.DTO.PatientDTO;
import OMP.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping()
    public ResponseEntity<List<PatientDTO>> getPatients() {
        List<PatientDTO> dtos = patientService.findPatients();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> insertPatient(@Valid @RequestBody PatientDTO patientDTO) {
        String patientUsername = patientService.insert(patientDTO);
        return new ResponseEntity<>(patientUsername, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<String> updatePatient(@Valid @RequestBody PatientDTO patientDTO) {
        String patientUsername = patientService.update(patientDTO);
        return new ResponseEntity<>(patientUsername, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deletePatient(@Valid @RequestBody PatientDTO patientDTO) {
        String patientUsername = patientService.delete(patientDTO);
        return new ResponseEntity<>(patientUsername, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<PatientDTO> getPatientByUsername(@PathVariable("username") String username) {
        PatientDTO dto = patientService.findPatientByUsername(username);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
