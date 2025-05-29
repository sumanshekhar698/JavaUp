package dev.codecounty.java.java8.specials.streams;

import java.util.ArrayDeque;

public class WalmartQ {

    public static void main(String[] args) {
//        int[] arr = {1, 7, -2, 3, -7, 0, 1, 8};
//        Tree

//        5
//        2 4
//        1 null 5 7
//        5 2 4 1 null null
        TreeNode treeNode = new TreeNode(5, new TreeNode(2), new TreeNode(4));
        treePatternCheck(treeNode);




    }

    static boolean treePatternCheck(TreeNode root) {

        ArrayDeque<TreeNode> tempNodeHolder = new ArrayDeque<>();
        if (root == null)
            return false;


        tempNodeHolder.addLast(root);


        while (!tempNodeHolder.isEmpty()) {
//        for (int i = 1; tempNodeHolder.isEmpty(); i++) {
            TreeNode treeNode = tempNodeHolder.removeFirst();


            System.out.println(treeNode.val);


            if (treeNode.left != null)
                tempNodeHolder.addLast(treeNode.left);
            if (treeNode.right != null)
                tempNodeHolder.addLast(treeNode.right);
        }

        return true;


    }

    // odd
    // even
    // odd
    // even

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }




}
