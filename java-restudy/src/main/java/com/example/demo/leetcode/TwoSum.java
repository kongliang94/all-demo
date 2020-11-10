package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arrs=new int[]{1,2,4,6,7,10};
        Arrays.stream(twosum(arrs,9)).forEach(System.out::println);

    }

    /**
     *  使用map 将arr[i] 记录，利用map.containsKey() 来判断 
     * @param arrs
     * @param target
     * @return
     */
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

    /**
     *  左右指针 sum=arrs[left]+arrs[right]
     * @param arrs
     * @param target
     * @return
     */
    public static int[] twosum2(int[] arrs,int target){
        arrs= Arrays.stream(arrs).sorted().toArray();

        // 左右指针
        int lo = 0, hi = arrs.length - 1;
        while (lo < hi) {
            int sum = arrs[lo] + arrs[hi];
            // 根据 sum 和 target 的比较，移动左右指针
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else if (sum == target) {
                return new int[]{lo, hi};
            }
        }
        return new int[]{};
    }
}
