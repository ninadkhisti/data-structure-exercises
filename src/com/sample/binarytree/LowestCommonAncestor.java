package com.sample.binarytree;

/**
 * binary tree
 * 
 *                     5 
 *                   /   \
 *                  3     7
 *                 / \   / \
 *                1   4 6   9
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode<Integer> ll1 = new TreeNode<>(1);
        TreeNode<Integer> rl1 = new TreeNode<>(4);
        TreeNode<Integer> l1 = new TreeNode<>(3, ll1, rl1);

        TreeNode<Integer> lr1 = new TreeNode<>(6);
        TreeNode<Integer> rr1 = new TreeNode<>(9);
        TreeNode<Integer> r1 = new TreeNode<>(7, lr1, rr1);
        TreeNode<Integer> root = new TreeNode<>(5, l1, r1);

        TreeNode<Integer> lca = lowerstCommonAncestor(ll1, rl1, root);
        System.out.println(lca.data);
    }

    private static TreeNode<Integer> lowerstCommonAncestor(TreeNode<Integer> p, TreeNode<Integer> q,
            TreeNode<Integer> root) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;
        TreeNode<Integer> l = lowerstCommonAncestor(p, q, root.left);
        TreeNode<Integer> r = lowerstCommonAncestor(p, q, root.right);

        if (l != null && r != null)
            return root;
        return l == null ? r : l;
    }
}
