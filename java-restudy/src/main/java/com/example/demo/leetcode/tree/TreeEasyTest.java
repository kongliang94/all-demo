package com.example.demo.leetcode.tree;

import javax.print.attribute.standard.NumberUp;
import java.util.LinkedList;
import java.util.Queue;

public class TreeEasyTest {

    public static int max=0;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode.left=treeNode2;
        treeNode.right=treeNode3;
        treeNode3.right=treeNode4;
        findMaxPath(treeNode);
        System.out.println(max);
    }

    public static int findMaxPath(TreeNode node){
        if(node.left==null&&node.right==null){
            return 0;
        }

        int leftMax=node.left==null?0:findMaxPath(node.left)+1;
        int rightMax=node.right==null?0:findMaxPath(node.right)+1;

        max=Math.max(max,leftMax+rightMax);

        return leftMax>rightMax?leftMax:rightMax;

    }

    /**
     * 序列化一棵树
     */
    static String LEAF="#";
    static String SEP=",";
    public static String serialise(TreeNode root){
        StringBuilder sb=new StringBuilder();
        serialise(root,sb);
        return sb.toString();
    }

    public static void serialise(TreeNode root,StringBuilder sb){
        if (root==null){
            sb.append(LEAF).append(SEP);
        }

        sb.append(root.value).append(SEP);
        serialise(root.left,sb);
        serialise(root.right,sb);
    }


    public static TreeNode buildByPreStr(String str) {
        if (str == null||str=="") {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();

        for (String s : str.split(SEP)) {
            linkedList.add(s);
        }
        return prebStr(linkedList);
    }

    public static TreeNode prebStr(LinkedList<String> list){
        String poll = list.removeFirst();
        if (poll=="#"){
            return null;
        }
        TreeNode node=new TreeNode(Integer.valueOf(poll));
        node.left=prebStr(list);
        node.right=prebStr(list);

        return node;
    }



    public static Queue<String> preSerial(TreeNode head) {
        Queue<String> ans = new LinkedList<>();
        pres(head, ans);
        return ans;
    }

    public static void pres(TreeNode root,Queue<String> ans){
        if (root==null){
            ans.add(null);
        }
        ans.add(String.valueOf(root.value));
        pres(root.left,ans);
        pres(root.right,ans);
    }

    /**
     * 反序列化
     */
    public static TreeNode buildByPreQueue(Queue<String> prelist) {
        if (prelist == null || prelist.size() == 0) {
            return null;
        }
        return preb(prelist);
    }


    public static TreeNode preb(Queue<String> ans){

        String poll = ans.poll();
        if (poll==null){
            return null;
        }
        TreeNode node=new TreeNode(Integer.valueOf(poll));
        node.left=preb(ans);
        node.right=preb(ans);

        return node;
    }

}
