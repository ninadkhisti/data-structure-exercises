package com.sample.binarytree;

/**
 * /**
 * binary tree paths
 * 
 *                     5 
 *                   /   \
 *                  3     7
 *                 / \   / \
 *                1   4 2   9
 */

public class ValidateBST {

    public static void main(String[] args) {
        TreeNode<Integer> ll1 = new TreeNode<>(1);
        TreeNode<Integer> rl1 = new TreeNode<>(4);
        TreeNode<Integer> l1 = new TreeNode<>(3, ll1, rl1);

        TreeNode<Integer> lr1 = new TreeNode<>(2);
        TreeNode<Integer> rr1 = new TreeNode<>(9);
        TreeNode<Integer> r1 = new TreeNode<>(7, lr1, rr1);
        TreeNode<Integer> root = new TreeNode<>(5, l1, r1);

        boolean valid = validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(valid);
    }

    private static boolean validateBST(TreeNode<Integer> root, int min, int max) {
        if (root == null)
            return true;
        if (min >= root.data || max <= root.data)
            return false;

        return validateBST(root.left, min, root.data) && validateBST(root.right, root.data, max);

    }
}
