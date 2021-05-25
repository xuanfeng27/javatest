package com.test;

public class HelloWord {
    int a = 4;
    int b = 9;
    public static void main(String[] args){
        System.out.println("Hello World");
        for (String arg : args) {
            System.out.println(arg);
        }
        new HelloWord().hello();
    }
    void hello(){
        int c = a+b;
        System.out.println(c);
    }
}

/*
 junitTest
单元测试:
我们现在要想执行一个方法,只能从main方法中开始,有一定的弊端: 必须要创建对象才能调用非静态的方法.
使用 junittest 可以不通过 main 方法让我们的程序直接执行。
 右键 go to --->test
*/