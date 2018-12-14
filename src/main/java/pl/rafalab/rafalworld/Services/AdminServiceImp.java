package pl.rafalab.rafalworld.Services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.rafalab.rafalworld.Model.Role;
import pl.rafalab.rafalworld.Model.User;
import pl.rafalab.rafalworld.Repositories.AdminRepository;
import pl.rafalab.rafalworld.Repositories.RoleRepository;

@Transactional
@Service("adminServices")
public class AdminServiceImp implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private JpaContext jpaContext;
	@Autowired
	RoleRepository roleRepository; 
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
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
	public Page<User> searchUsers(String param, Pageable pageable) {
			Page<User> foundUsers =  adminRepository.searchUsers(param, pageable);
		return foundUsers;
	}

	@Override
	public void insertBatch(List<User> userList) {
		EntityManager entityManager = jpaContext.getEntityManagerByManagedType(User.class);
		
		userList.forEach(u -> {
			int counter=0;
			Role role = roleRepository.findByRole("ROLE_USER");
			u.setRoles(new HashSet<Role>(Arrays.asList(role)));
			u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
			entityManager.persist(u);
			counter++;
			if(counter % 50 == 0 && counter > 0){
				 entityManager.flush();
				 entityManager.clear();
				 System.out.println("Załadowano " + counter + " rekordów z "+userList.size());
			}
		});
		
	}
}
