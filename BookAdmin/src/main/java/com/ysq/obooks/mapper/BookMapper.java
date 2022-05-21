package com.ysq.obooks.mapper;

import com.ysq.obooks.domain.Book;
import com.ysq.obooks.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BookMapper {
    //查询单个数据
    @Select("select * from book where id=#{id}")
    Book findOneBook(Integer id);

    //查询名字
    @Select("select * from student where name=#{name}")
    Book  selectByName(String name);

    //查询所有
    @Select("select * from book")
    List<Book> BookAll();

    //添加数据
    @Insert("insert into book (bname,author,type,booknum,btime) values (#{bname},#{author},#{type},#{booknum},#{btime})")
    int insertBook(Book book);

    //登录
    @Select("select * from user where username=#{username} and password=#{password}")
    User selectByLogin(String username,String password);




}
