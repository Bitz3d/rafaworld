package pl.rafalab.rafalworld.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.rafalab.rafalworld.Model.User;
import pl.rafalab.rafalworld.Services.UserService;
import pl.rafalab.rafalworld.Validator.UserRegisterValidator;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.Locale;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;


    @Autowired
    MessageSource messageSource;

    @GET
    @RequestMapping(value = "/register")
    public String registerForm(Model model){

        User user = new User();
        model.addAttribute("user", user);
        return "register";

    }

    @POST
    @RequestMapping(value = "/adduser")
    public String adduser(User user, BindingResult bindingResult, Model model, Locale locale){

        String returnPage = null;

        User userExist = userService.findUserByEmail(user.getEmail());

        new UserRegisterValidator().validateEmailExist(userExist, bindingResult);

        new UserRegisterValidator().validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            returnPage = "register";
        } else {
            userService.saveUser(user);
            model.addAttribute("message", messageSource.getMessage("user.register.success", null, locale));
            model.addAttribute("user", new User());
            returnPage = "register";
        }

        return returnPage;
    }

}
