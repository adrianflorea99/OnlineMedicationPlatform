package OMP.DTO.Builders;

import OMP.DTO.DoctorDTO;
import OMP.Entity.Doctor;

public class DoctorBuilder {

    private DoctorBuilder() {
    }

    public static DoctorDTO toDoctorDTO(Doctor doctor) {
        return new DoctorDTO(doctor.getUsername(), doctor.getName(), doctor.getBirth_date(), doctor.getGender(), doctor.getAddress());
    }
}
