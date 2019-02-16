package com.praveen.Hospital.api.assembler;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.util.CollectionUtils;

import com.praveen.Hospital.api.AuthorController;
import com.praveen.Hospital.api.BookController;
import com.praveen.Hospital.api.resource.BookResource;
import com.praveen.Hospital.web.entity.Book;
import com.praveen.Hospital.web.entity.BookAuthor;

/**
 * <b>Book Resource Assembler</b><br>
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */
public class BookResourceAssembler extends ResourceAssemblerSupport<Book, BookResource> {

	public BookResourceAssembler() {
		super(BookController.class, BookResource.class);
	}

	@Override
	public BookResource toResource(Book book) {
		BookResource resource = createResourceWithId(book.getId(), book);
		// authors
		if (!CollectionUtils.isEmpty(book.getBookAuthors())) {
			for (BookAuthor bookAuthor : book.getBookAuthors()) {
				resource.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(AuthorController.class)
						.getAuthor(bookAuthor.getAuthor().getId())).withRel("authors"));
			}
		}

		// assign author
		Link assignAuthorLink = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(BookController.class).assignAuthor(book.getId(), null))
				.withRel("assignAuthor");
		resource.add(assignAuthorLink);

		return resource;
	}

	@Override
	protected BookResource instantiateResource(Book book) {

		BookResource resource = new BookResource();
		resource.setBookName(book.getBookName());
		resource.setCreateBy(book.getCreateBy().getUsername());
		resource.setCreateDate(book.getCreateDate());
		if (null != book.getLastModifiedBy()) {
			resource.setLastModifiedBy(book.getLastModifiedBy().getUsername());
			resource.setLastModifiedDate(book.getLastModifiedDate());
		}

		return resource;
	}

}
