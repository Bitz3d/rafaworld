package pl.rafalab.rafalworld.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.rafalab.rafalworld.Model.User;
import pl.rafalab.rafalworld.Services.UserService;

@RestController
public class RestConnectionController {

	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/api")
	public List<User> getAllUsers(){
		return userService.findAll();
	}
}
