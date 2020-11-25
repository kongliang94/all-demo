package com.example.demo.leetcode.dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintAllSubsquences {

    public static List<String> subs(String s){
        char[] str=s.toCharArray();
        String path="";
        List<String> ans=new ArrayList<>();
        process1(str,0,ans,path);
        return ans;
    }

    /**
     * 暴力递归决策树
     * @param str 固定不变的字符串
     * @param index 此时来到的位置，要 or 不要
     * @param ans 答案
     * @param path 之前做出的选择就是path
     */
    public static void process1(char[] str,int index,List<String> ans,String path){
        if (index==str.length){
            ans.add(path);
            return;
        }
        // 不要这个数据，相当于跳过
        String no=path;
        process1(str,index+1,ans,no);

         // 要这个数据，把他添加到path中
        String yes=path+String.valueOf(str[index]);
        process1(str,index+1,ans,yes);
    }



    public static List<String> subsNoRepeat(String s){
        char[] str=s.toCharArray();
        String path="";
        Set<String> set=new HashSet<>();
        List<String> ans=new ArrayList<>();
        process2(str,0,set,path);
        for (String s1 : set) {
            ans.add(s1);
        }
        return ans;
    }

    /**
     * 暴力递归决策树
     * @param str 固定不变的字符串
     * @param index 此时来到的位置，要 or 不要
     * @param ans 答案
     * @param path 之前做出的选择就是path
     */
    public static void process2(char[] str, int index, Set<String> ans, String path){
        if (index==str.length){
            ans.add(path);
            return;
        }
        // 不要这个数据，相当于跳过
        String no=path;
        process2(str,index+1,ans,no);

        // 要这个数据，把他添加到path中
        String yes=path+String.valueOf(str[index]);
        process2(str,index+1,ans,yes);
    }
}
