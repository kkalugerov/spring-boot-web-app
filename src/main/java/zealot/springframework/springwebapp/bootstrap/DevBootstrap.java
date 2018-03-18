package zealot.springframework.springwebapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import zealot.springframework.springwebapp.models.Author;
import zealot.springframework.springwebapp.models.Book;
import zealot.springframework.springwebapp.repository.AuthorRepository;
import zealot.springframework.springwebapp.repository.BookRepository;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    //Dependency injection
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author ivan = new Author("Ivan", "Bogrov");
        Book book1 = new Book("This is test book ", "1234", "Agency1");
        ivan.getBooks().add(book1);
        book1.getAuthors().add(ivan);

        authorRepository.save(ivan);
        bookRepository.save(book1);

        Author asen = new Author("Asen", "Asenov");
        Book book2 = new Book("This is test book2 ", "4321", "Agency2");
        asen.getBooks().add(book2);

        authorRepository.save(asen);
        bookRepository.save(book2);

    }
}
