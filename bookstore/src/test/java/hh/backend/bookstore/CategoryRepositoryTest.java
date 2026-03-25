package hh.backend.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test // search
    public void findByCategory() {
        Category category = new Category("scifi");
        categoryRepository.save(category);

        List<Category> categories = categoryRepository.findByName("scifi");

        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("scifi");
    }

    @Test // save 
    public void saveCategory() {
        Category category = new Category(
            "komedia"
        );
        
        categoryRepository.save(category);

        List<Category> categories = categoryRepository.findByName("komedia");

        assertThat(categories).isNotEmpty();
        assertThat(categories.get(0).getName()).isEqualTo("komedia");
    }

    @Test // delete
    public void deleteCategory() {
        Category category = new Category(
            "komedia"
        );
        
        categoryRepository.save(category);
        Long id = category.getCategoryId();

        categoryRepository.delete(category);

        assertThat(categoryRepository.findById(id)).isEmpty();
    }
        

}
