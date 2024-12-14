package Login.R.Registration.L.service;

import Login.R.Registration.L.entity.User;
import Login.R.Registration.L.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.boot.autoconfigure.container.ContainerImageMetadata.isPresent;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    public boolean createUser(User user) {
        if (user != null) {
            user.setFirstName(user.getFirstName());
            user.setLastName(user.getLastName());
            user.setEmail(user.getEmail());
            user.setUsername(user.getUsername());
            // Store password in plain text (**NOT RECOMMENDED**)
            user.setPassword(user.getPassword());
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
