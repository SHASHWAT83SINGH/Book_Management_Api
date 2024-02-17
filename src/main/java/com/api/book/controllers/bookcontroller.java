package com.api.book.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.book.entities.Book;
import com.api.book.services.BookService;

@RestController
public class bookcontroller {

	/* @RequestMapping(value="/books",method=RequestMethod.GET) */
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks()
	{
		List<Book> list = this.bookService.getAllBooks();
		if(list.size() <=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id)
	{
		return bookService.getBookById(id);
	}
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{
		this.bookService.addBook(book);
		return book;
	}
	@DeleteMapping("/books{bookid}")
	public void deletebook(@PathVariable("bookid") int bookid )
	{
		this.bookService.deletebook(bookid);
	}
	
	@PutMapping("/books/{bookId}")
	public Book updatebook(@RequestBody Book book,@PathVariable("bookId")int bookId)
	{
		this.bookService.updateBook(book,bookId);
		return book;
	}
	
}
