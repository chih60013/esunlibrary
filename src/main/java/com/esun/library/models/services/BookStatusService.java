package com.esun.library.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esun.library.models.beans.books.BookStatus;
import com.esun.library.models.repositorys.BookStatusRepository;

@Service
public class BookStatusService {

	@Autowired
	private BookStatusRepository bookStatusRepository;
	
	//新增書籍狀態
	public void addBookStatus(BookStatus bookStatus) {
		bookStatusRepository.save(bookStatus);
	}
	
	
	//找尋所有書籍狀態
	public List<BookStatus> findAllBookStatus(){
		List<BookStatus> findAllBookStatus = bookStatusRepository.findAll();
		return findAllBookStatus;
		
	}
	
	
}
