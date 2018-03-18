package zealot.springframework.springwebapp.repository;

import org.springframework.data.repository.CrudRepository;
import zealot.springframework.springwebapp.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
