import java.util.Scanner;

public class Main {
    static class Node {
        String title, director;
        int year;
        double rating;
        Node prev, next;

        Node(String t, String d, int y, double r) {
            title=t; director=d; year=y; rating=r;
        }
    }

    static Node head, tail;
    static Scanner sc = new Scanner(System.in);

    static void addMovie() {
        System.out.print("Movie title: ");
        String t = sc.nextLine();
        System.out.print("Director: ");
        String d = sc.nextLine();
        System.out.print("Release year: ");
        int y = sc.nextInt();
        System.out.print("Rating: ");
        double r = sc.nextDouble();
        sc.nextLine();

        Node n = new Node(t,d,y,r);
        if (head == null) head = tail = n;
        else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        System.out.println("Movie added.");
    }

    static void addAtPosition() {
        System.out.print("Position: ");
        int pos = sc.nextInt();
        sc.nextLine();
        System.out.print("Movie title: ");
        String t = sc.nextLine();
        System.out.print("Director: ");
        String d = sc.nextLine();
        System.out.print("Year: ");
        int y = sc.nextInt();
        System.out.print("Rating: ");
        double r = sc.nextDouble();
        sc.nextLine();
        Node n = new Node(t,d,y,r);

        if (pos == 1) {
            if (head == null) tail = n;
            else { n.next = head; head.prev = n; }
            head = n;
            return;
        }

        Node temp = head;
        for (int i=1; temp != null && i<pos-1; i++) temp=temp.next;
        if (temp == null) System.out.println("Invalid position.");
        else if (temp == tail) {
            tail.next=n; n.prev=tail; tail=n;
        } else {
            n.next=temp.next; n.prev=temp;
            temp.next.prev=n; temp.next=n;
        }
    }

    static void deleteMovie() {
        System.out.print("Title to delete: ");
        String t = sc.nextLine();
        Node temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(t)) temp=temp.next;

        if (temp == null) System.out.println("Movie not found.");
        else {
            if (temp.prev == null) head=temp.next;
            else temp.prev.next=temp.next;
            if (temp.next == null) tail=temp.prev;
            else temp.next.prev=temp.prev;
            System.out.println("Movie deleted.");
        }
    }

    static void searchMovie() {
        System.out.print("Enter director name: ");
        String d = sc.nextLine();
        Node temp=head;
        boolean found=false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(d)) {
                System.out.println(temp.title+" | "+temp.director+" | "+temp.year+" | "+temp.rating);
                found=true;
            }
            temp=temp.next;
        }
        if (!found) System.out.println("No movie found.");
    }

    static void displayForward() {
        Node temp=head;
        while(temp!=null) {
            System.out.println(temp.title+" | "+temp.director+" | "+temp.year+" | "+temp.rating);
            temp=temp.next;
        }
    }

    static void displayReverse() {
        Node temp=tail;
        while(temp!=null) {
            System.out.println(temp.title+" | "+temp.director+" | "+temp.year+" | "+temp.rating);
            temp=temp.prev;
        }
    }

    static void updateRating() {
        System.out.print("Movie title: ");
        String t=sc.nextLine();
        Node temp=head;
        while(temp!=null && !temp.title.equalsIgnoreCase(t)) temp=temp.next;
        if(temp==null) System.out.println("Movie not found.");
        else {
            System.out.print("New rating: ");
            temp.rating=sc.nextDouble();
            sc.nextLine();
            System.out.println("Rating updated.");
        }
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("\n1.Add movie 2.Add at position 3.Delete 4.Search by director 5.Forward 6.Reverse 7.Update rating 0.Exit");
            int ch=sc.nextInt(); sc.nextLine();
            if(ch==1) addMovie();
            else if(ch==2) addAtPosition();
            else if(ch==3) deleteMovie();
            else if(ch==4) searchMovie();
            else if(ch==5) displayForward();
            else if(ch==6) displayReverse();
            else if(ch==7) updateRating();
            else if(ch==0) break;
            else System.out.println("Wrong choice.");
        }
    }
}
