package model;

public class UserModel {
    private int id;
    private String email;
    private String password;
    private String avatar;
    private  String fullname;
    private int roleId;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getFullname() {
        return fullname;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
