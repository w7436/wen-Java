package com.bit.operation;

import com.bit.book.Book;
import com.bit.book.Booklist;

/**
 * @ClassName DelOperation
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/16 11:35
 * @Version 1.0
 **/
public class DelOperation implements IOperation {
    @Override
    public void work(Booklist booklist) {
        System.out.println("输入需要删除书籍的名称");
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
        int pos=i;
        for (int j = pos; j <booklist.getSize()-1; j++) {
            Book nextBook=booklist.getBook(j+1);
            booklist.setBooks(j,nextBook);
        }
        booklist.setSize(booklist.getSize()-1);
        System.out.println("删除成功");
    }
}
