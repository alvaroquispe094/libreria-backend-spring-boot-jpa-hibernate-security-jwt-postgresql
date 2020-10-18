package com.groupal.libreriaPrismaBackend.service;

import java.util.List;

import com.groupal.libreriaPrismaBackend.dto.BookDto;

public interface IBookService {
	
	public BookDto createBook(BookDto book);

    public BookDto updateBook(BookDto book);
    
    public List<BookDto> getAllBooks();
    
    public BookDto getBookById(Integer productId);
    
    public void deleteBook(Integer bookId);

}
