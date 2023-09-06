package com.polstat.perpustakaan2.components.mapper;
import com.polstat.perpustakaan2.components.dto.BookDto;
import com.polstat.perpustakaan2.components.entity.Book;
public class BookMapper {
    public static Book mapToBook(BookDto bookDto){
        return Book.builder()
                .id(bookDto.getId())
                .title(bookDto.getTitle())
                .description(bookDto.getDescription())
                .author(bookDto.getAuthor())
                .build();
    }
    public static BookDto mapToBookDto(Book book){
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .description(book.getDescription())
                .author(book.getAuthor())
                .build();
    }
}