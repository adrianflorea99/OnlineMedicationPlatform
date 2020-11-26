package OMP.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class MedicalRecord implements Serializable {

    @Id
    @Column(name = "username_patient", nullable = false)
    private String username_patient;

    @Column(name = "description", nullable = false)
    private String description;

    public MedicalRecord() {
    }

    public MedicalRecord(String username_patient, String description) {
        this.setUsername_patient(username_patient);
        this.setDescription(description);
    }

    public String getUsername_patient() {
        return username_patient;
    }

    public void setUsername_patient(String username_patient) {
        this.username_patient = username_patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
