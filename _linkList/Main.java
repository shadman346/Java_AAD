package _linkList;

public class Main {
    public static void main(String[] args){
        LinkList list = new LinkList();
        list.addFirst(12);
        list.addLast(55);
        list.addFirst(5);
        list.display();

        list.addAt(1,9);
        list.display();
        list.reversePi();
        list.display();
        list.reverseDI();


    }

//    public static class Node{
//        int data;
//        Node next;
//    }
//
//    public static class LinkListtemp{
//        Node head;
//        Node tail;
//        int size;
//
//        public void addLast(int val){
//            Node temp = new Node();
//            temp.data=val;
//            temp.next=null;
//                if(size==0){
//                    head = tail = temp;
//                }else{
//                    tail.next=temp;
//                    tail=temp;
//                }
//            size++;
//        }
//
//        public void display(){
//            Node temp = head;
//            while (temp != null){
//                System.out.println(temp.data + "");
//                temp= temp.next;
//            }
//            System.out.println();
//        }
//
//        public int size(){
//            return size;
//        }
//
//        public void removeFirst(){
//            if(size==0){
//                System.out.println("List is Empty!!");
//            }else if(size==1){
//                head=tail=null;
//                size = 0;
//            }else{
//                head=head.next;
//                size--;
//            }
//        }
//
//        public int getFirst(){
//            if(size==0){
//                System.out.println("List is empty");
//                return -1;
//            }else
//                return head.data;
//        }
//
//        public int getLast(){
//            if(size==0){
//                System.out.println("List is empty");
//                return -1;
//            }else
//                return tail.data;
//        }
//
//        public int getAt(int idx){
//            if(size==0){
//                System.out.println("List is empty");
//                return -1;
//            }else if(idx<0 || idx>=size){
//                System.out.println("Invalid argument");
//                return -1;
//            }else{
//                Node temp = head;
//                for(int i=0; i<idx; i++){
//                    temp=temp.next;
//                }
//                return temp.data;
//            }
//        }
//
//        public void addFirst(int val){
//            Node temp = new Node();
//            temp.data=val;
//            temp.next=head;
//            head = temp;
//            if(size==0){
//                tail=temp;
//            }
//            size++;
//        }
//
//        public void addAt(int idx, int val){
//            Node temp = new Node();
//            temp.data= val;
//            temp.next=null;
//
//            if(idx<0 || idx>size){
//                System.out.println("invalid argument");
//            }else if(size==0){
//                head = tail = temp;
//                size++;
//            } else{
//                Node temp2 = head;
//                for (int i=0; i<idx-1;i++){
//                    temp2=temp2.next;
//                }
//                temp.next = temp2.next;
//                temp2.next=temp;
//                if(idx==size){
//                    tail = temp;
//                }
//                size++;
//            }
//        }
//
//        public void removeLast(){
//            if(size==0){
//                System.out.println("List is Empty!!");
//            }else if(size==1){
//                head=tail=null;
//                size = 0;
//            }else{
//                Node temp = head;
//                for(int i=0 ; i<size-2; i++){
//                    temp=temp.next;
//                }
//                tail=temp;
//                temp.next=null;
//                size--;
//            }
//        }
//
//        private Node getNodeAt(int idx){
//            Node temp = head;
//            for(int i=0; i<idx; i++){
//                temp=temp.next;
//            }
//            return temp;
//        }
//
//        public void reverseDI(){
//            int li = 0;
//            int ri = size-1;
//            while(li<ri){
//                Node left = getNodeAt(li);
//                Node right = getNodeAt(ri);
//
//                int temp = left.data;
//                left.data=right.data;
//                right.data=temp;
//
//                li++;
//                ri++;
//            }
//        }
//
//        public void reversePi(){
//            Node prev = null;
//            Node curr = head;
//
//            while(curr != null){
//                Node currNext = curr.next;
//
//                curr.next = prev;
//
//                prev = curr;
//                curr = currNext;
//            }
//            Node temp = head;
//            head = tail;
//            tail = temp;
//        }
//
//        public void removeAt(int idx){
//            if(idx<0 || idx>=size){
//                System.out.println("invalid arguments");
//            }else if(size==1){
//                removeFirst();
//            }else if(idx==size-1){
//                removeLast();
//            }else{
//                Node temp = head;
//                for (int i=0;i<idx-1;i++){
//                    temp = temp.next;
//                }
//                temp.next = temp.next.next;
//
//                size--;
//            }
//        }
//    }
}
