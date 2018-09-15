package demo.springapplication.demoSpringapplication.bootstrap;

import demo.springapplication.demoSpringapplication.model.Author;
import demo.springapplication.demoSpringapplication.model.Book;
import demo.springapplication.demoSpringapplication.model.Publisher;
import demo.springapplication.demoSpringapplication.repositories.AuthorRepository;
import demo.springapplication.demoSpringapplication.repositories.BookRepository;
import demo.springapplication.demoSpringapplication.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisher.setAddress("my street address");
        publisherRepository.save(publisher);

        //

        Author auth1 = new Author("firstName1", "lastName1");
        Book book1 = new Book("Book name", "1234", publisher);
        auth1.getBooks().add(book1);
        book1.getAuthors().add(auth1);

        authorRepository.save(auth1);
        bookRepository.save(book1);

        //

        Author auth2 = new Author("firstName2", "lastName2");
        Book book2 = new Book("Book name 2", "5678", publisher);
        auth2.getBooks().add(book2);
        book2.getAuthors().add(auth2);

        authorRepository.save(auth2);
        bookRepository.save(book2);
    }
}
