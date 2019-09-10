package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 贪婪算法
 * @author: KL
 * @create: 2019-09-10
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {
        int[][] intervals={{1,2},{1,4},{3,4},{2,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    /**
     * 计算让一组区间不重叠所需要移除的区间个数。
     *
     * Input: [ [1,2], [1,2], [1,2] ]
     * Output: 2
     * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }
}
