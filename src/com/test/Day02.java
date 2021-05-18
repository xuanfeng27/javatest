package com.test;

/*
 * @ClassName: Day02
 * @Author: zll
 * @CreateTime: 2021/5/13 11:24
 * @Desc: java 程序---TODO
 * @Version: 1.0
 **/
//1.关键字  概念: 被java语言赋予特定含义的单词
/*
2. 标识符
概念: 给类,接口,方法,变量起名字的字符序列
组成规则:
英文字母的大小写
数字
$ _
注意事项:
不能以数字开头
不能是java中的关键字(包括保留字)
严格区分大小写(hello != Hello)

包: 包的本质是文件夹(方便管理,同名文件的问题)
域名反转,用.隔开
域名:www.alibaba.com
包名: com.alibaba.项目名.模块名

常量: java程序运行的过程中,其值保持不变的量:
所有的字母都大写,多个单词中间使用_ 隔开
public static final double PI = 3.14;
SECRET_KEY=”dfasjdfd*”
*/

/** 常量: 在程序运行的过程中,其值保持不变的量
 字面值常量:
 字符串常量: 用双引号括起来的内容
 整数常量: 所有的整数
 小数常量 : 所有的小数
 布尔常量: true false
 字符常量: 用单引号括起来的内容: 只能有一个字符(字母,数字,符号,中文) ','
 '3' ,'在' , ' ' 空常量: null
 自定义常量: final 修饰的变量
 */
//print 和 println 的区别:
//println : 打印完内容后会换行
//print: 打印内容后不换行
/*二进制:0,1,10,11,100,101,110,111,.... 0,1           0b
八进制:0,1,..7,10,...17,20,....77, 100..... 0-7     0
十进制:0,1…9,10,…19,20…99,100…. 0-9                 默认
十六进制:0,1,…9,a,b,c,d,e,f,10…. 0-9a-f             0x
0b10010101010
07332420
23462847823
0xabcdef4523
10进制转成其他进制
   结论: 转成几进制就除以几,直到商为 0,把余数反转

为了解决负数在计算机中的存储,就出现了 原码,反码,补码
原码: 用最高位代表符号, 正数的符号位是 0,负数的符号位是 1,其他位代表数值
都使用 8 位二进制来表示
7 的原码:  0 000 0111
-7 的原码: 1 000 0111
反码: 正数的反码就是原码, 负数的反码,符号位不变,其他为取反
7 的反码:  0 000 0111
-7 的反码: 1 111 100
补码: 正数的补码就是原码,负数的补码,在反码的基础上末位加 1
7 的补码: 0 000 0111
-7 的补码: 1 111 1001
*****计算机中最终存储的都是二进制的补码*****
*/
class ConstDemo{
    public static void main(String[] args){
        System.out.println("大数据");
        System.out.println(18);
        System.out.println(189.9);
        System.out.println(true);
        System.out.println('1');
    }
}

/*
* 变量的注意事项:
*1. 定义在方法中的变量叫做局部变量, 局部变量不赋初值不能使用
*2. 变量所在的大括号叫做变量的作用域,同一个作用域中不能存在多个名字相同的变量
*
* */



public class Day02 {
    public static void main(String[] args){
        System.out.println("Dayup");
    }
}

/*
* 数据类型：
*基本数据类型
四类八种
整数类: byte short int long
小数类: float double
字符类: char
布尔类: boolean
*
*引用数据类型: 除了基本数据类型以外的所有类型
类: String
接口
数组
类型 字节 位数 默认值 范围
byte  1    8    0    -128~127
short 2    16   0    -32768~32767 -2^15-- 2^15 -1
int   4    32   0    -2147483648~2147483647
long  8    64   0    -9223372036854775808~9223372036854775807
float 4    32   0.0  -3.4E38~3.4028235E38
double 8   64   0.0  -1.79E-308~1.7976931348623157E308
char  2    16   \u0000 0~65535
boolean 1  8    false true或 false
*整数的默认类型是 int, 小数的默认类型double
* 定义 long 类型的变量的时候,如果等号右边的值在 int 的范围之内,则可以直接赋值,如果等号右
边的数值超出 int 的范围,需要在数值的后面加上一个 L(l),推荐使用大写的
*
* */
class DataTypeDemo{
    public static void main(String[] args){
        byte a = 125;
        short b = 289;
        int c = 888;
        long d = 2147483649L;//过大的整数
        float e = 12.4F;
        double f = 23.45;
        char g = 'f';
        boolean h = false;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);

    }
}
/*
* 8种基本数据类型,都有各自对应的默认值:
byte,short,int ,long 默认值为 0
float double 默认值 0.0
char \u0000 (空格)
boolean false
只有定义在类中方法外的变量才有默认值
* 定义在方法中的变量是没有默认值的,要想使用,必须赋值
静态的方法中只能调用外部用 static 修饰的变量
*
* */
class TypeDemo {
    int a;
    static double b;
    static boolean bo;
    public static void main(String[]args){
        byte b1=3;
        System.out.println(b1);//没有初始化
       // System.out.println(a);//非static
        System.out.println(b);
    }
}
/*运算规则
* byte,short,char 不能直接做运算,要想做运算必须先转成 int
*默认转换:byte,short,char—int—long—float—double
* */
class DataTypeDemo3{
    public static void main(String[]args){
        byte a = 2,b=3,c;
        c = (byte) (a+b);
        System.out.println(c);
    }
}
/*
* char 类型代表的是字符.用单引号括起来,里面只能有一个字符:
char 占两个字节(0-65535),用的是 unicode
*char 类型直接打印,用的是他所代表的字符
char 类型参与运算,用的是他底层的编码
定义 char 类型:
char ch = ‘a’;
char ch1 = 98;
char ch2 = ‘\u0061’//a
char 类型的默认值其实就是编码是 0 的字符,表现形式是一个空格,也可以表示成'\u0000
*
* */
class DataTypeDemo4{
    public static void main(String[] args){
    //char: 如果直接打印,用的是他所代表的字符,一旦参与运算,使用编码来运算
        char a = '3';
        char ch = 'a';
        System.out.println(ch);//a
        System.out.println(ch+1);//98
        char ch2 =98;
        System.out.println(ch2);//b
        char ch3 = '\u0063';// 后面是 4 位的十六进制,99
        System.out.println(ch3);//c
        //char 默认值: 0 \u0000 表现形式是一个空格
        System.out.println('3'+4);//55
        System.out.println('3'+'4');//103
    }
}
//String 和任意类型做加法,得到的都是 String,值就是拼接后的结果
//布尔类型不能和其他的基本数据类型做运算
class DataTypeDemo5{
    public static void main(String[]args){
        int a = 10;
        System.out.println('a');
        System.out.println('a'+1);//98
        System.out.println("hello"+a+1);//helloa1
        System.out.println('a'+1+"hello");//98hello
        System.out.println(true +"1");//
    }
}
/*
* 6. 强制类型转换:
强制类型转换的格式:
目标类型 变量名 = (目标类型) 要转的值(常量或变量);
基本数据类型: 除了 boolean 类型以外,其他 7 中类型都可以 互相转换
一般是在把大类型转成小类型的时候用强转
引用数据类型: 必须具备子父类的关系 向下转
* */
class ForceTypeZH{
    public static void main(String[]args){
        int a = 10;
        long b = a;
        System.out.println(getType(b));

        long c =10;
        int d = (int) c;//强制转换
        System.out.println(d);

        byte by = (byte) 130;
        System.out.println(by);//-126
    }
    public static String getType(Object o){
        return o.getClass().toString();
    }
}
