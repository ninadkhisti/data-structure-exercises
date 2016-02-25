package com.sample.binarytree;

import java.util.Iterator;
import java.util.Stack;

/**
 * Balanced binary tree
 * 
 *                     5 
 *                   /   \
 *                  3     7
 *                 / \   / \
 *                1   4 6   9
 */
public class BinaryTreeIterator implements Iterator<TreeNode<Integer>> {

    private Stack<TreeNode<Integer>> nodes;
    private TreeNode<Integer> current;

    public BinaryTreeIterator(TreeNode<Integer> root) {
        this.nodes = new Stack<>();
        current = root;
    }

    @Override
    public boolean hasNext() {
        return !nodes.isEmpty() || current != null;
    }

    @Override
    public TreeNode<Integer> next() {
        TreeNode<Integer> n = null;
        while (current != null) {
            nodes.push(current);
            current = current.left;
        }
        n = nodes.pop();
        current = n.right;
        return n;
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        TreeNode<Integer> ll1 = new TreeNode<>(1);
        TreeNode<Integer> rl1 = new TreeNode<>(4);
        TreeNode<Integer> l1 = new TreeNode<>(3, ll1, rl1);

        TreeNode<Integer> lr1 = new TreeNode<>(6);
        TreeNode<Integer> rr1 = new TreeNode<>(9);
        TreeNode<Integer> r1 = new TreeNode<>(7, lr1, rr1);
        TreeNode<Integer> root = new TreeNode<>(5, l1, r1);

        BinaryTreeIterator iterator = new BinaryTreeIterator(root);
        for (int cnt = 0; cnt < 15; cnt++)
            if (iterator.hasNext())
                System.out.println(iterator.next().data);
    }
}
