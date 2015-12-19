package com.sample.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Tree
 */
public class TreeNode<T> {

    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public String toString() {
        return "Node =>" + this.data.toString();
    }

    public void print() {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.remove();
            System.out.println(node.toString());
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }
}
