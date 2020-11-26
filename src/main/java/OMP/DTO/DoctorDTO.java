package OMP.DTO;

import java.sql.Date;

public class DoctorDTO {
    private String username;
    private String name;
    private Date birth_date;
    private String gender;
    private String address;

    public DoctorDTO() {

    }

    public DoctorDTO(String username, String name, Date birth_date, String gender, String address) {
        this.username = username;
        this.name = name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
