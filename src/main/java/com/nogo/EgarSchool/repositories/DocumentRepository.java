package com.nogo.EgarSchool.repositories;

import com.nogo.EgarSchool.models.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;


@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {


        // поиск по бд по заданным полям
        @Query("SELECT t FROM Document t WHERE t.title = ?1 or t.number = ?2 or t.type = ?3 or t.contentOfDoc = ?4")
        List<Document> findAllByfind(String title, Long number,String type,String contentOfDoc);

}
