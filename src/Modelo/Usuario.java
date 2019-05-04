package Modelo;

import java.sql.Date;

public class Usuario {

    private String first_name;
    private String last_name;
    private Date born_date;
    private String email;
    private String password;

    public Usuario() {
    }

    public Usuario(String first_name, String last_name, Date born_date, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.born_date = born_date;
        this.email = email;
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBorn_date() {
        return born_date;
    }

    public void setBorn_date(Date born_date) {
        this.born_date = born_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "first_name=" + first_name + ", last_name=" + last_name + ", born_date=" + born_date + ", email=" + email + ", password=" + password + '}';
    }

}
