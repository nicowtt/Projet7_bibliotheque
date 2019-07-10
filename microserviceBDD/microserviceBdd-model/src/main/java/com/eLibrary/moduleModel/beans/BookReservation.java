package com.eLibrary.moduleModel.beans;

import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;

@Entity
@Table(name = "bookreservation")
public class BookReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.book_id_seq")
    @SequenceGenerator(name = "public.book_id_seq", sequenceName = "public.book_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "beginofreservationdate")
    private String beginOfReservationDate;

    @Column(name = "endofreservationdate")
    private String endOfReservationDate;

    @Column(name = "extensionofreservation")
    private boolean extensionOfReservation;

    @Column(name = "bookback")
    private boolean bookBack;

    @Column(name = "user_id")
    private int userId;

    @Column
    private int bookId;

    @Column
    private int libraryId;

//    @ManyToOne //many reservation for one user
//    @JoinColumn(name = "user_id") //fk
////    @JsonIgnore
//    private Libraryuser libraryuser;

//    @ManyToOne //many reservation for one livre
//    @JoinColumn(name = "book_id") //fk
////    @JsonIgnore
//    private Book book;

//    @ManyToOne //many reservation for one library
//    @JoinColumn(name = "library_id") //fk
////    @JsonIgnore
//    private Library library;


    //constructor
    public BookReservation() {
    }

    public BookReservation(String beginOfReservationDate, String endOfReservationDate, boolean extensionOfReservation, boolean bookBack, int userId, int bookId, int libraryId) {
        this.beginOfReservationDate = beginOfReservationDate;
        this.endOfReservationDate = endOfReservationDate;
        this.extensionOfReservation = extensionOfReservation;
        this.bookBack = bookBack;
        this.userId = userId;
        this.bookId = bookId;
        this.libraryId = libraryId;
    }

    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeginOfReservationDate() {
        return beginOfReservationDate;
    }

    public void setBeginOfReservationDate(String beginOfReservationDate) {
        this.beginOfReservationDate = beginOfReservationDate;
    }

    public String getEndOfReservationDate() {
        return endOfReservationDate;
    }

    public void setEndOfReservationDate(String endOfReservationDate) {
        this.endOfReservationDate = endOfReservationDate;
    }

    public boolean isExtensionOfReservation() {
        return extensionOfReservation;
    }

    public void setExtensionOfReservation(boolean extensionOfReservation) {
        this.extensionOfReservation = extensionOfReservation;
    }

    public boolean isBookBack() {
        return bookBack;
    }

    public void setBookBack(boolean bookBack) {
        this.bookBack = bookBack;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }


    //to string

}
