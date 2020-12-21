package sumart.web.entity;



import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "USERSSS")
public class User {
    @Id
    @Column(name = "U_ID")
    @NotNull
    Integer userId;

    @Size(min = 2, max = 40)
    String name;

    @Email
    @Size(min = 2, max = 40)
    String email;

    @Size(min = 2, max = 40)
    String type;

    @Size(min = 2, max = 40)
    String district;

    @Size(min = 2, max = 40)
    String subdistrict;

    Integer apNum;

    Integer houseNum;


    Float debt;

    @Size(min = 2, max = 40)
    String lastPaid;

    @Size(min = 2, max = 40)
    String current;



//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "Enrollments",
//            joinColumns = @JoinColumn(name = "st_id"),
//            inverseJoinColumns = @JoinColumn(name = "c_id"))
//    List<Course> courses;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSubdistrict() {
        return subdistrict;
    }

    public void setSubdistrict(String subdistrict) {
        this.subdistrict = subdistrict;
    }

    public Integer getApNum() {
        return apNum;
    }

    public void setApNum(Integer apNum) {
        this.apNum = apNum;
    }

    public Integer getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(Integer houseNum) {
        this.houseNum = houseNum;
    }

    public Float getDebt() {
        return debt;
    }

    public void setDebt(Float debt) {
        this.debt = debt;
    }

    public String getLastPaid() {
        return lastPaid;
    }

    public void setLastPaid(String lastPaid) {
        this.lastPaid = lastPaid;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }
}
