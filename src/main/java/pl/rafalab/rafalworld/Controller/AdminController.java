package pl.rafalab.rafalworld.Controller;

import java.util.List;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.rafalab.rafalworld.Model.User;
import pl.rafalab.rafalworld.Services.UserService;

@Controller
public class AdminController{

	@Autowired
	private UserService userServices;
	
	@GET
	@RequestMapping(value="/admin")
	@Secured(value={"ROLE_ADMIN"})
	public String openAdminPage(){
		return "admin/admin";
	}
	@GET
	@RequestMapping(value="/admin/users")
	@Secured(value={"ROLE_ADMIN"})
	public String allUsersPage(Model model){
		List<User> userList = getUserList();
		model.addAttribute("userList",userList);
		return "admin/users";
	}
	
	
	
	//helper methods
	private List<User> getUserList() {
		List<User> userList = userServices.findAll();
		userList.forEach(u -> {
			int roleNumber = u.getRoles().iterator().next().getId();
			u.setNrRoli(roleNumber);
		});
		return userList;
	}
	
	
}
