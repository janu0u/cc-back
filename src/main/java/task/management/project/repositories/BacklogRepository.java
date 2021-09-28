package task.management.project.repositories;

import task.management.project.models.Backlog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog, Long> {

  Backlog findByProjectIdentifier(String Identifier);

}
