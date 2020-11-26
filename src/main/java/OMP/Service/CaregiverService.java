package OMP.Service;

import OMP.DTO.Builders.CaregiverBuilder;
import OMP.DTO.Builders.PatientBuilder;
import OMP.DTO.CaregiverDTO;
import OMP.DTO.PatientDTO;
import OMP.Entity.Caregiver;
import OMP.Entity.Patient;
import OMP.Repository.CaregiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CaregiverService {

    private final CaregiverRepository caregiverRepository;

    @Autowired
    public CaregiverService(CaregiverRepository caregiverRepository) {
        this.caregiverRepository = caregiverRepository;
    }

    public List<CaregiverDTO> findCaregivers() {
        List<Caregiver> caregiverList = caregiverRepository.findAll();
        return caregiverList.stream()
                .map(CaregiverBuilder::toCaregiverDTO)
                .collect(Collectors.toList());
    }

    public String insert(CaregiverDTO caregiverDTO) {
        Caregiver caregiver = CaregiverBuilder.toEntity(caregiverDTO);
        caregiver = caregiverRepository.save(caregiver);
        return caregiver.getUsername();
    }

    public String update(CaregiverDTO caregiverDTO) {
        Caregiver caregiver = CaregiverBuilder.toEntityWithPatients(caregiverDTO);
        caregiver = caregiverRepository.save(caregiver);
        return caregiver.getUsername();
    }

    public String delete(CaregiverDTO caregiverDTO) {
        Caregiver caregiver = CaregiverBuilder.toEntity(caregiverDTO);
        caregiverRepository.delete(caregiver);
        return caregiver.getUsername();
    }

    public CaregiverDTO findCaregiverByUsername(String username) {
        Optional<Caregiver> caregiver = caregiverRepository.findById(username);
        if (!caregiver.isPresent()) {
            Logger logger = Logger.getLogger(Caregiver.class.getName());
            logger.log(Level.SEVERE, "Caregiver with username: " + username + " was not found in DB");
            return null;
        }
        return CaregiverBuilder.toCaregiverDTO(caregiver.get());
    }
}
