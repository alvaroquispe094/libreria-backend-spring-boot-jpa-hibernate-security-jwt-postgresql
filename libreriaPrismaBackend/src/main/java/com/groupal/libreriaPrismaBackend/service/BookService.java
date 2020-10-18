package com.groupal.libreriaPrismaBackend.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupal.libreriaPrismaBackend.dto.BookDto;
import com.groupal.libreriaPrismaBackend.entity.Book;
import com.groupal.libreriaPrismaBackend.exception.ResourceNotFoundException;
import com.groupal.libreriaPrismaBackend.repository.BookRepository;
import com.groupal.libreriaPrismaBackend.utils.ObjectMapperUtils;

@Service
public class BookService implements IBookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public BookDto createBook(BookDto bookDto) {

		try {
			Book book = ObjectMapperUtils.map(bookDto, Book.class);
			this.bookRepository.save(book);
			
			bookDto.setMensaje("El libro ha sido guardado de manera exitosa");
		    return bookDto;
	    
		} catch (ResourceNotFoundException e) {
			throw e;
		} catch (Exception e) {
//		LOG.error("Error al grabar la información.", e);
			throw new ServiceException("Error al grabar la información.");
		}
	}

	@Override
	public BookDto updateBook(BookDto bookDto) {
		
		Optional<Book> bookDb = this.bookRepository.findById(bookDto.getId());

        if (bookDb.isPresent()) {
        	Book book = ObjectMapperUtils.map(bookDto, Book.class);
            bookRepository.save(book);
            
            bookDto.setMensaje("El libro ha sido actualizado");
            return bookDto;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + bookDto.getId());
        }
	}

	@Override
	public List<BookDto> getAllBooks() {
		
		List<Book> books = this.bookRepository.findAll();
		
		List<BookDto> listBooksDto = ObjectMapperUtils.mapAll(books, BookDto.class);
		
        return listBooksDto;
	}

	@Override
	public BookDto getBookById(Integer bookId) {
		try {	 
			Optional<Book> book = this.bookRepository.findById(bookId);
			 	
	        if (!book.isPresent()) {
	            throw new ResourceNotFoundException("Record not found with id : " + bookId);
	        }
        
	        BookDto bookDto = ObjectMapperUtils.map(book.get(), BookDto.class);
	        return bookDto;
        
		} catch (ResourceNotFoundException e) {
			throw e;
		} catch (Exception e) {
//		LOG.error("Error al grabar la información.", e);
			throw new ServiceException("Error al grabar la información.");
		}

	}	
	
	@Override
	public void deleteBook(Integer bookId) {
		Optional<Book> bookDb = this.bookRepository.findById(bookId);

        if (bookDb.isPresent()) {
            this.bookRepository.delete(bookDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + bookId);
        }
		
	}

}
