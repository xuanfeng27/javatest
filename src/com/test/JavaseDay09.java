package com.test;

/**
 * @ClassName: JavaseDay09
 * @Author: zll
 * @CreateTime: 2021/5/24 1:26
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
多态
0.1.前提:
1. 有继承关系
2. 父类的引用指向子类的对象
3. 有方法的重写
0.2.两种转型
向上转型: Shape sh = new Circle();
向下转型: Circle t = (Circle)sh;
0.3.调用关系:
同名成员变量: 父类的
同名静态方法: 父类的
同名静态变量 父类的
同名成员方法: 子类的
子类独有: 不能调用
父类独有: 父类的

虚函数
虚函数的存在是为了多态。
Java 中其实没有虚函数的概念，它的普通函数就相当于 C++ 的虚函数，动态绑定是Java的默认行为。
如果 Java 中不希望某个函数具有虚函数特性，可以加上 final关键字变成非虚函数。

1. 抽象类
用 abstract 修饰的类:
抽象方法格式:
abstract 修饰符 返回值类型 方法名(参数列表);
抽象类的定义格式abstract class 类名{}
2. 抽象类不能创建对象,需要使用子类向上转型
3. 抽象的子类要么实现抽象类中所有的抽象方法,要么自己是一个抽象类
4. 抽象类有构造方法,为了完成子类的初始化
5. abstract 不能和 final 共存,因为抽象类必须要被继承

2. 接口
定义格式:
interface 接口名{}
注意事项:
1. 接口中只能定义常量,默认 public static final 修饰
2. 接口中只能定义抽象方法(1.8 之前) 默认是 public abstract 修饰
3. 接口不能创建对象,使用子类向上转型
4. 接口的子类: 实现了接口的类
5. 接口的子类要么实现接口中所有的抽象方法要么自己是一个抽象类
6. 一个类可以实现多个接口,并且可以在继承类的同时实现多个接口
7. 接口中没有构造方法
8. jdk8 之后接口中可以定义已经实现的方法,但是必须使用 static/default 修饰
9. 接口不能实现接口,只能继承接口,并且可以多继承
class 子类名 implements 接口 1,接口 2{}


抽象类和接口的区别:
1.一个类最多只能继承一个抽象类,但是可以实现多个接口
2.抽象类中既可以定义变量也可以定义常量,接口中只能定义常量
3.抽象类中既可以定义抽象方法,也可以定义非抽象方法,接口中中能定义抽象方法(8 之前)
4.接口中没有构造方法,抽象类中有构造方法
接口只能继承接口不能实现接口,可以多继承
* */
public class JavaseDay09 {
    public static void main(String []args) {
        //向上转型 父类的引用指向子类的对象
        Shape sh = new Circle();
        System.out.println(sh.a);//3
        sh.sleep();//Shape.sleep()
        System.out.println(sh.age);//51
        sh.draw();//"Circle.draw()"
        //System.out.println(sh.c);不能调用
        System.out.println(sh.b);//Shape
        sh.eat();//eat.draw()
        //sh.eatCircle(); 不可以wrong

        System.out.println("================================");
        //向下转型
        Circle t = (Circle)sh;
        t.sleep();//Circle.sleep()
        System.out.println(t.age);//15
        t.draw();//Circle.draw()
        System.out.println(t.c);//Circle
        System.out.println(t.a);//1
        System.out.println(t.b);//Shape
        t.eat();//eat.draw()
        t.eatCircle();//eatCircle.draw()

        //abstract class
        System.out.println("*********************************");
        Square sq = new LittleSquare();
        sq.draw();
        sq.love();

        //接口
        System.out.println("((((((((()))))))))))))))))))))))");
        InterA intFaceA = new InterC();
        intFaceA.intera();
        //intFaceA.interb();不能调用
        ((InterC)intFaceA).interb();//向下转型


    }
}

class Shape {
    int a = 3;
    String b = "Shape";
    static int age =51;

    public Shape() {
    }

    void draw() {
        System.out.println("Shape.draw()");
    }
    void eat() {
        System.out.println("eat.draw()");
    }
    public static void sleep(){
        System.out.println("Shape.sleep()");
    }
}

class Circle extends Shape {
    int a = 1;
    String c = "Circle";
    static int age =15;

    public Circle() {
    }

    void draw() {
        //********调用被改写的parent中draw（）方法 输出“Shape.draw()”*************
        super.draw();
        System.out.println("Circle.draw()");
    }
    void eatCircle() {
        System.out.println("eatCircle.draw()");
    }
    public static void sleep(){
        System.out.println("Circle.sleep()");
    }
}

// 抽象类
abstract class Square {
    int a = 4;
    public Square() {
        System.out.println("Square");
    }
    abstract void draw();
    abstract void love();
}

class LittleSquare extends Square {
    public LittleSquare() { }
    @Override
    void draw() {
        System.out.println("LittleSquare.draw");
    }

    @Override
    void love() {
        a = 1;
        System.out.println(a);
    }
}

//接口
interface InterA{
    String a = "3";
    //default void intera();
    void intera();
}
interface InterB{
    void interb();
}
class InterC implements InterA,InterB{

    public InterC() {}

    @Override
    public void intera() {
        System.out.println(a+3);
    }

    @Override
    public void interb() {
        System.out.println(a+"interb");
    }
}