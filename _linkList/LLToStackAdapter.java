package _linkList;

public class LLToStackAdapter {
    LinkList list ;

    public LLToStackAdapter(){
        list = new LinkList();
    }

    int size(){
        return list.size;
    }

    void push(int val){
        list.addFirst(val);
    }

    void pop(){
        if(size()==0){
            System.out.println("Stack underflow");
        }else{
            list.removeFirst();
        }
    }

    int top(){
        if(size()==0){
            System.out.println("stack is empty");
            return -1;
        }else{
            return list.getFirst();
        }
    }
}
