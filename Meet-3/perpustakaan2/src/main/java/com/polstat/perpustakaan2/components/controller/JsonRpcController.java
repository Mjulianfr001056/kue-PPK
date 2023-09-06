package com.polstat.perpustakaan2.components.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.polstat.perpustakaan2.components.dto.BookDto;
import com.polstat.perpustakaan2.components.rpc.JsonRpcRequest;
import com.polstat.perpustakaan2.components.rpc.JsonRpcResponse;
import com.polstat.perpustakaan2.components.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class JsonRpcController {
    @Autowired
    private BookService bookService;
    @PostMapping("/jsonrpc")
    public ResponseEntity<Object> handleJsonRpcRequest(@RequestBody
                                                       JsonRpcRequest request) {
        try {
            String method = request.getMethod();
            JsonNode params = request.getParams();
            System.out.println("Method: "+ method);
            switch (method) {
                case "createBook":
                    String title = params.get("title").asText();
                    String author = params.get("author").asText();
                    String description = params.get("description").asText();
                    BookDto book = BookDto.builder()
                            .title(title)
                            .description(description)
                            .author(author)
                            .build();
                    bookService.createBook(book);
                    return ResponseEntity.ok(new JsonRpcResponse("created", request.getId()));
                case "getBooks":
                    List<BookDto> books = bookService.getBooks();
                    return ResponseEntity.ok(new JsonRpcResponse(books, request.getId()));
                case "searchBooks":
                    String titleSearch = params.get("title").asText();
                    List<BookDto> bookSearch = bookService.searchBook(titleSearch);
                    return ResponseEntity.ok(new JsonRpcResponse(bookSearch, request.getId()));
                default:
                    return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }
}