package OMP.Repository;

import OMP.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, String> {

    List<Doctor> findByName(String name);
}
