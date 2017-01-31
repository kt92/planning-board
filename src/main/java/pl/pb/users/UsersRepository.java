package pl.pb.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pb.model.PbUser;

@Repository
public interface UsersRepository extends CrudRepository<PbUser, Long>{
    PbUser findByLogin(String login);
}
