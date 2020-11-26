package OMP.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Patient implements Serializable {

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

    @ManyToMany(mappedBy = "takingCareOfPatients")
    private Set<Caregiver> belongingToCaregivers = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "activity_of",
            joinColumns = @JoinColumn(name = "username_patient"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private Set<Activity> doingActivities = new HashSet<>();

    public Patient() {
    }

    public Patient(String username, String name, Date birth_date, String gender, String address) {
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

    public Set<Caregiver> getBelongingToCaregivers() {
        return belongingToCaregivers;
    }

    public void setBelongingToCaregivers(Set<Caregiver> belongingToCaregivers) {
        this.belongingToCaregivers = belongingToCaregivers;
    }

    public Set<Activity> getDoingActivities() {
        return doingActivities;
    }

    public void setDoingActivities(Set<Activity> doingActivities) {
        this.doingActivities = doingActivities;
    }
}
