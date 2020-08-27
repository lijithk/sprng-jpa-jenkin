package org.dxc.book.service;

import java.util.List;
import java.util.Optional;

import org.dxc.book.model.Book;

public interface BookService {

	public List<Book> getAllBooks();

	public boolean savebook(Book book);

	public Optional<Book> getBook(Integer bid);

	public void deleteBook(Integer bid);

	public void updatebook(Book book,Integer bid);

	public List<Book> findByPublisher(String publisher);

	

	
	public List<Book> findByCategory(String category);

	public List<Book> findByAuthor(String authorName);



	

	

	



}
