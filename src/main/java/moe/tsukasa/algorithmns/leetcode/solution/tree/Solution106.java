package moe.tsukasa.algorithmns.leetcode.solution.tree;

/**
 * <p>
 * Class/Interface/Enum/Annotation description
 * </p>
 *
 * @package: moe.tsukasa.algorithmns.leetcode.solution.tree
 * @description: Description message
 * @author: Tsukasa
 * @date: Created in 2021/6/14 17:16
 * @copyright: Copyright (c) 2021
 * @version: V1.0
 * @modified: Tsukasa
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length <= 0 || inorder.length <= 0) {
            return null;
        }

        // 找到中序的根节点位置
        int pos = 0;
        while (pos <= inorder.length - 1 && inorder[pos] != postorder[postorder.length - 1]) {
            pos ++;
        }
        int numLeft = pos - 0;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        int postEnd = postorder.length - 1;
        root.left = buildTree(inorder, 0, pos - 1, postorder, 0,  numLeft - 1);
        root.right = buildTree(inorder, pos + 1, inorder.length - 1, postorder, numLeft, postEnd - 1);
        return root;
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // 找到中序的根节点位置
        int pos = inStart;
        while (pos <= inEnd && inorder[pos] != postorder[postEnd]) {
            pos ++;
        }
        int numLeft = pos - inStart;

        TreeNode root = new TreeNode(postorder[postEnd]);
        root.left = buildTree(inorder, inStart, pos - 1, postorder, postStart, postStart + numLeft - 1);
        root.right = buildTree(inorder, pos + 1, inEnd, postorder, postStart + numLeft, postEnd - 1);
        return root;
    }
}
