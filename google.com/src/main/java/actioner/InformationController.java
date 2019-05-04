package actioner;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableAutoConfiguration
@Controller
public class InformationController {

    @RequestMapping("/general")
    public String general(@RequestParam(required = false, defaultValue = "Dear User") String user, Model model) {
        model.addAttribute("name", user);
        return "general";
    }

    @RequestMapping("/")
    public String general(Model model) {
        return "home";
    }
}
