package pl.rafalab.rafalworld.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pl.rafalab.rafalworld.Model.User;
import pl.rafalab.rafalworld.Repositories.AdminRepository;

@Transactional
@Service("adminServices")
public class AdminServiceImp implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Page<User> findAll(Pageable pageable){	
		 Page<User> userList = adminRepository.findAll(pageable);
		 return userList;
	}

	@Override
	public void updateUser(long id, int roleNumber, int activity){
		adminRepository.updateUserAvtivity(activity, id);
		adminRepository.updateUserRole(roleNumber, id);
	}

	@Override
	public Page<User> searchUsers(Pageable pageable, String param) {
			Page<User> foundUsers =  adminRepository.searchUsers(param, pageable);
		return foundUsers;
	}
}
