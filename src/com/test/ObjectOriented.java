package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ObjectOriented
 * @Author: zll
 * @CreateTime: 2021/5/20 12:31
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
1. 面向对象
1.1.概述:
面向过程: C
面向对象: object-c Java C++ scala
OO: object – oriented 面向对象
1.2.三大特征
封装 继承 多态
1.3.类和的对象的关系
类: 一种 (引用)数据类型, 自定义的一种类型
对象: 具体存在的事物,符合类的定义特征
类的定义:
class 类名{
//属性,变量
//行为,方法
}
如何创建对象:
类名 对象名 = new 类名();
给对象赋值:
对象名.属性 = 要赋的值;

1.4.内存分析
栈(stack): 方法的执行, 局部变量, 没有初始值
堆: new出来的东西 有初始值,基本数据类型初始值就是默认值,引用数据类型初始值为null
方法区:
class 区: 所有字节码文件(.class 文件),类加载的时候会把相关字节码文件加载到 class区中,
同时把用 static 修饰的东西存入到静态区。
static 区: 用 static 修饰的东西

1.5.成员变量和局部变量的区别
成员变量: 定义在类中方法外的变量,没有 static 修饰;存放在堆内存中,有初始值;随着对象的
产生而产生,随着对象的消失而消失
局部变量: 定义在方法中或者是方法的参数列表上的变量;存放在栈内存中,没有初始值;随
着方法的调用而产生,随着方法的结束而消失

1.6.匿名对象
匿名对象: 没有名字的对象
Teacher t = new Teacher();//这是有名字的对象,对象名叫 t
new Teacher();// 这就叫匿名对象


1.8.形参和实参
形参: 定义方法时方法参数列表上的变量
实参: 调用方法时传进去的具体值
**********基本数据类型做参数形参的改变不影响实参的值************
**********引用数据类型做参数,形参的改变影响实参的值(String 和包装类除外)***********
什么是包装类
所谓包装类，就是能够直接将简单类型的变量表示为一个类，在执行变量类型的相互转换时，我们会大量使用这些包装类。
基本类型    包装类:
byte        Byte
short       Short
int         Integer
long        Long
float       Float
double      Double
char        Character
boolean     Boolean

基本类型与包装类型的区别1、在Java中，一切皆对象，但八大基本类型却不是对象。
2、声明方式的不同，基本类型无需通过new关键字来创建，而封装类型需new关键字。
3、存储方式及位置的不同，基本类型是直接存储变量的值保存在堆栈中能高效的存取，封装类型需要通过引用指向实例，具体的实例保存在堆中。
4、初始值的不同，封装类型的初始值为null，基本类型的的初始值视具体的类型而定，比如int类型的初始值为0，boolean类型为false；
5、使用方式的不同，比如与集合类合作使用时只能使用包装类型。
6、什么时候该用包装类，什么时候用基本类型，看基本的业务来定：这个字段允允许null值，就需要使用包装类型，如果不允许null值，
使用基本类型就可以了，用到比如泛型和反射调用函数，就需要用包装类！

所以最基本的一点区别是：Ingeter是int的包装类，int的初值为0，Ingeter的初值为null。除此之外还有区别，请看代码：
*/
class TestInteger {
    public static void main(String[] args) {
        int i = 128;
        Integer i2 = 128;
        Integer i3 = new Integer(128);
        System.out.println(i == i2); //Integer会自动拆箱为int，所以为true
        System.out.println(i == i3); //true，理由同上
        Integer i4 = 127;//编译时被翻译成：Integer i4 = Integer.valueOf(127);
        Integer i5 = 127;
        System.out.println(i4 == i5);//true
        Integer i6 = 128;
        Integer i7 = 128;
        System.out.println(i6 == i7);//false
        Integer i8 = new Integer(127);
        System.out.println(i5 == i8); //false
        Integer i9 = new Integer(128);
        Integer i10 = new Integer(123);
        System.out.println(i9 == i10);  //false
    }
}

