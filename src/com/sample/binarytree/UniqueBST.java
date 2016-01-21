package com.sample.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 */
public class UniqueBST {

    public static void main(String[] args) {
        int n = 3;
        findUniqueBST(n);
        printUniqueBST(n);
    }

    private static void printUniqueBST(int n) {
        List<List<TreeNode<Integer>>> bsts = new ArrayList<>(n);

        List<TreeNode<Integer>> bst0 = new ArrayList<>();
        bst0.add(null);
        List<TreeNode<Integer>> bst1 = new ArrayList<>();
        bst1.add(new TreeNode<Integer>(1));
        bsts.add(bst0);
        bsts.add(bst1);

        List<TreeNode<Integer>> bstn = null;
        for (int cnt = 2; cnt < n; cnt++) {
            bstn = new ArrayList<>();
            for (int k = 0; k < cnt; k++) {
                TreeNode<Integer> root = new TreeNode<Integer>(cnt);
                List<TreeNode<Integer>> leftNodes = bsts.get(k);
                List<TreeNode<Integer>> rightNodes = bsts.get(cnt - (k + 1));
                for (TreeNode<Integer> leftNode : leftNodes) {
                    for (TreeNode<Integer> rightNode : rightNodes) {
                        root.left = leftNode;
                        root.right = rightNode;
                        bstn.add(root);
                    }
                }
            }
            bsts.add(bstn);
        }
        List<TreeNode<Integer>> roots = bsts.get(n - 1);
        int cnt = 1;
        for (TreeNode<Integer> root : roots) {
            System.out.println("Tree => " + cnt++);
            root.print();
        }
    }

    private static void findUniqueBST(int n) {
        int[] bsts = new int[n];

        bsts[0] = 1;
        bsts[1] = 1;

        for (int cnt = 2; cnt < n; cnt++) {
            for (int k = 0; k < cnt; k++) {
                bsts[cnt] += bsts[k] * bsts[cnt - (k + 1)];
            }
        }
        System.out.println("BSTS =>" + bsts[n - 1]);
    }
}
