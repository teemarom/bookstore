package hh.backend.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.backend.bookstore.web.CategoryController;

@SpringBootTest
public class CategoryControllerTests {

    @Autowired
    private CategoryController categoryController;

    @Test
    void contextLoads() {
        assertThat(categoryController).isNotNull();
    }


}
