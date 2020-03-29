package com.nju.leetcode.offer;

import com.nju.leetcode.datastructure.Node;

import java.util.HashMap;
import java.util.Map;


/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
 * 每个节点除了有一个 next 指针指向下一个节点，还有一个
 * random 指针指向链表中的任意节点或者 null。
 *
 */
public class Pro35 {

    /**
     * 用hash的思路做的，原始Node 和 当前Node进行映射起来
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Map<Node, Node> hash = new HashMap<>();
        hash.put(null, null);
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            hash.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node next = cur.next;
            Node random = cur.random;
            Node copy = hash.get(cur);
            copy.next = hash.get(next);
            copy.random = hash.get(random);
            cur = cur.next;
        }
        return hash.get(head);
    }

}
