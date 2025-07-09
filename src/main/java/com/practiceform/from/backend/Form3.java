package com.practiceform.from.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Form3{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String range;
   private String color;
   private String num;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Form3(String range, String color, String num){
        this.range=range;
        this.color=color;
        this.num=num;
    }
}
