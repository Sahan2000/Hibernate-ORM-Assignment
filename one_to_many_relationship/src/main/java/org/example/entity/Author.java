package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
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
    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
