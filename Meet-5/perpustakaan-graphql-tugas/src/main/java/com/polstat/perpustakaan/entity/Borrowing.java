package com.polstat.perpustakaan.entity;

import com.polstat.perpustakaan.enumeration.BorrowingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "borrowing")
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "memberID", nullable = false)
    private Member member;
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book bookID;
    @Column(nullable = false)
    private Date start_date;
    @Column(nullable = false)
    private Date end_date;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BorrowingStatus status;
    @Column(nullable = true)
    private Integer penalty;
}