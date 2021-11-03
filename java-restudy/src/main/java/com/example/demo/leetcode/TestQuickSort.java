package com.example.demo.leetcode;

import java.util.Arrays;

public class TestQuickSort {

    public static void main(String[] args) {
        int[] nums={3,2,1,3,4};

        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums,int start,int end){
        if(start<end){
            int key=nums[start];
            int i=start;
            int j=end;
            int temp;

            do{
                while (nums[i]<key&&i<end){
                    i++;
                }
                while (nums[j]>key&&j>start){
                    j--;
                }

                if (i<=j){
                    temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    i++;
                    j--;
                }
            } while (i<=j);

            if (start<j){
                quickSort(nums,start,j);
            }
            if (i<end){
                quickSort(nums,i,end);
            }
        }
    }
}
