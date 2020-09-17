package com.sajina;

import java.util.Collection;

public interface BookService {
    public void addBook (Book book);
	    
    public Collection<Book> getBooks ();
    public Book getBook (String id);

    public Book editBook(Book book) throws BookException;

    public void deleteBook(String id);
}
