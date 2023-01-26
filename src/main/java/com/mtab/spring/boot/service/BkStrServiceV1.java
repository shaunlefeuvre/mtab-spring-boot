package com.mtab.spring.boot.service;

import com.mtab.spring.boot.service.models.Book;
import com.mtab.spring.boot.service.models.BookPurchase;
import com.mtab.spring.boot.service.models.NewPrice;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BkStrServiceV1 implements BkStrService{

    private final Map<String, Book> books = new HashMap<>();
    public final double centsToDollars = 0.01;

    @Override
    public int addBookToInventory(Book book) {
        System.out.println(" ");
        Book oldBook = books.get(book.bookID());
        if(oldBook == null) {
            books.put(book.bookID(), book);
            System.out.println("New Book entered:");
        } else {
            books.put(book.bookID(), new Book(oldBook.bookID(), oldBook.title(), oldBook.author(), oldBook.price(), oldBook.numberInStock()+book.numberInStock()));
            System.out.println("Extra copy of Book added:");
        }
        System.out.println(books.get(book.bookID()));
        return 0;
    }

    @Override
    public List<Book> getBooksFromInventory() {
        System.out.println(" ");
        System.out.println("Books that are in our system:");
        books.values().forEach(t ->  System.out.println("Title: " + t.title() + " - Author: " + t.author() + ", Price: $" + (t.price() * centsToDollars) + ", Number in Stock: " + t.numberInStock() + ", ISBN: " + t.bookID()));
        return null;
    }

    @Override
    public int purchase(BookPurchase bookPurchase) {
        System.out.println(" ");
        Book inStock = books.get(bookPurchase.bookID());
        if(inStock == null) {
            System.out.println("Error: That ID does not correspond to a Book in our system!");
        } else if(inStock.numberInStock() <= 0) {
            System.out.println("Sorry. That Book is currently out of stock.");
        } else if(inStock.numberInStock() > 0 && inStock.numberInStock() < bookPurchase.quantity()) {
            System.out.println("Sorry. While we have that book in stock, we do not have as many copies as you are asking to purchase.");
        } else if(inStock.numberInStock() >= bookPurchase.quantity()) {
            books.put(inStock.bookID(), new Book(inStock.bookID(), inStock.title(), inStock.author(), inStock.price(), inStock.numberInStock()-bookPurchase.quantity()));
            System.out.println("Your total is $" + (centsToDollars * bookPurchase.quantity() * inStock.price()) + "\nThank you for your purchase!");
        } else {
            System.out.println("Unknown Error");
        }
        return 0;
    }

    @Override
    public int priceChange(NewPrice newPrice) {
        System.out.println(" ");
        Book inStock = books.get(newPrice.bookID());
        if(inStock == null) {
            System.out.println("Error: That ID does not correspond to a Book in our system");
        } else {
            System.out.println("Price changed from $" + (inStock.price() * centsToDollars) + " to $" + (newPrice.updatedPrice() * centsToDollars));
            books.put(inStock.bookID(), new Book(inStock.bookID(), inStock.title(), inStock.author(), newPrice.updatedPrice(), inStock.numberInStock()));
        }
        return 0;
    }
}
