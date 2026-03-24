package hh.backend.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import hh.backend.bookstore.web.BookController;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTests {

    @Autowired
    private BookController bookController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        assertThat(bookController).isNotNull();
    }

    @Test
    public void testIndexMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
            .andExpect(content().string(containsString("Bookstore")));
    }

}
