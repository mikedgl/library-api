package com.mikedgl.livrariaapi.service;

import com.mikedgl.livrariaapi.dto.BookDTO;
import com.mikedgl.livrariaapi.dto.FilteredSearchDTO;
import com.mikedgl.livrariaapi.dto.SaveBookDTO;
import com.mikedgl.livrariaapi.dto.ViewBookDTO;

import java.util.List;

public interface BookService {
    ViewBookDTO findById(Long id);
    List<ViewBookDTO> filteredSearch(FilteredSearchDTO filter);
    BookDTO saveBook(SaveBookDTO bookDTO);
}
