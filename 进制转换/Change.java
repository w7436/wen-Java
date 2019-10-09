
// import java.util.Scanner;
// public class Change{
//   // 十进制转换为 n 进制
//   public String fun(int n,int num) {
//     // n 表示目标进制, num 要转换的值
//     String str= "";
//     int yushu ;      // 保存余数
//     int shang = num;      // 保存商
//     while (shang>0) {
//       yushu = shang %n;
//       shang = shang/n;
      
//       // 10-15 -> a-f
//       if(yushu>9) {
//         str =(char)('a'+(yushu-10)) + str;
//       }else {
//         str = yushu+str;
//       }
//     }
    
//     return str;
//   }
 
//   public static void main(String[] args) {
   
//     Change s1 = new Change();
    
//     Scanner scanner = new Scanner(System.in);
//     System.out.print("请输入目标进制：");
//     int jinzhi = scanner.nextInt();
//     System.out.print("请输入要转换的数字：");
//     int num = scanner.nextInt();
//     scanner.close();
    
//     System.out.println(s1.fun(jinzhi, num));
//   }
 
// }

import java.util.Scanner;
public class Change{
	public String fun1(int num){
		
		String str="";
		while (num!=0) {
			str=num %2+str;
			num/=2;
    	}
		return str;
	}

	//十六进制转换
	public String fun2(int num){
		String str="";
		while(num!=0){
			if(num%16>9){
				str=(char)(num%16-10+'A')+str;
			}
			else{
				str=num%16+str;
			}	
			num/=16;
		}
		return str;
	}
	public static void main(String[] args){
		Change s1 = new Change();
		

		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入要转换的数字：");
		int num = scanner.nextInt();
		scanner.close();
		System.out.print("二进制：");
		System.out.println(s1.fun1(num));
		System.out.print("十六进制：");
		System.out.println(s1.fun2(num));


		
	}
}