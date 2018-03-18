package zealot.springframework.springwebapp.repository;

import org.springframework.data.repository.CrudRepository;
import zealot.springframework.springwebapp.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
