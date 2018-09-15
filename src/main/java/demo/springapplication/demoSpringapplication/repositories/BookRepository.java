package demo.springapplication.demoSpringapplication.repositories;

import demo.springapplication.demoSpringapplication.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
