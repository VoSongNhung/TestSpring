package com.example.demo.Controller;


import com.example.demo.Service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping("/input")
    public String input(){
        return "inputname";
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name",required = false,defaultValue = "") String name,Model model){
        model.addAttribute("name", name);
        return "hello";
    }

}
