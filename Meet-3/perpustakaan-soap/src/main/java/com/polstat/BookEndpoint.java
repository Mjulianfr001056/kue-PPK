package com.polstat;

import com.polstat.components.service.BookService;
import com.polstat.components.dto.BookDto;
import com.polstat.perpustakaansoap.gen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class BookEndpoint {

    private static final String NAMESPACE_URI = "http://www.polstat.com/perpustakaansoap/gen";

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
