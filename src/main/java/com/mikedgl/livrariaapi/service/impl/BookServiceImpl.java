package com.mikedgl.livrariaapi.service.impl;

import com.mikedgl.livrariaapi.dao.BookDAO;
import com.mikedgl.livrariaapi.dto.ViewBookDTO;
import com.mikedgl.livrariaapi.exception.ResourceNotFound;
import com.mikedgl.livrariaapi.service.BookService;
import com.mikedgl.livrariaapi.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;

    public ViewBookDTO findById(Long id){
        ViewBookDTO book = bookDAO.findById(id);
        if(Objects.isNull(book)) throw new ResourceNotFound(Messages.BOOK_NOT_FOUND);
        return book;
    }


}
