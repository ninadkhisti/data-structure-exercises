package com.sample.binarytree;

import java.util.ArrayList;
import java.util.List;

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
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        printPaths(root, 21, current, 0, result);
        System.out.println(result.toString());
    }

    private static void printPaths(TreeNode<Integer> node, int target, List<Integer> current, int sum,
            List<List<Integer>> result) {
        if (sum + node.data == target && node.isLeaf()) {
            current.add(node.data);
            result.add(new ArrayList<>(current));
            return;
        }
        if (node.left != null) {
            List<Integer> tmp = new ArrayList<>(current);
            tmp.add(node.data);
            printPaths(node.left, target, tmp, sum + node.data, result);
        }
        if (node.right != null) {
            List<Integer> tmp = new ArrayList<>(current);
            tmp.add(node.data);
            printPaths(node.right, target, tmp, sum + node.data, result);
        }

    }

    private static boolean binaryTreePathSum(TreeNode<Integer> root, int i) {
        if (root == null)
            return false;

        if (root.left != null || root.right != null)
            return binaryTreePathSum(root.left, i + root.data) || binaryTreePathSum(root.right, i + root.data);

        return SUM == i + root.data;
    }
}
