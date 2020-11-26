package OMP.Repository;

import OMP.Entity.MedicationPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicationPlanRepository extends JpaRepository<MedicationPlan, Integer> {

    List<MedicationPlan> findById(int id);

    @Query("SELECT mp FROM MedicationPlan mp"
            + " LEFT JOIN FETCH mp.patient"
            + " WHERE mp.patient.username = :username_patient")
    List<MedicationPlan> findByPatient(String username_patient);
}
