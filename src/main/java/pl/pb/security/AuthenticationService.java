package pl.pb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.pb.model.PbUser;
import pl.pb.users.UsersRepository;

import static java.util.Arrays.asList;

@Service
public class AuthenticationService implements UserDetailsService {

    private UsersRepository usersRepository;

    @Autowired
    public AuthenticationService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PbUser userInfo = usersRepository.findByLogin(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException(String.format("No user with login: %s exists!", username));
        }

        GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole().name());

        return new User(
                userInfo.getLogin(),
                userInfo.getPassword(),
                asList(authority)
        );
    }
}
