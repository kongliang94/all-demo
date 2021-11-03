package com.example.demo.leetcode.arrays;

import sun.management.Sensor;

import java.awt.image.PixelInterleavedSampleModel;
import java.util.*;

public class XiaomiTest {

    /**
     * 题意：0，1，2分别代表红，白，蓝，然后把数组按照这个顺序排序，最简单的是遍历两次，一次左边排红色，一次右边排蓝色，但是要求一次遍历。
     * 可以遍历一次数组，维护两个下标，一个从左边记录0的位置，一个右边记录2的位置
     */
    public static void sortColors(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int i = 0;
        while (i <= right) {
            if (A[i] == 0) {
                swap(A, i, left);
                i++;
                left++;
            } else if (A[i] == 2) {
                swap(A, i, right);
                right--;
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    public static void findSecondMax(int[] nums) {
        int secondMax = Integer.MIN_VALUE;
        int firstMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstMax) {
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        System.out.println(secondMax);
    }

    public static int maxDifference(int[] nums) {

        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int minValue = nums[0];
        int maxValue = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {

            if (nums[i] < minValue) {
                minValue = nums[i];
            }
            if (nums[i] - minValue > maxValue) {
                maxValue = nums[i] - minValue;
            }

        }
        return maxValue;
    }


    public static List<List<Integer>> threeSum0(int[] nums){

        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);

        List<Integer> list;
        // 尝试双指针
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int count = 0 - nums[i];
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                if (nums[left]+nums[right]==count){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    // 注意去重逻辑
                    while (left < right && nums[left] == nums[left + 1]) { left++;}
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }else if(nums[left]+nums[right]<count){
                    left++;
                }else if(nums[left]+nums[right]>count){
                    right--;
                }

            }
        }

        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums){

        List<List<Integer>> result=new ArrayList<>();
        //Arrays.sort(nums);

        List<Integer> list;
        // 尝试双指针
        for (int i = 0; i < nums.length; i++) {
            int target=0-nums[i];
            int[] twoSum=twoSum(nums,target,i);
            if (twoSum.length>0) {
                list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[twoSum[0]]);
                list.add(nums[twoSum[1]]);
                result.add(list);
            }
        }

        return result;
    }

    public static int[] twoSum(int[] nums,int target,int start){

        Map<Integer,Integer> map=new HashMap<>();

        for (int i = start; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                // 找到了2个数
                Integer j = map.get(target - nums[i]);
                return new int[]{j,i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }


    public static void main(String[] args) {
        int[] nums={2,2,2,0,1,1,0};
        int[] nums1={21,22,20,2,10,11,0};
        int[] nums2={2,2,3,6,8,3,2,1};
        int[] nums3={-1,-2,3,0,8,-6,-2,1};
        //sortColors(nums);
        //System.out.println(Arrays.toString(nums));
        //findSecondMax(nums2);
        //System.out.println(maxDifference(nums2));
        for (List<Integer> list : threeSum0(nums3)) {
            System.out.println(list.toString());
        }
    }

}
