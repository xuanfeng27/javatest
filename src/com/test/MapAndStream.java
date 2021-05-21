package com.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ClassName: ForLoopOptimization
 * @Author: zll
 * @CreateTime: 2021/5/19 22:41
 * @Desc: java 程序
 * @Version: 1.0
 */



public class MapAndStream {
    public static void main(String[] args) {
        List<Map<String,Object>> list = new ArrayList<>();
        IntStream.range(1,5).forEach(e->{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("name","张三"+(e<3?e:e-1));
            map.put("score", (int)(Math.random()*100)+1);
            list.add(map);
        });
        System.out.println(list);

        //过滤分数大于60的元素
        List<Map<String, Object>> filterList =
            list.stream().filter(e -> (int) e.get("score") > 60)
            .collect(Collectors.toList());
        System.out.println(filterList);

        //分数排序
        List<Map<String, Object>> sortList =
            list.stream().sorted((v1, v2) -> {
            BigInteger b1 = new BigInteger(v1.get("score").toString());
            BigInteger b2 = new BigInteger(v2.get("score").toString());
            return b1.compareTo(b2);
        }).collect(Collectors.toList());

        System.out.println(sortList);
    }
}

