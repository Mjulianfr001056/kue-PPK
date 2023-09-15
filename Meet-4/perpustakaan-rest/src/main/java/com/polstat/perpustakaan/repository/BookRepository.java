package com.polstat.perpustakaan.repository;
import com.polstat.perpustakaan.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book, Long>{
}