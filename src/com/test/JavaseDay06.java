package com.test;
import com.test.util.ArrayUtil;

import java.util.Arrays;
import java.util.Random;
/**
 * @ClassName: JavaseDay06
 * @Author: zll
 * @CreateTime: 2021/5/18 16:26
 * @Desc: java 程序
 * @Version: 1.0
 */
//数组
/*
1. 数组的概述
概念:
用来存储一组相同数据类型的集合(或者叫容器)
注意事项:
1. 数组中的元素类型必须一致
2. 数组本身是引用数据类型,但是里面的元素既可以是基本数据类型,也可以是引
用数据类型
3. 数组的长度一旦给定无法改变
声明:
数据类型[] 数组名
数据类型 数组名[]
备注: main 方法中只有两个地方可以改变:
中括号的位置和 args的名字

2. 数组的初始化
2.1.动态初始化
给定数组的长度,有系统分配空间和初始值
格式:
数据类型[] 数组名 = new 数据类型[数组的长度];
 int[] arr = new int[4];
2.2.静态初始化
概念
给定数组中的元素,由系统分配长度并赋值. 格式:
数据类型[ ] 数组名 = new 数据类型[]{元素}
数组长度的获取: 数组名.length

3. 数组的内存分析
栈(stack):
局部变量和方法的执行. 没有初始值
print(arr)//  [I@4554617c
堆(heap):
new 出来的东西;
有初始值
基本数据类型: 默认值
引用数据类型: null
如果堆中内存没有栈中变量指向时,就会成为垃圾,等待 GC 自动回收

4. 数组常见异常
空指针异常:
产生的原因: 使用 null 调用堆中的内容,要注意的是,如果一个变量的初始值是 null, 直接打印是不报错的,只有调用他里面的东西才会报空指针
案例:
int [] arr = null;//有初始值,初始值为 null
System.out.println(arr); //null
System.out.println(arr[0]);// java.lang.NullPointerExceptio

数组角标越界异常:
产生的原因:数组的索引值超出的最大的范围,就会出现该异常
案例:
int[] arr = new int[3];// 索引值 0-2
System.out.println(arr[4]);// java.lang.ArrayIndexOutOfBoundsException

5.5.元素交换
int temp = arr[0];//第一个元素进空杯
arr[0] = arr[1];//第二个元素进第一个元素
arr[1] = temp;//空杯中倒入第二个

6. 多维数组
1 数据类型[][] 数组名 = new 数据类型[m][n];
m: 二维数组中一维数组的个数
n: 一维数组中元素的个数
2 数据类型[][] 数组名 = new 数据类型[m][];
m:二维数组中一维数组的个数
3. 数据类型[][] 数组名 = new 数据类型[][]{{元素值,元素值...},{元素值,元素值...},{元素值, 元素值,...}};
简写: = {{元素值,元素值...},{元素值,元素值...},{元素值,元素值,...}}
*/

class TwoDArrayDemo {
    public static void main(String[] args) {
        int[][] arr = new int[4][3];
        int[][] arr1 = new int[3][];

        arr1[0] = new int[]{1, 2, 3, 4, 5};
        arr1[1] = new int[]{1, 2};
        //arr1[2]= {3,4}; 给二维数组中一维数组赋值的时候,不能简写,会报错
        arr1[2] = new int[]{3, 4};

        int[][] arr2 = new int[][]{{1, 2}, {3, 4, 5, 6, 7}, {7, 8, 9, 9, 2}};

        System.out.println(arr2);// [[I@4554617c
        System.out.println(arr2[0]);// [I@74a14482
        System.out.println(arr2[2][3]);//9
        System.out.println(arr2.length);//3
        System.out.println(arr2[1].length);//5

        //遍历:
        for (int i = 0; i < arr2.length; i++) {
            int[] a = arr2[i];//二维数组中的每一个元素都是一维数组
            ArrayUtil.printArr(a);
        }
    }
}

public class JavaseDay06 {
    public static void main(String[]args){
        //逆序排列
        int[] arr_reverse = new int[]{1,2,3,4,5};
        ArrayUtil.reverseArray(arr_reverse);
        System.exit(0);//退出不再向下执行代码

        //调用方法
        int[] arrp = new int[]{2,3,7,4,6,1};
        ArrayUtil.printArr(arrp);


        // 生成随机索引
        Random r = new Random();
        int a = r.nextInt(20);//生成 [0-20) 之间的随机数
        System.out.println("随机数"+a);

        //空指针异常
        int[] arr6 = null;
        System.out.println(arr6);//null
        //System.out.println(arr6[2]);//java.lang.NullPointerExceptio

        //动态初始化
        int[] arr = new int[4];
        arr[0] = 100;
        System.out.println(arr);//[I@4554617c
        System.out.println(arr[0]);//100
        System.out.println(arr[2]);//0

        String[] arr1 = new String[4];
        //静态初始化
        int[] arr2 = new int[]{1,3,4,5,2};
        System.out.println(arr2.length);

        //浅拷贝
        arr = arr2;
        System.out.println(arr[0]);//1,
        arr[0] = 49;
        System.out.println("arr"+Arrays.toString(arr));//[49, 3, 4, 5, 2]
        System.out.println("arr2"+Arrays.toString(arr2));//[49, 3, 4, 5, 2]
        System.out.println("arr"+arr);//[I@677327b6
        System.out.println("arr2"+arr2);//[I@677327b6
        //深拷贝
        arr = arr2.clone();
        arr[0] = 79;
        System.out.println("arr"+Arrays.toString(arr));//[79, 3, 4, 5, 2]
        System.out.println("arr2"+Arrays.toString(arr2));//[49, 3, 4, 5, 2]
        System.out.println("arr"+arr);//[I@14ae5a5
        System.out.println("arr2"+arr2);//[I@677327b6

        char[] arr3 = new char[]{'多','快','好','省'};
        for(int i=0;i<arr3.length;i++){
            System.out.print(arr3[i]);
        }
    }
}
