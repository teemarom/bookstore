package hh.backend.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import hh.backend.bookstore.domain.AppUser;
import hh.backend.bookstore.domain.AppUserRepository;

@DataJpaTest
public class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository appUserRepository;

    @Test // search
    public void findByUsername() {
        AppUser appUser = new AppUser(
            "testaaja",
            "$2a$12$MBaXNSwETCBds0fOti1gnezpiIC2gol4DMh4T/qeeqypdeYnDeVuq",
            "user@example.com",
            "ADMIN"
        );

        appUserRepository.save(appUser);

        AppUser user = appUserRepository.findByUsername("testaaja");

        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo("testaaja");
    }

    @Test // save
    public void saveUser() {
        AppUser appUser = new AppUser(
            "testaaja",
            "$2a$12$MBaXNSwETCBds0fOti1gnezpiIC2gol4DMh4T/qeeqypdeYnDeVuq",
            "user@example.com",
            "ADMIN"
        );

        appUserRepository.save(appUser);

        AppUser user = appUserRepository.findByUsername("testaaja");

        assertThat(user.getUsername()).isEqualTo("testaaja");
    }
    
    @Test
    public void deleteUser() {
        AppUser appUser = new AppUser(
            "testaaja",
            "$2a$12$MBaXNSwETCBds0fOti1gnezpiIC2gol4DMh4T/qeeqypdeYnDeVuq",
            "user@example.com",
            "ADMIN"
        );

        appUserRepository.save(appUser);
        Long id = appUser.getId();
        
        appUserRepository.delete(appUser);

        assertThat(appUserRepository.findById(id)).isEmpty();   
    }
}
