package com.bit.book;

/**
 * @ClassName Book
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/16 11:33
 * @Version 1.0
 **/
public class Book {
    public String name;
    public String author;
    public int price;
    public String type;//小说
    public boolean isBorrowead;

    public Book(String name, String author, int price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
       // this.isBorrowead = isBorrowead;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ((isBorrowead==true)?"已经被借出":"未被借出")+
               // ", isBorrowead=" + isBorrowead +
                '}';
    }
}
