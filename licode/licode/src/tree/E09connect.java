package tree;

import java.util.HexFormat;
import java.util.LinkedList;
import java.util.Queue;

public class E09connect {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        /*Node leftMost = root;
        while (leftMost.left != null){
            Node head = leftMost;
            while (head != null){
                head.left.next = head.right;
                if (head.next != null){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;*/
        Node leftMost = root;
        while (leftMost.left != null){
            Node head = leftMost;
            while (head != null && head.left != null){
                head.left.next = head.right;
                if(head.next != null){
                    if(head.next.left != null){
                        head.right.next = head.next.left;
                    }else if(head.next.right != null){
                        head.right.next = head.next.right;
                    }
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
