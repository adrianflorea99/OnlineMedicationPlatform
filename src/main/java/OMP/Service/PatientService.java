package OMP.Service;

import OMP.DTO.Builders.PatientBuilder;
import OMP.DTO.PatientDTO;
import OMP.Entity.Patient;
import OMP.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientDTO> findPatients() {
        List<Patient> patientList = patientRepository.findAll();
        return patientList.stream()
                .map(PatientBuilder::toPatientDTO)
                .collect(Collectors.toList());
    }

    public String insert(PatientDTO patientDTO) {
        Patient patient = PatientBuilder.toEntity(patientDTO);
        patient = patientRepository.save(patient);
        return patient.getUsername();
    }

    public String update(PatientDTO patientDTO) {
        Patient patient = PatientBuilder.toEntityWithActivities(patientDTO);
        patient = patientRepository.save(patient);
        return patient.getUsername();
    }

    public String delete(PatientDTO patientDTO) {
        Patient patient = PatientBuilder.toEntity(patientDTO);
        patientRepository.delete(patient);
        return patient.getUsername();
    }

    public PatientDTO findPatientByUsername(String username) {
        Optional<Patient> patient = patientRepository.findById(username);
        if (!patient.isPresent()) {
            Logger logger = Logger.getLogger(Patient.class.getName());
            logger.log(Level.SEVERE, "Patient with username: " + username + " was not found in DB");
            return null;
        }
        return PatientBuilder.toPatientDTO(patient.get());
    }
}
