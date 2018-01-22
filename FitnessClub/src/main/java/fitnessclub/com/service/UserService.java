package fitnessclub.com.service;

import fitnessclub.com.entity.Role;
import fitnessclub.com.entity.User;
import fitnessclub.com.form.RegistrationFormModel;
import fitnessclub.com.repository.RoleRepository;
import fitnessclub.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user) {

        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(RegistrationFormModel form) {
        User user = new User();
        user.setUsername(form.getUsername());
        user.setName(form.getName());
        user.setSurname(form.getSurname());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        Set<Role> roles = Collections.singleton(roleRepository.getRoleByName("USER"));
        user.setRoles(roles);
        userRepository.save(user);
        return user;
    }
}