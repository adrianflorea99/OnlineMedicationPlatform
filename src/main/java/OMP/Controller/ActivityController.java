package OMP.Controller;

import OMP.DTO.ActivityDTO;
import OMP.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/activity")
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping()
    public ResponseEntity<List<ActivityDTO>> getActivity() {
        List<ActivityDTO> dtos = activityService.findActivities();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Integer> insertActivity(@Valid @RequestBody ActivityDTO activityDTO) {
        Integer activityID = activityService.insert(activityDTO);
        return new ResponseEntity<>(activityID, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Integer> updateActivity(@Valid @RequestBody ActivityDTO activityDTO) {
        Integer activityID = activityService.update(activityDTO);
        return new ResponseEntity<>(activityID, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Integer> deleteActivity(@Valid @RequestBody ActivityDTO activityDTO) {
        Integer activityID = activityService.delete(activityDTO);
        return new ResponseEntity<>(activityID, HttpStatus.OK);
    }
}
