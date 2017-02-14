package pl.pb.security;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.userdetails.User;
import pl.pb.model.RoleType;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class LoggedUser {

    private String userName;
    private Permissions permissions;

    @Getter
    public static class Permissions {

        private boolean canManageUsers = false;

        public Permissions(User user) {
            this.canManageUsers = canManageUsers(user);
        }

        private boolean canManageUsers(User user) {
            List<RoleType> roles = user.getAuthorities().stream()
                    .map(a -> RoleType.valueOf(a.getAuthority()))
                    .collect(Collectors.toList());

            return roles.stream()
                    .anyMatch(role -> role.equals(RoleType.ADMIN));
        }
    }

}