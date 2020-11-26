package OMP.DTO.Builders;

import OMP.DTO.MedicationDTO;
import OMP.DTO.MedicationPlanListDTO;
import OMP.Entity.MedicationPlanList;

import java.util.ArrayList;
import java.util.List;

public class MedicationPlanListBuilder {

    public static MedicationPlanListDTO toDto(MedicationPlanList medicationPlanList) {
        MedicationDTO medicationDTO = MedicationBuilder.toMedicationDTO(medicationPlanList.getMedication());
        MedicationPlanListDTO medicationPlanListDTO = new MedicationPlanListDTO();
        medicationPlanListDTO.setIntervals(medicationPlanList.getIntervals());
        medicationPlanListDTO.setMedicationDTO(medicationDTO);
        medicationPlanListDTO.setPeriod(medicationPlanList.getMedicationPlan().getPeriod());
        return medicationPlanListDTO;
    }

    public static List<MedicationPlanListDTO> toDtos(List<MedicationPlanList> medicationPlanLists) {
        List<MedicationPlanListDTO> medicationPlanListDTOS = new ArrayList<>();
        medicationPlanLists.forEach(medicationPlanList ->
                medicationPlanListDTOS.add(toDto(medicationPlanList)));
        return medicationPlanListDTOS;
    }
}
