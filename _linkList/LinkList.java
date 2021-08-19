package _linkList;

public class LinkList {

    public static class Node{
        int data;
        Node next;
    }

        Node head;
        Node tail;
        int size;

        public void addLast(int val){
        Node temp = new Node();
        temp.data=val;
        temp.next=null;
        if(size==0){
            head = tail = temp;
        }else{
            tail.next=temp;
            tail=temp;
        }
        size++;
    }

        public void display(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data + "");
            temp= temp.next;
        }
        System.out.println();
    }

        public int size(){
        return size;
    }

        public void removeFirst(){
        if(size==0){
            System.out.println("List is Empty!!");
        }else if(size==1){
            head=tail=null;
            size = 0;
        }else{
            head=head.next;
            size--;
        }
    }

        public int getFirst(){
        if(size==0){
            System.out.println("List is empty");
            return -1;
        }else
            return head.data;
    }

        public int getLast(){
        if(size==0){
            System.out.println("List is empty");
            return -1;
        }else
            return tail.data;
    }

        public int getAt(int idx){
        if(size==0){
            System.out.println("List is empty");
            return -1;
        }else if(idx<0 || idx>=size){
            System.out.println("Invalid argument");
            return -1;
        }else{
            Node temp = head;
            for(int i=0; i<idx; i++){
                temp=temp.next;
            }
            return temp.data;
        }
    }

        public void addFirst(int val){
        Node temp = new Node();
        temp.data=val;
        temp.next=head;
        head = temp;
        if(size==0){
            tail=temp;
        }
        size++;
    }

        public void addAt(int idx, int val){
        Node temp = new Node();
        temp.data= val;
        temp.next=null;

        if(idx<0 || idx>size){
            System.out.println("invalid argument");
        }else if(size==0){
            head = tail = temp;
            size++;
        } else if(idx==0){
            addFirst(val);
        } else{
            Node temp2 = head;
            for (int i=0; i<idx-1;i++){
                temp2=temp2.next;
            }
            temp.next = temp2.next;
            temp2.next=temp;
            if(idx==size){
                tail = temp;
            }
            size++;
        }
    }

        public void removeLast(){
        if(size==0){
            System.out.println("List is Empty!!");
        }else if(size==1){
            head=tail=null;
            size = 0;
        }else{
            Node temp = head;
            for(int i=0 ; i<size-2; i++){
                temp=temp.next;
            }
            tail=temp;
            temp.next=null;
            size--;
        }
    }

        private Node getNodeAt(int idx){
        Node temp = head;
        for(int i=0; i<idx; i++){
            temp=temp.next;
        }
        return temp;
    }

        public void reverseDI(){
        int li = 0;
        int ri = size-1;
        while(li<ri){
            Node left = getNodeAt(li);
            Node right = getNodeAt(ri);

            int temp = left.data;
            left.data=right.data;
            right.data=temp;

            li++;
            ri--;
        }
    }

        public void reversePi(){
        Node prev = null;
        Node curr = head;

        while(curr != null){
            Node currNext = curr.next;

            curr.next = prev;

            prev = curr;
            curr = currNext;
        }
        Node temp = head;
        head = tail;
        tail = temp;
    }

        public void removeAt(int idx){
        if(idx<0 || idx>=size){
            System.out.println("invalid arguments");
        }else if(size==1){
            removeFirst();
        }else if(idx==size-1){
            removeLast();
        }else{
            Node temp = head;
            for (int i=0;i<idx-1;i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;

            size--;
        }
    }

    public void reversePRHelper(Node node){
        if(node == null){
            return;
        }
        reversePRHelper(node.next);

        if(node==tail){
            //do nothing
        }else{
            node.next.next = node;
        }
    }
    public void reversePR(){
            // using recursion to reverse
        reversePRHelper(head);
        head.next=null;
        Node temp = head;
        head = tail;
        tail = temp;
    }
    /**
     * this using slow pointer and fast pointer to find the mid element
     * in even we choose left mid
     */
    public int findMiddleWithoutSize(){
        Node slow = head;
        Node fast = head;

        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.data;
    }

    /**
     * Better approach availalble on leetcode
     * use dummy and tail approach instead
     */
    static LinkList merge2SortedList(LinkList l1, LinkList l2){
        Node temp1 = l1.head;
        Node temp2 = l2.head;
        LinkList list = new LinkList();
        while(temp1!=null && temp2!=null){
            if(temp1.data > temp2.data){
                list.addLast(temp2.data);
                temp2=temp2.next;
            }else{
                list.addLast(temp1.data);
                temp1=temp1.next;
            }
        }
        while(temp1!=null){
              list.addLast(temp1.data);
              temp1=temp1.next;
         }
        while(temp2!=null){
            list.addLast(temp2.data);
            temp2=temp2.next;
        }
        return list;
    }

    

}
