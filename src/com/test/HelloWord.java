package com.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class HelloWord {
    int a = 4;
    int b = 9;
    public static void main(String[] args){
        System.out.println("Hello World");

       // System.out.println(3480/1000*1000);//3000

        // for (String arg : args) {
        //    System.out.println(arg);
      //  }
        new HelloWord().hello();
    }
    void hello(){
        String str = "[{'id':1,'name':'香蕉','price':8.0,'danwei':'公斤','quality':'A','number':5},{'id':2,'name':'苹果','price':6.5,'danwei':'公斤','quality':'B','number':3},{'id':3,'name':'橙子','price':9.0,'danwei':'公斤','quality':'A','number':4}]";
        double total = 0.0;
        JSONArray json = JSONArray.parseArray(str); // 首先把字符串转成 JSONArray  对象

        if(json.size()>0){
            for(int i=0;i<json.size();i++){
                JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                //System.out.println(job.get("id")) ;  // 得到 每个对象中的属性值
                Double price = Double.parseDouble( job.get("price").toString());
                Integer number = Integer.parseInt(job.get("number").toString()) ;
                double sum = price*number;
                total +=sum;
                String aa = job.get("id").toString() +"\t"+ job.get("name").toString()+"\t"+
                        job.get("price").toString()+"\t"+ job.get("danwei").toString()+"\t"+
                        job.get("quality").toString()+"\t"+ job.get("number").toString()+"\t"+ sum;
                System.out.println(aa) ;
            }
            System.out.println("一共是"+total) ;
        }


      //  int c = a+b;
      //  System.out.println(c);
    }



}

/*
 junitTest
单元测试:
我们现在要想执行一个方法,只能从main方法中开始,有一定的弊端: 必须要创建对象才能调用非静态的方法.
使用 junittest 可以不通过 main 方法让我们的程序直接执行。
 右键 go to --->test
*/