package com.test.util;
import java.util.Arrays;

/**
 * @ClassName: ArrayUtil
 * @Author: zll
 * @CreateTime: 2021/5/19 11:23
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
工具类的封装
1. 在我们的项目中创建一个叫 util 的包
2. 在包下创建一个类:ArrayUtil
3. 在类中创建方法:
4.调用
*/

public class ArrayUtil {
    //调用测试
    public static void printArr(int[] arr){
        System.out.println(arr.length);//6
        System.out.println(Arrays.toString(arr));//[2, 3, 7, 4, 6, 1]
        System.out.println(arr);//[I@4554617c
    }

    //逆序
    public static void reverseArray(int[] arr){
        int temp = 0;
        for (int i = 0;i<arr.length/2;i++){
            temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

}
