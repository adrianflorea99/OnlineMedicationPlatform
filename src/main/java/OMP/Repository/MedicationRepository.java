package OMP.Repository;

import OMP.Entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationRepository extends JpaRepository<Medication, Integer> {

    List<Medication> findById(int id);
}
