package com.esun.library.models.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esun.library.models.beans.books.BookStatus;


@Repository
public interface BookStatusRepository extends JpaRepository<BookStatus ,Integer> {

	

}
