package com.groupal.libreriaPrismaBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupal.libreriaPrismaBackend.dto.BookDto;
import com.groupal.libreriaPrismaBackend.service.BookService;
					
//@CrossOrigin(origins = "https://libreria-prisma-frontend.herokuapp.com")
@CrossOrigin(origins = "${angular.cross-origin}")
@RestController
@RequestMapping("/api/admin")
public class BookController {
	
	@Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity < List<BookDto> > getAllBooks() {
        return ResponseEntity.ok().body(bookService.getAllBooks());
    }

    @GetMapping("/book/{id}")
    public ResponseEntity < BookDto > getBookById(@PathVariable Integer id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PostMapping("/book/add")
    public ResponseEntity < BookDto > createBook(@RequestBody BookDto bookDto) {
        return new ResponseEntity<>(this.bookService.createBook(bookDto), HttpStatus.CREATED);
    }

    @PutMapping("/book/update/{id}")
    public ResponseEntity < BookDto > updateBook(@PathVariable Integer id, @RequestBody BookDto bookDto) {
    	bookDto.setId(id);
        return ResponseEntity.ok().body(this.bookService.updateBook(bookDto));
    }

    @DeleteMapping("/book/delete/{id}")
    public HttpStatus deleteBook(@PathVariable Integer id) {
        this.bookService.deleteBook(id);
        return HttpStatus.OK;
    }

}
