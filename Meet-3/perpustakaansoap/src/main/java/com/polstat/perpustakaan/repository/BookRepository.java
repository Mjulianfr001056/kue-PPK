/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.polstat.perpustakaan.repository;

/**
 *
 * @author asus
 */
import com.polstat.perpustakaan.entity.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
        List<Book> findByTitleContainingOrAuthorContainingOrDescriptionContaining(String title,String author, String description);
}
