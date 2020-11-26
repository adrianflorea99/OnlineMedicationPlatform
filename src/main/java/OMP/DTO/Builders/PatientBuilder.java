package OMP.DTO.Builders;

import OMP.DTO.ActivityDTO;
import OMP.DTO.CaregiverDTO;
import OMP.DTO.PatientDTO;
import OMP.Entity.Activity;
import OMP.Entity.Caregiver;
import OMP.Entity.Patient;

import java.util.HashSet;
import java.util.Set;

public class PatientBuilder {

    private PatientBuilder() {
    }

    public static PatientDTO toPatientDTO(Patient patient) {
        Set<Activity> activities = patient.getDoingActivities();
        Set<ActivityDTO> activityDTOS = new HashSet<>();
        activities.forEach(activity -> {
                    activityDTOS.add(ActivityBuilder.toActivityDTO(activity));
                }
        );
        return new PatientDTO(patient.getUsername(),
                patient.getName(),
                patient.getBirth_date(),
                patient.getGender(),
                patient.getAddress(),
                activityDTOS);
    }



    public static Patient toEntity(PatientDTO patientDTO) {
        return new Patient(patientDTO.getUsername(),
                patientDTO.getName(),
                patientDTO.getBirth_date(),
                patientDTO.getGender(),
                patientDTO.getAddress());
    }

    public static Patient toEntityWithActivities(PatientDTO patientDTO) {
        Patient patient = new Patient(patientDTO.getUsername(),
                patientDTO.getName(),
                patientDTO.getBirth_date(),
                patientDTO.getGender(),
                patientDTO.getAddress());
        patientDTO.getDoingActivities().forEach(activityDTO -> {
                    Activity activity = ActivityBuilder.toEntity(activityDTO);
                    activity.getMadeByPatients().add(patient);
                    patient.getDoingActivities().add(activity);
                }
        );
        return patient;
    }
}
