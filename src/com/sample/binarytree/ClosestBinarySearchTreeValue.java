package com.sample.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * TODO: Describe purpose and behavior of ClosestBinarySearchTreeValue
 */
public class ClosestBinarySearchTreeValue {

    public static void main(String[] args) {
        TreeNode<Integer> l1 = new TreeNode<>(1);
        TreeNode<Integer> r1 = new TreeNode<>(2, l1, null);
        System.out.println(closestKValues(r1, 4.14d, 2));
    }

    public static List<Integer> closestKValues(TreeNode<Integer> root, double target, int k) {
        if (root == null || k <= 0)
            return Collections.emptyList();
        Stack<Integer> s = new Stack<>();
        Stack<Integer> h = new Stack<>();
        inorder(s, root, target, false);
        inorder(h, root, target, true);

        List<Integer> result = new ArrayList<>();
        while (k-- > 0) {
            if (s.isEmpty())
                result.add(h.pop());
            else if (h.isEmpty())
                result.add(s.pop());
            else if (Math.abs(s.peek() - target) < Math.abs(h.peek() - target)) {
                result.add(s.pop());
            } else {
                result.add(h.pop());
            }
        }
        return result;
    }

    private static void inorder(Stack<Integer> s, TreeNode<Integer> node, double target, boolean reverse) {
        if (node == null)
            return;
        inorder(s, reverse ? node.right : node.left, target, reverse);
        if ((reverse && node.data < target) || (!reverse && node.data > target))
            return; //pruning

        s.push(node.data);
        inorder(s, reverse ? node.left : node.right, target, reverse);
    }
}
