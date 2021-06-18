package moe.tsukasa.algorithmns.leetcode.solution.tree;

/**
 * <p>
 * Class/Interface/Enum/Annotation description
 * </p>
 *
 * @package: moe.tsukasa.algorithmns.leetcode.solution.tree
 * @description: Description message
 * @author: Tsukasa
 * @date: Created in 2021/6/17 00:07
 * @copyright: Copyright (c) 2021
 * @version: V1.0
 * @modified: Tsukasa
 */
public class Solution99 {
    int[] nums = new int[1001];
    int index = 0;

    int x = -1, y = -1;
    TreeNode n1, n2;

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

    public void recoverTree(TreeNode root) {
        travaser(root);
        for (int i = 0; i < index - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                x = nums[i + 1];
                if (y == -1) {
                    y = nums[i];
                } else {
                    break;
                }
            }
        }

        findNode(root, x, y);

        int tv = n1.val;
        n1.val = n2.val;
        n2.val = tv;

    }

    private void findNode(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }

        if (root.val == x) {
            n1 = root;
        } else if (root.val == y) {
            n2 = root;

        }

        findNode(root.left, x, y);
        findNode(root.right, x, y);
    }

    private void travaser(TreeNode root) {
        if (root == null) {
            return;
        }
        travaser(root.left);
        nums[index++] = root.val;
        travaser(root.right);
    }

    public static void main(String[] args) {
        Solution99 s99 = new Solution99();
        Solution99.TreeNode t2 = s99.new TreeNode(2, null, null);
        Solution99.TreeNode t4 = s99.new TreeNode(4, t2, null);
        Solution99.TreeNode t1 = s99.new TreeNode(1, null, null);
        Solution99.TreeNode t3 = s99.new TreeNode(3, t1, t4);

        display(t3);
        System.out.println();
        s99.recoverTree(t3);
        display(t3);
        System.out.println();
    }

    public static void display(TreeNode root) {
        if (root == null) {
            System.out.print(",null");
        } else {
            System.out.print(","+root.val);
            display(root.left);
            display(root.right);
        }
    }
}

