package com.esun.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.esun.library.models.beans.books.BookInventory;
import com.esun.library.models.repositorys.BookInventoryRepository;
import com.esun.library.models.services.BookInventoryService;

@Controller
public class BookInventoryController {

	@Autowired
	private BookInventoryService bookInventoryService;
	
	
	
	@Autowired
	private BookInventoryRepository bookInventoryRepository;
	
	
	
	//新增書籍庫存資訊 (要寫U才能修改狀態)
	@GetMapping("/book/addBookInventory")
	public String addBookInventory (BookInventory bookInventory, Model model) {
		model.addAttribute("bookInventory",bookInventory);
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
