package hh.backend.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // tietokannan taulun määrittely
public class Category {

    @Id // taulun sarake
    @GeneratedValue(strategy = GenerationType.AUTO) // tietokanta generoi uudelle kirjalle id-arvon

    private Long categoryId;
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    // getterit
    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    // setterit
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + "]";
    }

    
    


}
