import java.util.Scanner;

public class Main {
    static class Node {
        int id, burst, remaining, priority;
        Node next;
        Node(int i,int b,int p) { id=i; burst=b; remaining=b; priority=p; }
    }

    static Node head,tail;
    static Scanner sc=new Scanner(System.in);

    static void addProcess() {
        System.out.print("Process ID: "); int id=sc.nextInt();
        System.out.print("Burst time: "); int b=sc.nextInt();
        System.out.print("Priority: "); int p=sc.nextInt();
        Node n=new Node(id,b,p);
        if(head==null) { head=tail=n; n.next=head; }
        else { tail.next=n; tail=n; tail.next=head; }
        System.out.println("Process added.");
    }

    static void display() {
        if(head==null) { System.out.println("No processes."); return; }
        Node temp=head;
        do {
            System.out.print("P"+temp.id+"(remaining "+temp.remaining+") ");
            temp=temp.next;
        } while(temp!=head);
        System.out.println();
    }

    static void runRoundRobin() {
        if(head==null) { System.out.println("No processes."); return; }
        System.out.print("Time quantum: "); int quantum=sc.nextInt();
        if(quantum<=0) { System.out.println("Enter a positive quantum."); return; }

        int time=0, totalWaiting=0, totalTurnaround=0, completed=0;
        Node current=head, previous=tail;

        while(head!=null) {
            if(current.remaining>0) {
                if(current.remaining>quantum) {
                    current.remaining-=quantum;
                    time+=quantum;
                } else {
                    time+=current.remaining;
                    current.remaining=0;
                    totalTurnaround+=time;
                    totalWaiting+=time-current.burst;
                    completed++;
                }
            }

            if(current.remaining==0) {
                if(current==head && current==tail) {
                    head=tail=null;
                    break;
                }
                previous.next=current.next;
                if(current==head) head=current.next;
                if(current==tail) tail=previous;
                current=previous.next;
                tail.next=head;
            } else {
                previous=current;
                current=current.next;
            }

            System.out.print("Current queue: ");
            display();
        }

        System.out.println("Average waiting time: "+(double)totalWaiting/completed);
        System.out.println("Average turnaround time: "+(double)totalTurnaround/completed);
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("\n1.Add process 2.Display 3.Run Round Robin 0.Exit");
            int ch=sc.nextInt();
            if(ch==1) addProcess();
            else if(ch==2) display();
            else if(ch==3) runRoundRobin();
            else if(ch==0) break;
            else System.out.println("Wrong choice.");
        }
    }
}
