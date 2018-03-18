package zealot.springframework.springwebapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import zealot.springframework.springwebapp.models.Author;
import zealot.springframework.springwebapp.models.Book;
import zealot.springframework.springwebapp.models.Publisher;
import zealot.springframework.springwebapp.repository.AuthorRepository;
import zealot.springframework.springwebapp.repository.BookRepository;
import zealot.springframework.springwebapp.repository.PublisherRepository;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    private PublisherRepository publisherRepository;

    //Dependency injection
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher publisher1 = new Publisher();
        publisher1.setName("publisher 1");
        publisher1.setAddress("address1");

        publisherRepository.save(publisher1);

        Author ivan = new Author("Ivan", "Bogrov");
        Book book1 = new Book("This is test book ", "1234", publisher1);
        ivan.getBooks().add(book1);
        book1.getAuthors().add(ivan);

        authorRepository.save(ivan);
        bookRepository.save(book1);


        Publisher publisher2 = new Publisher();
        publisher2.setName("publisher 2");
        publisher2.setAddress("address2");

        publisherRepository.save(publisher2);

        Author asen = new Author("Asen", "Asenov");
        Book book2 = new Book("This is test book2 ", "4321", publisher2);
        asen.getBooks().add(book2);

        authorRepository.save(asen);
        bookRepository.save(book2);

    }
}
