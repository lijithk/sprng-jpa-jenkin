package org.dxc.book.service;

import java.util.List;
import java.util.Optional;



import org.dxc.book.model.Book;
import org.dxc.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {

		return bookRepository.findAll();
	
	}

	@Override
	public boolean savebook(Book book) {
		
		boolean status = bookRepository.save(book)!= null;
		
		return status;
		
	}

	@Override
	public Optional<Book> getBook(Integer bid) {
		return bookRepository.findById(bid);
	}

	@Override
	public void deleteBook(Integer bid) {
		
		bookRepository.deleteById(bid);
		
	}

	
	@Override
	public void updatebook(Book book, Integer id) {
		
		
		Book updatedbook = bookRepository.findById(id).get();
		updatedbook.setBookName(book.getBookName());
		updatedbook.setAuthorName(book.getAuthorName());
		updatedbook.setCategory(book.getCategory());
		updatedbook.setiSBN(book.getiSBN());
		updatedbook.setPublisher(book.getPublisher());
		updatedbook.setPrice(book.getPrice());
		
		bookRepository.save(updatedbook);
		
		
	}

	@Override
	public List<Book> findByPublisher(String publisher) {
		return bookRepository.findByPublisher(publisher);
	}
	@Override
	public List<Book> findByCategory(String category) {
		return bookRepository.findByCategory(category);
	}
	
	@Override
	public List<Book> findByAuthor(String authorName) {
		return bookRepository.findByAuthor(authorName);
	}
	
}

