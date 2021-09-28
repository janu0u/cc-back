package task.management.project.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import task.management.project.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  User findByUsername(String username);

  User getById(Long id);

  Optional<User> findById(Long userId);

}
