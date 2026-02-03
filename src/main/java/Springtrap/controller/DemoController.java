package springtrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springtrap.model.Student;

@Controller
public class DemoController {

    @GetMapping("/demo")
    public String demoPage(Model model) {
        Student student = new Student(1, "Nguyễn Văn A");
        model.addAttribute("student", student);
        model.addAttribute("message", "Welcome Thymeleaf!");
        return "demo";
    }
}