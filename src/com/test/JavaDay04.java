package com.test;

import java.util.Scanner;

/**
 * @ClassName: JavaDay04
 * @Author: zll
 * @CreateTime: 2021/5/16 10:10
 * @Desc: java 程序---TODO
 * @Version: 1.0
 */
//流程控制结构
/*
1. 顺序结构
代码从上往下依次执行
2. 选择结构
选择结构会根据执行的结果选择不同的代码执行
两种形式:
if 语句
switch 语句
*/
/*
2.2. switch 语句
格式:
switch(表达式) {
case 常量值 1：
语句体 1;
break;
case 常量值 2：
语句体 2;
break; …
default：
语句体 n+1;
break;
}
*/

/*
3. 循环结构
让一段代码反复执行很多次
3.1.for 循环
语法格式:
for(初始化语句;判断条件语句;控制条件语句) {
循环体语句体;
}

3.2.while 循环
格式:
初始化语句;
while(判断条件语句) {
循环体语句体;
控制条件语句;
}
*/
public class JavaDay04 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个整数");
        int a = sc.nextInt();
        System.out.println("请输入第二个整数");
        int b = sc.nextInt();
        if(a == b){
            System.out.println(1);
        }else {
            System.out.println(0);
        }

        System.out.println("请输入一个整数");
        int day = sc.nextInt();
        switch (day) {
            case 1:
                System.out.println("周一");
                break;
           /* case 1 -> System.out.println("周一");
            case 2 -> System.out.println("周二");
            case 3 -> System.out.println("周三");
            case 4 -> System.out.println("周四");
            case 5 -> System.out.println("周五");
            default -> System.out.println(0);*/
        }

        //打印1-10
        for(int i=1;i<=10;i++) {
            System.out.println(i);
        }

        //1-10之和
        int sum = 0;
        int j=1;
        while(j<=10) {
            sum += j;
            j++;
        }
        System.out.println(sum);//55

    }
}
//两种循环对比:
//for 循环适合针对一个范围判断进行操作
//while 循环适合不知道循环的次数,或者要求循环的次数