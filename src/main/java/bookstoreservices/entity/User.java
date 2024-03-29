package bookstoreservices.entity;

import bookstoreservices.common.Constant;
import jakarta.persistence.*;
import org.joda.time.DateTime;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private String emailId;
    private String phoneNumber;
    private String userType= Constant.User_Type.NORMAL;
    private String password;
    private boolean isActive=true;
    private Integer loginCount=0;
    private String ssoType;

    @Convert(converter = DateTimeConverter.class)
    private DateTime loginAt;

    @Convert(converter = DateTimeConverter.class)
    private DateTime createdAt;

    @Convert(converter = DateTimeConverter.class)
    private DateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nmae) {
        this.name = nmae;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public String getSsoType() {
        return ssoType;
    }

    public void setSsoType(String ssoType) {
        this.ssoType = ssoType;
    }

    public DateTime getLoginAt() {
        return loginAt;
    }

    public void setLoginAt(DateTime loginAt) {
        this.loginAt = loginAt;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    @PrePersist
    public void  onSave(){
        //create at and update at
        DateTime currentDateTime= new DateTime();

        this.createdAt=currentDateTime;
        this.updatedAt=currentDateTime;
    }

    @PostPersist
    public void onUpdate(){
        //update at
        DateTime currentDateTime= new DateTime();

        this.updatedAt=currentDateTime;
    }

}
