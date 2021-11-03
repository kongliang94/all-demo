package com.example.demo.leetcode;

public class FindKSolution {

    /*
   题目:两个正序排序的数组，求合并后的第K个。(数组内元素没有重复数字; 数组没有 0，找不到第 K 个数可以返回 0)
   要求：不要申请额外的数组空间(List、Set、Map底层也是数组,不可使用)；

   示例 1：
   如果 K = 5
   >array1 = [1, 13, 16, 20]
   >array2 = [2, 8, 12, 27]
   >则第K个数是：13
*/


    public static void main(String[] args) {
        int[] nums1={1,3,12,15,20};
        int[] nums2={2,5,11,20};
        System.out.println(findK(nums1, nums2, 5));

    }


    public static int findK(int[] array1, int[] array2, int k) {

       int sum=1;
       int k1=0;
       int k2=0;
       int temp=0;
        while (sum<k&&(k1<array1.length&&k2<array2.length)){
            if (k1!=array1.length-1&&array1[k1]<=array2[k2]){
                if (array1[k1+1]>array2[k2]){
                    temp=array2[k2];
                }else {
                    temp=array1[k1+1];
                }
                k1++;
            }else if(k2!=array2.length-1){
                if (array1[k1]>array2[k2+1]){
                    temp=array2[k2+1];
                }else {
                    temp=array1[k1];
                }
                k2++;
            }
            sum=sum+1;
        }
        return temp;
    }

}
