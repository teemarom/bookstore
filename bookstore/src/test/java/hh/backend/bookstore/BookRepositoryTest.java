package hh.backend.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test // search
    public void findByTitle() {
        List<Book> books = bookRepository.findByTitle("Testikirja");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("A. Kirjailija");
    }

    @Test // save
    public void saveBook() {
        Book book = new Book(
            "Tallennuskirja",
            "T. Esti",
            2000,
            "123-321",
            9.90,
            null
        );
        bookRepository.save(book);

        List<Book> books = bookRepository.findByTitle("Tallennuskirja");

        assertThat(books.get(0).getAuthor()).isEqualTo("T. Esti");
    }

    @Test // delete
    public void deleteBook() {
        Book book = new Book(
            "Poistuva kirja",
            "T. Esti",
            2000,
            "123-321",
            9.90,
            null
        );

        bookRepository.save(book);
        Long id = book.getBookId();

        bookRepository.delete(book);

        assertThat(bookRepository.findById(id)).isEmpty();
    }
}
