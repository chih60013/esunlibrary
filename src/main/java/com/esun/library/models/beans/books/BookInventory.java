package com.esun.library.models.beans.books;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="bookInventory")
public class BookInventory {

	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_InventoryId")
    private Integer bookInventoryId;



	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column(name = "book_PurchaseDate", columnDefinition = "datetime")
	private Date bookPurchaseDate;
//	書籍購買日期

//	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "fk_bookStatusId", nullable = false)
//    private BookStatus bookStatus;
	//串接  多對一  書籍狀態表
	
	
	
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "fk_bookISBN" , nullable = false)
//	private Book book;
	//串接  多對一  書籍基本資訊



	public Integer getBookInventoryId() {
		return bookInventoryId;
	}



	public void setBookInventoryId(Integer bookInventoryId) {
		this.bookInventoryId = bookInventoryId;
	}



	public Date getBookPurchaseDate() {
		return bookPurchaseDate;
	}



	public void setBookPurchaseDate(Date bookPurchaseDate) {
		this.bookPurchaseDate = bookPurchaseDate;
	}



//	public BookStatus getBookStatus() {
//		return bookStatus;
//	}
//
//
//
//	public void setBookStatus(BookStatus bookStatus) {
//		this.bookStatus = bookStatus;
//	}



//	public Book getBook() {
//		return book;
//	}
//
//
//
//	public void setBook(Book book) {
//		this.book = book;
//	}

	
	
	
	
	
	
	
	
	
}
