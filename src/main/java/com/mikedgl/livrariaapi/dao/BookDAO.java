package com.mikedgl.livrariaapi.dao;

import com.mikedgl.livrariaapi.dto.ViewBookDTO;

public interface BookDAO{

    ViewBookDTO findById(Long id);


}
