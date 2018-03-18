package zealot.springframework.springwebapp.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class Book {

    //JPA - java persistence API

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // JPA automatic generate id for us
    private Long id;
    private String title;
    private String ibsn;

    @OneToOne
    private Publisher publisher;

    @ManyToMany // JPA generate many to many relationship
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id "))
    private Set<Author> authors = new HashSet<>();

    public Book(){};

    public Book(String title, String ibsn, Publisher publisher) {
        this.title = title;
        this.ibsn = ibsn;
        this.publisher = publisher;
    }

    public Book(String title, String ibsn, Publisher publisher, Set<Author> authors) {
        this.title = title;
        this.ibsn = ibsn;
        this.publisher = publisher;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIbsn() {
        return ibsn;
    }

    public void setIbsn(String ibsn) {
        this.ibsn = ibsn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ibsn='" + ibsn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", authors=" + authors +
                '}';
    }
}
