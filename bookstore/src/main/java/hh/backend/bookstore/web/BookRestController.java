package hh.backend.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@CrossOrigin
@Controller
@RequestMapping("/rest")
public class BookRestController {

    private BookRepository bookRepository;

    // konstruktori injektio
    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public @ResponseBody List<Book> findAllBooksRest() {
        return (List<Book>) bookRepository.findAll();
    }
    
    @GetMapping("/books/{bookId}")
    public @ResponseBody Optional<Book> getOneBookRest(@PathVariable(name = "bookId") Long bookId) {
        return bookRepository.findById(bookId);
    }

    @PostMapping(value="/books")
    public @ResponseBody Book saveBookRest(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    

}
