package com.sample.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * binary tree serializer
 * 
 *                     5 
 *                   /   \
 *                  3     7
 *                 / \   / \
 *                #   4 2   #
 */
public class BinaryTreeSerializer {

    public static void main(String[] args) {
        TreeNode<Integer> rl1 = new TreeNode<>(4);
        TreeNode<Integer> l1 = new TreeNode<>(3, null, rl1);

        TreeNode<Integer> lr1 = new TreeNode<>(2);
        TreeNode<Integer> r1 = new TreeNode<>(7, lr1, null);
        TreeNode<Integer> root = new TreeNode<>(5, l1, r1);
        String tree = serialize(root);
        System.out.println(tree);
        TreeNode<Integer> node = deserialize(tree);
        node.print();
    }

    public static TreeNode<Integer> deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        String[] nodes = data.split(",");
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        TreeNode<Integer> root = new TreeNode<>(0);
        queue.add(root);
        int i = 0;
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.remove();
            node.data = Integer.parseInt(nodes[node.data]);
            int left = i + 1;
            int right = i + 2;

            if (left < nodes.length && !nodes[left].equals("null")) {
                TreeNode<Integer> leftNode = new TreeNode<>(left);
                node.left = leftNode;
                queue.add(leftNode);
            }

            if (right < nodes.length && !nodes[right].equals("null")) {
                TreeNode<Integer> rightNode = new TreeNode<>(right);
                node.right = rightNode;
                queue.add(rightNode);
            }
            i += 2;
        }
        return root;
    }

    public static String serialize(TreeNode<Integer> root) {
        if (root == null)
            return null;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.remove();
            if (node.data == -1) {
                sb.append("null,");
                continue;
            } else {
                sb.append(node.data + ",");
            }

            if (node.left != null) {
                queue.add(node.left);
            } else {
                queue.add(new TreeNode<Integer>(-1));
            }

            if (node.right != null) {
                queue.add(node.right);
            } else {
                queue.add(new TreeNode<Integer>(-1));
            }
        }

        return sb.toString();
    }

}
