import java.util.Scanner;

public class Main {
    static class Node {
        int id, priority;
        String name, date;
        Node next;
        Node(int i, String n, int p, String d) {
            id=i; name=n; priority=p; date=d;
        }
    }

    static Node head, tail, current;
    static Scanner sc = new Scanner(System.in);

    static void addTask() {
        System.out.print("Task ID: "); int id=sc.nextInt(); sc.nextLine();
        System.out.print("Task name: "); String name=sc.nextLine();
        System.out.print("Priority: "); int p=sc.nextInt(); sc.nextLine();
        System.out.print("Due date: "); String date=sc.nextLine();

        Node n=new Node(id,name,p,date);
        if(head==null) {
            head=tail=current=n;
            n.next=head;
        } else {
            tail.next=n;
            tail=n;
            tail.next=head;
        }
        System.out.println("Task added.");
    }

    static void addAtPosition() {
        System.out.print("Position: "); int pos=sc.nextInt(); sc.nextLine();
        System.out.print("Task ID: "); int id=sc.nextInt(); sc.nextLine();
        System.out.print("Task name: "); String name=sc.nextLine();
        System.out.print("Priority: "); int p=sc.nextInt(); sc.nextLine();
        System.out.print("Due date: "); String date=sc.nextLine();
        Node n=new Node(id,name,p,date);

        if(pos==1) {
            if(head==null) { head=tail=current=n; n.next=head; }
            else { n.next=head; head=n; tail.next=head; }
            return;
        }
        Node temp=head;
        int i=1;
        while(temp!=null && i<pos-1 && temp.next!=head) { temp=temp.next; i++; }
        if(temp==null || i!=pos-1) System.out.println("Invalid position.");
        else {
            n.next=temp.next; temp.next=n;
            if(temp==tail) tail=n;
        }
    }

    static void deleteTask() {
        System.out.print("Task ID: "); int id=sc.nextInt();
        if(head==null) { System.out.println("List is empty."); return; }

        Node temp=head, prev=tail;
        do {
            if(temp.id==id) {
                if(head==tail) head=tail=current=null;
                else {
                    prev.next=temp.next;
                    if(temp==head) head=temp.next;
                    if(temp==tail) tail=prev;
                    if(current==temp) current=temp.next;
                    tail.next=head;
                }
                System.out.println("Task deleted.");
                return;
            }
            prev=temp; temp=temp.next;
        } while(temp!=head);
        System.out.println("Task not found.");
    }

    static void showCurrent() {
        if(current==null) System.out.println("No task.");
        else {
            System.out.println("Current task: "+current.id+" "+current.name);
            current=current.next;
        }
    }

    static void display() {
        if(head==null) { System.out.println("No tasks."); return; }
        Node temp=head;
        do {
            System.out.println(temp.id+" | "+temp.name+" | "+temp.priority+" | "+temp.date);
            temp=temp.next;
        } while(temp!=head);
    }

    static void searchPriority() {
        System.out.print("Priority: "); int p=sc.nextInt();
        if(head==null) { System.out.println("No tasks."); return; }
        Node temp=head; boolean found=false;
        do {
            if(temp.priority==p) { System.out.println(temp.id+" "+temp.name); found=true; }
            temp=temp.next;
        } while(temp!=head);
        if(!found) System.out.println("No task with this priority.");
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("\n1.Add task 2.Add at position 3.Delete task 4.Current/Next task 5.Display 6.Search priority 0.Exit");
            int ch=sc.nextInt();
            if(ch==1) addTask();
            else if(ch==2) addAtPosition();
            else if(ch==3) deleteTask();
            else if(ch==4) showCurrent();
            else if(ch==5) display();
            else if(ch==6) searchPriority();
            else if(ch==0) break;
            else System.out.println("Wrong choice.");
        }
    }
}
