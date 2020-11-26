package OMP.Controller;

import OMP.DTO.MedicationDTO;
import OMP.Service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/medication")
public class MedicationController {

    private final MedicationService medicationService;

    @Autowired
    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping()
    public ResponseEntity<List<MedicationDTO>> getMedications() {
        List<MedicationDTO> dtos = medicationService.findMedications();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Integer> insertMedication(@Valid @RequestBody MedicationDTO medicationDTO) {
        int medicationId = medicationService.insert(medicationDTO);
        return new ResponseEntity<>(medicationId, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Integer> updateMedication(@Valid @RequestBody MedicationDTO medicationDTO) {
        int medicationId = medicationService.update(medicationDTO);
        return new ResponseEntity<>(medicationId, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Integer> deleteMedication(@Valid @RequestBody MedicationDTO medicationDTO) {
        int medicationId = medicationService.delete(medicationDTO);
        return new ResponseEntity<>(medicationId, HttpStatus.OK);
    }
}
