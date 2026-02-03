package hh.backend.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // tietokannan taulun määrittely
public class Book {

    @Id // taulun PK-sarake
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tietokanta generoi uudelle kirjalle id-arvon
    private Long bookId;
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;
    private double price;
    
    public Book() {
    }

    public Book(String title, String author, int publicationYear, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    public Book(Long bookId, String title, String author, int publicationYear, String isbn, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    // getterit
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public double getPrice() {
        return price;
    }
    
    public Long getBookId() {
        return bookId;
    }
    
    
    // setterit
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    // toString
    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", publicationYear="
                + publicationYear + ", isbn=" + isbn + ", price=" + price + "]";
    }


    
}
