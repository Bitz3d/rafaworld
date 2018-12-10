package pl.rafalab.rafalworld.Repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.rafalab.rafalworld.Model.User;

public interface AdminRepository extends JpaRepository<User, Long>  {

	
	@Modifying
	@Query("UPDATE User u SET u.active =:intAvtive where u.id = :id")
	void updateUserAvtivity(@Param("intAvtive") int intAvtive, @Param("id") long id);
	

	@Modifying
	@Query(value = "UPDATE user_role r SET r.role_id = :roleId WHERE r.user_id= :id", nativeQuery = true)
	void updateUserRole(@Param("roleId") int intAvtive, @Param("id") long id);
	
	@Query(value = "SELECT * FROM user u WHERE u.name LIKE %:param% OR u.last_name LIKE %:param% OR email LIKE %:param%", nativeQuery = true)
	Page<User> searchUsers(@Param("param") String param, Pageable pageable);
	
} 