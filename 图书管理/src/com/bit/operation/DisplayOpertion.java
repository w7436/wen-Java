package com.bit.operation;

import com.bit.book.Booklist;

/**
 * @ClassName DisplayOpertion
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/16 11:35
 * @Version 1.0
 **/
public class DisplayOpertion implements IOperation {
    @Override
    public void work(Booklist booklist) {
        System.out.println();
        for (int i = 0; i <booklist.getSize() ; i++) {
            System.out.println(booklist.getBook(i));
        }

    }


}
