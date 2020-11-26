package OMP.Service;

import OMP.DTO.Builders.MedicationBuilder;
import OMP.DTO.MedicationDTO;
import OMP.Entity.Medication;
import OMP.Repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;

    @Autowired
    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public List<MedicationDTO> findMedications() {
        List<Medication> medicationList = medicationRepository.findAll();
        return medicationList.stream()
                .map(MedicationBuilder::toMedicationDTO)
                .collect(Collectors.toList());
    }

    public int insert(MedicationDTO medicationDTO) {
        Medication medication = MedicationBuilder.toEntity(medicationDTO);
        medication = medicationRepository.save(medication);
        return medication.getId();
    }

    public int update(MedicationDTO medicationDTO) {
        Medication medication = MedicationBuilder.toEntity(medicationDTO);
        medication = medicationRepository.save(medication);
        return medication.getId();
    }

    public int delete(MedicationDTO medicationDTO) {
        Medication medication = MedicationBuilder.toEntity(medicationDTO);
        medicationRepository.delete(medication);
        return medication.getId();
    }
}
