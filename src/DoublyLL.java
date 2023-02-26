public class DoublyLL {
    public static class Node{
        Node prev;
        Node next;
        int data;
       public Node(int data){
           this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public static void addfirst(int data){
        Node n =new Node(data);
        size++;
        if(head==null){
            head=tail=n;
        }
        n.next=head;
        head.prev=n;
        head=n;
    }
    public static void addlast(int data){
        Node n=new Node(data);
        size++;
        if(head==null){
            head=tail=n;
        }
        tail.next=n;
        n.prev=tail;
        tail=n;
    }
    public void print(){
        Node temp=head;
        while (temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }

    }
    public static void removefirst(){
        if (head==null){
            System.out.println("empty");
            return;
        }
        if(size==1){
            head=tail=null;
        }
        head=head.next;
        head.prev=null;
    }
    public static void removelast(){
        if (head==null){
            System.out.println("empty");
            return;
        }
        if(size==1){
            head=tail=null;
        }
        Node temp=head;
        while (temp.next.next!=null){
            temp=temp.next;
        }
        temp.next.prev=null;
        temp.next=null;
        tail=temp;
    }
    public void reverse(){
        Node curr=tail=head;
        Node prev=null;
        Node next;
        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;

    }
    public static void main(String[] args) {
    DoublyLL dl=new DoublyLL();
    dl.addlast(4);
    dl.addlast(5);
    dl.addfirst(3);
    dl.addfirst(2);
    dl.addfirst(1);
//    dl.removefirst();
//    dl.print();
//    dl.removelast();
    dl.print();
    dl.reverse();
    dl.print();
    }
}
