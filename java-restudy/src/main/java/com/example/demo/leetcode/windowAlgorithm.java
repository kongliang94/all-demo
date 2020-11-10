package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class windowAlgorithm {

    public static void main(String[] args) {
        String s = "ABCBDEBCAD";
        String t = "BDE";
        System.out.println(slidingWindow(s,t));
        System.out.println(minWindow(s,t));
    }

    /* 滑动窗口算法框架 */
    public static String slidingWindow(String s, String t) {
        Map<Character, Integer> need=new HashMap<>();
        Map<Character, Integer> window=new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left = 0, right = 0;
        int valid = 0;
        int start=0,len=Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid==need.size()) {

                if (right-left<len){
                    start=left;
                    len=right-left;
                }

                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新

                if (need.containsKey(d)){
                    if (need.get(d).equals(window.get(d))){
                        valid--;
                    }

                    window.put(d,window.getOrDefault(d,0)-1);
                }

            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }

        public static String minWindow(String s, String t) {
            int left=0,right=0;
            int start=0,len=100000;
            Map<Character,Integer> need=new HashMap<>();
            Map<Character,Integer> window=new HashMap<>();
            // 将字串录入到map
            for(char c:t.toCharArray()){
                need.put(c,need.getOrDefault(c,0)+1);
            }

            int valid=0;

            while(right<s.length()){
                char c1=s.charAt(right);
                right++;

                if(need.containsKey(c1)){

                    window.put(c1,window.getOrDefault(c1,0)+1);

                    if(need.get(c1).equals(window.get(c1))){
                        valid++;
                    }
                }

                // 缩小窗口
                while(need.size()==valid){
                    if(right-left<len){
                        start=left;
                        len=right-left;
                    }
                    char c2=s.charAt(left);
                    left++;
                    if(need.containsKey(c2)){
                        if(need.get(c2).equals(window.get(c2))){
                            valid--;
                        }
                        window.put(c2,window.getOrDefault(c2,0)-1);

                    }

                }
            }

            return len==100000?"":s.substring(start,start+len);
        }
}
