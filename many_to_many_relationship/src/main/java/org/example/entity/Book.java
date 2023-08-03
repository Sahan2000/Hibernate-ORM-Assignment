package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Book {
    @Id
    private String book_id;
    private String book_name;
    @ManyToMany
    private List<Author> authors;
}
