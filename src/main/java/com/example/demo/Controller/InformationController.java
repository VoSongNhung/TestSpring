package com.example.demo.Controller;

import com.example.demo.Entity.Infomation;
import com.example.demo.Responsitory.InformationRespository;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InformationController {
    @Autowired
    private InformationRespository informationRespository;
    @GetMapping("/information")
    public String listALll(Model model){
        List<Infomation> list = informationRespository.findAll();
        model.addAttribute("listInformation",list);
        return "information";
    }
    @GetMapping("/add")
    public String Add(Model model) {
        model.addAttribute("inf", new Infomation());
        return "login";
    }
    @PostMapping("/add")
    public String Add(@ModelAttribute Infomation infomation,Model model){
        informationRespository.save(infomation);
        List<Infomation> list = informationRespository.findAll();
        model.addAttribute("listInformation",list);
        return "information";
    }
}
