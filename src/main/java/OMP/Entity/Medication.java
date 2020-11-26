package OMP.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Medication implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "dosage", nullable = false)
    private int dosage;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "med_effect",
            joinColumns = @JoinColumn(name = "id_med"),
            inverseJoinColumns = @JoinColumn(name = "id_effect")
    )
    private Set<SideEffect> sideEffectsResulted = new HashSet<>();

    @OneToMany(mappedBy = "medication")
    private Set<MedicationPlanList> medicationPlanList = new HashSet<>();

    public Medication() {
    }

    public Medication(int id, String name, int dosage) {
        this.setId(id);
        this.setName(name);
        this.setDosage(dosage);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public Set<SideEffect> getSideEffectsResulted() {
        return sideEffectsResulted;
    }

    public void setSideEffectsResulted(Set<SideEffect> sideEffectsResulted) {
        this.sideEffectsResulted = sideEffectsResulted;
    }
}
