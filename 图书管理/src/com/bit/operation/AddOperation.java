package com.bit.operation;

import com.bit.book.Book;
import com.bit.book.Booklist;

/**
 * @ClassName AddOperation
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/16 11:34
 * @Version 1.0
 **/
public class AddOperation implements IOperation {

    @Override
    public void work(Booklist booklist) {
        System.out.println("添加书籍");
        System.out.println("请输入图书的名字：");
        String name=scanner.next();
        System.out.println("请输入图书的作者：");
        String author=scanner.next();
        System.out.println("请输入图书的价格：");
        int price=scanner.nextInt();
        System.out.println("请输入图书的类型:");
        String type=scanner.next();
        Book book=new Book(name,author,price,type);//将图书的信息纳入
        //未考虑满的情况
        int curSize=booklist.getSize();
        booklist.setBooks(curSize,book);
        booklist.setSize(curSize+1);
        System.out.println("添加书籍成功");

    }
}
