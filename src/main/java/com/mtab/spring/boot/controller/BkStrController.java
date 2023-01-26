package com.mtab.spring.boot.controller;

import com.mtab.spring.boot.service.BkStrService;
import com.mtab.spring.boot.service.models.Book;
import com.mtab.spring.boot.service.models.BookPurchase;
import com.mtab.spring.boot.service.models.NewPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BkStrController {
    private final BkStrService bkStrService;

    @Autowired
    BkStrController(BkStrService bkStrService) {
        this.bkStrService = bkStrService;
    }

    @PostMapping("/addBook")
    public int addBookToInventory(@RequestBody Book book) {
        return bkStrService.addBookToInventory(book);
    }

    @GetMapping("/inventory")
    public List<Book> getBooksFromInventory() {
        return bkStrService.getBooksFromInventory();
    }

    @PostMapping("/purchase")
    public int purchase(@RequestBody BookPurchase bookPurchase) {
        return bkStrService.purchase(bookPurchase);
    }

    @PostMapping("/priceChange")
    public int priceChange(@RequestBody NewPrice newPrice) {
        return bkStrService.priceChange(newPrice);
    }
}
