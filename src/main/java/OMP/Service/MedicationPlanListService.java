package OMP.Service;

import OMP.DTO.Builders.MedicationPlanListBuilder;
import OMP.DTO.MedicationPlanListDTO;
import OMP.Entity.MedicationPlan;
import OMP.Entity.MedicationPlanList;
import OMP.Repository.MedicationPlanListRepository;
import OMP.Repository.MedicationPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationPlanListService {

    private final MedicationPlanListRepository medicationPlanListRepository;
    private final MedicationPlanRepository medicationPlanRepository;

    @Autowired
    public MedicationPlanListService(MedicationPlanListRepository medicationPlanListRepository,
                                     MedicationPlanRepository medicationPlanRepository) {
        this.medicationPlanListRepository = medicationPlanListRepository;
        this.medicationPlanRepository = medicationPlanRepository;
    }

    public List<MedicationPlanListDTO> findMedicationPlanListForUser(String username_patient) {
        List<MedicationPlan> medicationPlans = medicationPlanRepository.findByPatient(username_patient);
        List<MedicationPlanList> medicationPlanLists = medicationPlanListRepository.findAllByMedicationPlans(medicationPlans);
        return MedicationPlanListBuilder.toDtos(medicationPlanLists);
    }
}
