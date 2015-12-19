package com.sample.binarytree;

/**
 * count nodes 
 * 
 *                     5 
 *                   /   \
 *                  3     7
 *                 / \   / \
 *                1   4 6   9
 */
public class NumberofNodesinTree {

    public static void main(String[] args) {
        TreeNode<Integer> ll1 = new TreeNode<>(1);
        TreeNode<Integer> rl1 = new TreeNode<>(4);
        TreeNode<Integer> l1 = new TreeNode<>(3, ll1, rl1);

        TreeNode<Integer> lr1 = new TreeNode<>(6);
        TreeNode<Integer> rr1 = new TreeNode<>(9);
        TreeNode<Integer> r1 = new TreeNode<>(7, lr1, rr1);
        TreeNode<Integer> root = new TreeNode<>(5, l1, r1);

        CountWrapper counter = new CountWrapper();
        numberofNodes(root, counter);
        System.out.println(counter.count);
    }

    private static void numberofNodes(TreeNode<Integer> root, CountWrapper counter) {
        counter.increaseCount();
        if (root.left != null) {
            numberofNodes(root.left, counter);
        }
        if (root.right != null) {
            numberofNodes(root.right, counter);
        }
    }

    static class CountWrapper {
        public int count = 0;

        void increaseCount() {
            count++;
        }

    }

}
