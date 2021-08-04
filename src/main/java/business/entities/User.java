package business.entities;

public class User {
    private int user_id; // just used to demo retrieval of autogen keys in UserMapper
    private String user_mail;
    private String user_password; // Should be hashed and secured
    private int user_phone;
    private int user_credit;
    private String user_role;

    public User(String user_mail, String user_password, int user_phone, int user_credit, String user_role) {
        this.user_mail = user_mail;
        this.user_password = user_password;
        this.user_phone = user_phone;
        this.user_credit = user_credit;
        this.user_role = user_role;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return user_mail;
    }

    public void setEmail(String user_mail) {
        this.user_mail = user_mail;
    }

    public String getPassword() {
        return user_password;
    }

    public void setPassword(String user_password) {
        this.user_password = user_password;
    }

    public int getPhone() {
        return user_phone;
    }

    public void setPhone(int user_phone) {
        this.user_phone = user_phone;
    }

    public int getCredit() {
        return user_credit;
    }

    public void setCredit(int user_credit) {
        this.user_credit = user_credit;
    }

    public String getRole() {
        return user_role;
    }

    public void setRole(String user_role) {
        this.user_role = user_role;
    }
}
