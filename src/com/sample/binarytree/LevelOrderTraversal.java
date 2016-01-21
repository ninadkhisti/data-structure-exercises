package com.sample.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * level order traversal
 * 
 *                     5 
 *                   /   \
 *                  3     7
 *                 / \   / \
 *                1   4 6   9
 *               / \
 *              10 11
 *  Some additional applications include 
 *  Same Tree (equality of nodes) 
 *  Symmetric Tree (Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center)       
 *  Serialize and De-serialize Binary Tree (Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *  
 */
public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode<Integer> lll1 = new TreeNode<>(10);
        TreeNode<Integer> llr1 = new TreeNode<>(11);

        TreeNode<Integer> ll1 = new TreeNode<>(1, lll1, llr1);
        TreeNode<Integer> rl1 = new TreeNode<>(4);
        TreeNode<Integer> l1 = new TreeNode<>(3, ll1, rl1);

        TreeNode<Integer> lr1 = new TreeNode<>(6);
        TreeNode<Integer> rr1 = new TreeNode<>(9);
        TreeNode<Integer> r1 = new TreeNode<>(7, lr1, rr1);
        TreeNode<Integer> root = new TreeNode<>(5, l1, r1);

        levelOrderTraversal(root);
        levelOrderTraversalII(root);
        levelOrderTraversalZigZag(root);
        levelOrderTraversalZigZagII(root);
    }

    private static void levelOrderTraversal(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        if (root == null) {
            return;
        }
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int queuesize = queue.size();
            //level traversal
            for (int cnt = 0; cnt < queuesize; cnt++) {
                TreeNode<Integer> node = queue.remove();
                level.add(node.data);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.add(level);
        }
        System.out.println(result.toString());
    }

    private static void levelOrderTraversalII(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        if (root == null) {
            return;
        }
        queue.add(root);
        Stack<List<Integer>> result = new Stack<>();
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int queuesize = queue.size();
            //level traversal
            for (int cnt = 0; cnt < queuesize; cnt++) {
                TreeNode<Integer> node = queue.remove();
                level.add(node.data);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.push(level);
        }
        while (!result.isEmpty()) {
            System.out.println(result.pop().toString());
        }
    }

    private static void levelOrderTraversalZigZag(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        if (root == null) {
            return;
        }
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        int height = 0;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int queuesize = queue.size();
            //level traversal
            for (int cnt = 0; cnt < queuesize; cnt++) {
                TreeNode<Integer> node = queue.remove();
                level.add(node.data);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            if (height % 2 == 0) {
                List<Integer> ziggedLevel = new ArrayList<>();
                for (int cnt = level.size() - 1; cnt >= 0; cnt--) {
                    ziggedLevel.add(level.get(cnt));
                }
                level = ziggedLevel;
            }
            result.add(level);
            height++;
        }
        System.out.println(result.toString());
    }

    private static void levelOrderTraversalZigZagII(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        if (root == null) {
            return;
        }
        queue.add(root);
        int height = 0;
        while (!queue.isEmpty()) {
            Deque<Integer> level = new LinkedList<>();
            int queuesize = queue.size();
            //level traversal
            for (int cnt = 0; cnt < queuesize; cnt++) {
                TreeNode<Integer> node = queue.remove();
                if (height % 2 == 0) {
                    level.addLast(node.data);
                } else {
                    level.addFirst(node.data);
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            System.out.println(level.toString());
            height++;
        }

    }

}
