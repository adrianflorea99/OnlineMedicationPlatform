package OMP.Controller;

import OMP.DTO.CaregiverDTO;
import OMP.DTO.DoctorDTO;
import OMP.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping()
    public ResponseEntity<List<DoctorDTO>> getDoctors() {
        List<DoctorDTO> dtos = doctorService.findDoctors();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<DoctorDTO> getDoctorByUsername(@PathVariable("username") String username) {
        DoctorDTO dto = doctorService.findDoctorByUsername(username);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
