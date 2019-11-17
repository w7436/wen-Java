package com.bit.operation;

import com.bit.book.Booklist;

import java.util.Scanner;

public interface IOperation {
    Scanner scanner=new Scanner(System.in);
    void work(Booklist booklist);

}
