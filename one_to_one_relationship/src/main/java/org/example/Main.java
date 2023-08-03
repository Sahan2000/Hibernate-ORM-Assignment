package org.example;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Book book = new Book("B001","Harry Potter");
        Book book1 = new Book("B002","Game of Thrones");

        Author author = new Author("A001","Lakshan Chamuditha",book);
        Author author1 = new Author("A002","Ruvuni Rangathara",book1);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(book);
        session.persist(book1);
        session.persist(author);
        session.persist(author1);

        transaction.commit();

    }
}