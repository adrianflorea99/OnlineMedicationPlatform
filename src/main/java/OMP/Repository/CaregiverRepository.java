package OMP.Repository;

import OMP.Entity.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaregiverRepository extends JpaRepository<Caregiver, String> {

    List<Caregiver> findByName(String name);

}
