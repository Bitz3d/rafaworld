package pl.rafalab.rafalworld.Controller;

import javax.ws.rs.GET;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController{

	@GET
	@RequestMapping(value="/admin")
	@Secured(value={"ROLE_ADMIN"})
	public String openAdminPage(){
		return "admin/admin";
	}
}