/*1.9.封装
 封装概述：
 是指隐藏对象的属性和实现细节，仅对外提供公共访问方式。
 好处：
 隐藏实现细节，提供公共的访问方式
 提高了代码的复用性
 提高安全性

实现封装的步骤:
成员变量私有化:用 private 修饰成员变量
权限修饰符:
public: 修饰类,方法,变量;可在本项目中访问,跨包需要导包
(default): 修饰类,方法,变量 ,什么都不加, 只能在本包中访问
private: 修饰方法,变量;被 private 修饰的方法和变量只能在本类中访问
提供 get 和 set
this 用法: 当局部变量和成员变量重名是,使用 this 加以区分,this 指代的是成员变量
*/
//实现封装的步骤:
// 定义Person类
class Person {
    //属性 变量
    private int age;
    private String name;
    //方法
    public void setPerson(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
//主类
public class ObjectOriented {

    public static void main(String[] args) {
        //创建对象并赋值
        Person p1 = new Person();// 如果不在类中创建构造方法,那么系统会为我们自动生成无参数的构造方法
        p1.setPerson(18, "Tom");
        Person p2 = new Person();
        p2.setPerson(5, "Jarry");
        Person p3 = new Person();
        p3.setPerson(26, "Kitty");

        //对象数组 动态初始化
        Person[] pers = new Person[3];
        //实例化
        pers[0] = p1;
        pers[1] = p2;
        pers[2] = p3;

        //对象数组 静态初始化
        Person[] pers1 = new Person[]{p1,p2,p3};

        //ArrayList
        List<Person> list = new ArrayList<Person>();
        list.add(0, p1);
    }
}

/***********构造方法 *********
构造方法,也叫构造器(Constructor), 是类中比较特殊的一种方法.
 修饰符 类名(参数列表){方法体;}
 注意事项:
 1. 方法名和类名相同
 2. 没有返回值,连 void 都没有
 3. 构造方法是可以重载的
 构造方法何时被调用?
 使用 new 关键字创建对象的时候,就是在调用构造方法
 如果要调用其他的构造方法,只需要在 new 后面的括号中,传入参数
 如果我们不在类中创建构造方法,那么系统会为我们自动生成无参数的构造方法
 如果我们在类中自己写了构造方法,那么系统则不再为我们生成
*/
 /*构造方法 如下：
//定义Person类
class Person {
    //变量
    public int age;
    public String name;
    //方法
    public Person(int age, String name) {//注意事项:1. 方法名和类名相同2. 没有返回值,连 void 都没有3. 构造方法是可以重载的
        this.age = age;
        this.name = name;
    }
    public int getAge() {
        return age;
    }
     public void setAge(int age) {
        this.age = age;
     }
}
//主类
public class ObjectOriented {
    public static void main(String[] args) {
        //创建对象并赋值
        Person p1 = new Person(18, "Tom");
        int age = p1.getAge();
        p1.setAge(12);
        Person p2 = new Person(5, "Jarry");
        Person p3 = new Person(26, "Kitty");

        //对象数组 动态初始化
        Person[] pers = new Person[3];
        //实例化
        pers[0] = p1;
        pers[1] = p2;
        pers[2] = p3;

        //对象数组 静态初始化
        Person[] pers1 = new Person[]{p1,p2,p3};
    }
}
*/
/*
1.11. 六大组件
成员变量
静态变量
局部变量
成员方法
静态方法
构造方法
1.12. 给对象赋值的方式 三种:
    1.对象名.属性名 = 要赋的值
        Person t = new Person();
        t.name = "zhang san";
    2.使用 set 方法:
        t.setName("李四");
    3. 使用构造方法
        Person t = new Person(23,"赵")
*/
//作业:使用构造方法
class ZuoYe {
    public int a;
    public int b;

    public ZuoYe(int a,int b){
        this.a = a;
        this.b = b;
    }
    public int getSum(){
        return a+b;
    }
    public void setSum(int a){
        this.a = a;
    }
}
class Test {
    public static void main(String[]args){
        ZuoYe z1 = new ZuoYe(12,3);
        int sum = z1.getSum();
        System.out.println(sum);
        z1.setSum(5);
        sum = z1.getSum();
        System.out.println(sum);
    }
}