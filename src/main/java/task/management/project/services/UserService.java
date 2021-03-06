package task.management.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import task.management.project.exceptions.UsernameAlreadyExistsException;
import task.management.project.models.User;
import task.management.project.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public User saveUser(User newUser) {

    try {

      newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
      //Username has to be unique (exception)
      newUser.setUsername(newUser.getUsername());
      // Make sure that password and confirmPassword match
      // We don't persist or show the confirmPassword
      newUser.setPasswordConfirmation("");
      return userRepository.save(newUser);

    } catch (Exception e) {

      throw new UsernameAlreadyExistsException(e.getMessage());

    }

  }

}
