package com.sajina;


import static spark.Spark.post;
import static spark.Spark.get;
import static spark.Spark.put;
import static spark.Spark.delete;

import com.google.gson.Gson;

public class SparkRestApi {
    public static void main(String args[]){
        final BookService bookService = new BookServiceMapImpl();

        post("/books", (request, response) -> {
            response.type("application/json");
            Book book = new Gson().fromJson(request.body(), Book.class);
            bookService.addBook(book);

            //return new Gson().toJson(user);

            return new Gson()
              .toJson(new StandardResponse(StatusResponse.SUCCESS));
        });

        get("/books", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
              new StandardResponse(StatusResponse.SUCCESS,new Gson()
                .toJsonTree(bookService.getBooks())));
        });

        get("/books/:id", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
              new StandardResponse(StatusResponse.SUCCESS,new Gson()
                .toJsonTree(bookService.getBook(request.params(":id")))));
        });

        put("/books/:id", (request, response) -> {
            response.type("application/json");

            Book toEdit = new Gson().fromJson(request.body(), Book.class);
            Book editedBook = bookService.editBook(toEdit);

            if (editedBook != null) {
                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(editedBook)));
            } else {
                return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, new Gson().toJson("Book not found or error in edit")));
            }
        });

        delete("/books/delete/:id", (request, response) -> {
            response.type("application/json");

            bookService.deleteBook(request.params(":id"));
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "book deleted"));
        });

    }
}
