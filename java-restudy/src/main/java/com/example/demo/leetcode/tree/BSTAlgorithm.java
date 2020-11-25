package com.example.demo.leetcode.tree;

/**
 *  汇集二叉搜索收的算法
 */
public class BSTAlgorithm {


    int rank=0;
    int res=0;
    // 获取二叉搜索树的第K元素，可利用二叉搜索树的中序遍历为递增有序特性即可
    public int kthSmallest(TreeNode root, int k) {
        getSmallest(root,k);
        return res;
    }

    public void getSmallest(TreeNode current, int k) {
        if (current == null) {
            return;
        }
        getSmallest(current.left,k);

        rank++;
        if(k==rank){
            res= current.value;
            return;
        }

        getSmallest(current.right,k);

    }


    //输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
    //输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
    //
    // 二叉搜索树转换为累加树
    //给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
    // 使每个节点 node的新值等于原树中大于或等于node.val的值之和。
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    // 记录累加和
    int sum = 0;
    void traverse(TreeNode root) {
        if(root==null){
            return;
        }
        // BST先打印右树节点，逆序输出
        traverse(root.right);
        // 逆序累加
        sum+=root.value;
        root.value=sum;
        traverse(root.left);
    }

    // 二叉搜索树寻找一个节点
    boolean isInBST(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.value == target) {
            return true;
        }
        if (root.value < target){
            return isInBST(root.right, target);
        }
        if (root.value > target) {
            return isInBST(root.left, target);
        }
        //永远不会走到
        return false;
    }

    //二叉搜索树插入一个节点
    TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空位置插入新节点
        if (root == null) return new TreeNode(val);
        // if (root.val == val)
        // BST 中一般不会插入已存在元素
        if (root.value < val)
            root.right = insertIntoBST(root.right, val);
        if (root.value > val)
            root.left = insertIntoBST(root.left, val);
        return root;
    }

    //删除二叉搜索树的一个节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.value) {
            // 待删除节点在左子树中
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.value) {
            // 待删除节点在右子树中
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            // key == root.val，root 为待删除节点
            if (root.left == null) {
                // 返回右子树作为新的根
                return root.right;
            } else if (root.right == null) {
                // 返回左子树作为新的根
                return root.left;
            } else {
                // 左右子树都存在，返回后继节点（右子树最左叶子）作为新的根
                TreeNode successor = min(root.right);
                // 这里删除右子树的最小节点实际是将最小
                successor.right = deleteMin(root.right);
                successor.left = root.left;
                return successor;
            }
        }

    }

    //平衡二叉树的左子树的最左节点为最小值
    public TreeNode min(TreeNode root){
        if(root.left==null){
            return root;
        }
        return min(root.left);
    }

    // 必须找到右子树中最小的那个节点 删除，并返回null或者第二小节点
    private TreeNode deleteMin(TreeNode node) {
        // 当前节点的左子树为空时，说明当前节点在这颗树中是最小节点，直接返回它的右子树
        // 这时它的右子树可能是null或者第二小节点
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }


}
