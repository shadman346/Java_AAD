package _linkList;

import java.util.LinkedList;

public class ReverseLLusingRecursion {
    public static void main(String[] args) {
        LinkList li = new LinkList();

        li.addLast(10);
        li.addLast(20);
        li.addLast(30);
        li.addLast(40);
        li.addLast(50);
        li.addLast(-60);
        li.display();
        System.out.println(li.findMiddleWithoutSize());

    }

}
