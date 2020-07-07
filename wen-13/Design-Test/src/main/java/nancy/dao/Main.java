package nancy.dao;

import nancy.modol.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/17 10:30
 * @Version 1.0
 **/

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void menu(){
        System.out.println("1、插入学生信息");
        System.out.println("2、删除学生信息(根据学号)");
        System.out.println("3、修改学生信息");
        System.out.println("4、查询学生信息（根据Id号）");
        System.out.println("5、查询学生信息（根据姓名）");
        System.out.println("6、查询某一分数段的学生信息");
        System.out.println("7、查询不同系的学生信息");
        System.out.println("8、查看学生信息");
        System.out.println("9、退出！");
        System.out.println("-----------------------------------");
    }

    //1、添加数据
    public static void insertS(){
        System.out.print("请输入你的用户信息：学号,成绩,姓名,系名,：");
        Student stu = new Student();

        int ID = sc.nextInt();
        String  NAME = sc.next();
        int SCORE = sc.nextInt();
        String DEPART = sc.next();


        stu.setId(ID);
        stu.setName(NAME);
        stu.setDepartment(DEPART);
        stu.setScore(SCORE);


        boolean t = StuDao.insert(stu);
        if(t == true) System.out.println("插入数据成功");
    }

    //2、删除可以一次删除多组数据
    public static void selectS(){
        System.out.print("请输入需要删除的学生信息的个数>");
        int count = sc.nextInt();
        int[] arr = new int[count];
        for(int i = 0;i < count;i++){
            System.out.print("请输入需要删除的学生的学号：");
            arr[i] = sc.nextInt();
        }
        boolean t1 = StuDao.delete(arr);
        if(t1 == true){
            System.out.println("删除数据成功!");
        }
    }
    //    3、修改学生信息
    public static void updateS(){
        System.out.print("请输入修改后用户信息：学号，姓名，系名，成绩：");
        Student stu = new Student();
        int ID = sc.nextInt();
        String  NAME = sc.nextLine();
        String DEPART = sc.nextLine();
        int SCORE = sc.nextInt();

        stu.setId(ID);
        stu.setName(NAME);
        stu.setDepartment(DEPART);
        stu.setScore(SCORE);
        boolean t2 = StuDao.update(stu);
        if(t2 == true) System.out.println("修改信息成功");
    }
    //4、查询学生信息（根据Id号）
    public static void queryID(){
        //查询ID信息
        System.out.print("请输入需要查询学生的ID号：");
        int ID = sc.nextInt();
        Student student = StuDao.query(ID);
        System.out.println(student);
    }
    //5、查询学生信息（根据姓名）
    public static void queryNAME(){
        //查询ID信息
        System.out.print("请输入需要查询学生的姓名：");
        String name = sc.nextLine();
        Student student = StuDao.query(name);
        System.out.println(student);
    }
    //6、查询某一分数段的学生信息
    public static void querySCORE(){
        System.out.print("请输入需要查询成绩段的最小值和最大值：");
        int min = sc.nextInt();
        int max = sc.nextInt();
        List<Student> l = new ArrayList<Student>();
        l = StuDao.query(min,max);
        for (int i = 0;i < l.size();i++){
            System.out.println(l.get(i));
        }
    }
    //7、查询不同系的学生信息
    public static void queryDEPART(){
        System.out.print("请输入需要查询的系名：");
        String depart = sc.next();
        List<Student> l = new ArrayList<Student>();
        l = StuDao.query1(depart);
        for (int i = 0;i < l.size();i++){
            System.out.println(l.get(i));
        }
    }
    //8、查看学生信息
    public static void queryALL(){
        List<Student> l = new ArrayList<Student>();
        l = StuDao.select();
        for (int i = 0;i < l.size();i++){
            System.out.println(l.get(i));
        }
    }

    public static void main(String[] args) {

        boolean running = true;
        while(running){
            menu();
            System.out.print("请输入你的选择>");
            int select = sc.nextInt();
            switch (select){
                case 1:
                    insertS();
                    break;
                case 2:
                    selectS();
                    break;
                case 3:
                    updateS();
                    break;
                case 4:
                    queryID();
                    break;
                case 5:
                    queryNAME();
                    break;
                case 6:
                    querySCORE();
                    break;
                case 7:
                    queryDEPART();
                    break;
                case 8:
                    queryALL();
                    break;
                case 9:
                    running = false;
                default:
                    return;
            }
        }
    }

}
