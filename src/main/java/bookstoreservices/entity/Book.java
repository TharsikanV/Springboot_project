package bookstoreservices.entity;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//hibernate check pannum table ah ithu auto genaartela irukkannu
    private Long id;
    private String name;

    @Column(name = "description") //db column yum entity class oda column ayum match pannikkum
    private String desc;
    private Integer yearOfPublication;

    private String bookType;

    public Book(){

    }//default constructor kodukkanum
    public Book(Long id, String name, String desc, Integer yearOfPublication, String bookType) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.yearOfPublication = yearOfPublication;
        this.bookType = bookType;
    }
    public Long getId()
    {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public Integer getYearOfPublication()
    {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }



    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getBookType() {
        return bookType;
    }
}
