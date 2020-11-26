package OMP.DTO;

import java.math.BigInteger;

public class ActivityDTO {
    private Integer id;
    private BigInteger start_time;
    private BigInteger end_time;
    private String name;

    public ActivityDTO() {
    }

    public ActivityDTO(Integer id, BigInteger start_time, BigInteger end_time, String name) {
        this.setId(id);
        this.setStart_time(start_time);
        this.setEnd_time(end_time);
        this.setName(name);
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
}
