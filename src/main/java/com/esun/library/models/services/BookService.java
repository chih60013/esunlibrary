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
	
	
	public boolean isBookBorrowed(String bookISBN) {
	    // 根据 bookISBN 查询书籍信息，包括借阅状态
	    Book book = bookRepository.findById(bookISBN).orElse(null);
	    
	    if (book != null) {
	        // 在这里根据书籍的借阅状态判断书是否被借阅
	        return book.isBorrowed(); // 使用 Book 实体类的 isBorrowed 方法
	    } else {
	        return false; // 如果书籍不存在，可以考虑返回 false 或抛出异常，根据你的业务需求
	    }
	}
	

}
