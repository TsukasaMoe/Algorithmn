package moe.tsukasa.algorithmns.leetcode.solution.tree;

/**
 * <p>
 * Class/Interface/Enum/Annotation description
 * </p>
 *
 * @package: moe.tsukasa.algorithmns.leetcode.solution
 * @description: Description message
 * @author: Tsukasa
 * @date: Created in 2021/6/14 16:08
 * @copyright: Copyright (c) 2021
 * @version: V1.0
 * @modified: Tsukasa
 */
public class Solution124 {
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        result = Math.max(result, left + right + root.val);
        // 经过当前节点的单端最大值：（1）当前节点；（2）当前节点与左子树形成的路径；（3）当前节点与右子树形成的路径
        // 对于当前节点的父节点，如果经过当前节点，那么只能取单端最大值，不能取Math.max(result, left + right + root.val)，因为只能走一条边
        return Math.max(left, right) + root.val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}