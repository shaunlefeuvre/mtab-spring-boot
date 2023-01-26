package com.mtab.spring.boot.service;

import com.mtab.spring.boot.service.models.Book;
import com.mtab.spring.boot.service.models.BookPurchase;
import com.mtab.spring.boot.service.models.NewPrice;

import java.util.List;

public interface BkStrService {
     // Returns the number of this book in inventory
     int addBookToInventory(Book book);

     // Returns all books in inventory
     List<Book> getBooksFromInventory();

     // Returns 0
     int purchase(BookPurchase bookPurchase);

     int priceChange(NewPrice newPrice);
}