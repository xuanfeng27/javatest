package com.test;

/**
*@ClassName: JavaseDay08
*@Author: zll
*@CreateTime: 2021/5/22 15:48
*@Desc: java 程序
*@Version: 1.0
*/

/*javabean: 一个普通的类,就来描述事物的类,里面不包含任何的业务逻辑,只是用来存储数据
规范:
成员变量私有化
提供 get 和 set 方法
提供无参构造方法
提供有参的构造方法
自动生成 get 和 set 方法
快捷键：alt + insert
*/
/*
static 关键字
静态的方法中只能调用外部用 static 修饰的变量和方法,如果非要调用非静态的,需要创建对象.
原因是静态的变量或方法,最先加载到内存中,如果此时没有对象,那么成员变量还不存在,所以不能调用

* 静态代码块: static{} 随着类的加载而执行一次
* 构造代码块: {} 每创建一个对象,就会执行一次
* 局部代码块: 定义在方法中的一对大括号 ,局部代码块执行完毕后会立马被释放
* 静态代码块 先于 构造代码块 先于 构造方法

继承
格式:
class 子类名 extends 父类名{
}
被继承的类: 叫做父类,基类或超类
继承的类: 子类或派生类
5.2.注意事项
java 中的继承只支持单继承,不支持多继承(C++),支持多层继承
Object:(万类之祖) 如果一个类没有继承任何类,那么他默认继承自 Object
父类中的私有成员不能被继承

同一个包中不能定义名字相同的类一个文件中定义多个类(the class already define）

5.5. super 关键字
super:可以看做是父类中的一个引用,用于区分子类中和父类中同名的成员(成员变量,成
员方法),super 指代的是父类中的值
this: 可以看做是本类中的一个对象,用于区分同名的局部变量和成员变量,this 指代的是
成员变量
this 和 super 后面可以跟成员变量和成员方法
this.成员变量 super.成员变量
this.成员方法() super.成员方法()
调用构造方法:
this(参数);调用本类中的构造方法
super(); 调用父类中的构造方法
this 和 super 不能用于 static 方法

*/
public class JavaseDay08 {
    int a =5;//成员变量，存放堆内存中
    static int b = 0;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    //静态代码块先于构造代码块先于构造方法执行
    static {
        System.out.println("static is first!");
    }

    public JavaseDay08(int a) {
        this.a = a;
    }

    public JavaseDay08() {
    }

    public void show() {//成员方法
        System.out.println("[局部代码块]:我要这代码块有何用");
    }

    //main()
    public static void main(String[] args){
        //a = 1; 不是static
        b = 5;
        //先创建对象再使用
        JavaseDay08 J8 = new JavaseDay08();
        J8.show();
        J8.a=6;

        //继承
        Students st = new Students(21,"ssfs",67);
        st.gender = '4';
        st.height = 4.0;
        st.eat(0.8);
        st.setAge(14);

        //继承中构造方法的关系
        //子类中的构造方法默认会调用父类中无参数的构造方法
        //Personu pu = new Personu();
        //pu.eat(3.3);
        //SuperPerson
        //gender=9
        //Personu
        //3.3
        //8.2
        //4.2
    }
}
class SuperPerson{
    private int sp;
    double height = 4.2;

    public SuperPerson() {
        System.out.println("SuperPerson");
    }

    public SuperPerson(int sp, double height) {
        this.sp = sp;
        this.height = height;
        System.out.println("+++++++++++++++++++++++++++++++++++");
    }
}
//同一个包中不能定义名字相同的类,ObjectOriented.java中已经有Person类
class Personu extends SuperPerson{
    char gender;
    double height = 8.2;

    public Personu(char gender) {
        this.gender = gender;
        System.out.println("gender="+gender);
    }

    public Personu() {
        this('9');
        System.out.println("Personu");
    }

    public void eat(double height) {
        System.out.println(height);
        System.out.println(this.height);
        System.out.println(super.height);
    }

}

class Students extends Personu{
    private int age;
    private String name;
    private int score;

    public Students() {
        System.out.println("==================================");
    }

    public Students(int age, String name, int score) {
        this.age = age;
        this.name = name;
        this.score = score;
        System.out.println("-------------------------------");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    //重写
    public void eat(double height) {
        super.eat(1.1);//调用父类同名方法
        System.out.println("heightheightheightheight");
        System.out.println(height);
    }
}
/*
重写(override): 子类中出现了和父类中 方法名一样,返回值类型一样,参数列表一样的方法,就叫做方法的重写
重载(overload): 一个类中可以存在多个名字相同的方法,但是必须保证参数的个数或类型不同,与返回值无关

6. final
final 可以用来修饰 类,方法,变量
final 修饰的类不能被继承
final 修饰的方法不能被重写
final 修饰的变量值不能改变, final 修饰的变量要有初始值
一般我们创建常量: public static final
final: 限制值不能变
*/
//单例设计模式: 让类只能产生一个对象
//菜鸟地址：https://www.runoob.com/design-pattern/singleton-pattern.html
class Singleton{
    private static Singleton s = new Singleton();
    //私有化构造器不允许自己创建对象
    private Singleton(){}
    public static Singleton getInstance(){
        return s;
    }
}
//什么是枚举类：
//在某些情况下，一个类的对象是有限且固定的，比如季节类，它只有4个对象；行星类只有8个对象，这种实例有限且固定的类，被称为枚举类
//Java5新增了一个关键字 enum （与 class关键字的地位相同），用于定义枚举类
enum Singleton1 {
    INSTANCE;
    public void whateverMethod() {
        System.out.println(" Singleton1");
    }
}