package pl.rafalab.rafalworld.Repositories;

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
	@Query(value="UPDATE role r SET r.role.id=:roleID where r.user_id=:id", nativeQuery=true)
	void updateUserRole(@Param("roleID") int intAvtive, @Param("id") long id);
} 