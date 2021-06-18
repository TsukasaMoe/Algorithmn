package moe.tsukasa.algorithmns.leetcode.solution;

import moe.tsukasa.algorithmns.datastructure.tree.BiTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * Class/Interface/Enum/Annotation description
 * </p>
 *
 * @package: moe.tsukasa.algorithmns.leetcode.solution
 * @description: Description message
 * @author: Tsukasa
 * @date: Created in 2021/6/17 23:53
 * @copyright: Copyright (c) 2021
 * @version: V1.0
 * @modified: Tsukasa
 */
public class Solution144 {
    public class TreeNode {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        // 1.递归实现
        // List<Integer> list = new ArrayList<>();
        // preOrder(root, list);
        // return list;

        // 2.非递归实现
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        result.add(root.val);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if ()
        }
    }

    private void preOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }


}
