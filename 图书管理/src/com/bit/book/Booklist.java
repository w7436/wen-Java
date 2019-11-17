package com.bit.book;

/**
 * @ClassName Booklist
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/16 11:33
 * @Version 1.0
 **/
public class Booklist {
    public Book[] books=new Book[10];
    private int size;//有效数据个数

    public Booklist(){
        books[0]=new Book("三国演义","罗贯中",100,"小说");
        books[1]=new Book("水浒传","施耐庵",67,"小说");
        books[2]=new Book("红楼梦","曹雪芹",67,"小说");
        this.size=3;
    }
    public void setBooks(int pos,Book book){
        this.books[pos]=book;
    }

    public Book getBook(int pos) {
        return books[pos];
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }


}
