package OMP.DTO.Builders;

import OMP.DTO.MedicationPlanDTO;
import OMP.Entity.MedicationPlan;

public class MedicationPlanBuilder {

    public static MedicationPlanDTO toMedicationPlanDTO(MedicationPlan medicationPlan) {
        return new MedicationPlanDTO(medicationPlan.getId(),
                PatientBuilder.toPatientDTO(medicationPlan.getPatient()),
                medicationPlan.getPeriod());
    }

    public static MedicationPlan toEntity(MedicationPlanDTO medicationPlanDTO) {
        return new MedicationPlan(medicationPlanDTO.getId(),
                PatientBuilder.toEntity(medicationPlanDTO.getPatientDTO()),
                medicationPlanDTO.getPeriod());
    }
}
