package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Author {
    @Id
    private String author_id;
    private String author_name;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
}
