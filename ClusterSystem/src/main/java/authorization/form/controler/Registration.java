package authorization.form.controler;

import authorization.form.Role;
import authorization.form.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class Registration {
    @Autowired
    UserRepository dataSource;

    @GetMapping("/registration")
    public String registrationForm() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUserToSystem(User user) {

        User newUser = dataSource.findByUsername(user.getUsername());
        if (newUser == null) {
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.USER));
            dataSource.save(user);
            return "redirect:/login";
        }
        return "registration";
    }

}
