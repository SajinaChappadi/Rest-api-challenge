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

    @Override
    public Book editBook(Book forEdit) throws BookException {
    try{
        if (forEdit.getId() == null)
        throw new BookException("ID cannot be blank");

        Book toEdit = bookMap.get(forEdit.getId());

        if (toEdit == null)
        throw new BookException("Book not found");

        if (forEdit.getName() != null) {
            toEdit.setName(forEdit.getName());
        }
        if (forEdit.getAuthor() != null) {
            toEdit.setAuthor(forEdit.getAuthor());
        }
        if (forEdit.getPrice() != null) {
            toEdit.setPrice(forEdit.getPrice());
        }
        if (forEdit.getId() != null) {
            toEdit.setId(forEdit.getId());
        }
        return toEdit;
    }catch (Exception ex) {
    throw new BookException(ex.getMessage());   
    }
    }

    @Override
    public void deleteBook(String id) {
        bookMap.remove(id);
    }
}