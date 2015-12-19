package com.sample.binarytree;

/**
 * binary tree path sum
 * 
 *                     5 
 *                   /   \
 *                  3     7
 *                 / \   / \
 *                1   4 6   9
 */
public class BinaryTreePathSum {

    static int SUM = 21;

    public static void main(String[] args) {
        TreeNode<Integer> ll1 = new TreeNode<>(1);
        TreeNode<Integer> rl1 = new TreeNode<>(4);
        TreeNode<Integer> l1 = new TreeNode<>(3, ll1, rl1);

        TreeNode<Integer> lr1 = new TreeNode<>(6);
        TreeNode<Integer> rr1 = new TreeNode<>(9);
        TreeNode<Integer> r1 = new TreeNode<>(7, lr1, rr1);
        TreeNode<Integer> root = new TreeNode<>(5, l1, r1);

        System.out.println(binaryTreePathSum(root, 0));

    }

    private static boolean binaryTreePathSum(TreeNode<Integer> root, int i) {
        if (root == null)
            return false;

        if (root.left != null || root.right != null)
            return binaryTreePathSum(root.left, i + root.data) || binaryTreePathSum(root.right, i + root.data);

        return SUM == i + root.data;
    }
}
