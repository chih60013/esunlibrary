package com.esun.library.models.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
	
	
	//透過bookInventoryId 來找書籍
	
	public BookInventory findByBookInventoryId(Integer bookInventoryId) {
		Optional<BookInventory>	option = bookInventoryRepository.findById(bookInventoryId);
		
		if(option.isEmpty()) {
			return null;
		}
		return option.get();
	}
		
		
		
	
	
	
	
	
	
	
//	透過 id 更新
	
	@Transactional
	public BookInventory updateBookInventoryById (Integer bookInventoryId , BookInventory newbookInventory) {
		Optional<BookInventory> option = bookInventoryRepository.findById(bookInventoryId);
		if(option.isPresent()) {
			BookInventory bookInventory = option.get();
			bookInventory.setBookStatus(newbookInventory.getBookStatus()); //也只有書籍狀態能更改
			return bookInventory;
			
		}
		return null;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public BookInventoryService() {
		// TODO Auto-generated constructor stub
	}

}
