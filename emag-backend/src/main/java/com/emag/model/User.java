package com.emag.model;

import com.emag.exceptions.UserException;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
public class User {

    private Long id;
    private String name;
    private String password;
    private String email;
    private String pictureUrl;
    private String gender;
    private String phone;
    private String type;

    public User() {
    }

    public User(String name, String password, String email) throws UserException {
        setName(name);
        setPassword(password);
        setEmail(email);
    }

    public User(Long id, String name, String email, String pictureUrl, String gender, String phone) throws UserException {
        setId(id);
        setName(name);
        setEmail(email);
        setPictureUrl(pictureUrl);
        setGender(gender);
        setPhone(phone);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) throws UserException {
        if (id!=null && id>-1)
            this.id = id;
        else throw new UserException("Invalid id");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws UserException {
        if (name != null && name.trim().length() > 0) {
            this.name = name;
        } else throw new UserException("Invalid name");
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

    public void setEmail(String email) throws UserException {
        if (email != null && email.trim().length() > 0) {
            this.email = email;
        } else throw new UserException("Invalid email");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPictureUrl(String pictureUrl) throws UserException {
        if (pictureUrl != null && pictureUrl.trim().length() > 0)
            this.pictureUrl = pictureUrl;
        else throw new UserException("invalid picture url");
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) throws UserException {
        if (gender != null && gender.trim().length() > 0)
            this.gender = gender;
        else throw new UserException("invalid gender");
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws UserException {
        if (phone != null && phone.trim().length() == 10 && phone.startsWith("08"))
            this.phone = phone;
        else throw new UserException("invalid phone");
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
