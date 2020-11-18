package OMP.DTO;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class CaregiverDTO {
    private String username;
    private String name;
    private Date birth_date;
    private String gender;
    private String address;
    private Set<PatientDTO> takingCareOfPatients = new HashSet<>();

    public CaregiverDTO() {
    }

    public CaregiverDTO(String username, String name, Date birth_date, String gender, String address,
                        Set<PatientDTO> takingCareOfPatients) {
        this.username = username;
        this.name = name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.address = address;
        this.takingCareOfPatients = takingCareOfPatients;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<PatientDTO> getTakingCareOfPatients() {
        return takingCareOfPatients;
    }

    public void setTakingCareOfPatients(Set<PatientDTO> takingCareOfPatients) {
        this.takingCareOfPatients = takingCareOfPatients;
    }
}
