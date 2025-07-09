package com.practiceform.from.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Form2{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long  id;
    private String language;
    private String skills;
    private String para;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Form2(String language, String skills, String para){
        this.language =language;
        this.skills=skills;
        this.para=para;
    }
}
