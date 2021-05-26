package com.test;
import com.test.util.ArrayUtil;
import com.test.JavaseDay10;
import java.util.*;
/**
 * @ClassName: JavaseDay10TestHashMap
 * @Author: zll
 * @CreateTime: 2021/5/25 17:15
 * @Desc: java 程序
 * @Version: 1.0
 */

public class JavaseDay10TestHashMap {
    public static void main(String[] args){
        JavaseDay10 jd10 = new JavaseDay10();
        jd10.addTest();

        int[] arr =new int[] {1,3,4,2,8,5};
        ArrayUtil.reverseArray(arr);
    }
}

//Java 实例 - HashMap遍历  使用 Collection 类的 iterator() 方法来遍历集合
//https://www.runoob.com/java/java-hashmap.html
class HashMapTest {
    public static void main(String[] args) {
        HashMap< String, String> hMap =
                new HashMap< String, String>();
        hMap.put("1", "1st");
        hMap.put("2", "2nd");
        hMap.put("3", "3rd");
        System.out.println(hMap);
        System.out.println(hMap.size());
        System.out.println(hMap.get("3"));
        hMap.remove("3");
        System.out.println(hMap);
        //hMap.clear();
        //System.out.println(hMap);
        //可以使用 for-each 来迭代 HashMap 中的元素。
        //如果你只想获取 key，可以使用 keySet() 方法，然后可以通过 get(key) 获取对应的 value
        // 如果你只想获取 value，可以使用 values() 方法。
        for (String i : hMap.keySet()) {
            System.out.println("key: " + i + " value: " + hMap.get(i));
        }
        // 返回所有 value 值
        for(String value: hMap.values()) {
            // 输出每一个value
            System.out.print(value + ", ");
        }

        System.out.println("\n==============================");
        Collection cl = hMap.values();
        Iterator itr = cl.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}