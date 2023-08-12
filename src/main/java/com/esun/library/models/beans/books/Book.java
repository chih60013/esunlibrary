package com.esun.library.models.beans.books;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {

	

	
	
	@Id
	@Column(name="book_ISBN",nullable = false)
	private  String bookISBN ;
	
	
	
	@Column(name="book_Name",nullable = false)
	private String bookName;
	
	@Column(name="book_Author",nullable = false)
	private String bookAuthor;
	
	@Column(name="book_Introduction")
	private String bookIntroduction;
	
	
	
	
	
	
	
	
	public String getBookISBN() {
		return bookISBN;
	}








	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}








	public String getBookName() {
		return bookName;
	}








	public void setBookName(String bookName) {
		this.bookName = bookName;
	}








	public String getBookAuthor() {
		return bookAuthor;
	}








	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}








	public String getBookIntroduction() {
		return bookIntroduction;
	}








	public void setBookIntroduction(String bookIntroduction) {
		this.bookIntroduction = bookIntroduction;
	}








	public Book() {
		// TODO Auto-generated constructor stub
	}

}
