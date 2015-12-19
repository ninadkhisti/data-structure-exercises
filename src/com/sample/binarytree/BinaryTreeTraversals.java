package com.sample.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * in-order, pre-order and post-order
 * 
 *                     5 
 *                   /   \
 *                  3     7
 *                 / \   / \
 *                1   4 6   9
 */
public class BinaryTreeTraversals {

    public static void main(String[] args) {
        TreeNode<Integer> ll1 = new TreeNode<>(1);
        TreeNode<Integer> rl1 = new TreeNode<>(4);
        TreeNode<Integer> l1 = new TreeNode<>(3, ll1, rl1);

        TreeNode<Integer> lr1 = new TreeNode<>(6);
        TreeNode<Integer> rr1 = new TreeNode<>(9);
        TreeNode<Integer> r1 = new TreeNode<>(7, lr1, rr1);
        TreeNode<Integer> root = new TreeNode<>(5, l1, r1);

        System.out.println("inorder");
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        System.out.println("preorder");
        List<Integer> preorder = new ArrayList<>();
        preorderTraversal(root, preorder);
        System.out.println("postorder");
        List<Integer> postorder = new ArrayList<>();
        postorderTraversal(root, postorder);
        System.out.println("Preorder Iterative");
        List<Integer> preorderRec = new ArrayList<>();
        preorderTraversalIterative(root, preorderRec);
        System.out.println("Inorder Iterative");
        List<Integer> inorderRec = new ArrayList<>();
        inorderTraversalIterative(root, inorderRec);
        System.out.println("Postorder Iterative");
        List<Integer> postorderRec = new ArrayList<>();
        postorderTraversalInterative(root, postorderRec);
        inorder.toString();
        inorderRec.toString();
        preorder.toString();
        preorderRec.toString();
        postorder.toString();
        postorderRec.toString();

    }

    private static void postorderTraversal(TreeNode<Integer> root, List<Integer> postOrder) {
        if (root.left != null)
            postorderTraversal(root.left, postOrder);
        if (root.right != null)
            postorderTraversal(root.right, postOrder);
        System.out.println("Node =>" + root.data);
        postOrder.add(root.data);
    }

    private static void inorderTraversal(TreeNode<Integer> root, List<Integer> inorder) {
        if (root.left != null)
            inorderTraversal(root.left, inorder);
        System.out.println("Node =>" + root.data);
        inorder.add(root.data);
        if (root.right != null)
            inorderTraversal(root.right, inorder);
    }

    private static void preorderTraversal(TreeNode<Integer> root, List<Integer> preorder) {
        System.out.println("Node => " + root.data);
        preorder.add(root.data);
        if (root.left != null)
            preorderTraversal(root.left, preorder);
        if (root.right != null)
            preorderTraversal(root.right, preorder);
    }

    private static void preorderTraversalIterative(TreeNode<Integer> root, List<Integer> preorder) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<Integer> node = stack.pop();
            System.out.println("Node => " + node.data);
            preorder.add(node.data);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    private static void inorderTraversalIterative(TreeNode<Integer> root, List<Integer> inorder) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.println("Node => " + current.data);
            inorder.add(current.data);
            current = current.right;

        }
    }

    private static void postorderTraversalInterative(TreeNode<Integer> root, List<Integer> postorder) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> node = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            node = stack.pop();
            postorder.add(node.data);
            System.out.println("Node => " + node.data);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }
}
