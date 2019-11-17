package com.bit.user;

import com.bit.book.Booklist;
import com.bit.operation.IOperation;

/**
 * @ClassName User
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/16 11:37
 * @Version 1.0
 **/
public abstract class User {

    protected String name;
    protected IOperation[] operations;

    public abstract int menu();
    public void doOperation(int choice, Booklist booklist){
        operations[choice].work(booklist);
    }

}
