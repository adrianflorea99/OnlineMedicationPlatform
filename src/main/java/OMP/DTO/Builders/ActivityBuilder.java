package OMP.DTO.Builders;

import OMP.DTO.ActivityDTO;
import OMP.Entity.Activity;

public class ActivityBuilder {

    public ActivityBuilder() {
    }

    public static ActivityDTO toActivityDTO(Activity activity) {
        return new ActivityDTO(activity.getId(),
                activity.getStart_time(),
                activity.getEnd_time(),
                activity.getName());
    }

    public static Activity toEntity(ActivityDTO activityDTO) {
        return new Activity(activityDTO.getId(),
                activityDTO.getStart_time(),
                activityDTO.getEnd_time(),
                activityDTO.getName());
    }
}
