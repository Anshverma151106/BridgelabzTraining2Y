import java.util.Scanner;

public class Main {
    static class Node {
        String title, author, genre;
        int id;
        boolean available;
        Node prev,next;
        Node(String t,String a,String g,int i,boolean av) {
            title=t; author=a; genre=g; id=i; available=av;
        }
    }

    static Node head,tail;
    static Scanner sc=new Scanner(System.in);

    static void addBook() {
        System.out.print("Book title: "); String t=sc.nextLine();
        System.out.print("Author: "); String a=sc.nextLine();
        System.out.print("Genre: "); String g=sc.nextLine();
        System.out.print("Book ID: "); int id=sc.nextInt();
        System.out.print("Available (true/false): "); boolean av=sc.nextBoolean(); sc.nextLine();
        Node n=new Node(t,a,g,id,av);
        if(head==null) head=tail=n;
        else { tail.next=n; n.prev=tail; tail=n; }
        System.out.println("Book added.");
    }

    static void addAtPosition() {
        System.out.print("Position: "); int pos=sc.nextInt(); sc.nextLine();
        System.out.print("Book title: "); String t=sc.nextLine();
        System.out.print("Author: "); String a=sc.nextLine();
        System.out.print("Genre: "); String g=sc.nextLine();
        System.out.print("Book ID: "); int id=sc.nextInt();
        System.out.print("Available (true/false): "); boolean av=sc.nextBoolean(); sc.nextLine();
        Node n=new Node(t,a,g,id,av);

        if(pos==1) {
            if(head==null) tail=n;
            else { n.next=head; head.prev=n; }
            head=n; return;
        }
        Node temp=head;
        for(int i=1;temp!=null && i<pos-1;i++) temp=temp.next;
        if(temp==null) System.out.println("Invalid position.");
        else if(temp==tail) { tail.next=n; n.prev=tail; tail=n; }
        else { n.next=temp.next; n.prev=temp; temp.next.prev=n; temp.next=n; }
    }

    static void deleteBook() {
        System.out.print("Book ID: "); int id=sc.nextInt();
        Node temp=head;
        while(temp!=null && temp.id!=id) temp=temp.next;
        if(temp==null) System.out.println("Book not found.");
        else {
            if(temp.prev==null) head=temp.next;
            else temp.prev.next=temp.next;
            if(temp.next==null) tail=temp.prev;
            else temp.next.prev=temp.prev;
            System.out.println("Book deleted.");
        }
    }

    static void searchBook() {
        System.out.print("Book title: "); String title=sc.nextLine();
        Node temp=head; boolean found=false;
        while(temp!=null) {
            if(temp.title.equalsIgnoreCase(title)) {
                System.out.println(temp.title+" | "+temp.author+" | "+temp.genre+" | "+temp.id);
                found=true;
            }
            temp=temp.next;
        }
        if(!found) System.out.println("Book not found.");
    }

    static void updateStatus() {
        System.out.print("Book ID: "); int id=sc.nextInt();
        Node temp=head;
        while(temp!=null && temp.id!=id) temp=temp.next;
        if(temp==null) System.out.println("Book not found.");
        else { System.out.print("Available (true/false): "); temp.available=sc.nextBoolean(); }
    }

    static void forward() {
        Node temp=head;
        while(temp!=null) {
            System.out.println(temp.title+" | "+temp.author+" | "+temp.id+" | "+(temp.available?"Available":"Not available"));
            temp=temp.next;
        }
    }

    static void reverse() {
        Node temp=tail;
        while(temp!=null) {
            System.out.println(temp.title+" | "+temp.author+" | "+temp.id);
            temp=temp.prev;
        }
    }

    static void countBooks() {
        int count=0;
        Node temp=head;
        while(temp!=null) { count++; temp=temp.next; }
        System.out.println("Total books: "+count);
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("\n1.Add book 2.Add at position 3.Delete by ID 4.Search by title 5.Update availability 6.Forward 7.Reverse 8.Count 0.Exit");
            int ch=sc.nextInt(); sc.nextLine();
            if(ch==1) addBook();
            else if(ch==2) addAtPosition();
            else if(ch==3) deleteBook();
            else if(ch==4) searchBook();
            else if(ch==5) updateStatus();
            else if(ch==6) forward();
            else if(ch==7) reverse();
            else if(ch==8) countBooks();
            else if(ch==0) break;
            else System.out.println("Wrong choice.");
        }
    }
}
