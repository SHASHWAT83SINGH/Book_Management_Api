package com.api.book.services;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Component //For AutoWiring
public class BookService {
	@Autowired
	private BookRepository br;
	/*
	 * private static List<Book> list =new ArrayList<>(); static {
	 * 
	 * list.add(new Book(12,"python complete refrense","XYZ")); list.add(new
	 * Book(36,"Let us C","ABC")); list.add(new
	 * Book(44,"programming book for C++","EFG"));
	 * 
	 * }
	 */
 //Return All book
 public List<Book> getAllBooks()
 {
	 List <Book> list=(List<Book>)this.br.findAll();
	 return list;
 }
 
 //Return single Book
 public Book getBookById(int id)
 {
	 Book book =null;
	// book =list.stream().filter(e->e.getId()==id).findFirst().get();
	book= this.br.findById(id);
	 return book;
 
 }
 //Adding book 
 public Book addBook(Book b)
 {
	 Book result=br.save(b);
	 return result;
 }
 
 public void deletebook(int bid)
 {
		/*
		 * //list.stream().filter(book->{ if (book.getId() !=bid) { return true; } else
		 * { return false; } }).collect(Collectors.toList());
		 */
	 this.br.deleteById(bid);
 }
 public void updateBook(Book book ,int bookId)
 {
		/*
		 * list.stream().map(b->{ if(b.getId()==bookId) { b.setTitle(book.getTitle());
		 * b.setAuthor(book.getAuthor());
		 * 
		 * } return b; }).collect(Collectors.toList());
		 */
	 book.setId(bookId);
	 this.br.save(book);
 }
}
