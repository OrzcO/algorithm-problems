package com.nju.leetcode.offer;

import com.nju.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */
public class Pro34 {

    /**
     * dfs , 但是代码比较冗余
     */
//    List<List<Integer>> ans = new ArrayList<>();
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        if (root == null) {
//            return ans;
//        }
//        dfs(root, new ArrayList<>(), sum);
//        return ans;
//    }
//    public void dfs(TreeNode cur, List<Integer> trace, int sum) {
//        if (cur.val == sum && cur.left == null && cur.right == null) {
//            trace.add(cur.val);
//            ans.add(trace);
//            return;
//        }
//        if (cur.left != null) {
//            ArrayList<Integer> path = new ArrayList<>(trace);
//            path.add(cur.val);
//            dfs(cur.left, path, sum-cur.val);
//        }
//        if (cur.right != null) {
//            ArrayList<Integer> path = new ArrayList<>(trace);
//            path.add(cur.val);
//            dfs(cur.right, path, sum-cur.val);
//        }
//    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> trace = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return ans;
        }
        dfs(root, sum);
        return ans;
    }
    public void dfs(TreeNode cur, int sum) {
        trace.add(cur.val);
        if (cur.val == sum && cur.left == null && cur.right == null) {
            ans.add(new ArrayList<>(trace));
        }
        if (cur.left != null) {
            dfs(cur.left, sum-cur.val);
        }
        if (cur.right != null) {
            dfs(cur.right, sum-cur.val);
        }
        trace.remove(trace.size()-1);
    }
}
