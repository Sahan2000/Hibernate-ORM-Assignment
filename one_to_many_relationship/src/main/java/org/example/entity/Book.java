package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

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
    @ManyToOne
    private Author author;
}
