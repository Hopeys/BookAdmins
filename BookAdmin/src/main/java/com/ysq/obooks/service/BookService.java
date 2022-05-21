package com.ysq.obooks.service;

import com.ysq.obooks.common.BookAdminException;
import com.ysq.obooks.common.BookAdminExceptionEnum;
import com.ysq.obooks.domain.Book;
import com.ysq.obooks.domain.Student;
import com.ysq.obooks.domain.User;
import com.ysq.obooks.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;
    //登录
    public User login(String username,String password){
       User user= bookMapper.selectByLogin(username,password);
       if (user==null){
           throw new BookAdminException(BookAdminExceptionEnum.WRONG_PASSWORD);
       }
       return user;
    }

    //查询所有数据
    public List<Book> BookAll(){
        return   bookMapper.BookAll();
    }
    //添加数据
    public void insertBook(Book addBook){
        bookMapper.insertBook(addBook);
    }
}
