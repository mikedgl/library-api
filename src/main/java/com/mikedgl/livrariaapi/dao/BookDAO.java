package com.mikedgl.livrariaapi.dao;

import com.mikedgl.livrariaapi.domain.Book;
import com.mikedgl.livrariaapi.dto.FilteredSearchDTO;
import com.mikedgl.livrariaapi.dto.ViewBookDTO;

import java.util.List;
import java.util.Optional;

public interface BookDAO{

    ViewBookDTO findById(Long id);

    List<ViewBookDTO> filteredSearch(FilteredSearchDTO filter);

    Optional<Book> findBookByIsbn(String isbn);

    void save(Book book);


}
