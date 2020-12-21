package sumart.web.controller;

import sumart.web.entity.User;
import sumart.web.repository.userRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    userRepository userRepo;

    @GetMapping("/")
    public String getIndex(){
        return "user/index";
    }

    @GetMapping("/list")
    public String getStudentList(Model model){
        Iterable<User> users = userRepo.findAll();
        model.addAttribute("users",users);

        return "user/list";
    }

    @GetMapping("/search")
    public String searchCourses(Model model,@RequestParam("district") String district){
        List<User> users = userRepo.findByDistrictIgnoreCase(district);
        model.addAttribute("users",users);

        return "user/list";
    }
}
