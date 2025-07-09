package com.practiceform.from.backend;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
@Entity
public class Form1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

   private String name;
   private String email;
   private String password;
   private LocalDate date;
   private String gender;
    @Transient
    MultipartFile file;

    public  Form1(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Form1(String name, String email, String password, LocalDate date, String gender, MultipartFile file) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.date = date;
        this.gender = gender;
        this.file = file;
    }
}