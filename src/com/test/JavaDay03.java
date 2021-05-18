package com.test;
import java.util.Scanner;
/**
 * @ClassName: JavaDay03
 * @Author: zll
 * @CreateTime: 2021/5/14 13:08
 * @Desc: java 程序---TODO
 * @Version: 1.0
 */
/*
* 1. 运算符
1.1.算数运算符
1.1.1. 加减乘除运算
* 注意事项:
整数和整数相运算得到的还是整数,运算时从左往后,先算乘除后算加减,有括号先算括号
*

* */
public class JavaDay03 {
    public static void main(String[] args){
        int a = 9;
        int b = 2;
        System.out.println(a/b);//4 两个 int 相运算
        //如果想要得到 4.5 怎么办,必须让小数运算
        System.out.println(1.0*a/b);//4.5
        System.out.println(a/b*1.0);//4.0

        // 参与运算:
        //前加加: 先加 1 ,后运算
        //后加加: 先运算,后加
        int c = 10;
        int d = 10;
        int e = c++;
        System.out.println(e);//10
        System.out.println(c);//11

        int f = ++d;
        System.out.println(f);//11
        System.out.println(d);//11

        int g = 4;
        int h = (g++)+(++g)+(g*10); //70
        //把括号看成是一种运算4+6+60=70
        System.out.println(h);
    }
}
//1.2.赋值运算符
//+= -= *= /= %= 包含了一个默认的强制类型转换,尽量使用这样的写法
/*
1.3.关系运算符
关系运算符(也叫比较运算符),特点是返回的结果都是布尔类型的值,要么是 true,要么是 false == 判断两个数是否相等
!= 判断两个数是否不等
>
<
>=
<=
instanceof 判断对象是否属于类:
"hello" instanceof String  true
只能连接引用数据类型,不能用于基本数据类型
5 instanceof int 写法错误
*/

/*
* 1.4.逻辑运算符
1.4.1. 基本规则
逻辑运算符通常用来连接布尔类型的值;
& : AND(并且) 两个都是 true 结果才是 true
|: OR(或者) 只要有一个是 true,那么结果就是 true
^: XOR(异或) 不同为 true, 相同为 false true^true=false
! 非: (取反) !true = false
优先级: & 先于 ^ 先于 |
6>x>3 在 java 中不能这么写, 要写成 x>3 & x<6

1.4.2. 短路运算
短路运算符:
&: 两个都是 true 结果就是true
&& 前面为false，后面就不再运算了
& 和 && 最终运算出来结果一致
|: 只要有一个是 true,结果就是 true
*
1.4.3. 连接数字
& | ^ 除了可以连接布尔类型外,还可以用来连接整数,短路运算符不能连接数
字. 在连接数字的时候,是针对二进制进行运算的, 将连接的数字转成二进制的补码,逐
位进行运算, 把 0 当做 false ,把 1 当做 true
* */
class LogicOperatorDemo{
    public static void main(String[] args){
        System.out.println((4>3)&(2!=1)); // true: true&true
        System.out.println((4>3)^(2==1));// true true^false
        System.out.println((4<3)|(2!=1));//true false|true
        System.out.println((4>=3)^(2!=1)&(2!=1));//false true^true&true
        System.out.println(!(2!=1));//false

        int x = 3;int y =4;
        //System.out.println((x++ > 3) & (y++ > 4));//false
        //System.out.println(x);//4
        //System.out.println(y);//5
        System.out.println((x++ > 3) && (y++ > 4));//false
        System.out.println(x);//4
        System.out.println(y);//4

        System.out.println(16&4);//0
        /*
        00000000 00000000 00000000 00010000
        00000000 00000000 00000000 00000100
      $ 00000000 00000000 00000000 00000000  0
        *
        18|4
        00000000 00000000 00000000 00010010
        00000000 00000000 00000000 00000100
        00000000 00000000 00000000 00010110  22
        * */
    }
}

/*
1.6.三目运算符
也称之为 三元运算符
格式:
(关系表达式)?表达式 1：表达式 2；
 如果条件为 true，运算后的结果是表达式 1；
 如果条件为 false，运算后的结果是表达式2
* */
class ThreeEyesTest{
    public static void main(String[]args){
        float a = 12.3F;
        float b = 56;
        float min = a<b ? a:b;
        System.out.println(min);

        long b1 = 100;
        long b2 = 200L;
        String result = b1 == b2 ? "相等" : "不相等";
        System.out.println(result);//不相等
    }
}
//键盘录入
class ScannerDemo {
    public static void main(String[] args) {
        // 创建对象
        Scanner sc = new Scanner(System.in);
        // 使用对象获取键盘录入的信息
        System.out.println("请输入您的年龄");
        int age = sc.nextInt();//如果输入的类型不是 int,java.util.InputMismatchException
        System.out.println("请输入您的姓名");
        String name = sc.next();
        System.out.println("您好,"+name+",原来您的年龄是:"+age+",您好年轻啊");
    }
}