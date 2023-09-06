package com.polstat.perpustakaan2;

import com.polstat.perpustakaan2.gen.Book;
import com.polstat.perpustakaan2.gen.CreateBookRequest;
import com.polstat.perpustakaan2.gen.CreateBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.polstat.perpustakaan2.gen.GetBookResponse;
import com.polstat.perpustakaan2.components.dto.BookDto;
import com.polstat.perpustakaan2.components.service.BookService;
import java.util.List;

@Endpoint
public class BookEndpoint {

    private static final String NAMESPACE_URI = "http://www.polstat.com/perpustakaan2/gen";

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
