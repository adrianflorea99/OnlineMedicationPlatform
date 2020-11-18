package OMP.Service;

import OMP.DTO.Builders.CaregiverBuilder;
import OMP.DTO.CaregiverDTO;
import OMP.Entity.Caregiver;
import OMP.Repository.CaregiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
