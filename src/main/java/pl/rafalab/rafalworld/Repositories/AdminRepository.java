package pl.rafalab.rafalworld.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rafalab.rafalworld.Model.User;

public interface AdminRepository extends JpaRepository<User, Long>  {

	User findUserById(int id);
	
} 