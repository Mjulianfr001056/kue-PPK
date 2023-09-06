package com.polstat.components.service;

import com.polstat.components.dto.BookDto;
import com.polstat.components.entity.Book;
import com.polstat.components.mapper.BookMapper;
import com.polstat.components.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void createBook(BookDto bookDto) {
        bookRepository.save(BookMapper.mapToBook(bookDto));
    }

    @Override
    public List<BookDto> getBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = books.stream()
                .map((product) -> (BookMapper.mapToBookDto(product)))
                .collect(Collectors.toList());
        return bookDtos;
    }

    @Override
    public List<BookDto> searchBook(String title) {
        List<Book> books = bookRepository.findByTitleContainingOrAuthorContainingOrDescriptionContaining(title, title, title);
        List<BookDto> bookDtos = books.stream()
                .map((book)->(BookMapper.mapToBookDto(book)))
                .collect(Collectors.toList());
        return bookDtos;
    }
}