package com.esun.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.esun.library.models.beans.books.Book;
import com.esun.library.models.beans.books.BookInventory;
import com.esun.library.models.beans.books.BookStatus;
import com.esun.library.models.repositorys.BookInventoryRepository;
import com.esun.library.models.services.BookInventoryService;
import com.esun.library.models.services.BookService;
import com.esun.library.models.services.BookStatusService;

@Controller
public class BookInventoryController {

	@Autowired
	private BookInventoryService bookInventoryService;
	
	
	
	@Autowired
	private BookInventoryRepository bookInventoryRepository;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookStatusService bookStatusService;
	
	//新增書籍庫存資訊 (要寫U才能修改狀態)
	@GetMapping("/book/addBookInventory")
	public String addBookInventory (BookInventory bookInventory, Model model) {
		//這邊才新增物件，前面的好像....   要修改一下...
		model.addAttribute("bookInventory", new BookInventory());
		
		//要給清單 才可以有選擇器
		List<Book> bookList = bookService.findAllBook();
		model.addAttribute("bookList",bookList);
		
		List<BookStatus> bookStatusList = bookStatusService.findAllBookStatus();
		model.addAttribute("bookStatusList",bookStatusList);
		return "book/addBookInventory";
	
	
	}
	
	@PostMapping("/book/postBookInventory")
	public String postBookInventory (@ModelAttribute("bookInventory")BookInventory bookInventory, Model model) {
		
		bookInventoryService.addBookInventory(bookInventory);
		model.addAttribute("bookInventory",bookInventory);
		return "redirect:/book/bookInventoryAll";
	}
	
	
	//讀取所有書籍庫存狀態
	@GetMapping("/book/bookInventoryAll")
	public String showAllBookInventory (Model model) {
		List<BookInventory> findAllBookInventory = bookInventoryService.findAllBookInventory();
		model.addAttribute("bookInventoryList",findAllBookInventory);
		return "book/bookInventoryAll";
	}
	
	
	
	
	
	
	
	
	public BookInventoryController() {
		// TODO Auto-generated constructor stub
	}

}
