package pl.rafalab.rafalworld.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rafalab.rafalworld.Model.User;


public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
}
