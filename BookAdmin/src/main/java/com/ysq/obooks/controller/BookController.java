package com.ysq.obooks.controller;

import com.alibaba.druid.util.StringUtils;
import com.ysq.obooks.common.ApiRestResponse;
import com.ysq.obooks.common.BookAdminException;
import com.ysq.obooks.common.BookAdminExceptionEnum;
import com.ysq.obooks.domain.Book;
import com.ysq.obooks.domain.Student;
import com.ysq.obooks.domain.User;
import com.ysq.obooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class BookController {
    @Autowired
    private BookService bookService;

    //登录接口
    @PostMapping("/login")
    public ApiRestResponse login(@RequestParam String username, @RequestParam String password,
                                 HttpSession session){

        if (StringUtils.isEmpty(username)){
            throw new BookAdminException(BookAdminExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(password)){
            throw new BookAdminException(BookAdminExceptionEnum.NEED_PASSWORD);
        }
        User user = bookService.login(username, password);
        session.setAttribute("userContent",user);
        user.setPassword(null);

        return ApiRestResponse.success();
    }
    @PostMapping("/logout")
    public ApiRestResponse logout(HttpSession session) {
        session.removeAttribute("userContent");
        return ApiRestResponse.success();
    }


    //1.添加书籍接口
    @PostMapping(value = "/insert",produces="application/json;charset=utf-8")
    public ApiRestResponse insertStudent(@RequestBody @Validated Book addbook){

        bookService.insertBook(addbook);
        return ApiRestResponse.success();
    }
    //2.查询所有书籍接口
    @GetMapping("/list" )
    public ApiRestResponse BookAll(HttpSession session){
        User userContent = (User) session.getAttribute("userContent");
//        if (userContent == null){
//            return ApiRestResponse.error(BookAdminExceptionEnum.NEED_LOGIN);
//        }
        List<Book> list = bookService.BookAll();
        return ApiRestResponse.success(list);
    }




}


