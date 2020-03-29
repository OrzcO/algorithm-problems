package com.nju.leetcode.offer;

import com.nju.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Pro32_1 {
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len -- > 0) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    ans.add(cur.val);
                } else {
                    break;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        int[] ret = new int[ans.size()];
        for (int i=0;i<ans.size();i++) {
            ret[i] = ans.get(i);
        }
        return ret;
    }
}
