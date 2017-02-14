package pl.pb.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.pb.security.LoggedUser.Permissions;

@RestController
@RequestMapping(value = "/logged-user")
public class SessionController {

    @RequestMapping(method = RequestMethod.GET)
    public LoggedUser getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        return LoggedUser.builder()
                .userName(user.getUsername())
                .permissions(new Permissions(user))
                .build();
    }
}