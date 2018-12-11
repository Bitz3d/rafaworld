package pl.rafalab.rafalworld.Controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pl.rafalab.rafalworld.Model.User;
import pl.rafalab.rafalworld.RafUtils.RafUtils;

@Controller
public class UploadFileController {

	
	@PostMapping("/admin/users/upload")
	@Secured("ROLE_ADMIN")
	public String importUsersFromFile(@RequestParam("filename") MultipartFile mfile){
		String uploadDir = System.getProperty("user.dir")+"/uploads";
		File file;
		try {
			file = new File(uploadDir);
			if(!file.exists()){
				file.mkdir();
			}
			Path fileAndPath = Paths.get(uploadDir, mfile.getOriginalFilename());
			Files.write(fileAndPath, mfile.getBytes());
			file = new File(fileAndPath.toString());
			List<User> userList = RafUtils.readUserXmlFile(file);
			userList.forEach(u -> System.out.println(u.getEmail()+" || "+ u.getName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/users/1";
	}
	
}
