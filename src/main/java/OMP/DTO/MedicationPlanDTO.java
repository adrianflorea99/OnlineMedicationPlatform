package OMP.DTO;

public class MedicationPlanDTO {
    private int id;
    private PatientDTO patientDTO;
    private int period;

    public MedicationPlanDTO() {
    }

    public MedicationPlanDTO(int id, PatientDTO patientDTO, int period) {
        this.setId(id);
        this.patientDTO = patientDTO;
        this.setPeriod(period);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
