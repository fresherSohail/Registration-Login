package Login.R.Registration.L.Controller;

import Login.R.Registration.L.entity.User;
import Login.R.Registration.L.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/errorPage")
    public String show(){
        return "";
    }

    @PostMapping("/registrate")
    public ModelAndView createUser(@ModelAttribute("registrate") User user){
        ModelAndView modelV = new ModelAndView();

        if(user!=null){
            if(registerService.createUser(user)){
                modelV.addObject("message", "SucessFully registered");
                modelV.setViewName("sohail");
            }else {
                return errorPage();
            }
        }else{
            return errorPage();
        }
        return modelV;
    }

    @GetMapping("/alreadyRegistered")
    public ModelAndView errorPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "User already exists");
        modelAndView.addObject("link","/sohail");
        modelAndView.setViewName("sohail");
        return modelAndView;
    }


}

