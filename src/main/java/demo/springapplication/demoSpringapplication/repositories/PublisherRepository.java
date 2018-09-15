package demo.springapplication.demoSpringapplication.repositories;

import demo.springapplication.demoSpringapplication.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
