package hh.backend.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.backend.bookstore.web.BookRestController;

@SpringBootTest
public class BookRestControllerTests {

    @Autowired
    private BookRestController bookRestController;

    @Test
    void contextLoads() {
        assertThat(bookRestController).isNotNull();
    }

}