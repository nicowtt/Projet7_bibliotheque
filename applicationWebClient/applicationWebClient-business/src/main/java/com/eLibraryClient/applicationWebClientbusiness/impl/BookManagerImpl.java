package com.eLibraryClient.applicationWebClientbusiness.impl;

import ch.qos.logback.core.pattern.FormatInfo;
import com.eLibraryClient.applicationWebClientbusiness.contract.BookManager;
import com.eLibraryClient.applicationWebClientbusiness.contract.BookReservationManager;
import com.eLibraryClient.applicationWebClientbusiness.contract.LibraryCatalogManager;
import com.eLibraryClient.applicationWebClientmodel.beans.BookBean;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryCatalogBean;
import com.eLibraryClient.applicationWebClientproxies.proxies.MicroserviceBDDProxy;
import org.springframework.beans.factory.annotation.Autowired;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookManagerImpl implements BookManager {

    @Autowired
    private MicroserviceBDDProxy microserviceBDDProxy;

    @Autowired
    private LibraryCatalogManager libraryCatalogManager;

    @Autowired
    private BookReservationManager bookReservationManager;

    static final Log logger = LogFactory.getLog(BookManagerImpl.class);

    /**
     * Ask all books from BDD
     *
     * @return -> list of all books
     */
    @Override
    public List<BookBean> getListAllBooks() {

        List<BookBean> booksList = microserviceBDDProxy.getBooksList();

        return booksList;
    }

    /**
     * Ask one book from BDD
     * @param pBookId
     * @return
     */
    @Override
    public BookBean getOneBook(int pBookId) {
        BookBean oneBook = microserviceBDDProxy.getOneBook(pBookId);
        return oneBook;
    }

    /**
     * Find number of iteration of one book in the city
     * @param bookId
     * @return
     */
    @Override
    public int getNbrOfIterationForOneBook(int bookId) {

        int nbrIteration = 0;

        List<LibraryCatalogBean> librariescatalogForOneBook = libraryCatalogManager.getLibrariesCatalogForOneBook(bookId);

        for (int i = 0; i < librariescatalogForOneBook.size(); i++) {
            nbrIteration = nbrIteration + librariescatalogForOneBook.get(i).getBookIteration();
        }

        return nbrIteration;
    }

    /**
     * For change disponibility of one book when there is no more iteration of book for reservation
     * @param bookId
     */
    @Override
    public void changedisponibilityOfOneBookIfNeeded(int bookId) {

        //get iteration number of book on all city
        int nbrIterationBook = getNbrOfIterationForOneBook(bookId);
        //get count number of reservation for one book in progress
        int countReservationForOneBookInProgress = bookReservationManager.countReservationInProgressForOneBook(bookId);

        if (countReservationForOneBookInProgress == nbrIterationBook) {
            // change book disponibility
            microserviceBDDProxy.bookNotDisponible(bookId);
            logger.info("Le livre d'ID:"+ bookId +" n'est plus reservable" );
        }
    }


}
