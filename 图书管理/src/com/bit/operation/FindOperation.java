package com.bit.operation;

import com.bit.book.Booklist;

/**
 * @ClassName FindOperation
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/16 11:36
 * @Version 1.0
 **/
public class FindOperation implements IOperation{
    @Override
    public void work(Booklist booklist) {
        System.out.println("输入需要查找书籍的名称");
        String name = scanner.next();
        //不会从bookList-》进行删除-》isBorrowed true
        //1、找这本书 是否存在
        int i = 0;
        for (i = 0; i <booklist.getSize() ; i++) {
            if (booklist.getBook(i).name.equals(name)){
                System.out.println(booklist.getBook(i));
                break;
            }
        }
        if (i>=booklist.getSize()){
            System.out.println("没有此书");
            return;
        }
        System.out.println("书籍查找成功");
        System.out.println();
    }
}
