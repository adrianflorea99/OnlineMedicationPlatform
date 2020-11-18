package OMP.Service;

import OMP.Entity.Login;
import OMP.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {

    private final LoginRepository loginRepository;

    public void loginFailed(String username) {
        if (Objects.isNull(loadUserByUsername(username))) {
            throw new UsernameNotFoundException("User not found");
        }
    }

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login user = logInByUsername(username);
        if (Objects.nonNull(user)) {
            return new User(user.getUsername(), user.getPassword(), true, true, true, true, AuthorityUtils.NO_AUTHORITIES);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public Login logInByUsername(String username) {
        Optional<Login> user = loginRepository.findLoginByUsername(username);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }


}
