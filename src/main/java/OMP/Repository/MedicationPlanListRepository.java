package OMP.Repository;

import OMP.Entity.MedicationPlan;
import OMP.Entity.MedicationPlanList;
import OMP.Entity.MedicationPlanListKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicationPlanListRepository extends JpaRepository<MedicationPlanList, MedicationPlanListKey> {

    @Query("SELECT mpl FROM MedicationPlanList mpl"
            + " LEFT JOIN FETCH mpl.medicationPlan"
            + " WHERE mpl.medicationPlan IN (:medicationPlans)")
    List<MedicationPlanList> findAllByMedicationPlans(List<MedicationPlan> medicationPlans);

}
