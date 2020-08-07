# Rest-api-challenge
This repository is to learn how to design,develop and test a Rest api web service


The challenge is to design, develop and test a Rest api web service for an Online Bookstore.

Scenario: Online bookstore

The main resource is books. A book object has attributes such as unique id, a name, an author, a price and an ISBN. 
{
    "id": "A10001",
    "name": "Atomic Habits",
    "author": "James Clear",
    "price": "$32.50",
    "ISBN": "9781847941831"
}

APIs for Books resources
URL – https://mybookstore.com/api/books/

1.Creating a record - Create a new book in the system

Request header:

POST https://mybookstore.com/api/books/

{
	"id": "B10001",
   	"name": "Start With Why",
   	"author": "Simon Sinek",
   	"price": "$30.00",
    "ISBN": "9780241958223"
}

Response header – 

HTTP response code – 201 Created

{
	"id": "B10001",
   	"name": "Start With Why",
   	"author": "Simon Sinek",
   	"price": "$30.00",
    "ISBN": "9780241958223"
}

2.Updating a record – Update the content (price) of the book object identified by book id.

Request header:

PUT https://mybookstore.com/api/books/A10001

{
    "id": "A10001",
   	"name": "Atomic Habits",
   	"author": "James Clear",
    "price": "$25.50",
   	"ISBN": "9781847941831"
}

Response header – 

HTTP response code – 200 OK

{
    "id": "A10001",
   	"name": "Atomic Habits",
   	"author": "James Clear",
    "price": "$25.50",
   	"ISBN": "9781847941831"
}

3.Deleting a record – Delete the book object identified by the book id

Request header:

DELETE https://mybookstore.com/api/books/B10001 

Response header – 

HTTP response code – 200 OK / 204 No Content

4.Getting a record – Return a book object

Request header:

GET https://mybookstore.com/api/books/A10001 

Response header – 

HTTP response code – 200 OK

{
    "id": "A10001",
   	"name": "Atomic Habits",
   	"author": "James Clear",
    "price": "$25.50",
   	"ISBN": "9781847941831"
}

5.Getting several records – Return all the book objects

Request header:

GET https://mybookstore.com/api/books

Response header – 

HTTP response code – 200 OK

[
	{
    	"id": "A10001",
   		"name": "Atomic Habits",
   		"author": "James Clear",
    	"price": "$25.50",
   		"ISBN": "9781847941831"
	},
	{
	   	"id": "B10001",
   		"name": "Start With Why",
   		"author": "Simon Sinek",
   		"price": "$30.00",
    	"ISBN": "9780241958223"
	}
]


	






