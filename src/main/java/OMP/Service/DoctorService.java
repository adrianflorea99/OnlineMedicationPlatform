package OMP.Service;

import OMP.DTO.Builders.CaregiverBuilder;
import OMP.DTO.Builders.DoctorBuilder;
import OMP.DTO.CaregiverDTO;
import OMP.DTO.DoctorDTO;
import OMP.Entity.Caregiver;
import OMP.Entity.Doctor;
import OMP.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorDTO> findDoctors() {
        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList.stream()
                .map(DoctorBuilder::toDoctorDTO)
                .collect(Collectors.toList());
    }

    public DoctorDTO findDoctorByUsername(String username) {
        Optional<Doctor> doctor = doctorRepository.findById(username);
        if (!doctor.isPresent()) {
            Logger logger = Logger.getLogger(Caregiver.class.getName());
            logger.log(Level.SEVERE, "Doctor with username: " + username + " was not found in DB");
            return null;
        }
        return DoctorBuilder.toDoctorDTO(doctor.get());
    }
}
