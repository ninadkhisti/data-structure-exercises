package com.sample.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * invert a binary tree
 * 
 *                     5 
 *                   /   \
 *                  3     7
 *                 / \   / \
 *                1   4 6   9
 */
public class InvertBinaryTreee {

    public static void main(String[] args) {
        TreeNode<Integer> ll1 = new TreeNode<>(1);
        TreeNode<Integer> rl1 = new TreeNode<>(4);
        TreeNode<Integer> l1 = new TreeNode<>(3, ll1, rl1);

        TreeNode<Integer> lr1 = new TreeNode<>(6);
        TreeNode<Integer> rr1 = new TreeNode<>(9);
        TreeNode<Integer> r1 = new TreeNode<>(7, lr1, rr1);
        TreeNode<Integer> root = new TreeNode<>(5, l1, r1);

        TreeNode<Integer> print = root;
        invertBinaryTree(root);
        print.print();

    }

    private static void invertBinaryTree(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.remove();
            TreeNode<Integer> leftNode = root.left;
            TreeNode<Integer> rightNode = root.right;
            root.left = rightNode;
            root.right = leftNode;

            if (root.left != null)
                queue.add(root.left);
            if (root.right != null)
                queue.add(root.right);

        }

    }
}
