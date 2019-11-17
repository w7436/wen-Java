package com.bit.operation;

import com.bit.book.Book;
import com.bit.book.Booklist;

/**
 * @ClassName BorrowOperration
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/16 11:34
 * @Version 1.0
 **/
public class BorrowOperration implements IOperation{

    @Override
    public void work(Booklist booklist) {
        System.out.println("输入需要借阅书籍的名称");
        String name = scanner.next();
        //不会从bookList-》进行删除-》isBorrowed true
        //1、找这本书 是否存在
        int i = 0;
        for (i = 0; i <booklist.getSize() ; i++) {
            if (booklist.getBook(i).name.equals(name)){
                break;
            }
        }
        if (i>=booklist.getSize()){
            System.out.println("没有此书");
            return;
        }
        //2、他是否被借出   false  可以借
        Book book=booklist.getBook(i);
        if (book.isBorrowead){
            System.out.println("已经借出去了");
            return;
        }else{
            book.isBorrowead=true;
            System.out.println("书籍借阅成功");

        }

    }
}
