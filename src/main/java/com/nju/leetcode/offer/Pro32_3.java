package com.nju.leetcode.offer;

import com.nju.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pro32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = true;
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> a = new ArrayList<>();
            int len = queue.size();
            while (len -- > 0) {
                TreeNode cur = queue.poll();
                a.add(cur.val);
                if (flag) {
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                } else {
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
            }
            ans.add(a);
            flag = !flag;
        }
        return ans;
    }
}
