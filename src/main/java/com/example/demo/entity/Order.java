package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="ORDERS")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
//    @JoinColumn(name="client_id")
    @JsonBackReference
    private Client client;

    @Column(name="cost")
    private Integer cost;

    // TODO уточнить как генерируются имена для колонки id (например, у класса ORDERS orders_id?)

    @ManyToMany
//    @JoinTable(
//            name = "orders_books",
//            joinColumns = @JoinColumn(name = "orders_id"),
//            inverseJoinColumns = @JoinColumn(name = "book_id")
//    )
    @JsonIgnoreProperties("orders")
    private List<Book> books;
}
