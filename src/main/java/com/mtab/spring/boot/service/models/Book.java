package com.mtab.spring.boot.service.models;

public record Book(
        String bookID,
        String title,
        String author,
        Integer price,
        Integer numberInStock) {
}
