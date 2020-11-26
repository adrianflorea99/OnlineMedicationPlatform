package OMP.Producer;

import java.io.Serializable;

public class SensorActivity implements Serializable {

    private String username;
    private String activity;
    private long start;
    private long end;

    public SensorActivity(String username, String activity, long start, long end) {
        this.username = username;
        this.activity = activity;
        this.start = start;
        this.end = end;
    }

    public SensorActivity() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "{" +
                "\"patient_id\" : \"" + username + "\"" +
                ", \"activity\" : \"" + activity + "\"" +
                ", \"start\" : " + start +
                ", \"end\" : " + end + '}';
    }
}
