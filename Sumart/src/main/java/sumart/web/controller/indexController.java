package sumart.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {



    @RequestMapping(value = {"/","/welcome"})
    public String getPage(Model model) {
        return "welcome";
    }


    }