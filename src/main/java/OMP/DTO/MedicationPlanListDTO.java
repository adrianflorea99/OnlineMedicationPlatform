package OMP.DTO;

public class MedicationPlanListDTO {

    private int period;
    private MedicationDTO medicationDTO;
    private String intervals;

    public MedicationPlanListDTO() {
    }

    public MedicationPlanListDTO(int period, MedicationDTO medicationDTO, String intervals) {
        this.period = period;
        this.medicationDTO = medicationDTO;
        this.intervals = intervals;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public MedicationDTO getMedicationDTO() {
        return medicationDTO;
    }

    public void setMedicationDTO(MedicationDTO medicationDTO) {
        this.medicationDTO = medicationDTO;
    }

    public String getIntervals() {
        return intervals;
    }

    public void setIntervals(String intervals) {
        this.intervals = intervals;
    }
}
