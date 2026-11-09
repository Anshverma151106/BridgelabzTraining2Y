import java.util.Scanner;

public class Main {
    static class Node {
        String text;
        Node prev,next;
        Node(String t) { text=t; }
    }

    static Node head,tail,current;
    static int count=0;
    static final int LIMIT=10;
    static Scanner sc=new Scanner(System.in);

    static void addText() {
        System.out.print("Enter new complete text: ");
        String text=sc.nextLine();

        // Remove redo history if a new action is done after undo.
        if(current!=null) {
            current.next=null;
            tail=current;
        }

        Node n=new Node(text);
        if(head==null) head=tail=current=n;
        else {
            tail.next=n;
            n.prev=tail;
            tail=n;
            current=n;
        }
        count++;

        // Keep only the latest 10 states.
        if(count>LIMIT) {
            head=head.next;
            head.prev=null;
            count--;
        }
    }

    static void undo() {
        if(current==null || current.prev==null) System.out.println("Nothing to undo.");
        else current=current.prev;
        showText();
    }

    static void redo() {
        if(current==null || current.next==null) System.out.println("Nothing to redo.");
        else current=current.next;
        showText();
    }

    static void showText() {
        if(current==null) System.out.println("Text is empty.");
        else System.out.println("Current text: "+current.text);
    }

    public static void main(String[] args) {
        addText();
        while(true) {
            System.out.println("\n1.Type new text 2.Undo 3.Redo 4.Show current text 0.Exit");
            int ch=sc.nextInt(); sc.nextLine();
            if(ch==1) addText();
            else if(ch==2) undo();
            else if(ch==3) redo();
            else if(ch==4) showText();
            else if(ch==0) break;
            else System.out.println("Wrong choice.");
        }
    }
}
