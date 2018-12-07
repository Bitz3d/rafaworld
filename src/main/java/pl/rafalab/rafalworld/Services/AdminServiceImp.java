package pl.rafalab.rafalworld.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pl.rafalab.rafalworld.Model.User;
import pl.rafalab.rafalworld.Repositories.AdminRepository;

public class AdminServiceImp implements AdminService {
	
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Page<User> findAll(Pageable pageable) {
		
		 Page<User> userList = adminRepository.findAll(pageable);
		
		return userList;
	}

}
