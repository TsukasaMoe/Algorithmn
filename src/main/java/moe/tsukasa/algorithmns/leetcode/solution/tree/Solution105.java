package moe.tsukasa.algorithmns.leetcode.solution.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Class/Interface/Enum/Annotation description
 * </p>
 *
 * @package: moe.tsukasa.algorithmns.leetcode.solution.tree
 * @description: Description message
 * @author: Tsukasa
 * @date: Created in 2021/6/14 16:41
 * @copyright: Copyright (c) 2021
 * @version: V1.0
 * @modified: Tsukasa
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length <= 0 || inorder.length <= 0) {
            return null;
        }

        // 构造中序遍历对应的顺序关系
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        // 获取中序遍历数组中的根节点的下标
        int pos = inMap.get(preorder[0]);
        // int num = pos - 0;

        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(preorder, 1, pos, inorder, 0, pos - 1, inMap);
        root.right = buildTree(preorder, pos + 1, preorder.length - 1, inorder, pos + 1, inorder.length - 1, inMap);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        // 异常情况
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // 常规
        // 中序遍历中根节点的位置
        int pos = inMap.get(preorder[preStart]);
        int num = pos - inStart;

        // 寻找根节点
        // int pos = inStart;
        // while (pos <= inEnd && preorder[preStart] != inorder[pos]) {
        //     pos ++;
        // }

        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = buildTree(preorder, preStart + 1, preStart + num, inorder, inStart, pos - 1, inMap);
        root.right = buildTree(preorder, preStart + num + 1, preEnd, inorder, pos + 1, inEnd, inMap);
        return root;
    }
}
