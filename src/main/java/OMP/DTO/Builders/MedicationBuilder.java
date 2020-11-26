package OMP.DTO.Builders;

import OMP.DTO.MedicationDTO;
import OMP.DTO.SideEffectDTO;
import OMP.Entity.Medication;
import OMP.Entity.SideEffect;

import java.util.HashSet;
import java.util.Set;

public class MedicationBuilder {

    private MedicationBuilder() {
    }

    public static MedicationDTO toMedicationDTO(Medication medication) {
        Set<SideEffect> sideEffects = medication.getSideEffectsResulted();
        Set<SideEffectDTO> sideEffectDTOs = new HashSet<>();
        sideEffects.forEach(sideEffect -> {
            sideEffectDTOs.add(SideEffectBuilder.toSideEffectDTO(sideEffect));
        });
        return new MedicationDTO(medication.getId(),
                medication.getName(),
                medication.getDosage(),
                sideEffectDTOs);
    }

    public static Medication toEntity(MedicationDTO medicationDTO) {
        return new Medication(medicationDTO.getId(),
                medicationDTO.getName(),
                medicationDTO.getDosage());
    }
}
