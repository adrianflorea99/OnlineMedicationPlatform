package OMP.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class SideEffect implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "effect", nullable = false)
    private String effect;

    public SideEffect() {
    }

    public SideEffect(int id, String effect) {
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
