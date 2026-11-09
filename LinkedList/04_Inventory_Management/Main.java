import java.util.Scanner;

public class Main {
    static class Node {
        String name;
        int id, quantity;
        double price;
        Node next;
        Node(String n,int i,int q,double p) { name=n; id=i; quantity=q; price=p; }
    }

    static Node head;
    static Scanner sc=new Scanner(System.in);

    static void addItem() {
        System.out.print("Item name: "); String n=sc.nextLine();
        System.out.print("Item ID: "); int id=sc.nextInt();
        System.out.print("Quantity: "); int q=sc.nextInt();
        System.out.print("Price: "); double p=sc.nextDouble(); sc.nextLine();
        Node newNode=new Node(n,id,q,p);

        if(head==null) head=newNode;
        else {
            Node temp=head;
            while(temp.next!=null) temp=temp.next;
            temp.next=newNode;
        }
        System.out.println("Item added.");
    }

    static void addAtPosition() {
        System.out.print("Position: "); int pos=sc.nextInt(); sc.nextLine();
        System.out.print("Item name: "); String n=sc.nextLine();
        System.out.print("Item ID: "); int id=sc.nextInt();
        System.out.print("Quantity: "); int q=sc.nextInt();
        System.out.print("Price: "); double p=sc.nextDouble(); sc.nextLine();
        Node newNode=new Node(n,id,q,p);

        if(pos==1) { newNode.next=head; head=newNode; return; }
        Node temp=head;
        for(int i=1;temp!=null && i<pos-1;i++) temp=temp.next;
        if(temp==null) System.out.println("Invalid position.");
        else { newNode.next=temp.next; temp.next=newNode; }
    }

    static void deleteItem() {
        System.out.print("Item ID: "); int id=sc.nextInt();
        if(head==null) { System.out.println("List is empty."); return; }
        if(head.id==id) { head=head.next; System.out.println("Deleted."); return; }
        Node temp=head;
        while(temp.next!=null && temp.next.id!=id) temp=temp.next;
        if(temp.next==null) System.out.println("Item not found.");
        else { temp.next=temp.next.next; System.out.println("Deleted."); }
    }

    static void updateQuantity() {
        System.out.print("Item ID: "); int id=sc.nextInt();
        Node temp=head;
        while(temp!=null && temp.id!=id) temp=temp.next;
        if(temp==null) System.out.println("Item not found.");
        else { System.out.print("New quantity: "); temp.quantity=sc.nextInt(); }
    }

    static void searchItem() {
        System.out.print("Enter item ID: "); int id=sc.nextInt();
        Node temp=head;
        while(temp!=null && temp.id!=id) temp=temp.next;
        if(temp==null) System.out.println("Item not found.");
        else System.out.println(temp.name+" "+temp.id+" "+temp.quantity+" "+temp.price);
    }

    static void display() {
        Node temp=head;
        while(temp!=null) {
            System.out.println(temp.name+" | "+temp.id+" | Qty: "+temp.quantity+" | Price: "+temp.price);
            temp=temp.next;
        }
    }

    static void totalValue() {
        double total=0;
        Node temp=head;
        while(temp!=null) {
            total=total+(temp.price*temp.quantity);
            temp=temp.next;
        }
        System.out.println("Total inventory value: "+total);
    }

    static void sortByPrice() {
        for(Node i=head;i!=null;i=i.next) {
            for(Node j=i.next;j!=null;j=j.next) {
                if(i.price>j.price) {
                    double p=i.price; i.price=j.price; j.price=p;
                    String n=i.name; i.name=j.name; j.name=n;
                    int id=i.id; i.id=j.id; j.id=id;
                    int q=i.quantity; i.quantity=j.quantity; j.quantity=q;
                }
            }
        }
        System.out.println("Sorted by price.");
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("\n1.Add item 2.Add at position 3.Delete 4.Update quantity 5.Search by ID 6.Display 7.Total value 8.Sort by price 0.Exit");
            int ch=sc.nextInt(); sc.nextLine();
            if(ch==1) addItem();
            else if(ch==2) addAtPosition();
            else if(ch==3) deleteItem();
            else if(ch==4) updateQuantity();
            else if(ch==5) searchItem();
            else if(ch==6) display();
            else if(ch==7) totalValue();
            else if(ch==8) sortByPrice();
            else if(ch==0) break;
            else System.out.println("Wrong choice.");
        }
    }
}
