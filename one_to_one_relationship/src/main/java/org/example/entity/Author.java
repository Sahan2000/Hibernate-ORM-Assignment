package org.example.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.hibernate.annotations.Cascade;

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
    @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.MERGE})
    private Book book;
}
