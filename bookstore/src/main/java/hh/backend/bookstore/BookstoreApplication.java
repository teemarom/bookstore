package hh.backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner createBookRows(BookRepository bookRepository) {

		return (args) -> {
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
