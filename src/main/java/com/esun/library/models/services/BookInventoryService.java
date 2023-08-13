package com.esun.library.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esun.library.models.beans.books.BookInventory;
import com.esun.library.models.repositorys.BookInventoryRepository;

@Service
public class BookInventoryService {

	@Autowired
	private BookInventoryRepository bookInventoryRepository;
	
	//新增書籍庫存資訊
	
	public void addBookInventory(BookInventory bookInventory) {
		bookInventoryRepository.save(bookInventory);
	}
	
	
	
	
	//檢視所有書籍現存狀態
	
	public List<BookInventory> findAllBookInventory(){
		List<BookInventory> findAllBookInventory = bookInventoryRepository.findAll();
		return findAllBookInventory;
	}
	
	
	
	public BookInventoryService() {
		// TODO Auto-generated constructor stub
	}

}
