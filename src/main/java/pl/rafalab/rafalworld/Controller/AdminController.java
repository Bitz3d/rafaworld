package pl.rafalab.rafalworld.Controller;

import javax.ws.rs.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController{

	@GET
	@RequestMapping(value="/admin")
	public String openAdminPage(){
		return "admin/admin";
	}
}
