package Doublylinkedlist;


import java.util.Iterator;

public class Lianbiao<T>  implements  Iterable<T> {
    private  Node head;
    private  Node last;
    private  int N;
    public  class Node{
        public Node(T item,Node pre,Node next){
            this.item=item;
            this.pre=pre;
            this.next=next;

        }

        public Node() {
        }

        public  T item;
        public  Node pre;
        public  Node next;

        public Node getNext() {
            return next;
        }
        public Node getPre() {
            return pre;
        }
        public T getitem(){
            return item;
        }

    }

    public Lianbiao() {

        //初始化头结点 和为节点
        this.head=new  Node(null,null,null);
        this.last=null;
        this.N=0;
    }



    //清空链表
    public  void clear(){
        this.head.next=null;
        this.last=null;
        this.head.pre=null;
        this.head.item=null;
        this.N=0;
    }

    //获取链表的长度
    public  int lLenght(){

        return  N;
    }

    //判断链表是否为空
    public  boolean isEmpty(){
        return  N==0;
    }

    //获取第一个元素
    public  T getFirst(){
        if(isEmpty()){
            return  null;
        }
        return  head.next.item;
    }

    //获取最后一个元素
    public  T getLast(){

        if(isEmpty()){
            return  null;
        }
        return  last.item;
    }

    //插入元素t
    public  void insert(T t){

        if(isEmpty()){

            //如果链表为空
            //创建新的节点
            //新节点称为为节点，头节点指向为节点
            Node newnode1 = new Node(t, head, null);
            last=newnode1;
            head.next=last;
        }else {
            //如果链表不为空
            Node oldlast=last;
            Node newnode2 = new Node(t, oldlast, null);

            //让当前节点指向新节点
            oldlast.next=newnode2;
            //让新节点成为尾结点

            last=newnode2;
            //闯进新的节点


        }
        N++;


    }

    //向指定位置i插入元素t
    public  void insert(int i,T t){
        //找到i位置的前一个节点
        Node pre=head;
        for (int j = 0; j <i ; j++) {
            pre=pre.next;
        }
        //找到当前节点


        Node curr = pre.next;
        //创建新节点
        Node newnode = new Node(t, pre, curr);
        //前一个结点指向当前节点

        pre.next=newnode;
        //新节点指向当前节点

        curr.pre=newnode;

        //元素加一
        N++;
    }


    //获取指定位置i出元素
    public  T gets(int i){
        Node curr=head.next;
        for (int j = 0; j <i ; j++) {

            curr=curr.next;
        }
        return  curr.item;
    }

    public  int  indexOf(T t){

        Node  n=head;
        for (int i = 0; n.next!=null ; i++) {
            n=n.next;
            if(n.next.equals(t)){
                return  i;
            }
        }
        return  -1;
    }


    //删除位置i出元素，并返回该元素

    public  T remove(int i){

        //找到i位置的前一个节点
        Node pre=head;
        for (int j = 0; j <i ; j++) {
            pre=pre.next;
        }

        //找到i位置节点

        Node curr = pre.next;
        //找打i位置下一个节点

        Node nextnode = curr.next;
        //i位置前一个节点变为当前节点

        pre.next=nextnode;

        //i位置下一个节点变为当前节点

        nextnode.pre=pre;


        //元素个数减一

        N--;
        return  curr.item;
    }
    @Override
    public Iterator<T> iterator() {

        return new TItrtayor();
    }

    private  class  TItrtayor implements  Iterator{

        private  Node n;
        public  TItrtayor(){
            this.n=head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.item;
        }
    }

    public void reverse() {
        if (head.next == last) {
            return;
        }
        // _ 2 3 4 5 6 _
        Node rh = new Node();
        rh.next = last;
        Node cur = head.next;
        Node cn;
        while (cur != last) {
            cn = cur.next;
            cur.next = rh.next;
            rh.next.pre = cur;
            cur.pre = rh;
            rh.next = cur;
            cur = cn;
        }
        rh.next.pre = head;
        head.next = rh.next;
    }



}
