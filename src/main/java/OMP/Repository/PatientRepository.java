package OMP.Repository;

import OMP.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, String> {

    List<Patient> findByName(String name);

    @Query("SELECT patient FROM Patient patient " +
            "LEFT JOIN FETCH patient.doingActivities " +
            "WHERE patient.username = :username")
    Patient findPatientByNameFetchActivities(@Param("username") String username);
}
