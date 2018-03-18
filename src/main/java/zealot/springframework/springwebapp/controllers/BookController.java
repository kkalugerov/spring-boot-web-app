package zealot.springframework.springwebapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zealot.springframework.springwebapp.repository.BookRepository;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        // add list of books from book repository to model
        model.addAttribute("books", bookRepository.findAll());

        //specified the view name that Thymeleaf should render
        return "books";
    }
}
