package OMP.DTO.Builders;

import OMP.DTO.CaregiverDTO;
import OMP.DTO.PatientDTO;
import OMP.Entity.Caregiver;
import OMP.Entity.Patient;

import java.util.HashSet;
import java.util.Set;

public class CaregiverBuilder {

    private CaregiverBuilder() {
    }

    public static CaregiverDTO toCaregiverDTO(Caregiver caregiver) {
        Set<Patient> patients = caregiver.getTakingCareOfPatients();
        Set<PatientDTO> patientDtos = new HashSet<>();
        patients.forEach(patient -> {
                    patientDtos.add(PatientBuilder.toPatientDTO(patient));
                }
        );
        return new CaregiverDTO(caregiver.getUsername(),
                caregiver.getName(),
                caregiver.getBirth_date(),
                caregiver.getGender(),
                caregiver.getAddress(),
                patientDtos);
    }

    public static Caregiver toEntity(CaregiverDTO caregiverDTO) {
        return new Caregiver(caregiverDTO.getUsername(),
                caregiverDTO.getName(),
                caregiverDTO.getBirth_date(),
                caregiverDTO.getGender(),
                caregiverDTO.getAddress());
    }

    public static Caregiver toEntityWithPatients(CaregiverDTO caregiverDTO) {
        Caregiver caregiver = new Caregiver(caregiverDTO.getUsername(),
                caregiverDTO.getName(),
                caregiverDTO.getBirth_date(),
                caregiverDTO.getGender(),
                caregiverDTO.getAddress());
        caregiverDTO.getTakingCareOfPatients().forEach(patientDto -> {
                    Patient patient = PatientBuilder.toEntity(patientDto);
                    patient.getBelongingToCaregivers().add(caregiver);
                    caregiver.getTakingCareOfPatients().add(patient);
                }
        );
        return caregiver;
    }
}
