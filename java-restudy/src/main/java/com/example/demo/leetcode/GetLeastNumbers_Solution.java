package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers_Solution {

    /**
     * 用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。
     *     最大堆 时间复杂度O（nlogk）
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k){
        ArrayList<Integer> res = new ArrayList<>();
        //这里不要忘了判断 k>input.length
        if (input == null || input.length == 0 || k <= 0 || k > input.length) {
            return res;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);

        for (int i = 0; i < input.length; i++) {
            if (maxHeap.size()!=k){
                maxHeap.offer(input[i]);
            }else if(maxHeap.peek()>input[i]){
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }

        for (int num : maxHeap) {
            res.add(num);
        }
        return res;
    }

}
