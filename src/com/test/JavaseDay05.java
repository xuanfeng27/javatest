package com.test;
import java.util.Scanner;
/**
 * @ClassName: JavaseDay05
 * @Author: zll
 * @CreateTime: 2021/5/18 9:07
 * @Desc: java 程序---TODO
 * @Version: 1.0
 */
/*3.4.3.改写成字符串
字符串在比较内容的时候是不能使用 == != 的, 字符串在比较内容的时候,用的是 equals
用法: 字符串 a.equals(字符串 b); 如果内容相同 返回 true, 否则返回 false
在使用 equals 比较字符串内容的时候,要把已知存在的字符串放到前面
!"abc".equals(password)
*/
public class JavaseDay05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎来到贪吃蛇,还有5秒到达战场,请准备!");
        //分数
        int score = 0;
        System.out.println("请输入您的操作(1/0)");
        int oper = sc.nextInt();
        while(oper == 1) {
            // 操作:得分加10, 继续输入
            score += 10;
            System.out.println("请输入您的操作(1/0)");
            oper = sc.nextInt();//对oper重新赋值,(条件控制语句)
        }
        //代码如果能够执行到这里,说明循环已经结束了
        System.out.println("GAME OVER:您的分数为:"+score);//打印得分
    }
}


/**
 3.5.循环嵌套
 在循环中继续使用循环:
 案例: 请输出一个 4 行 5 列的星星(*)图案
 * 循环的嵌套:
 * 循环中还有循环 两层嵌套
 * 外层循环控制行
 * 内存循环控制列
 * 列不换行
 * 内层循环结束后,在换行
 */
class CircleQTDemo {
    public static void main(String[] args) {
        //请输出一个4行5列的星星(*)图案
        for(int i=1;i<=4;i++) {
            for(int j=1;j<=5;j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}

/*4.4.方法的重载
概念:一个类中可以存在多个名字相同的方法,但是必须保证参数的个数或类型不同,与返回值无关*/

class OverLoadDemo {
    public static void main(String[] args) {
        System.out.println(getSum(34L,45));
        System.out.println(getSum(3, 4L));
        System.out.println();//println也是一个重载的方法
    }

    public static long getSum(long a, int b) {
        System.out.println(1);
        return a + b;
    }

    public static long getSum(int a, long b) {
        System.out.println(2);
        return a + b;
    }
}