/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polstat.perpustakaan;

/**
 *
 * @author asus
 */
import com.example.perpustakaan.soap.Book;
import com.example.perpustakaan.soap.CreateBookRequest;
import com.example.perpustakaan.soap.CreateBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.perpustakaan.soap.GetBookResponse;
import com.polstat.perpustakaan.dto.BookDto;
import com.polstat.perpustakaan.service.BookService;
import java.util.List;

@Endpoint
public class BookEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/perpustakaan/soap";
//    private CountryRepository countryRepository;

    @Autowired
    public BookService bookService;

   
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createBookRequest")
    @ResponsePayload
 public CreateBookResponse createBook(@RequestPayload CreateBookRequest request) {
        BookDto book = BookDto.builder()
            .title(request.getBook().getTitle())
            .author(request.getBook().getAuthor())
            .description(request.getBook().getDescription())
            .build();
        bookService.createBook(book);

        CreateBookResponse response = new CreateBookResponse();
        response.setStatusCode(201);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBooksRequest")
    @ResponsePayload
    public GetBookResponse getBooks() {
        GetBookResponse response = new GetBookResponse();

        List<BookDto> books = bookService.getBooks();
        for (BookDto book : books) {
            Book it = new Book();
            it.setTitle(book.getTitle());
            it.setAuthor(book.getAuthor());
            it.setDescription(book.getDescription());
            
            response.getBooks().add(it);
        }

        return response;
    }
}
