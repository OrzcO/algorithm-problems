package com.nju.leetcode.offer;

import com.nju.leetcode.datastructure.TreeNode;
import org.junit.Test;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * preorder = [3,9,8,5,4,10,20,15,7]
 * inorder = [4,5,8,10,9,3,15,20,7]
 *
 * 例如要重建的是如下二叉树。
 *
 *         3
 *        / \
 *       9  20
 *      /  /  \
 *     8  15   7
 *    / \
 *   5  10
 *  /
 * 4
 *
 */

public class Pro7 {
    private HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return root;
    }
    public TreeNode build(int[] preorder, int px, int py, int[] inorder, int ix, int iy) {
        if (px > py || ix > iy) {
            return null;
        }
        if (px == py) {
            return new TreeNode(preorder[px]);
        }
        int idx = map.get(preorder[px]);
        TreeNode cur = new TreeNode(preorder[px]);
        cur.left = build(preorder, px+1, idx, inorder, ix, idx-1);
        cur.right = build(preorder, idx+1, py, inorder, idx+1, iy);
        return cur;
    }

    @Test
    public void test() {
        System.out.println(buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
        System.out.println(buildTree(new int[]{3,9,8,5,4,10,20,15,7}, new int[]{4,5,8,10,9,3,15,20,7}));
    }
}
