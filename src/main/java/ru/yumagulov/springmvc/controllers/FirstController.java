package ru.yumagulov.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println("Hello " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam(value = "name",required = false) String name,
                              @RequestParam(value = "surname",required = false)String surname){
        System.out.println("Goodbye " + name + " " + surname);
        return "first/goodbye";
    }
    @GetMapping("/calculator")
    public String goodByePage(@RequestParam(value = "a") int a,
                              @RequestParam(value = "b")int b,
                              @RequestParam(value = "action")String action,
                              Model model){
        double result;
        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / (double)b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "addition":
                result = a + b;
                break;
            default:
                result = Double.NaN;
        }
        model.addAttribute("result",result);
        return "first/calculator";
    }
}
