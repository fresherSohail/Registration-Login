package Login.R.Registration.L.Controller;

import Login.R.Registration.L.entity.Login;
import Login.R.Registration.L.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private Login login;

    @Autowired
    private LoginService loginService;

    @RequestMapping("/sohail")
    public String showForm(){
        return "sohail";
    }

    @PostMapping("/processform")
    public ModelAndView processLogin(@ModelAttribute("processform") Login login) {
        ModelAndView mv = new ModelAndView();

        try {
            if (login != null) {
                if (loginService.loginProcess(login)) {
                    mv.addObject("message", "Login Successfull!!");
                    mv.setViewName("successPage");
                } else{
                    return errorPage();
                }
            } else {
                return errorPage();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return errorPage();
        }

        return mv;
    }


    @GetMapping("/error")
    public ModelAndView errorPage(){
        ModelAndView modelAndView = new ModelAndView("errorPage");
        modelAndView.addObject("message", "Invalid Input");
        modelAndView.addObject("Link","/sohail");
        return modelAndView;
    }

}
