package com.example.demo.leetcode.tree;


import java.util.*;

/**
 * 分别用递归和非递归的方式实现二叉树先序、中序和后序遍历
 *  分析：
 *           先序：访问根节点、先序遍历左子树、先序遍历右子树
 *           中序：中序遍历左子树，访问根节点，中序遍历右子树
 *           后序：后序遍历左子树，后序遍历右子树，访问根节点
 *           因此，递归实现就很简单
 */
public class TreeOrder {

    public void preOrder(TreeNode root) {
        if (root==null) return;
        System.out.println(root.value);

        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root) {
        if (root==null) return;

        preOrder(root.left);
        System.out.println(root.value);
        preOrder(root.right);
    }
    public void postOrder(TreeNode root) {
        if (root==null) return;

        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.value);
    }

    // 用递归实现的都可以使用栈实现
//  先看先序遍历
//1、申请一个栈stack，将头结点压入stack中
//2、从stack中弹出头结点，记为cur，打印cur的值，再将cur的右孩子压入栈中，再将cur的左孩子压入栈中
//3、不断重复2，直到stack为空
    public void preNotCur(TreeNode root){
        if (root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack();

        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            System.out.println(node.value);
            if (node.left!=null){
                stack.push(node.left);
            }
            if (node.right!=null){
                stack.push(node.right);
            }
        }

    }

    public void inNotCur(TreeNode root){
        if (root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack();
        while (!stack.isEmpty()){
            // root不为空，入栈，root指向左子树，继续判断左子树是否为空，为空的话直接打印root节点，在接着root指向右子树，继续判断右子树是否为空
            if (root!=null){
                stack.push(root);
                root=root.left;
            }else {
                root=stack.pop();
                System.out.println(root.value);
                root=root.right;
            }
        }

    }

    // 后序遍历
//    1、申请两个栈，将头结点压入栈stack中弹出stack中的顶点压入stack1中，
//    2、若头结点有孩子节点，则压入stack中，直到无左右孩子，此时
//    3、弹出stack栈中的顶点压入stack1中，重复2
    public void postNotCur(TreeNode root){
        if (root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack();

        Stack<TreeNode> stack1=new Stack();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            stack1.push(node);
            if (node.left!=null){
                stack.push(node.left);
            }
            if (node.right!=null){
                stack.push(node.right);
            }

        }

        while(!stack1.isEmpty()){
            System.out.println(stack1.pop().value);
        }
    }


    // 前序遍历
    // 通过遍历控制每个节点的事件来
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result=new ArrayList<>();
        // 用来存储每个节点的事件，每个节点的访问事件包括3个子事件：访问左节点、访问右节点、操作当前节点（顺序可变动）
        Deque<Event> path=new ArrayDeque(); //Deque可作为队列或栈 这里用做栈，比stack更快
        TreeNode p = root;
        // 默认先访问root节点
        path.addFirst(new Event(0,p));
        while (!path.isEmpty()){
            // 获取栈顶事件，
            Event currentEvent=path.removeFirst();
            if (currentEvent.node==null) continue;

            if (currentEvent.type==1){
                //输出当前节点值
                result.add(currentEvent.node.value);

            }else {
                // 执行访问事件 添加3个子事件，访问左节点、访问右节点、操作当前节点
                path.addFirst(new Event(0,currentEvent.node.right));
                path.addFirst(new Event(0,currentEvent.node.left));
                path.addFirst(new Event(1,currentEvent.node));
            }
        }
        return result;
    }
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result=new ArrayList<>();
        // 用来存储每个节点的事件，每个节点的访问事件包括3个子事件：访问左节点、访问右节点、操作当前节点（顺序可变动）
        Deque<Event> path=new ArrayDeque(); //Deque可作为队列或栈 这里用做栈，比stack更快
        TreeNode p = root;
        // 默认先访问root节点
        path.addFirst(new Event(0,p));
        while (!path.isEmpty()){
            // 获取栈顶事件，
            Event currentEvent=path.removeFirst();
            if (currentEvent.node==null) continue;

            if (currentEvent.type==1){
                //输出当前节点值
                result.add(currentEvent.node.value);

            }else {
                // 执行访问事件 添加3个子事件，访问左节点、访问右节点、操作当前节点
                path.addFirst(new Event(0,currentEvent.node.right));
                path.addFirst(new Event(1,currentEvent.node));
                path.addFirst(new Event(0,currentEvent.node.left));

            }
        }
        return result;
    }
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result=new ArrayList<>();
        // 用来存储每个节点的事件，每个节点的访问事件包括3个子事件：访问左节点、访问右节点、操作当前节点（顺序可变动）
        Deque<Event> path=new ArrayDeque(); //Deque可作为队列或栈 这里用做栈，比stack更快
        TreeNode p = root;
        // 默认先访问root节点
        path.addFirst(new Event(0,p));
        while (!path.isEmpty()){
            // 获取栈顶事件，
            Event currentEvent=path.removeFirst();
            if (currentEvent.node==null) continue;

            if (currentEvent.type==1){
                //输出当前节点值
                result.add(currentEvent.node.value);

            }else {
                // 执行访问事件 添加3个子事件，访问左节点、访问右节点、操作当前节点
                path.addFirst(new Event(1,currentEvent.node));
                path.addFirst(new Event(0,currentEvent.node.right));
                path.addFirst(new Event(0,currentEvent.node.left));
            }
        }
        return result;
    }

    class Event{

        int type;// 0 访问 1打印
        TreeNode node;

        public Event(int type, TreeNode node) {
            this.type = type;
            this.node = node;
        }
    }

}
