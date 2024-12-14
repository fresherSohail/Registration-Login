package Login.R.Registration.L.respository;

import Login.R.Registration.L.entity.Login;
import Login.R.Registration.L.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long> {

    public boolean existsByUsernameAndPassword(String username, String password);

}
