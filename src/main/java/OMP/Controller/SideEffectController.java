package OMP.Controller;

import OMP.DTO.SideEffectDTO;
import OMP.Service.SideEffectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/side_effect")
public class SideEffectController {

    private final SideEffectService sideEffectService;

    @Autowired
    public SideEffectController(SideEffectService sideEffectService) {
        this.sideEffectService = sideEffectService;
    }

    @GetMapping()
    public ResponseEntity<List<SideEffectDTO>> getPatients() {
        List<SideEffectDTO> dtos = sideEffectService.findSideEffects();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Integer> insertSideEffect(@Valid @RequestBody SideEffectDTO sideEffectDTO) {
        int sideEffectID = sideEffectService.insert(sideEffectDTO);
        return new ResponseEntity<>(sideEffectID, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Integer> updateSideEffect(@Valid @RequestBody SideEffectDTO sideEffectDTO) {
        int sideEffectID = sideEffectService.update(sideEffectDTO);
        return new ResponseEntity<>(sideEffectID, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Integer> deletePatient(@Valid @RequestBody SideEffectDTO sideEffectDTO) {
        int sideEffectID = sideEffectService.delete(sideEffectDTO);
        return new ResponseEntity<>(sideEffectID, HttpStatus.OK);
    }

}
