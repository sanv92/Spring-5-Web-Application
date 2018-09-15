package demo.springapplication.demoSpringapplication.repositories;

import demo.springapplication.demoSpringapplication.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
