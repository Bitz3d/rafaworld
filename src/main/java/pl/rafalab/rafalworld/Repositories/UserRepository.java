package pl.rafalab.rafalworld.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.rafalab.rafalworld.Model.User;


public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);

    @Modifying
    @Query("Update User u set u.password = :newPassword WHERE u.email= :email")
    public void updateUserPassword(@Param("newPassword") String password, @Param("email") String email);

    @Modifying
    @Query("Update User u set u.name= :newName, u.lastName= :newLastName, u.email= :newEmail WHERE u.id= :id")
    public void updateUserProfile(@Param("newName") String newName, @Param("newLastName") String newLastName, 
    							   @Param("newEmail") String newEmail, @Param("id") Long id);

    public User findById(long id);
    
    @Modifying
    //@Query("UPDATE User u SET u.active= :activeParam WHERE u.activation_code= :activationCode")
    @Query("UPDATE User u SET u.active = :activeParam WHERE u.activationCode = :activationCode")
    public void updateActivation(@Param("activeParam") int activeParam, @Param("activationCode") String activationCode);
    
    
}
