package com.sample.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * binary tree paths
 * 
 *                     5 
 *                   /   \
 *                  3     7
 *                 / \   / \
 *                1   4 2   9
 */
public class BinaryTreePaths {

    static int SUM = 14;

    public static void main(String[] args) {
        TreeNode<Integer> ll1 = new TreeNode<>(1);
        TreeNode<Integer> rl1 = new TreeNode<>(4);
        TreeNode<Integer> l1 = new TreeNode<>(3, ll1, rl1);

        TreeNode<Integer> lr1 = new TreeNode<>(2);
        TreeNode<Integer> rr1 = new TreeNode<>(9);
        TreeNode<Integer> r1 = new TreeNode<>(7, lr1, rr1);
        TreeNode<Integer> root = new TreeNode<>(5, l1, r1);

        List<String> paths = new ArrayList<>();
        printPaths(root, "", paths);
        System.out.println(paths.toString());
        paths = new ArrayList<String>();
        printPathsII(root, "", 0, paths);
        System.out.println(paths.toString());
    }

    private static void printPathsII(TreeNode<Integer> root, String path, int sum, List<String> paths) {
        if (root.isLeaf() && sum + root.data == SUM)
            paths.add(path.concat(root.data.toString()));
        if (root.left != null)
            printPathsII(root.left, path.concat(root.data.toString()).concat("->"), sum + root.data, paths);
        if (root.right != null)
            printPathsII(root.right, path.concat(root.data.toString()).concat("->"), sum + root.data, paths);

    }

    private static void printPaths(TreeNode<Integer> root, String path, List<String> paths) {
        if (root.isLeaf())
            paths.add(path.concat(root.data.toString()));
        if (root.left != null)
            printPaths(root.left, path.concat(root.data.toString()).concat("->"), paths);
        if (root.right != null)
            printPaths(root.right, path.concat(root.data.toString()).concat("->"), paths);

    }
}
