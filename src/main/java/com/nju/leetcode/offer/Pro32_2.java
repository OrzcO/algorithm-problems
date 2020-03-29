package com.nju.leetcode.offer;

import com.nju.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pro32_2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
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
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ans.add(a);
        }
        return ans;
    }


}
