package kz.kaznitu.jobs.controllers;

import kz.kaznitu.jobs.models.Job;
import kz.kaznitu.jobs.models.User;
import kz.kaznitu.jobs.repositories.JobRepository;
import kz.kaznitu.jobs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
    public String home(Model model){
        User user = new User();
        model.addAttribute("user",user);
        model.addAttribute("jobs",jobRepository.findAll());
        return "index";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-login");
        return modelAndView;
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user-register");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user) {
        ModelAndView modelAndView = new ModelAndView();
        userService.saveUser(user);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
