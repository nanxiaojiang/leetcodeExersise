package com.nj.leetcode.tree;

/**
 * @Author 南江
 * @Description: 二叉树直径 = 树种任意两节点最短路径的最大值
 * @Date 2022/7/7 0:14
 *  深度优先搜索，大多使用递归
 */
public class SecondTree {
    private static int max = 1;


    public static int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    public static int depth(TreeNode treeNode){

        if (treeNode == null){
            return  0;
        }

        int left = depth(treeNode.left);      //左儿子为根，树的深度
        int right = depth(treeNode.right);   //右儿子根，树的深度

        max = Math.max(max,left+right);     //将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        return Math.max(left+1,right+1);    //返回该节点为根的子树的深度，考虑到节点个数需要加+
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
