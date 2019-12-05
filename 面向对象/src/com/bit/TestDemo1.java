package com.bit;
/*
四种访问权限：
public ：
private ：
protected ：
包访问权限：(默认只能访问包当中的内容)

 */
//导入所有的包，用谁导入谁，如果编译器区分不了，只能自己指定，用谁加载谁，动态导入
import com.src.demo1.Animal;

import java.util.*;
import java.sql.*;
//静态导入
import static java.lang.System.*;//一般情况不用



/**
 * @ClassName TestDemo1
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/13 16:09
 * @Version 1.0
 **/
//路径指定到哪里，就从哪里启动JVM
//包访问权限只能访问包当中的内容
public class TestDemo1 {
    String name;//包访问权限
    public static void main(String[] args) {
          out.println("hello");



//        java.util.Date date=new java.util. Date();
//        int[] array={1,2,3,4};
//        System.out.println(Arrays.toString(array));
//        System.out.println(date.getTime());//ms数
    }
}
