package com.example.demo.leetcode.arrays;


public class ArrayTest {


    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,5,5,5,5,5,6,7,7,8,8,8,1};
        int[] nums3={9,9,9,9,9,9};
        int[] nums1={1,2,3,3,3,3,3,3,3,9,9,9,6,0};
        int[] nums2={1,3,3,3,4,5,6,7,8,8,8,8,8,9,10,10,11,11,12,23,33,33,10,2,2,2,2,2,2,2,2,2,1,1};
        maxArrays(nums3);

    }


    public static void maxArrays(int[] nums){

        int left=0;
        int right=nums.length-1;

        int temp=0;
        while(left<right){
            int mid=left+(right-left)/2;

            if(nums[mid]>nums[mid+1]){
                right=mid;
            }else if(nums[mid]>nums[mid-1]){
                left=mid+1;
            }else if(nums[mid]==nums[mid-1]||nums[mid]==nums[mid+1]){
                if (nums[mid]>temp){
                    left=mid+1;
                }else{
                    right=mid;
                }
            }
            temp=nums[mid];
        }

        int sum=1;
        int temp1=right;
        int temp2=right;

        while((temp1-1>=0||temp2+1<nums.length)&&(nums[temp1]==nums[temp1-1]||nums[temp2]==nums[temp2+1])){
            if(temp1-1>=0&&nums[temp1]==nums[temp1-1]){
                sum++;
                temp1--;
            }
            if(temp2+1<nums.length&&nums[temp2]==nums[temp2+1]){
                sum++;
                temp2++;
            }
        }

        System.out.println("最大数："+nums[right]+" 个数："+sum);
    }


    /**
     * 双指针删除数组元素
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums,int val){
        int fast=0;
        int slow=0;
        while (fast< nums.length){

            // 没找到val
            if (nums[fast]!=val){
                nums[slow]=nums[fast];
                // 慢指针++
                slow++;
            }

            fast++;
        }

        return slow;

    }

    /**
     * 删除有序数组中的重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int front = 1;
        int after = 1;

        for (;front<nums.length;front++){
            if (nums[front]!=nums[front-1]){
                nums[after]=nums[front];
                after++;
            }
        }

        return after;
    }


    /**
     *  长度最小的子数组
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        //起、止指针
        int start = 0, end = 0;
        //总和
        int sum = 0;
        while (end < nums.length) {
            sum=sum+nums[end];
            end++;
            while (sum>=target&&start<end){
                int sub = start - end;
                result=result>sub?sub:result;
                sum=sum-nums[start];
                start++;
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }

    /**
     *  旋转数组求最小值
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int left=0;
        int right=numbers.length-1;

        while (left<right){
            int mid=left+(right-left)/2;

            // // 核心：寻找数组两段有序的分界点
            if (numbers[mid]<numbers[right]){
                // 说明后半段是从小到大，分界点在前段
                right=mid;
            }else if (numbers[mid]>numbers[left]){
                //前半段有序，分界点在后段
                left=mid+1;
            }else if (numbers[mid]==numbers[right]){
                right--;
            }
        }

        return numbers[right];
    }

    public static int maxArray(int[] numbers) {
        int left=0;
        int right=numbers.length-1;

        int sum=1;
        while (left<right){
            int mid=left+(right-left)/2;
            if (numbers[mid]>numbers[mid+1]){
                right=mid;
            }else if (numbers[mid]>numbers[mid-1]){
                left=mid+1;
            }else if (numbers[mid]==numbers[mid-1]||numbers[mid]==numbers[mid+1]){
                left=mid+1;
                right--;
            }
        }
        int temp1=right;
        int temp2=right;
            while ((temp1-1>=0&&temp2+1<=numbers.length-1)
                    &&(numbers[temp1] == numbers[temp1 - 1] || (numbers[temp2] == numbers[temp2 + 1]))) {
                if (numbers[temp1] == numbers[temp1 - 1]) {
                    sum++;
                    temp1--;
                }

                if (numbers[temp2] == numbers[temp2 + 1]) {
                    sum++;
                    temp2++;
                }
            }
        System.out.println("个数:"+sum+" 最大数:"+numbers[right]);
        return numbers[right];

    }
}
