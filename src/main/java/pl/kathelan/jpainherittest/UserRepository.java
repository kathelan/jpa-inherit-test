package pl.kathelan.jpainherittest;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kathelan.jpainherittest.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
