package com.polstat.perpustakaan2.components.service;

import com.polstat.perpustakaan2.components.dto.BookDto;

import java.util.List;
public interface BookService {
    public void createBook(BookDto bookDto);
    public List<BookDto> getBooks();
    public List<BookDto> searchBook(String title);
}