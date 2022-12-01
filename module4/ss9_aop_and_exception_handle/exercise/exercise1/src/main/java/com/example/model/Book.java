package com.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private int quantityAvailable;
    private int totalQuantity;
    @ManyToMany(mappedBy = "bookList", cascade = CascadeType.ALL)
    private Set<BorrowedBook> borrowedBookList;

    public Book() {
    }

    public Book(Integer id, String name, int totalQuantity, Set<BorrowedBook> borrowedBookList) {
        this.id = id;
        this.name = name;
        this.quantityAvailable = totalQuantity;
        this.totalQuantity = totalQuantity;
        this.borrowedBookList = borrowedBookList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Set<BorrowedBook> getBorrowedBookList() {
        return borrowedBookList;
    }

    public void setBorrowedBookList(Set<BorrowedBook> borrowedBookList) {
        this.borrowedBookList = borrowedBookList;
    }
}
