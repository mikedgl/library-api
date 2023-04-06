package com.mikedgl.livrariaapi.controller;

import com.mikedgl.livrariaapi.dto.FilteredSearchDTO;
import com.mikedgl.livrariaapi.dto.ViewBookDTO;
import com.mikedgl.livrariaapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("search-filtered")
    public ResponseEntity<List<ViewBookDTO>> filteredSearch(FilteredSearchDTO filter){
        return ResponseEntity.ok(bookService.filteredSearch(filter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViewBookDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.findById(id));
    }

}
