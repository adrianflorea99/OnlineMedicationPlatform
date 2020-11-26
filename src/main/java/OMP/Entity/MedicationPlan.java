package OMP.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MedicationPlan implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "period", nullable = false)
    private int period;

    @OneToMany(mappedBy = "medicationPlan")
    private Set<MedicationPlanList> medicationPlanList = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username_patient", nullable = false)
    private Patient patient;

    public MedicationPlan() {
    }

    public MedicationPlan(int id, Patient patient, int period) {
        this.setId(id);
        this.patient = patient;
        this.setPeriod(period);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Set<MedicationPlanList> getMedicationPlanList() {
        return medicationPlanList;
    }

    public void setMedicationPlanList(Set<MedicationPlanList> medicationPlanList) {
        this.medicationPlanList = medicationPlanList;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
