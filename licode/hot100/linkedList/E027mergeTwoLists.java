package linkedList;

public class E027mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //设置虚拟头节点
        ListNode prehead = new ListNode(-1);
        //当前节点
        ListNode curr = prehead;
        while (list1 != null && list2 != null){
            if(list1.val >= list2.val){
                curr.next = list2;
                list2 = list2.next;
            }else {
                //currA < currB
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }
        //合并完之后，还有最后一个节点没加入
        prehead.next = list1 == null?list2:list1;
        return prehead.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
