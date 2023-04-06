package com.mikedgl.livrariaapi.service;

import com.mikedgl.livrariaapi.dto.ViewBookDTO;

public interface BookService {
    ViewBookDTO findById(Long id);
}
