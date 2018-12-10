package pl.rafalab.rafalworld.Services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pl.rafalab.rafalworld.Model.User;


public interface AdminService {
	
	Page<User> findAll(Pageable pageable); 
	void updateUser(long id, int roleNumber, int activity);
	Page<User> searchUsers(String param, Pageable pageable);
	
}
