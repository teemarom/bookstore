package hh.backend.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.AppUser;
import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

import hh.backend.bookstore.domain.AppUser;
import hh.backend.bookstore.domain.AppUserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class); 

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner createBookRows(CategoryRepository categoryRepository, BookRepository bookRepository, AppUserRepository appUserRepository) {

		return (args) -> {

			// kategorioiden lisäys tietokantaan
			log.info("Save some categories");
			Category scifi = categoryRepository.save(new Category("Sci-Fi"));
			Category fantasy = categoryRepository.save(new Category("Fantasy"));
			Category thriller = categoryRepository.save(new Category("Thriller"));
			Category science = categoryRepository.save(new Category("Science"));

			// kategorioden tulostus
			log.info("Fetch all the categories");
			for (Category c : categoryRepository.findAll()) {
				log.info(c.toString());
			}

			// kirjojen lisäys tietokantaan
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

			// käyttäjien lisäys tietokantaan
			AppUser user1 = new AppUser( // user/user
				"user", 
				"$2a$12$MBaXNSwETCBds0fOti1gnezpiIC2gol4DMh4T/qeeqypdeYnDeVuq",
				"user@example.com",
				"USER");
			AppUser user2 = new AppUser( // admin/admin
				"admin",
				"$2a$12$HI1OU4UMny7Di4lcUxFoy.4j9EoRRKgRLpAGT2/EG7u1gxNP681wu",
				"admin@example.com",
				"ADMIN");

			appUserRepository.save(user1);
			appUserRepository.save(user2);

		};

	}

}
