package com.esun.library.controller;

import java.util.Map;
import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.esun.library.models.beans.books.Book;
import com.esun.library.models.repositorys.BookRepository;
import com.esun.library.models.services.BookInventoryService;
import com.esun.library.models.services.BookService;
import com.esun.library.models.beans.books.BookInventory;



@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookInventoryService bookInventoryService;
	
	@Autowired
	private BookRepository bookRepository;
	
	
	//新增書籍資料
	@CrossOrigin
	@GetMapping("/book/addBook")
	public String addBook(Book book , Model model) {
		model.addAttribute("book",new Book());
		return "book/addBook";
		
	}
	@CrossOrigin
	@PostMapping("/book/post")
	public String postBook(@ModelAttribute("book") Book book,Model model) {
		
		bookService.addBook(book);
		model.addAttribute("book",book);
		return "redirect:/book/bookAll";
		
	}
	
	
	
	//讀取所有書本資料  原先能動的 嘗試先隱藏
//	@CrossOrigin(origins = "http://localhost:8080")
//	@GetMapping("/book/bookAll")
//	public String showAllBook(Model model) {
//		List<Book> findAllBook = bookService.findAllBook();
//		List<BookInventory> findAllBookInventory = bookInventoryService.findAllBookInventory();
//		model.addAttribute("bookInventoryList",findAllBookInventory);
//		model.addAttribute("bookList",findAllBook);
//		return "/book/bookAll";
//		
//	}
//	
	
	//使用gpt 撰寫
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/book/bookAll")
	public ResponseEntity<Map<String, Object>> showAllBook() {
	    Map<String, Object> response = new HashMap<>();
	    List<Book> findAllBook = bookService.findAllBook();
	    List<BookInventory> findAllBookInventory = bookInventoryService.findAllBookInventory();
	    
	    // 將數據添加到回應中
	    response.put("bookList", findAllBook);
	    response.put("bookInventoryList", findAllBookInventory);
	    
	    // 返回JSON格式的數據
	    return ResponseEntity.ok(response);
	}
	
	
	
	
	@PostMapping("/borrow/{bookId}")
	public ResponseEntity<String> borrowBook(@PathVariable String bookISBN) {
	    // 根据 bookId 查询书籍
	    Book book = bookRepository.findById(bookISBN).orElse(null);
	    
	    if (book == null) {
	        return ResponseEntity.notFound().build();
	    }

	    if (book.isBorrowed()) {
	        return ResponseEntity.badRequest().body("该书籍已被借出");
	    }

	    // 更新书籍的借阅状态
	    book.setBorrowed(true);
	    bookRepository.save(book);

	    return ResponseEntity.ok("借阅成功");
	}
	
	
	
	
	
	
	
	public BookController() {
		// TODO Auto-generated constructor stub
	}

}
