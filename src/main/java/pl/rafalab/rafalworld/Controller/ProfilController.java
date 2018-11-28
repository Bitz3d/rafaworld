package pl.rafalab.rafalworld.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.rafalab.rafalworld.Model.User;
import pl.rafalab.rafalworld.RafUtils.RafUtils;
import pl.rafalab.rafalworld.RafUtils.UserUtils;
import pl.rafalab.rafalworld.Services.UserService;
import pl.rafalab.rafalworld.Validator.ChangePasswordValidator;
import pl.rafalab.rafalworld.Validator.EditUserProfileValidator;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.Locale;

@Controller
public class ProfilController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @GET
    @RequestMapping(value = "/profil")
    public String showUserProfile(Model model){

        String userName= UserUtils.getLoggedUser();

        User user = userService.findUserByEmail(userName);

        long nrRole = user.getRoles().iterator().next().getId();

        user.setNrRoli(nrRole);

        model.addAttribute("user", user);

        return "profil";
    }


    @GET
    @RequestMapping(value = "/editPassword")
    public String editpassword(Model model){

        String username = UserUtils.getLoggedUser();
        User user = userService.findUserByEmail(username);

        model.addAttribute("user",user);

        return "editPassword";
    }


    @POST
    @RequestMapping(value = "/updatepass")
    public String updatePassword(User user, BindingResult bindingResult, Model model, Locale locale){
       String returnPage =null;
       new ChangePasswordValidator().validate(user,bindingResult);
       new ChangePasswordValidator().checkPassword(user.getNewPassword(), bindingResult);
       if(bindingResult.hasErrors()){
        returnPage="editPassword";
       }else{
           userService.updateUserPassword(user.getNewPassword(),user.getEmail());
           returnPage="editPassword";
           model.addAttribute("message", messageSource.getMessage("passwordChange.success", null, locale));
       }

        return returnPage;

    }
    
    @GET
	@RequestMapping(value = "/editprofile")
	public String changeUserData(Model model) {
		String username = UserUtils.getLoggedUser();
		User user = userService.findUserByEmail(username);
		model.addAttribute("user", user);
		return "editprofil";
	}
	
	@POST
	@RequestMapping(value = "/updateprofile")
	public String changeUserDataAction(User user, BindingResult result, Model model, Locale locale) {
		String returnPage = null;
		new EditUserProfileValidator().validate(user, result);
		if (result.hasErrors()) {
			returnPage = "editProfile";
		} else {
			userService.updateUserProfile(user.getName(), user.getLastName(), user.getEmail(), user.getId());
			model.addAttribute("message", messageSource.getMessage("profilEdit.success", null, locale));
			returnPage = "afterEdit";
		}
		return returnPage;
	}



}
