package com.polstat.perpustakaan2.components.repository;
import com.polstat.perpustakaan2.components.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book> findByTitleContainingOrAuthorContainingOrDescriptionContaining(String title, String author, String description);
}