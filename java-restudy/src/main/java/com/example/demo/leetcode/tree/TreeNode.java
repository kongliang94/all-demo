package com.example.demo.leetcode.tree;

public class TreeNode {
    public int value;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val) {
        this.value = val;
    }
}


/*一个Query类的实例表示一条查询语句，表示想要查询o1节点 和 o2节点 的最近公共祖先节点
  给定一颗二叉树的头节点head ，并给定所有的查询语句，即一个Query类型的数组Query[] ques, 请返回 TreeNode 类型的数组 TreeNode[] ans,
    ans[i] 代表ques[i] 这条查询的答案，即 ques[i].o1  和 ques[i].o2  的最近公共祖先
 */
class Query {
    public TreeNode o1;
    public TreeNode o2;

    public Query(TreeNode o1, TreeNode o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

}

//哈夫曼树独有的节点
class Huff_Node implements Comparable<Huff_Node> {
    char ch; // 字符
    int freq; // 权值
    boolean isLeaf;  // 是否是叶子节点
    Huff_Node left, right;  // 父节点的左节点和右节点

    // 初始化一个带权值的叶子节点
    public Huff_Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        this.isLeaf = true;
    }

    // 构建一个节点，带左右节点
    public Huff_Node(Huff_Node left, Huff_Node right, int freq) {
        this.left = left;
        this.right = right;
        this.freq = freq;
        this.isLeaf = false;
    }

    @Override
    public int compareTo(Huff_Node o) {
        return this.freq - o.freq;
    }


}

//红黑树的节点
class RBTNode<T extends Comparable<T>> {
    boolean color;        // 颜色
    T key;                // 关键字(键值)
    RBTNode<T> left;    // 左孩子
    RBTNode<T> right;    // 右孩子
    RBTNode<T> parent;    // 父结点

    public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
        this.key = key;
        this.color = color;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}

//平衡二叉树节点
class AVLNode {

    public AVLNode parent;
    public AVLNode leftChild, rightChild;
    public int data;

    public AVLNode(AVLNode parent, AVLNode leftChild, AVLNode rightChild, int data) {
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }

    public AVLNode(int data) {
        this(null, null, null, data);
    }

    public AVLNode(AVLNode parent, int data) {
        this.parent = parent;
        this.data = data;
    }
}
