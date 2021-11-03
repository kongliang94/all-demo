package com.example.demo.leetcode;

import java.util.*;

public class BackTrackAlgorithm {

    static List<String> res=new LinkedList<>();

    /**
     *  全排列
     * @return
     */
    public static void printAllSq(int[] nums){
        permute(nums);
        for (String re : res) {
            System.out.println(re);
        }

    }

    public static List<String> permute(int[] nums){
        // 记录路径
        LinkedList<Integer> track=new LinkedList<>();
        backtrack(track,nums);
        return res;
    }

    public static void backtrack(LinkedList<Integer> track,int[] nums){
        if (track.size()==nums.length){
            // By using String Class
            String s = "";

            // using iterator for traversing a linkedllist
            Iterator<Integer> iterator = track.iterator();

            while (iterator.hasNext()) {
                // appending using "+" operator
                s = s + iterator.next() + " ";
            }
            res.add(s);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(track,nums);
            track.removeLast();
        }
    }

    public static void backtrack2(int[] nums,int i, ArrayList<String> res){
        if (i==nums.length){
            res.add(Arrays.toString(nums));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            swap(nums,i,j);
            backtrack2(nums,i+1,res);
            swap(nums,i,j);
        }
    }

    public static void swap(int[] chs, int i, int j) {
        int tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }



    //结果集合
    static List<List<Integer>> result;
    //符合条件的结果
    static LinkedList<Integer> path;

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合你可以按 任何顺序 返回答案。
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        path = new LinkedList<>();
        backtrack3(n, k, 1);
        return result;
    }

    public void backtrack3(int n,int k,int start){

        if (k==path.size()){
            result.add(path);
            return;
        }

        for (int i = start; i < n; i++) {
            path.add(i);
            backtrack3(n,k,i+1);
            path.removeLast();
        }
    }



    public static List<List<Integer>> findSubsequences(int[] nums) {
        result = new ArrayList<>();
        path = new LinkedList();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        backtrack(nums, 0);
        return result;
    }

    public static void backtrack(int[] nums, int start) {
        //使用map辅助去重
        Map<Integer, Integer> map = new HashMap<>();
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            //判断当前元素序列是否递增
            if (!path.isEmpty() && path.getLast() > nums[i]) {
                continue;
            }
            //本层循环元素已经用过，去重
            if (map.containsKey(nums[i])) {
                continue;
            }
            path.addLast(nums[i]);
            map.put(nums[i], i);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{4,4,3,2,1};
        ArrayList<String> res=new ArrayList<>();
        backtrack2(nums,0,res);
        for (String re : res) {
            System.out.println(re);
        }
        System.out.println("===============");

        //printAllSq(nums);
        findSubsequences(nums);

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
