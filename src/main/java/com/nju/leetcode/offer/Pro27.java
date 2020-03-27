package com.nju.leetcode.offer;

import com.nju.leetcode.datastructure.TreeNode;

public class Pro27 {
    /**
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * 例如输入：
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 镜像输出：
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * 示例 1：
     *
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     * 限制：
     * 0 <= 节点个数 <= 1000
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(cur);
        return root;
    }
}
