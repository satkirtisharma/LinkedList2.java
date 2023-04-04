public class linkedlist {
    public  static class Node{
        Node next;
        int data;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public  void addfirst(int data){
        Node newNode =new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public  void addlast(int data){
        Node newNode =new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void index(int index, int data){
        if(index==0){
            addfirst(data);
            return;
        }
        Node NewNode=new Node(data);
        size++;
        Node temp=head;
        while (index-- > 1){
            temp=temp.next;
        }
        NewNode.next=temp.next;
        temp.next=NewNode;
    }
    public void printlinkedlist(){
        Node temp=head;
        if (head==null){
            System.out.println("empty");
        }
        while (temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public void removefirst(){
        if (head==null){
            System.out.println("empty");
            return;
        }
        if(size==1){
            head=tail=null;
            size--;
            return;
        }
        head=head.next;
        size--;
    }
    public void removelast(){
        if (head==null){
            System.out.println("empty");
            return;
        }
        if(size==1){
            head=tail=null;
            size--;
        }
        Node temp=head;
        while (temp.next!=tail){
            temp=temp.next;
        }
        temp.next=null;
        tail=temp;
        size--;
    }
    public int searchkey(int key){
        Node temp=head;
        int i=0;
        while (temp!=null){
            i++;
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
        }
        return -1;
    }
    public void deletefromlast(int pos){
        pos =size-pos;
        Node temp=head;
        for (int i=1;i<pos;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;

    }
    public Node getmid(){
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public  boolean checkpallindrome(){
        if (head==null||head.next==null){
            return true;
        }
        Node curr=getmid();
        Node prev=null;
        Node next;
        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node rhead=prev;
        Node lhead=head;
        while (rhead!=null){
            if (rhead.data!=lhead.data){
                return false;
            }
            rhead=rhead.next;
            lhead=lhead.next;
        }
        return true;

    }
    public void reverse(){
        Node prev =null;
        Node curr=tail=head;
        Node next;
        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public  static Node head;
    public static Node tail;
    public static int size;
    public static void main(String[] args) {
        linkedlist ll=new linkedlist();
        ll.addfirst(3);
        ll.addfirst(2);
//        ll.addfirst(1);
//        ll.addlast(4);
//        ll.addlast(5);
//        ll.addlast(6);
        ll.printlinkedlist();
        //  System.out.println("hjsfdb");
////        ll.index(1,9);
////        ll.printlinkedlist();
////        ll.removefirst();
////        ll.printlinkedlist();
//        ll.removelast();
//        ll.reverse();
//        ll.printlinkedlist();
        //System.out.println(ll.searchkey(5));
//        ll.deletefromlast(3);
//        ll.printlinkedlist();
        System.out.println(ll.checkpallindrome());
        ll.addlast(3);
        ll.addlast(2);
        ll.printlinkedlist();
        System.out.println(ll.checkpallindrome());
    }
}
