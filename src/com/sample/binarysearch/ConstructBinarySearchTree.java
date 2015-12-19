package com.sample.binarysearch;

import com.sample.binarytree.TreeNode;

/**
 * Construct BST
 * how about an iterative solution?? 
 *
 */
public class ConstructBinarySearchTree {

    public static void main(String[] args) {
        int[] input = { 1, 2, 5, 6, 7, 8, 9, 10, 20, 34, 35, 36, 40, 41, 42, 43, 44, 48, 49, 50 };

        TreeNode<Integer> root = constructBST(input, 0, input.length - 1);
        root.print();
    }

    private static TreeNode<Integer> constructBST(int[] input, int low, int high) {

        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode<Integer> root = new TreeNode<>(input[mid]);
        root.left = constructBST(input, low, mid - 1);
        root.right = constructBST(input, mid + 1, high);
        return root;
    }
}
