package com.esun.library.models.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esun.library.models.beans.books.Book;



	@Repository
	public  interface BookRepository extends JpaRepository<Book,String> {
	

}
