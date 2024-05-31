package model;

import java.sql.Date;
import java.sql.Timestamp;

public class UserDBO {

    private int id;
    private String username;
    private String password;
    private String email;
    private String name;
    private Date DOB;
    private int isAdmin;
    private String avatar;
    private Timestamp created_at;
    private String phone;
    private int status;

    public UserDBO() {
    }

    public UserDBO(int id, String username, String password, String email, String name, Date DOB, int isAdmin, String avatar, Timestamp created_at, String phone, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.DOB = DOB;
        this.isAdmin = isAdmin;
        this.avatar = avatar;
        this.created_at = created_at;
        this.phone = phone;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDBO{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", name=" + name + ", DOB=" + DOB + ", isAdmin=" + isAdmin + ", avatar=" + avatar + ", created_at=" + created_at + ", phone=" + phone + ", status=" + status + '}';
    }

   
   
}