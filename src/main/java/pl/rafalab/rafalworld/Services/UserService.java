package pl.rafalab.rafalworld.Services;

import pl.rafalab.rafalworld.Model.User;

public interface UserService {

    public User findUserByEmail(String emial);
    public void saveUser(User user);
    public void updateUserPassword(String newPassword, String email);


}
