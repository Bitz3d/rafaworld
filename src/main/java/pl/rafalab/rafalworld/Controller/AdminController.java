package pl.rafalab.rafalworld.Controller;

import java.util.List;

import javax.ws.rs.GET;

import org.aspectj.weaver.patterns.IfPointcut.IfFalsePointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.rafalab.rafalworld.Model.User;
import pl.rafalab.rafalworld.Services.AdminService;
import pl.rafalab.rafalworld.Services.UserService;

@Controller
public class AdminController{

	@Autowired
	private AdminService adminService;
	
	@GET
	@RequestMapping(value="/admin")
	@Secured(value={"ROLE_ADMIN"})
	public String openAdminPage(){
		return "admin/admin";
	}
	@GET
	@RequestMapping(value="/admin/users/{page}")
	@Secured(value={"ROLE_ADMIN"})
	public String allUsersPage(@PathVariable("page") int page, Model model){
		Page<User> userList = getAllUsersPageable(page);
		model.addAttribute("userList",userList);
		return "admin/users";
	}
	
	
	
	//helper methods
	private Page<User> getAllUsersPageable(int page) {
		int element =5;
		Page<User> pages = adminService.findAll(PageRequest.of(page, element)); 
		pages.forEach(u -> {
			int roleNumber = u.getRoles().iterator().next().getId();
			u.setNrRoli(roleNumber);
		});
		
		return pages;
		
	}
	
}
