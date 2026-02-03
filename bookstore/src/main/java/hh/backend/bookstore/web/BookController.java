package hh.backend.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.backend.bookstore.domain.BookRepository;

@Controller
public class BookController {

    // annotaatio injektio
    private BookRepository bookRepository;

    //konstruktori-injektio
    public BookController(BookRepository repository) {
        this.bookRepository = repository;
    }

    @GetMapping("/index")
    public String index() {
        return "index"; // index.html
    }

    @GetMapping("/booklist")
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist"; // booklist.html
    }
}
