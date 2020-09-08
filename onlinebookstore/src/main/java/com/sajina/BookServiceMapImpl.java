package com.sajina;

import java.util.Collection;
import java.util.HashMap;

public class BookServiceMapImpl implements BookService {
    private HashMap<String, Book> bookMap;

    public BookServiceMapImpl() {
        bookMap = new HashMap<>();
    }

    @Override
    public void addBook(Book book) {
        bookMap.put(book.getId(), book);
    }

    @Override
    public Collection<Book> getBooks() {
        return bookMap.values();
    }

    @Override
    public Book getBook(String id) {
        return bookMap.get(id);
    
}
}