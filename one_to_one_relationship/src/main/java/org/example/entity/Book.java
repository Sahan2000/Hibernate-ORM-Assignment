package org.example.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.hibernate.annotations.Cascade;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Book {
    @Id
    private String book_id;
    private String name;


}
