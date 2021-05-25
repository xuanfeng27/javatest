package com.test;
//Java 中带包（创建及引用）的类的编译与调试 https://www.runoob.com/w3cnote/java-compile-with-package.html
/*
带包编译:
编译命令: javac(空格) -d 空格.空格 文件名.java
运行命令: java 包名.类
原因是我们在 JavaseDay10.java 中有包声明，当执行 JavaseDay10.java 源文件时, java 虚拟机首先会在 JavaseDay10.java 当前目录
寻找字节码文件，虽然这下找到了，但是因为在 JavaseDay10.java 中有包声明，java 虚拟机紧接着去包目录下寻找有没有 JavaseDay10.class
字节码文件，这下找到了才能够成功执行，（这里我再教教大家怎么编译有包声明的 JavaseDay10.java，也就是打包编译
D:\zll\develop-tools\JetBrains\IdeaProjects\Template\javatest\src\com\test>javac -d . JavaseDay10.java
D:\zll\develop-tools\JetBrains\IdeaProjects\Template\javatest\src\com\test>java com.test.JavaseDay10
javac -d . *.java 指令可以给当前目录下的所有 java 文件打包
JavaseDay10Test导入包   import com.test.JavaseDay10;

总结一下
1、Java 命令的参数是"类的完整类名"，而不是"文件名"。
2、打包编译时，会自动创建包目录，不需要自己新建包名文件夹。
3、当当前目录有多个 java 文件需要编译或打包编译时，javac -d . *.java 指令进行编译或打包编译。
4、当类路径不在当前目录下时，需要用到 java -cp ...，
如：java -cp D:\zll\develop-tools\JetBrains\IdeaProjects\Template\javatest\src\com\test com.test.JavaseDay10
5、要清楚 java 虚拟机根据包声明包导入执行字节码文件的流程。
*/
/*
权限修饰符
             public     protected    (default)      private
本类中          1          1            1               1
本包中          1          1            1
不同包子类      1          1
不同包其他类    1

protected: 修饰方法和变量
可以在不同包的子类中访问, 可以使用 super 关键字,创建子类的对象访问(创建父类的对象无法访问)
修饰外部类的修饰符:
public (default) final abstract
* */
/*
2. 内部类
定义: 定义在类内部的类

2.1.成员内部类
1. 无限制的访问外部类中的成员,包括静态成员和私有成员
2. 成员内部类中不能定义静态成员
3. 如何创建内部类的对象:
外部类名.内部类名 对象名 = new 外部类名().new 内部类名();
4. 如何在内部类中访问外部类中同名的成员
外部类名.this.成员

2.2.局部内部类
局部内部类: 定义在方法中或者是代码块中的类
1. 局部内部类只能在方法中被认识
2. 局部内部类不能使用 public private protected 修饰符修饰

2.3.静态内部类
静态内部类: 用 static 修饰的内部类
1. 静态内部类中即可以定义静态成员,也可以定义非静态的成员
2. 有静态成员(变量和方法)的内部类,一定是静态内部类
3. 如何访问静态内部类中的成员
静态成员: 外部类名.内部类名.静态成员
非静态的成员: new 外部类名.内部类名().非静态成员

2.4.匿名内部类
匿名对象: new 类名().成员;
匿名内部类:
本质: 实现接口或者继承了(抽象)类的子类 对象
格式:
new 接口/类(){
重写或实现的方法
}
要求: 见到接口或者类就能写出匿名内部类

*/

interface InterAni{
    public void test();
}

class OutClass{
    int a =3;
    int c = 90;
    static boolean b = true;
    private String name = "张";


    int show(){
        System.out.println(a+"out show()");
        return a;
    }

    // 成员内部类
    class InnerClass{
        int a = 2;
        //static int d = 100;不允许
        int d = 100;

        void show(){
            System.out.println(a+"inner show()");//2inner show()
            System.out.println(OutClass.this.a);//3
            OutClass.this.show();//3out show()
            System.out.println(c);//90
            System.out.println(name);//张
            System.out.println(b);//true
            System.out.println(InnerClass.this.equals(this));//true
        }
    }

    //局部内部类
    public void innerJu(){
        String sr  = "局部内部类";
        class InnerJuBu{
            void innerIn(){
                System.out.println(sr+"InnerJuBu");
            }
        }
        new InnerJuBu().innerIn();
    }

    //静态内部类
    static class InnerStatic{
        static int a = 55;
        int b = 33;
         void innerSt(){
             System.out.println(a+"InnerStatic");
             System.out.println(OutClass.b);
        }
    }

    //匿名内部类
    public static void noNameInterAni(String name){
        //InterA a = new ClassA();//正常写法.必须得写一个子类,很麻烦,可以使用匿名内部类:

        //匿名内部类写法1:用变量接收,再调用方法
        InterAni b = new InterAni() {
            @Override
            public void test() {
                System.out.println(name+"没有比人更高的山,没有比脚更长的路!!!");
            }
        };
        b.test();

        //匿名内部类写法2:不用变量，直接在后面调用
        new InterAni() {
            @Override
            public void test() {
                System.out.println(name+"没有比人更高的山,没有比脚更长的路!!!");
            }
        }.test();
    }
}

public class JavaseDay10 {
    int a = 1;
    String b = "zll";

    public static void main(String[]args){
        JavaseDay10 jd = new JavaseDay10();
        jd.addTest();

        //成员内部类调用
        OutClass.InnerClass inner = new OutClass().new InnerClass();
        inner.show();

        //局部内部类调用
        new OutClass().innerJu();

        //静态内部类
        System.out.println(OutClass.InnerStatic.a);//静态成员: 外部类名.内部类名.静态成员
        System.out.println(new OutClass.InnerStatic().b);//new 外部类名.内部类名().非静态成员
        new OutClass.InnerStatic().innerSt();

        //匿名内部类
        OutClass.noNameInterAni("static");
        //new OutClass().noNameInterAni("非static");
    }

    public void addTest(){
        System.out.println(b+a);
    }
}



/**
 * @ClassName: JavaseDay10
 * @Author: zll
 * @CreateTime: 2021/5/25 16:50
 * @Desc: java 程序
 * @Version: 1.0
 */