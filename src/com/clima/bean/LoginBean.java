
package com.clima.bean;

public class LoginBean {
    
    int id_login;
    String login;
    String senha;
    String email;
    String perfil;

    public LoginBean() {
    }

    public LoginBean(int id_login, String login, String senha, String email, String perfil) {
        this.id_login = id_login;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.perfil = perfil;
    }

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
}
