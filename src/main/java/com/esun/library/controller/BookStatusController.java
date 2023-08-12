package com.esun.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.esun.library.models.beans.books.Book;
import com.esun.library.models.beans.books.BookStatus;
import com.esun.library.models.repositorys.BookStatusRepository;
import com.esun.library.models.services.BookStatusService;


@Controller
public class BookStatusController {

	@Autowired
	private BookStatusService bookStatusService;

	@Autowired
	private BookStatusRepository bookStatusRepository;

	// 新增書籍狀態
	@GetMapping("/book/addBookStatus")
	public String addBookStatus(BookStatus bookStatus, Model model) {
		model.addAttribute("bookStatus", bookStatus);
		return "book/addBookStatus";
	}

	
	@PostMapping("/book/postBookStatus")
	public String postBookStatus(@ModelAttribute("bookStatus") BookStatus bookStatus, Model model) {
		
		bookStatusService.addBookStatus(bookStatus);
		model.addAttribute("bookStatus",bookStatus);
		return "redirect:/book/bookStatusAll";
		
	}
	
	//讀取所有書籍狀態
	
	@GetMapping("/book/bookStatusAll")
	public String showAllBookStatus(Model model) {
		List<BookStatus> findAllBookStatus = bookStatusService.findAllBookStatus();
		model.addAttribute("bookStatusList",findAllBookStatus);
		return "/book/bookStatusAll";
		
	}
	
	
	
	
	
	public BookStatusController() {
		// TODO Auto-generated constructor stub
	}

}
