package day0512;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    int max = 1;
    Deque<Integer> queue = new LinkedList<>();
    int min = 0;
    Deque<TreeNode> stack = new ArrayDeque<>();

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        stack.offer(root);
        while (stack.size() > 0) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.poll();
                if (node.left != null) {
                    stack.offer(node.left);
                }
                if (node.right != null) {
                    stack.offer(node.right);
                }
                if(node.left == null && node.right == null) {
                    return min;
                }
            }
            min += 1;
        }
        return 0;
    }

    private TreeNode buildTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findMax(root);
        return max;
    }

    private void findMax(TreeNode node) {
        queue.push(node.val);
        if (node.left != null) {
            findMax(node.left);
        }
        if (node.right != null) {
            findMax(node.right);
        }
        max = Math.max(queue.size(), max);
        queue.pop();
    }

    public static void main(String[] args) {
        TreeNode treeNode = new Solution().buildTree();
        System.out.println(new Solution().minDepth(treeNode));
    }
}
