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
        author.setAuthor_id("A001");
        author.setAuthor_name("Sahan");

        Author author1 = new Author();
        author1.setAuthor_id("A002");
        author1.setAuthor_name("Kashmi");

        List<Author> authors = new ArrayList<>();
        authors.add(author);
        authors.add(author1);

        Book book = new Book();
        book.setBook_id("B001");
        book.setBook_name("Harry Potter");

        Book book1 = new Book();
        book1.setBook_id("B002");
        book1.setBook_name("Game of Thrones");

        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book1);

        author.setBooks(books);
        author1.setBooks(books);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(author);
        session.persist(author1);
        session.persist(book);
        session.persist(book1);

        transaction.commit();
        session.close();
    }
}