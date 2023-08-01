package org.example;

import org.example.entity.Book;
import org.example.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.Year;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //    create New object in book type
        Book book = new Book("B001", "Harry Potter", "J.K Rollings", "ISBN-10: 0590353403",
                Year.of(1997), "Bloomsbury Publishing", "English", 1000);

        Book book1 = new Book("B002", "Game of thrones", "George R.R Martin",
                "ISBN-10: 0553103547", Year.of(1996), "Bantam Spectra", "English",
                2000);

        // Get the Hibernate session instance from the factory configuration.
        Session session = FactoryConfiguration.getInstance().getSession();

        // Begin a new transaction.
        Transaction transaction = session.beginTransaction();

        /*Save the "book" object to the database table.
         The "persist" method is used to save the object, making it persistent.
         The book object should have been properly mapped as an entity in Hibernate.*/

        session.persist(book);
        session.persist(book1);

        /* Commit the transaction to make the changes permanent in the database.
         If there are any errors or exceptions during this process, the transaction will be rolled back.*/
        transaction.commit();

        System.out.println("Books save successfully");

        Transaction transaction1 = session.beginTransaction();

        // Use the session's get method to retrieve the Book entity by its ID
        Book book2 = session.get(Book.class, "B001");

        System.out.println("Retrieve the book successfully");

        if (book2!=null){

            // Update the book attributes
            book2.setIsbn("ISBN-13: 9780590353403");
            book2.setAuthor_name("William Shakespeare");
            book2.setPublication_year(Year.of(2000));

            //update automatically book object changes in  database
            transaction1.commit();

            System.out.println("Update the book successfully");

            Transaction transaction2 = session.beginTransaction();

            // Remove permanently the book object from the database.
            session.remove(book);

            transaction2.commit();

            System.out.println("Remove the book successfully");
        }
    }
}