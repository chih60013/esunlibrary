package com.esun.library.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esun.library.models.beans.books.Book;
import com.esun.library.models.repositorys.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	
	
	//新增書籍
	
	public void addBook(Book book) {
		bookRepository.save(book);
	}
	
	
	
	//找尋所有書籍
	
	public List<Book> findAllBook(){
		List<Book> findAllBook = bookRepository.findAll();
		return findAllBook;
		
	}
	
	
	
	

}
