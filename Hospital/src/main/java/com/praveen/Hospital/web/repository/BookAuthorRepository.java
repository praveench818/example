package com.praveen.Hospital.web.repository;

import com.praveen.Hospital.support.jpa.CustomJpaRepository;
import com.praveen.Hospital.web.entity.Author;
import com.praveen.Hospital.web.entity.Book;
import com.praveen.Hospital.web.entity.BookAuthor;

/**
 * <b>BookAuthor Repository</b><br>
 * You can use NamedQuery or Query annotation here.<br>
 * 
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */
public interface BookAuthorRepository extends CustomJpaRepository<BookAuthor, Long> {

	public BookAuthor findByBookAndAuthor(Book book, Author author);

	public void deleteByAuthor(Author author);

	public void deleteByBook(Book book);
}
