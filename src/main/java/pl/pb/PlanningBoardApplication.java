package pl.pb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.pb.model.PbUser;
import pl.pb.model.RoleType;
import pl.pb.users.UsersRepository;

import static java.util.Arrays.asList;

@SpringBootApplication
public class PlanningBoardApplication implements CommandLineRunner {

    @Autowired
    private UsersRepository usersRepository;

    public static void main(String[] args) {
        SpringApplication.run(PlanningBoardApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        PbUser user1 = PbUser.builder()
                .login("user")
                .password("user")
                .role(RoleType.USER)
                .build();
        PbUser user2 = PbUser.builder()
                .login("admin")
                .password("admin")
                .role(RoleType.ADMIN)
                .build();
        usersRepository.save(asList(user1, user2));
    }
}
