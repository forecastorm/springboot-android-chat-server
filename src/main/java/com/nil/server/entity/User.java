package com.nil.server.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")

public class User {


    public static User USER_NAME_TAKEN = new User("userName Taken", "", 0, "");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name")
    private String userName;


    @Column(name = "gender")
    private String gender;


    @Column(name = "status")
    private int status;


    @Column(name = "imageURL")
    private String imageURL;

    public User() {
    }

    public User(String userName, String gender, int status, String imageURL) {
        this.userName = userName;
        this.gender = gender;
        this.status = status;
        this.imageURL = imageURL;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", status=" + status +
                '}';
    }
}
