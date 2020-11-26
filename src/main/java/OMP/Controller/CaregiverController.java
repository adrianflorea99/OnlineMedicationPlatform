package OMP.Controller;

import OMP.Consumer.MessageConsumer;
import OMP.DTO.CaregiverDTO;
import OMP.DTO.PatientDTO;
import OMP.Service.CaregiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
//@RequestMapping(value = "/caregiver")
public class CaregiverController {

    private final CaregiverService caregiverService;
    private final MessageConsumer messageConsumer;

    @Autowired
    public CaregiverController(CaregiverService caregiverService, MessageConsumer messageConsumer) {
        this.caregiverService = caregiverService;
        this.messageConsumer = messageConsumer;
    }

    @GetMapping("/caregiver")
    public ResponseEntity<List<CaregiverDTO>> getCaregivers() {
        List<CaregiverDTO> dtos = caregiverService.findCaregivers();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping("/caregiver")
    public ResponseEntity<String> insertCaregiver(@Valid @RequestBody CaregiverDTO caregiverDTO) {
        String caregiverUsername = caregiverService.insert(caregiverDTO);
        return new ResponseEntity<>(caregiverUsername, HttpStatus.CREATED);
    }

    @PutMapping("/caregiver")
    public ResponseEntity<String> updateCaregiver(@Valid @RequestBody CaregiverDTO caregiverDTO) {
        String caregiverUsername = caregiverService.update(caregiverDTO);
        return new ResponseEntity<>(caregiverUsername, HttpStatus.OK);
    }

    @DeleteMapping("/caregiver")
    public ResponseEntity<String> deleteCaregiver(@Valid @RequestBody CaregiverDTO caregiverDTO) {
        String caregiverUsername = caregiverService.delete(caregiverDTO);
        return new ResponseEntity<>(caregiverUsername, HttpStatus.OK);
    }

    @GetMapping("/caregiver/{username}")
    public ResponseEntity<CaregiverDTO> getCaregiverByUsername(@PathVariable("username") String username) {
        CaregiverDTO dto = caregiverService.findCaregiverByUsername(username);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/profile")
    public void getPatientAnomalies() {
        try {
            messageConsumer.readMessagesFromQueue();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
