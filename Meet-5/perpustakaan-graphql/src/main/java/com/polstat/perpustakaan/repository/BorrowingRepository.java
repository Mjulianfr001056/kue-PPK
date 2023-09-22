package com.polstat.perpustakaan.repository;

import com.polstat.perpustakaan.entity.Borrowing;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "borrowing", path = "borrowing")
public interface BorrowingRepository extends PagingAndSortingRepository<Borrowing, Long>, CrudRepository<Borrowing, Long> {
    List<Borrowing> findByMemberMemberID(@Param("memberID") String memberID);
    List<Borrowing> findByBookIDId(@Param("bookID") Long bookID);

    List<Borrowing> findByBookIDTitleContaining(@Param("bookTitle") String title);
}
