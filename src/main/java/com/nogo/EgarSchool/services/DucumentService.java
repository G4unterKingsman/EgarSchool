package com.nogo.EgarSchool.services;

import com.nogo.EgarSchool.DTO.DTODocument;
import com.nogo.EgarSchool.Mapper.MapperDocument;
import com.nogo.EgarSchool.models.Document;
import com.nogo.EgarSchool.repositories.DocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DucumentService {
    private final DocumentRepository documentRepository;



    //добавление, редактирование документа, а так же поиск по запросу
    public List<Document> findByfind(String title ,Long number,String type,String contentOfDoc){
        return documentRepository.findAllByfind(title,number,type,contentOfDoc);
    }

    public void addDoc(DTODocument dtoDocument){
        Document document = MapperDocument.getDocument(new Document(), dtoDocument);
            documentRepository.save(document);
    };

    public void EditDoc(Document document, DTODocument dtoDocument) {
        documentRepository.save(MapperDocument.getDocument(document, dtoDocument));
    }
    public List<Document> findAll() {
        return documentRepository.findAll();
    }
    public Document findbyId(Long id){
        return documentRepository.findById(id).orElseThrow();
    }
}
