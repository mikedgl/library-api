package com.mikedgl.livrariaapi.dao;

import com.mikedgl.livrariaapi.dto.FilteredSearchDTO;
import com.mikedgl.livrariaapi.dto.ViewBookDTO;

import java.util.List;

public interface BookDAO{

    ViewBookDTO findById(Long id);

    List<ViewBookDTO> filteredSearch(FilteredSearchDTO filter);


}
