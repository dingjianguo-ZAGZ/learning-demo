package linkedList;

public class E034mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null){
            return null;
        }
        ListNode list1 = lists[0];
        ListNode res = list1;
        for (int i = 1; i < lists.length; i++) {
            list1 = mergeTwoList(list1,lists[i]);
        }
        return res;
    }

    /**
     * 合并两个有序链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoList(ListNode list1,ListNode list2){
        //合并后链表的头节点
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        //将两个有序链表合并
        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        //加上最后一个节点
        temp.next = list1 == null?list2:list1;
        return dummyHead.next;
    }
}
