package com.esun.library.models.beans.books;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="bookStatus")
public class BookStatus {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_StatusId")
	private Integer bookStatusId;
	
	
	
	@Column(name = "book_StatusName", columnDefinition = "nvarchar(50)", nullable = false)
	private String bookStatusName;

	@Column(name = "book_StatusDesc", columnDefinition = "nvarchar(200)", nullable = false)
	private String bookStatusDesc;
	
	
	
	public Integer getBookStatusId() {
		return bookStatusId;
	}







	public void setBookStatusId(Integer bookStatusId) {
		this.bookStatusId = bookStatusId;
	}







	public String getBookStatusName() {
		return bookStatusName;
	}







	public void setBookStatusName(String bookStatusName) {
		this.bookStatusName = bookStatusName;
	}







	public String getBookStatusDesc() {
		return bookStatusDesc;
	}







	public void setBookStatusDesc(String bookStatusDesc) {
		this.bookStatusDesc = bookStatusDesc;
	}







	public BookStatus() {
		// TODO Auto-generated constructor stub
	}

}
