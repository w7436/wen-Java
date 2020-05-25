import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Lambda
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/25 20:46
 * @Version 1.0
 **/
interface MyPrediect<T>{
    boolean test(T t);
}

class FilterAge implements MyPrediect<Employee> {
    @Override
    public boolean test(Employee t) {
        return t.getAge()>35 ;
    }
}
class FilterSalary implements MyPrediect<Employee> {
    @Override
    public boolean test(Employee t) {
        return t.getSalary()>5000 ;
    }
}
class Employee{
    private String name;
    private String gender;
    private int age;
    private double salary;
    public Employee(String name, String gender, int age, double salary) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee[" +name + "," + gender + "," + age + "," + salary + "]";
    }
    public String getGender(){
        return gender;
    }
    public double getSalary(){
        return salary;
    }
    public int getAge(){
        return age;
    }
}

/**
 * 1、过滤所有年龄超过35岁的员工
 * 2、所有薪资超过5000元的员工信息
 */
public class Lambda {

    public static List<Employee> filterEmployeeByAge(List<Employee> empList){
        // 过滤年龄超过35的员工
        List<Employee> list = new ArrayList<>();
        for(Employee e : empList){
            if(e.getAge() > 35)
                list.add(e);
        }
        return list;
    }
    public static List<Employee> filterEmployeeBySalary(List<Employee> empList){
        // 过滤薪资超过5000的员工
        List<Employee> list = new ArrayList<>();
        for(Employee e : empList){
            if(e.getSalary() >= 5000)
                list.add(e);
        }
        return list;
    }
    public static void test1(){
        List<Employee> emps = Arrays.asList(
                new Employee("张三","男", 20, 5000),
                new Employee("李四","男", 36, 7000),
                new Employee("王五","男", 16, 3000),
                new Employee("赵六","女", 23, 6000),
                new Employee("田七","男", 43, 8000)
        );
        for (Employee e : emps)
            System.out.println(e);
        System.out.println("------------------------------------------");

        List<Employee> list1 = filterEmployeeByAge(emps);
        for (Employee e : list1)
            System.out.println(e);
        System.out.println("------------------------------------------");
        List<Employee> list2 = filterEmployeeBySalary(emps);
        for (Employee e : list2)
            System.out.println(e);
    }

   public static List<Employee> filterEmploy(List<Employee> emps,MyPrediect<Employee> mp){
       // 过滤年龄超过35的员工
       List<Employee> list = new ArrayList<>();
       for(Employee e : emps){
           if(mp.test(e))
               list.add(e);
       }
       return list;
   }
   //优化1
   public static void test2(){
       List<Employee> emps = Arrays.asList(
               new Employee("张三","男", 20, 5000),
               new Employee("李四","男", 36, 7000),
               new Employee("王五","男", 16, 3000),
               new Employee("赵六","女", 23, 6000),
               new Employee("田七","男", 43, 8000)
       );

       List<Employee> l1 = filterEmploy(emps,new FilterAge());
       for (Employee e : l1)
           System.out.println(e);
       System.out.println("------------------------------------------");
       List<Employee> l2 = filterEmploy(emps,new FilterSalary());
       for (Employee e : l2)
           System.out.println(e);
       System.out.println("------------------------------------------");

   }
   //匿名内部类
    public static void test3(){
        List<Employee> emps = Arrays.asList(
                new Employee("张三","男", 20, 5000),
                new Employee("李四","男", 36, 7000),
                new Employee("王五","男", 16, 3000),
                new Employee("赵六","女", 23, 6000),
                new Employee("田七","男", 43, 8000)
        );

        List<Employee> l1 = filterEmploy(emps, new MyPrediect<Employee>() {
            @Override
            public boolean test(Employee t) {
                return t.getAge()>35 ;
            }
        });
        for (Employee e : l1)
            System.out.println(e);
        System.out.println("------------------------------------------");
        List<Employee> l2 = filterEmploy(emps,new MyPrediect<Employee>(){
            @Override
            public boolean test(Employee t) {
                return t.getSalary()>5000 ;
            }
        });
        for (Employee e : l2)
            System.out.println(e);
        System.out.println("------------------------------------------");

    }
    public static void test4() {
        List<Employee> emps = Arrays.asList(
                new Employee("张三","男", 20, 5000),
                new Employee("李四","男", 36, 7000),
                new Employee("王五","男", 16, 3000),
                new Employee("赵六","女", 23, 6000),
                new Employee("田七","男", 43, 8000)
        );

        List<Employee> l1 = filterEmploy(emps,e->e.getAge() > 35);//e->e.getAge() > 35表达式
        for (Employee e : l1)
            System.out.println(e);
        System.out.println("------------------------------------------");
        List<Employee> l2 = filterEmploy(emps,e->e.getSalary() > 5000);
        for (Employee e : l2)
            System.out.println(e);
        System.out.println("------------------------------------------");

    }
    public static void test5() {
        List<Employee> emps = Arrays.asList(
                new Employee("张三","男", 20, 5000),
                new Employee("李四","男", 36, 7000),
                new Employee("王五","男", 16, 3000),
                new Employee("赵六","女", 23, 6000),
                new Employee("田七","男", 43, 8000)
        );

        List<Employee> l1 = filterEmploy(emps,e->e.getAge() > 35);//e->e.getAge() > 35表达式
        l1.forEach(System.out::println);
        System.out.println("------------------------------------------");
        List<Employee> l2 = filterEmploy(emps,e->e.getSalary() > 5000);
        l2.forEach(System.out::println);
        System.out.println("------------------------------------------");

    }
    public static void main(String[] args) {
        test5();
    }

}
