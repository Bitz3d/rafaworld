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




}
