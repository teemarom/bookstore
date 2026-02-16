package hh.backend.bookstore.web;
import hh.backend.bookstore.domain.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;


@Controller
public class BookController {

    private final CategoryRepository categoryRepository;

    // annotaatio injektio
    private BookRepository bookRepository;

    //konstruktori-injektio
    public BookController(BookRepository repository, CategoryRepository categoryRepository) {
        this.bookRepository = repository;
        this.categoryRepository = categoryRepository;
    }

    // index
    @GetMapping("/index")
    public String index() {
        return "index"; // index.html
    }

    // booklist
    @GetMapping("/booklist")
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist"; // booklist.html
    }

    // delete book
    @GetMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable("bookId") Long bookId, Model model) {
        bookRepository.deleteById(bookId);
        return "redirect:../booklist"; // uudelleenohjaa booklist.html
    }

    // add new book
    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll()); // categoriat dropdown
        return "addbook"; // addbook.html
    }
    
    // save new book
    @PostMapping("/save")
    public String save(Book book) {
        bookRepository.save(book);
        return "redirect:booklist";
    }

    // edit book
    @GetMapping("/edit/{bookId}")
    public String editBook(@PathVariable("bookId") Long bookId, Model model) {
        Book book = bookRepository.findById(bookId).get();
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryRepository.findAll()); // categoriat dropdown
        return "editbook"; // editbook.html
    }


}
