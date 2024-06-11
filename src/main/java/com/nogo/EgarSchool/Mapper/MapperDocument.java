package com.nogo.EgarSchool.Mapper;

import com.nogo.EgarSchool.DTO.DTODocument;
import com.nogo.EgarSchool.models.Document;

public class MapperDocument {

    public static Document getDocument(Document document, DTODocument documentDto) {
        document.setTitle(documentDto.getTitle());
        document.setContentOfDoc(documentDto.getContentOfDoc());
        document.setNumber(documentDto.getNumber());
        document.setType(documentDto.getType());
        return document;
    }

    public static DTODocument getDTODocument(Document document) {
        return DTODocument.builder().title(document.getTitle()).type(document.getType()).contentOfDoc(document.getContentOfDoc()).number(document.getNumber()).build();
    }
}
