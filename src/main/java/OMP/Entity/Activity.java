package OMP.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Activity implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_time", nullable = false)
    private BigInteger start_time;

    @Column(name = "end_time", nullable = false)
    private BigInteger end_time;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "doingActivities", fetch = FetchType.EAGER)
    private Set<Patient> madeByPatients = new HashSet<>();

    public Activity() {
    }

    public Activity(Integer id, BigInteger start_time, BigInteger end_time, String name) {
        this.id = id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getStart_time() {
        return start_time;
    }

    public void setStart_time(BigInteger start_time) {
        this.start_time = start_time;
    }

    public BigInteger getEnd_time() {
        return end_time;
    }

    public void setEnd_time(BigInteger end_time) {
        this.end_time = end_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Patient> getMadeByPatients() {
        return madeByPatients;
    }

    public void setMadeByPatients(Set<Patient> madeByPatients) {
        this.madeByPatients = madeByPatients;
    }
}