package pl.rafalab.rafalworld.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.rafalab.rafalworld.Model.User;
import pl.rafalab.rafalworld.RafUtils.UserUtils;
import pl.rafalab.rafalworld.Services.UserService;

import javax.ws.rs.GET;

@Controller
public class ProfilController {

    @Autowired
    private UserService userService;

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


}
