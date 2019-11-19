import java.util.Arrays;

/**
 * @ClassName TestDemo2
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/17 9:53
 * @Version 1.0
 **/
//自定义类型排序时，implements Comparable<Student>
class Student implements Comparable<Student>{ //<   >内为排序的类型
    public String name;
    public int age;
    public int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
       return this.age-o.age;
      //return this.name.compareTo(o.name);
    }
}

public class TestDemo2 {

    public static void sort(Comparable[] comparables){
        //传的数据类型 肯定是实现Comparable类型接口的
        //冒泡排序
        for (int i = 0; i <comparables.length ; i++) {
            for (int j = 0; j <comparables.length-1-i ; j++) {
                if (comparables[j].compareTo(comparables[j+1])>0){
                    Comparable tmp=comparables[j];
                    comparables[j]=comparables[j+1];
                    comparables[j+1]=tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Student[] students=new Student[3];
        students[0]=new Student("liubei",99,21);
        students[1]=new Student("caocao",38,98);
        students[2]=new Student("zhangfei",89,64);

        System.out.println(Arrays.toString(students));
     //   Arrays.sort(students);
        sort(students);
        System.out.println(Arrays.toString(students));

    }
}
