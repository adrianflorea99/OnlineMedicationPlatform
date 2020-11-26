package OMP.DTO;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class PatientDTO {
    private String username;
    private String name;
    private Date birth_date;
    private String gender;
    private String address;
    private Set<ActivityDTO> doingActivities = new HashSet<>();

    public PatientDTO() {
    }

    public PatientDTO(String username, String name, Date birth_date, String gender, String address, Set<ActivityDTO> doingActivities) {
        this.setUsername(username);
        this.setName(name);
        this.setBirth_date(birth_date);
        this.setGender(gender);
        this.setAddress(address);
        this.setDoingActivities(doingActivities);
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

    public Set<ActivityDTO> getDoingActivities() {
        return doingActivities;
    }

    public void setDoingActivities(Set<ActivityDTO> doingActivities) {
        this.doingActivities = doingActivities;
    }
}
