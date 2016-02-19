package com.sample.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * vertical traversal a binary tree
 * 
 *                     5 
 *                   /   \
 *                  3     7
 *                 / \   / \
 *                1   4 6   9
 */

public class VerticalOrderTraversal {

    public static void main(String[] args) {
        TreeNode<Integer> ll1 = new TreeNode<>(1);
        TreeNode<Integer> rl1 = new TreeNode<>(4);
        TreeNode<Integer> l1 = new TreeNode<>(3, ll1, rl1);

        TreeNode<Integer> lr1 = new TreeNode<>(6);
        TreeNode<Integer> rr1 = new TreeNode<>(9);
        TreeNode<Integer> r1 = new TreeNode<>(7, lr1, rr1);
        TreeNode<Integer> root = new TreeNode<>(5, l1, r1);

        TreeNode<Integer> print = root;
        List<List<Integer>> result = verticalOrder(root);
        System.out.println(result.toString());
    }

    private static List<List<Integer>> verticalOrder(TreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode<Integer>> bfs = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        Map<Integer, List<Integer>> traversal = new HashMap<>();

        TreeNode<Integer> p = root;
        bfs.add(p);
        depth.add(0);

        int mindepth = 0, maxdepth = 0;

        while (!bfs.isEmpty()) {
            TreeNode<Integer> node = bfs.remove();
            int ndepth = depth.remove();
            updateTraversal(traversal, node, ndepth);

            if (node.left != null) {
                TreeNode<Integer> left = node.left;
                int ldepth = ndepth - 1;
                bfs.add(left);
                depth.add(ldepth);
                if (ldepth <= mindepth)
                    mindepth = ldepth;
            }

            if (node.right != null) {
                TreeNode<Integer> right = node.right;
                int rdepth = ndepth + 1;
                bfs.add(right);
                depth.add(rdepth);
                if (rdepth >= maxdepth)
                    maxdepth = rdepth;
            }
        }

        for (int cnt = mindepth; cnt <= maxdepth; cnt++) {
            if (traversal.containsKey(cnt)) {
                result.add(traversal.get(cnt));
            }
        }

        return result;
    }

    private static void updateTraversal(Map<Integer, List<Integer>> traversal, TreeNode<Integer> node, int depth) {
        if (traversal.containsKey(depth)) {
            traversal.get(depth).add(node.data);
        } else {
            List<Integer> nodes = new ArrayList<>();
            nodes.add(node.data);
            traversal.put(depth, nodes);
        }

    }
}
