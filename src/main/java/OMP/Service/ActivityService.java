package OMP.Service;

import OMP.DTO.ActivityDTO;
import OMP.DTO.Builders.ActivityBuilder;
import OMP.Entity.Activity;
import OMP.Repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<ActivityDTO> findActivities() {
        List<Activity> activityList = activityRepository.findAll();
        return activityList.stream()
                .map(ActivityBuilder::toActivityDTO)
                .collect(Collectors.toList());
    }

    public Integer insert(ActivityDTO activityDTO) {
        Activity activity = ActivityBuilder.toEntity(activityDTO);
        activity = activityRepository.save(activity);
        return activity.getId();
    }

    public Integer update(ActivityDTO activityDTO) {
        Activity activity = ActivityBuilder.toEntity(activityDTO);
        activity = activityRepository.save(activity);
        return activity.getId();
    }

    public Integer delete(ActivityDTO activityDTO) {
        Activity activity = ActivityBuilder.toEntity(activityDTO);
        activityRepository.delete(activity);
        return activity.getId();
    }
}
