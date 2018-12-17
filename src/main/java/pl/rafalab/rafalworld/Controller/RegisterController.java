package pl.rafalab.rafalworld.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.rafalab.rafalworld.Model.User;
import pl.rafalab.rafalworld.RafUtils.RafUtils;
import pl.rafalab.rafalworld.Services.EmailSender;
import pl.rafalab.rafalworld.Services.UserService;
import pl.rafalab.rafalworld.Validator.UserRegisterValidator;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;
    @Autowired
    MessageSource messageSource;
    @Autowired
    EmailSender emailSender;
    
    @GetMapping(value = "/register")
    public String registerForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping(value = "/adduser")
    public String adduser(User user, BindingResult bindingResult, Model model, Locale locale,
    		HttpServletRequest request){
        String returnPage = null;
        User userExist = userService.findUserByEmail(user.getEmail());
        new UserRegisterValidator().validateEmailExist(userExist, bindingResult);
        new UserRegisterValidator().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            returnPage = "register";
        } else {
        	user.setActivationCode(RafUtils.randomCodeGenerator());
        	String getHost= request.getRequestURL().toString();
        	System.out.println();
        	String text = "Wymagane potwierdzenie rejestracji. Kliknij w link, aby aktywować konto: "+
        		   getHost+"activatelink/"+user.getActivationCode();

            userService.saveUser(user);
            emailSender.sendEmail(user.getEmail(), messageSource.getMessage("mail.subject", null, locale), text);
            model.addAttribute("message", messageSource.getMessage("mail.send", null, locale));
            returnPage = "index";
        }
        return returnPage;
    }
    
    @GetMapping(value="/activatelink/{activationCode}")
    public String activateUser(@PathVariable("activationCode") String activationCode, Model model, Locale locale){
    	userService.updateUserActivation(1, activationCode);
    	model.addAttribute("message", messageSource.getMessage("user.register.success",null ,locale));
    	return "index";
    }
}
