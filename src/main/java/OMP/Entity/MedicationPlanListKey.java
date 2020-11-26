package OMP.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MedicationPlanListKey implements Serializable {

    @Column(name = "id_plan")
    int planId;

    @Column(name = "id_medication")
    int medicationId;
}
