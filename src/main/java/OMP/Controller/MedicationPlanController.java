package OMP.Controller;

import OMP.DTO.MedicationPlanDTO;
import OMP.DTO.MedicationPlanListDTO;
import OMP.Service.MedicationPlanListService;
import OMP.Service.MedicationPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/medication_plan")
public class MedicationPlanController {

    private final MedicationPlanService medicationPlanService;
    private final MedicationPlanListService medicationPlanListService;

    @Autowired
    public MedicationPlanController(MedicationPlanService medicationPlanService,
                                    MedicationPlanListService medicationPlanListService) {
        this.medicationPlanService = medicationPlanService;
        this.medicationPlanListService = medicationPlanListService;
    }

    @GetMapping()
    public ResponseEntity<List<MedicationPlanDTO>> getMedicationPlans() {
        List<MedicationPlanDTO> dtos = medicationPlanService.findMedicationPlans();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Integer> insertMedicationPlan(@Valid @RequestBody MedicationPlanDTO medicationPlanDTO) {
        int medicationPlanId = medicationPlanService.insert(medicationPlanDTO);
        return new ResponseEntity<>(medicationPlanId, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Integer> updateMedicationPlan(@Valid @RequestBody MedicationPlanDTO medicationPlanDTO) {
        int medicationPlanId = medicationPlanService.update(medicationPlanDTO);
        return new ResponseEntity<>(medicationPlanId, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Integer> deleteMedicationPlan(@Valid @RequestBody MedicationPlanDTO medicationPlanDTO) {
        int medicationPlanId = medicationPlanService.delete(medicationPlanDTO);
        return new ResponseEntity<>(medicationPlanId, HttpStatus.OK);
    }

    @GetMapping(value = "/{username_patient}")
    public ResponseEntity<List<MedicationPlanListDTO>> getMedicationPlanListForUser(@PathVariable("username_patient") String username_patient) {
        List<MedicationPlanListDTO> dtos = medicationPlanListService.findMedicationPlanListForUser(username_patient);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
