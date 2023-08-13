package com.esun.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.esun.library.models.beans.books.Book;
import com.esun.library.models.repositorys.BookRepository;
import com.esun.library.models.services.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookRepository bookRepository;
	
	
	//新增書籍資料
	@GetMapping("/book/addBook")
	public String addBook(Book book , Model model) {
		model.addAttribute("book",new Book());
		return "book/addBook";
		
	}
	
	@PostMapping("/book/post")
	public String postBook(@ModelAttribute("book") Book book,Model model) {
		
		bookService.addBook(book);
		model.addAttribute("book",book);
		return "redirect:/book/bookAll";
		
	}
	
	
	
	//讀取所有書本資料
	@GetMapping("/book/bookAll")
	public String showAllBook(Model model) {
		List<Book> findAllBook = bookService.findAllBook();
		model.addAttribute("bookList",findAllBook);
		return "/book/bookAll";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public BookController() {
		// TODO Auto-generated constructor stub
	}

}
