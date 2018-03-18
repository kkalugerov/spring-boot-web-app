package zealot.springframework.springwebapp.repository;


import org.springframework.data.repository.CrudRepository;
import zealot.springframework.springwebapp.models.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
