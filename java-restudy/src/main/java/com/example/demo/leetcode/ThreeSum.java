package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arrs=new int[]{1,2,4,6,7,10};
        Arrays.stream(twosum(arrs,9)).forEach(System.out::println);

    }


    public static int[] twosum(int[] arrs,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arrs.length; i++) {
            // 注意arrs[i]和target-arrs[i]就是对应的结果，所以只需要求解
            if (map.containsKey(target-arrs[i])){
                return new int[]{target-arrs[i],arrs[i]};
            }
            map.put(arrs[i],i);
        }
        return new int[]{-1,-1};
    }
}
