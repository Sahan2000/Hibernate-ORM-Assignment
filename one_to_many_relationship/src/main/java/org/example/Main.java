package org.example;



import org.example.entity.Author;
import org.example.entity.Book;
import org.example.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Author author = new Author();
        author.setAuthor_name("Charls Dekens");
        author.setAuthor_id("A001");

        Book book = new Book();
        book.setBook_id("B001");
        book.setBook_name("Harry Potter");
        book.setAuthor(author);

        Book book1 = new Book();
        book1.setBook_id("B002");
        book1.setBook_name("Game of Throne");
        book1.setAuthor(author);

        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book1);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(book);
        session.persist(book1);
        session.persist(author);

        transaction.commit();
        session.close();
    }
}