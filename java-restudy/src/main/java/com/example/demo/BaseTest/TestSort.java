package com.example.demo.BaseTest;

public class TestSort {
    public static void main(String[] args) {
        int[] nums={3,4,5,1,2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums){

        int high=nums.length-1;
        int min=nums[high];
        int low=0;

        while(low<high){
            int mid=(low+high)/2;
            if(nums[mid]==min){
                return min;
            }else if(nums[mid]>min){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return 0;
    }
}
