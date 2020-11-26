package OMP.DTO;

public class SideEffectDTO {
    private int id;
    private String effect;

    public SideEffectDTO() {
    }

    public SideEffectDTO(int id, String effect) {
        this.setId(id);
        this.setEffect(effect);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}
