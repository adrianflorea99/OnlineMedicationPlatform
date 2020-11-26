package OMP.DTO;

import java.util.HashSet;
import java.util.Set;

public class MedicationDTO {
    private int id;
    private String name;
    private int dosage;
    private Set<SideEffectDTO> sideEffectsResulted = new HashSet<>();

    public MedicationDTO() {
    }

    public MedicationDTO(int id, String name, int dosage, Set<SideEffectDTO> sideEffectsResulted) {
        this.setId(id);
        this.setName(name);
        this.setDosage(dosage);
        this.setSideEffectsResulted(sideEffectsResulted);
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

    public Set<SideEffectDTO> getSideEffectsResulted() {
        return sideEffectsResulted;
    }

    public void setSideEffectsResulted(Set<SideEffectDTO> sideEffectsResulted) {
        this.sideEffectsResulted = sideEffectsResulted;
    }
}
