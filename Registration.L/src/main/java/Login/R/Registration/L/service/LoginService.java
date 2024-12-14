package Login.R.Registration.L.service;

import Login.R.Registration.L.Exception.UserNotFoundException;
import Login.R.Registration.L.entity.Login;
import Login.R.Registration.L.entity.User;
import Login.R.Registration.L.respository.LoginRepository;
import Login.R.Registration.L.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

  private User user;

  private Login login;

  @Autowired
  private RegisterService registerService;

  @Autowired
  private LoginRepository loginRepository;

  @Autowired
  private UserRepository userRepository;

  public boolean loginProcess(Login login){
      if(login.getUsername().isEmpty() || login.getPassword().isEmpty()){
         return false;
      }
      Optional<User> user = userRepository.findByUsername(login.getUsername());
      if(user.isPresent() && user.get().getPassword().equals(login.getPassword())){
          return true;
      }
      return false;
  }

}
