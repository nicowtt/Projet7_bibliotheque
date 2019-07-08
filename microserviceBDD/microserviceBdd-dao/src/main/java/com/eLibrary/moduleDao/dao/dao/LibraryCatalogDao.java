package com.eLibrary.moduleDao.dao.dao;

import com.eLibrary.moduleModel.beans.LibraryCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LibraryCatalogDao extends JpaRepository<LibraryCatalog, Integer> {
    List<LibraryCatalog> findByBook_Id(int bookId);

}
