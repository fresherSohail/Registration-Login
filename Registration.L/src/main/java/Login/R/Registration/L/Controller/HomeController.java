package Login.R.Registration.L.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        System.out.println("Home main.java.webMvc.controller run....");
        return "sohail";
    }

    @RequestMapping("/about")
    public String about() {
        System.out.println("About main.java.webMvc.controller run....");
        return "about";
    }

}
