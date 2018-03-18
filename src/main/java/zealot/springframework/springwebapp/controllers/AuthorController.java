package zealot.springframework.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zealot.springframework.springwebapp.repository.AuthorRepository;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){

        // add list of authors from authors repository to model
        model.addAttribute("authors", authorRepository.findAll());

        //specified the view name that Thymeleaf should render
        return "authors";
    }
}
