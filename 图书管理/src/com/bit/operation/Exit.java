package com.bit.operation;

import com.bit.book.Booklist;

/**
 * @ClassName Exit
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/16 11:35
 * @Version 1.0
 **/
public class Exit implements IOperation{
    @Override
    public void work(Booklist booklist) {
        System.out.println("bye");
        System.exit(0);
    }
}
