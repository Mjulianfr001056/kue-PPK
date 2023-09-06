package com.polstat.perpustakaan2.components.service;

import com.polstat.perpustakaan2.components.dto.BookDto;
import com.polstat.perpustakaan2.components.entity.Book;
import com.polstat.perpustakaan2.components.mapper.BookMapper;
import com.polstat.perpustakaan2.components.repository.BookRepository;
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
    public List<BookDto> searchBook(String keyword) {
        List<Book> books = bookRepository.findByTitleContainingOrAuthorContainingOrDescriptionContaining(keyword,keyword,keyword);
        List<BookDto> bookDtos = books.stream()
                .map((book)->(BookMapper.mapToBookDto(book)))
                .collect(Collectors.toList());

        return bookDtos;
    }
}