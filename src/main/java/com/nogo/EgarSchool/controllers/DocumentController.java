package com.nogo.EgarSchool.controllers;


import com.nogo.EgarSchool.DTO.DTODocument;
import com.nogo.EgarSchool.Mapper.MapperDocument;
import com.nogo.EgarSchool.models.Document;
import com.nogo.EgarSchool.repositories.DocumentRepository;
import com.nogo.EgarSchool.services.DucumentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class DocumentController {

    //private final DocumentRepository documentRepository;
    private final DucumentService documentService;

    @GetMapping("/")
    public String documents(
            @RequestParam(defaultValue = "0") Long id,
            Model model
    ){
        List<Document> documents = documentService.findAll();
        model.addAttribute("documents", documents);
        return "index";
    }


    @GetMapping("/add")
    public String addDocument(Model model,
        @ModelAttribute("dtoDocument") DTODocument dtoDocument
    ){
        return "add";
    }

    @PostMapping("/add") //добавление документа с валидацией
    public String addPostDocument(
            @ModelAttribute(value = "dtoDocument") @Valid DTODocument dtoDocument,
            BindingResult bindingResult
    ){
        if(bindingResult.hasErrors())
            return "add";

        documentService.addDoc(dtoDocument);
        return "redirect:/";
    }


    @GetMapping("/{id}/edit")
    public String editDocument(
            @PathVariable(value = "id") Long id,
            Model model){
        Document documents = documentService.findbyId(id);
        model.addAttribute("documents", documents);
        DTODocument dtoDocument = MapperDocument.getDTODocument(documents);
        model.addAttribute("dtoDocument", dtoDocument);
        return "edit";
    }


    @PostMapping("/{id}/edit") // почему то не работает валидация, при этом она выполняется, но не отображается
    public String editDocument(
            @Valid @ModelAttribute DTODocument dtoDocument,
            BindingResult bindingResult,
            @PathVariable(value = "id") Long id,
            Model model
    ){
        Document document = documentService.findbyId(id);
        model.addAttribute("document", document);
        if (bindingResult.hasErrors())
            return "edit";

        documentService.EditDoc(document, dtoDocument);
        return "redirect:/";
    }

    @GetMapping("/finder") // поиск заданого параметра, все поля не обязательны
    public String FindDocuments(
            @RequestParam (value = "title", required = false) String title,
            @RequestParam (value = "number", required = false) Long number,
            @RequestParam (value = "type", required = false) String type,
            @RequestParam (value = "contentOfDoc", required = false) String contentOfDoc,
            Model model
    ){
        List<Document> documents = documentService.findByfind(title,number,type,contentOfDoc);
        model.addAttribute("documents", documents);
        return "finder";
    }
}
