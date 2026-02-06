package repository;

import model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface taskRepository extends JpaRepository<Task, Long> {
    //No further code for now as JPA handles basic CRUD code.

}
