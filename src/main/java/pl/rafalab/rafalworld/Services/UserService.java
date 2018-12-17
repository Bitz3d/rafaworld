package pl.rafalab.rafalworld.Services;

import java.util.List;
import pl.rafalab.rafalworld.Model.User;

public interface UserService {

    public User findUserByEmail(String emial);
    public void saveUser(User user);
    public void updateUserPassword(String newPassword, String email);
    public void updateUserProfile(String newName, String newLastName, String newEmail, Long id);
    public List<User> findAll();
    public User findUserById(long id);
    public void updateUserActivation(int active, String activationCode);

}
