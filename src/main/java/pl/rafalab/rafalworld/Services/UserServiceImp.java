package pl.rafalab.rafalworld.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.rafalab.rafalworld.Model.Role;
import pl.rafalab.rafalworld.Model.User;
import pl.rafalab.rafalworld.Repositories.RoleRepository;
import pl.rafalab.rafalworld.Repositories.UserRepository;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;


@Transactional
@Service("userServices")
public class UserServiceImp implements UserService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User findUserByEmail(String emial) {
        return userRepository.findByEmail(emial);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);

        Role role = roleRepository.findByRole("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(role)));

        userRepository.save(user);

    }
}
