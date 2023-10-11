package com.esun.library.models.beans.books;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BorrowedBooks")
public class BorrowedBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bookISBN")
    private String bookISBN;

    @Column(name = "borrowerID")
    private Long borrowerID;

    @Column(name = "borrowDate")
    private Date borrowDate;

    @Column(name = "returnDate")
    private Date returnDate;

	
    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public Long getBorrowerID() {
		return borrowerID;
	}

	public void setBorrowerID(Long borrowerID) {
		this.borrowerID = borrowerID;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

   
}
