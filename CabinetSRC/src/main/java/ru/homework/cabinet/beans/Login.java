package ru.homework.cabinet.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.homework.cabinet.entities.User;
import ru.homework.cabinet.service.UserService;

@Component
public class Login {

    @Autowired
    private UserService userService;
    @Autowired
    private Customer customer;
    private String name;
    private String psw;
    private String msg;
    private boolean isLogged;

    public boolean isLogged() {

        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String validate(){
        User user = userService.getUserByName(name);
        if (user != null && user.getPass().equals(psw)){
            customer.setCurrentUser(user);
            return "home";
        }
        return "login";
    }
}