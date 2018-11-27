package pl.rafalab.rafalworld.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.rafalab.rafalworld.Model.User;

import javax.ws.rs.GET;

@Controller
public class EditPasswordController {



    @GET
    @RequestMapping(value = "/editPassword")
    public String editpassword(Model model){

        User user = new User();

        model.addAttribute("user",user);

        return "editPassword";
    }

}
