package com.mikedgl.livrariaapi.controller;

import com.mikedgl.livrariaapi.dto.ViewBookDTO;
import com.mikedgl.livrariaapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<ViewBookDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.findById(id));
    }

}
