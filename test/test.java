public class test {
	public static void main(String[] args){
		/*1.Integer.MAX_VALUE   
		Integer.MIN_VALUE
		Integer--》属于java自己的一个类
		Integer-》int对应的包装类
		1.java Test    命令行的参数
		2.Integer.MAX_VALUE   
		Integer.MIN_VALUE
		Integer--》属于java自己的一个类
		Integer-》int对应的包装类
		int  short 内置类型-》简单类型
		3.String[] args 数组-》字符串数组 
		int arr[10];   int[] arr;
		4.String 字符串类型
		5.System.out.println("hello Java13!");
			"hello Java13!"-->字符串 但是不存在\0结尾
		6.一个class 对应一个.class 字节码文件
		7.类 只有使用到 才会被调用
		8.println 换行
			print 不换行
			printf("%d",a);
		9.定义局部变量的时候 我们要必须初始化
		10.int  一定是4个字节。跨平台性
		11.JAVA当中 只有符号。没有无符号。
		12.默认是double类型
		*/
		/*
		1.字节类型  1个字节	对标语c语言中的char类型-128~127
		2.cpu是以4个字节为单位从内存中读取数据，会进行整形提升，再进行运算
		
		 */
		
		
		
		
		
	
		int a=10;
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		int  a=Integer.MAX_VALUE+1;
		System.out.println(a);
	
		for(int i=0;i<args.length;i++){
			System.out.println(args[i]);
		}
		
	}

}