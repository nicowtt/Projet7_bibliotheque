package com.eLibraryClient.applicationWebClientbusiness.contract;

import com.eLibraryClient.applicationWebClientmodel.beans.BookReservationBean;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface BookReservationManager {
    void completeWithDate(BookReservationBean bookReservation);
    List<BookReservationBean> bookReservationInProgressList();
    int countReservationInProgressForOneBook(int bookId);
}
