package com.practiceform.from.backend;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Form1 {
    String name;
    String email;
    String password;
    LocalDate date;
    String gender;
    MultipartFile file;

    public Form1(String name, String email, String password, LocalDate date, String gender, MultipartFile file) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.date = date;
        this.gender = gender;
        this.file = file;
    }
}
class Form2{
    String language;
    String skills;
    String para;

    public Form2(String language,String skills,String para){
        this.language =language;
        this.skills=skills;
        this.para=para;
    }
}
class Form3{
    String range;
    String color;
    String num;
    public Form3(String range,String color,String num){
        this.range=range;
        this.color=color;
        this.num=num;
    }
}

@RestController
public class FormController {

    List<Form1> forms = new ArrayList<>();

    @PostMapping("/register")
    public String formData(
            @RequestParam("fullname") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("dob") String dateStr,
            @RequestParam("gender") String gender,
            @RequestParam(name = "profilephoto", required = false) MultipartFile file
    ) {
        // Convert date string safely
        LocalDate date = dateStr.isEmpty() ? null : LocalDate.parse(dateStr);

        // Store form
        forms.add(new Form1(name, email, password, date, gender, file));

        // Log for debug
        System.out.println(" FORM SUBMITTED:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("DOB: " + date);
        System.out.println("File: " + (file != null && !file.isEmpty() ? file.getOriginalFilename() : "No file"));

        return " Form received for: " + name;
    }

    List<Form2> forms2 =new ArrayList<>();
    @PostMapping("/survey")
    public String formData2(@RequestParam("language") String language,@RequestParam(value = "skills",required = false)String skills,@RequestParam("reason")String para){
        forms2.add(new Form2(language,skills,para));

        System.out.println(" FORM SUBMITTED:");
        System.out.println("Language: " + language);
        System.out.println("Skills: " + skills);
        System.out.println("Reason: " + para);
        return " Form received";
    }

    List<Form3> forms3= new ArrayList<>();
    @PostMapping("/savesettings")
    public  String formData3(@RequestParam("volume")String range,@RequestParam("theme")String color,@RequestParam("coding_hours")String num){
    forms3.add(new Form3(range,color,num));
        System.out.println(" FORM SUBMITTED:");
        System.out.println("volume: " + range);
        System.out.println("Theme: " + color);
        System.out.println("Hours: " + num);
        return " Form received";
    }
}
