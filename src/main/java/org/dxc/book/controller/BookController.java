package org.dxc.book.controller;

import java.util.List;
import java.util.Optional;



import org.dxc.book.model.Book;
import org.dxc.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/savebook")
	public HttpStatus saveBook(@RequestBody Book book) {
		
		boolean status = bookService.savebook(book);
		
		return status ? HttpStatus.CREATED:HttpStatus.BAD_REQUEST;

	}
	
	@GetMapping("/getbooks")
	public List<Book> getBooks(){
		
		return bookService.getAllBooks();
	}
	

	@GetMapping("/getbook")
	public Optional<Book> getBook(@RequestParam("id") Integer bid){
		
		return bookService.getBook(bid);
	}
	
	@DeleteMapping("/deletebook")
	public void deleteBook(@RequestParam("id") Integer bid){
		
		bookService.deleteBook(bid);
	}
	
	@PutMapping("/updatebook")
	public void updateBook(@RequestBody Book book, @RequestParam("id") Integer bid) {
		
		bookService.updatebook(book,bid);
	}
	@RequestMapping(value="/findbypublisher", method=RequestMethod.GET)
	public List<Book> fetchDataBypublisher(@RequestParam("publisher")String publisher) {
	
		return bookService.findByPublisher(publisher);

	}
	@RequestMapping(value="/findbycategory", method=RequestMethod.GET)
	public List<Book> fetchDataBycategory(@RequestParam("category")String category) {
	
		return bookService.findByCategory(category);

	
	
	}
	@RequestMapping(value="/findbyauthor", method=RequestMethod.GET)
	public List<Book> fetchDataByauthor(@RequestParam("authorname")String authorName) {
	
		return bookService.findByAuthor(authorName);
}
}

