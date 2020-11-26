package OMP.Entity;

import javax.persistence.*;

@Entity
public class MedicationPlanList {

    @EmbeddedId
    MedicationPlanListKey id;

    @ManyToOne
    @MapsId("planId")
    @JoinColumn(name = "id_plan")
    private MedicationPlan medicationPlan;

    @ManyToOne
    @MapsId("medicationId")
    @JoinColumn(name = "id_medication")
    private Medication medication;

    private String intervals;

    public MedicationPlan getMedicationPlan() {
        return medicationPlan;
    }

    public void setMedicationPlan(MedicationPlan medicationPlan) {
        this.medicationPlan = medicationPlan;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public String getIntervals() {
        return intervals;
    }

    public void setIntervals(String intervals) {
        this.intervals = intervals;
    }
}
