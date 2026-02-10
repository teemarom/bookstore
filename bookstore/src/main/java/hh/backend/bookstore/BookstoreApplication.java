package hh.backend.bookstore;

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

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner createBookRows(CategoryRepository categoryRepository, BookRepository bookRepository) {

		return (args) -> {
			categoryRepository.save(new Category("Sci-Fi"));
            categoryRepository.save(new Category("Fantasy"));
            categoryRepository.save(new Category("Thriller"));
            categoryRepository.save(new Category("Science"));


			bookRepository.save(new Book(
				"Testikirja",
				"A. Kirjailija",
				2000,
				"12983-74326",
				19.95
			));
			bookRepository.save(new Book(
				"Testikirjan paluu",
				"A. Kirjailija",
				2002,
				"12983-98779",
				29.95
			));
			bookRepository.save(new Book(
				"Opi koodaamaan",
				"B. End",
				2018,
				"12983-95433",
				35.00
			));
		};

	}

}
