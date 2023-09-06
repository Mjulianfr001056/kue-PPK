package com.polstat.components.repository;
import com.polstat.components.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
//    @Query("SELECT b FROM Book b WHERE b.title LIKE %:keyword% OR b.author LIKE %:keyword% OR b.description LIKE %:keyword%")
//    List<Book> searchBooksByKeyword(String keyword);
    List<Book> findByTitleContainingOrAuthorContainingOrDescriptionContaining(String title,String author, String description);
}