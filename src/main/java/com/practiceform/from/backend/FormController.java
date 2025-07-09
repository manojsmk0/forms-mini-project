package com.practiceform.from.backend;

import com.practiceform.from.backend.repository.Form1Repository;
import com.practiceform.from.backend.repository.Form2Repository;
import com.practiceform.from.backend.repository.Form3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RestController
public class FormController {
    @Autowired
    private Form1Repository form1Repository;

    @Autowired
    private Form2Repository form2Repository;

    @Autowired
    private Form3Repository form3Repository;


    @PostMapping("/register")
    public String formData(
            @RequestParam("fullname") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("dob") String dateStr,
            @RequestParam("gender") String gender,
            @RequestParam(name = "profilephoto", required = false) MultipartFile file
    ) {
        LocalDate date = dateStr.isEmpty() ? null : LocalDate.parse(dateStr);

        Form1 form1 =new Form1(name,email,password,date,gender,file);
        form1Repository.save(form1);

        return " Form received for: " + name;
    }


    @PostMapping("/survey")
    public String formData2(@RequestParam("language") String language,@RequestParam(value = "skills",required = false)String skills,@RequestParam("reason")String para){

        Form2 form2 =new Form2(language,skills,para);
        form2Repository.save(form2);
        return " Form received";
    }


    @PostMapping("/savesettings")
    public  String formData3(@RequestParam("volume")String range,@RequestParam("theme")String color,@RequestParam("coding_hours")String num){
        Form3 form3 =new Form3(range,color,num);
        form3Repository.save(form3);
        return " Form received";
    }
}
