package org.example.mambu;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        System.out.printf("visiting node %d\n", node.val);
        dfs(node.right);
    }

    public void dfs() {
        dfs(this);
    }

    public TreeNode find(int val, TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.val == val) {
            return node;
        }

        if (val > node.val) {
            return find(val, node.right);
        } else {
            return find(val, node.left);
        }
    }

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int minDepth(TreeNode node) {

        if (node == null) {
            return 0;
        }

        if (node.left == null) {
            return 1 + minDepth(node.right);
        } else if (node.right == null) {
            return 1 + minDepth(node.left);
        }

        return 1 + Math.min(minDepth(node.left), minDepth(node.right));
    }

    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodesInQueue = queue.size();

            for (int i = 0; i < nodesInQueue; i++) {
                TreeNode node = queue.remove();
                System.out.println(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public boolean isBST() {
        return isBST(this, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode node, int lowBound, int highBound) {
        if (node == null) {
            return true;
        }

        if (node.val <= lowBound || node.val >= highBound) {
            return false;
        }

        boolean leftIsBst = isBST(node.left, lowBound, node.val);
        boolean rightIsBst = isBST(node.right, node.val, highBound);

        return leftIsBst && rightIsBst;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(8);

//        root.dfs();
//
//        var node = root.find(7, root);
//        System.out.println(node.val);
//        System.out.println(root.maxDepth(root));

        root.bfs(root);

        System.out.printf("The tree is a BST: %b", root.isBST());
    }
}
