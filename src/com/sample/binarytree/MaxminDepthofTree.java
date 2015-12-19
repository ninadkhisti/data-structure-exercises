package com.sample.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * max depth 3
 * 
 *                     5 
 *                   /   \
 *                  3     7
 *                       / \
 *                      6   9
 *                           \
 *                           10
 *                           
 * 
 *                     5 
 *                   /   \
 *                  3     7
 *                 / \
 *                6   9
 *                     \
 *                     10
 */
public class MaxminDepthofTree {

    public static void main(String[] args) {
        TreeNode<Integer> l1 = new TreeNode<>(3, null, null);

        TreeNode<Integer> r2 = new TreeNode<>(10);

        TreeNode<Integer> lr1 = new TreeNode<>(6);
        TreeNode<Integer> rr1 = new TreeNode<>(9, null, r2);
        TreeNode<Integer> r1 = new TreeNode<>(7, lr1, rr1);
        TreeNode<Integer> root = new TreeNode<>(5, l1, r1);

        TreeNode<Integer> n2 = new TreeNode<>(10);
        TreeNode<Integer> n3 = new TreeNode<>(6);
        TreeNode<Integer> n4 = new TreeNode<>(9, null, n2);
        TreeNode<Integer> n1 = new TreeNode<>(3, n3, n4);

        TreeNode<Integer> n5 = new TreeNode<>(7);
        TreeNode<Integer> node = new TreeNode<>(5, n1, n5);

        //System.out.println(computeMaxDepth(root, 1));
        System.out.println(maxDepth(root));
        System.out.println(computeMinDepth(root));
        System.out.println(computeMaxDepthIterative(node));
        System.out.println(computeMaxDepthIterative(root));
        System.out.println(computeMinDepthIterative(node));
        System.out.println(computeMinDepthIterative(root));
    }

    /*
    private static int computeMaxDepth(TreeNode<Integer> root, int i) {
        i = i + 1;
        System.out.println("Node =>" + root.data + " depth=> " + i);
        if (root.left != null)
            return computeMaxDepth(root.left, i);
        if (root.right != null)
            return computeMaxDepth(root.right, i);
    }
    */

    private static int computeMinDepthIterative(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        int height = 0;
        outer: while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int cnt = 0; cnt < queueSize; cnt++) {
                TreeNode<Integer> node = queue.remove();
                if (node.isLeaf()) {
                    height++;
                    break outer;
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            height++;
        }
        return height;
    }

    private static int computeMinDepth(TreeNode<Integer> root) {
        if (root == null)
            return 0;
        if (root.left != null)
            return computeMinDepth(root.left) + 1;
        if (root.right != null)
            return computeMinDepth(root.right) + 1;
        return Math.min(computeMinDepth(root.left), computeMinDepth(root.right)) + 1;

    }

    private static int computeMaxDepthIterative(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        if (root != null)
            queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int cnt = 0; cnt < queueSize; cnt++) {
                TreeNode<Integer> node = queue.remove();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            depth++;
        }
        return depth;
    }

    private static int maxDepth(TreeNode<Integer> root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
