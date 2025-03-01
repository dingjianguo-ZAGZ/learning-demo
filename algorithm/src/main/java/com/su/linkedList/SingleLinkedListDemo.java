package com.su.linkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode n1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode n2 = new HeroNode(2, "吴用", "智多星");
        HeroNode n3 = new HeroNode(3, "李逵", "天煞星");
        SingleLinkedList list = new SingleLinkedList();
        list.addNode(n1);
        list.addNode(n2);
        list.addNode(n3);
        //显示
        list.list();
    }
}
//单链表，管理节点
class SingleLinkedList{
    //头节点不要动
    private HeroNode head = new HeroNode(0,"","");
    //添加节点
    public void addNode(HeroNode node){
        //辅助变量，找到链表最后一个元素，将最后一个元素的 next 指向心底的节点
        HeroNode temp = head;
        while (true){
            if(temp.next == null){
                //找到最后一个节点
                break;
            }
            temp = temp.next;
        }
        //当退出循环时，temp指向最后一个节点
        temp.next = node;
    }
    //显示lianb【遍历】
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //辅助变量，找到链表最后一个元素，将最后一个元素的 next 指向心底的节点
        HeroNode temp = head.next;
        while (true){
            if(temp == null){
                //最后一个节点
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //后移
            temp = temp.next;
        }

    }
}
//节点类
class HeroNode{
    public int heroId;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int heroId, String name, String nickName) {
        this.heroId = heroId;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "heroId=" + heroId +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
