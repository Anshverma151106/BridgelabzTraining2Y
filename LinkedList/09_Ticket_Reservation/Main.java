import java.util.Scanner;

public class Main {
    static class Node {
        int ticketId, seat;
        String customer, movie, time;
        Node next;
        Node(int id,String c,String m,int s,String t) {
            ticketId=id; customer=c; movie=m; seat=s; time=t;
        }
    }

    static Node head,tail;
    static Scanner sc=new Scanner(System.in);

    static void bookTicket() {
        System.out.print("Ticket ID: "); int id=sc.nextInt(); sc.nextLine();
        System.out.print("Customer name: "); String c=sc.nextLine();
        System.out.print("Movie name: "); String m=sc.nextLine();
        System.out.print("Seat number: "); int s=sc.nextInt(); sc.nextLine();
        System.out.print("Booking time: "); String t=sc.nextLine();

        Node n=new Node(id,c,m,s,t);
        if(head==null) {
            head=tail=n;
            n.next=head;
        } else {
            tail.next=n;
            tail=n;
            tail.next=head;
        }
        System.out.println("Ticket booked.");
    }

    static void cancelTicket() {
        System.out.print("Ticket ID: "); int id=sc.nextInt();
        if(head==null) { System.out.println("No bookings."); return; }

        Node temp=head, prev=tail;
        do {
            if(temp.ticketId==id) {
                if(head==tail) head=tail=null;
                else {
                    prev.next=temp.next;
                    if(temp==head) head=temp.next;
                    if(temp==tail) tail=prev;
                    tail.next=head;
                }
                System.out.println("Ticket cancelled.");
                return;
            }
            prev=temp;
            temp=temp.next;
        } while(temp!=head);
        System.out.println("Ticket not found.");
    }

    static void displayTickets() {
        if(head==null) { System.out.println("No tickets booked."); return; }
        Node temp=head;
        do {
            System.out.println(temp.ticketId+" | "+temp.customer+" | "+temp.movie+" | Seat "+temp.seat+" | "+temp.time);
            temp=temp.next;
        } while(temp!=head);
    }

    static void searchTicket() {
        System.out.print("Enter customer name: ");
        String name=sc.nextLine();
        if(head==null) { System.out.println("No bookings."); return; }
        Node temp=head;
        boolean found=false;
        do {
            if(temp.customer.equalsIgnoreCase(name)) {
                System.out.println(temp.ticketId+" "+temp.movie+" Seat "+temp.seat);
                found=true;
            }
            temp=temp.next;
        } while(temp!=head);
        if(!found) System.out.println("Ticket not found.");
    }

    static void countTickets() {
        int count=0;
        if(head!=null) {
            Node temp=head;
            do {
                count++;
                temp=temp.next;
            } while(temp!=head);
        }
        System.out.println("Total booked tickets: "+count);
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("\n1.Book ticket 2.Cancel ticket 3.Display tickets 4.Search customer 5.Count tickets 0.Exit");
            int ch=sc.nextInt(); sc.nextLine();
            if(ch==1) bookTicket();
            else if(ch==2) cancelTicket();
            else if(ch==3) displayTickets();
            else if(ch==4) searchTicket();
            else if(ch==5) countTickets();
            else if(ch==0) break;
            else System.out.println("Wrong choice.");
        }
    }
}
