package pl.rafalab.rafalworld.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.ws.rs.GET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.rafalab.rafalworld.Model.User;
import pl.rafalab.rafalworld.Services.AdminService;
import pl.rafalab.rafalworld.Services.UserService;

@Controller
public class AdminController{

	private int ELEMENTS = 5;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userServices;
	
	@Autowired
	private MessageSource messageSource;
	
	@GET
	@RequestMapping(value="/admin")
	@Secured(value={"ROLE_ADMIN"})
	public String openAdminPage(){
		return "admin/admin";
	}
	
	@GetMapping(value="/admin/users/{page}")
	@Secured(value={"ROLE_ADMIN"})
	public String allUsersPage(@PathVariable("page") int page, Model model){
			Page<User> pages = getAllUsersPageable(page - 1, false, null);
			int totalPages = pages.getTotalPages();
			int currentPage = pages.getNumber();
			List<User> userList = pages.getContent();
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("currentPage", currentPage + 1);
			model.addAttribute("userList", userList);
			model.addAttribute("recordStartCounter", currentPage * ELEMENTS);
			
			return "admin/users";
	}
	
	@GetMapping(value="/admin/users/importusers")
	@Secured(value={"ROLE_ADMIN"})
	public String getUploadPage(Model model){
	
		return "admin/importusers";
	}
	
	@GetMapping(value="/admin/users/edit/{id}")
	@Secured(value={"ROLE_ADMIN"})
	public String edituser(@PathVariable("id") int id, Model model)
	{		
		User user = userServices.findUserById(id);
		Map<Integer, String> roleMap = prepareRoleMap();
		Map<Integer, String> actvieMap = prepareActiveMap();
		int role = user.getRoles().iterator().next().getId();
		user.setNrRoli(role);
		model.addAttribute("roleMap", roleMap);
		model.addAttribute("actvieMap", actvieMap);
		model.addAttribute("user", user);
		
		return "admin/useredit"; 
	}
		
	@PostMapping(value="/admin/updateuser/{id}")
	@Secured(value={"ROLE_ADMIN"})
	public String updateUser(@PathVariable("id") long id, User user){
		int roleNumber = user.getNrRoli();
		int activity = user.getActive();
		adminService.updateUser(id, roleNumber, activity);		
		return "redirect:/admin/users/1";
		}
	
	@GetMapping(value="/admin/users/search/{searchWord}/{page}")
	@Secured("ROLE_ADMIN")
	public String openSearchUsersPage(@PathVariable("searchWord") String searchWord, 
			@PathVariable("page") int page, Model model) {
		Page<User> pages = getAllUsersPageable(page - 1, true, searchWord);
		int totalPages = pages.getTotalPages();
		int currentPage = pages.getNumber();
		List<User> userList = pages.getContent();
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage + 1);
		model.addAttribute("userList", userList);
		model.addAttribute("recordStartCounter", currentPage * ELEMENTS);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("userList", userList);
		return "admin/usersearch";
}
		
	//helper methods
	private Page<User> getAllUsersPageable(int page, boolean search, String seachWord) {
		Page<User> pages;
		if (!search) {
			pages = adminService.findAll(PageRequest.of(page, ELEMENTS));
		} else {
			pages = adminService.searchUsers(seachWord,PageRequest.of(page, ELEMENTS));
		}
		for (User users : pages) {
			int numerRoli = users.getRoles().iterator().next().getId();
			users.setNrRoli(numerRoli);
		}
		return pages;
	}

	private Map<Integer, String> prepareRoleMap() {
			Locale locale = Locale.getDefault();
			Map<Integer, String> roleMap = new HashMap<Integer, String>();
			roleMap.put(1, messageSource.getMessage("word.admin", null, locale));
			roleMap.put(2, messageSource.getMessage("word.user", null, locale));
			
			return roleMap;
	}
	
	private Map<Integer, String> prepareActiveMap() {
		Locale locale = Locale.getDefault();
		Map<Integer, String> activeMap = new HashMap<Integer, String>();
		activeMap.put(0, messageSource.getMessage("word.nie", null, locale));
		activeMap.put(1, messageSource.getMessage("word.tak", null, locale));
		
		return activeMap;
}
	
}
