package com.eLibraryClient.applicationWebClientbusiness.impl;

import com.eLibraryClient.applicationWebClientbusiness.contract.BookReservationManager;
import com.eLibraryClient.applicationWebClientmodel.beans.BookBean;
import com.eLibraryClient.applicationWebClientmodel.beans.BookReservationBean;

import java.util.ArrayList;
import java.util.List;

public class BookReservationManagerImpl implements BookReservationManager {


    @Override
    public  List<BookBean> askToBddOnWhichLibraryIsBook(int pBookId) {
        List<BookBean> listWithBookVersion = new ArrayList<>();

        //todo 2 method pour aller chercher une liste de bean avec l'id  d'un livre

        return listWithBookVersion;
    }








    @Override
    public void writeBookReservationOnBdd(BookReservationBean bookReservationBean) {
        //todo 5 method pour ecrire une reservation
        // pour faire une reservation il me faut
        // un userId
        // un bookId
        // une library Id
        //date du jour

        // et je demande a la bdd dans quel bibliotheque est ce livre
    }
}
