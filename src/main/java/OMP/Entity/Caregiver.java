package OMP.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Caregiver implements Serializable {

    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birth_date", nullable = false)
    private Date birth_date;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "address")
    private String address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "care_of",
            joinColumns = @JoinColumn(name = "username_caregiver"),
            inverseJoinColumns = @JoinColumn(name = "username_patient")
    )
    private Set<Patient> takingCareOfPatients = new HashSet<>();

    public Caregiver() {
    }

    public Caregiver(String username, String name, Date birth_date, String gender, String address) {
        this.setUsername(username);
        this.setName(name);
        this.setBirth_date(birth_date);
        this.setGender(gender);
        this.setAddress(address);
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

    public Set<Patient> getTakingCareOfPatients() {
        return takingCareOfPatients;
    }

    public void setTakingCareOfPatients(Set<Patient> takingCareOfPatients) {
        this.takingCareOfPatients = takingCareOfPatients;
    }
}
