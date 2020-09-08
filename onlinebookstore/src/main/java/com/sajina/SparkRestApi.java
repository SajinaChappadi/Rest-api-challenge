package com.sajina;


import static spark.Spark.post;
import static spark.Spark.get;

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

    }
}
