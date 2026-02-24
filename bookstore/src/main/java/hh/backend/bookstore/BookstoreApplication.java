package hh.backend.bookstore;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	// private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class); 

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner createBookRows(CategoryRepository categoryRepository, BookRepository bookRepository) {

		return (args) -> {
			// log.info("Save some categories");
			Category scifi = categoryRepository.save(new Category("Sci-Fi"));
			Category fantasy = categoryRepository.save(new Category("Fantasy"));
			Category thriller = categoryRepository.save(new Category("Thriller"));
			Category science = categoryRepository.save(new Category("Science"));

			// kategorioden tulostus
			// log.info("Fetch all the categories")
			for (Category c : categoryRepository.findAll()) {
				System.out.println(c.toString());
			}

			bookRepository.save(new Book(
				"Testikirja",
				"A. Kirjailija",
				2000,
				"12983-74326",
				19.95,
				scifi
			));
			bookRepository.save(new Book(
				"Testikirjan paluu",
				"A. Kirjailija",
				2002,
				"12983-98779",
				29.95,
				scifi
			));
			bookRepository.save(new Book(
				"Opi koodaamaan",
				"B. End",
				2018,
				"12983-95433",
				35.00,
				science
			));
		};

	}

}
