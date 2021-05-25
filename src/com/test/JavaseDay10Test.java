package com.test;
import com.test.util.ArrayUtil;
import com.test.JavaseDay10;
/**
 * @ClassName: JavaseDay10Test
 * @Author: zll
 * @CreateTime: 2021/5/25 17:15
 * @Desc: java 程序
 * @Version: 1.0
 */

public class JavaseDay10Test {
    public static void main(String[] args){
        JavaseDay10 jd10 = new JavaseDay10();
        jd10.addTest();

        int[] arr =new int[] {1,3,4,2,8,5};
        ArrayUtil.reverseArray(arr);
    }
}



