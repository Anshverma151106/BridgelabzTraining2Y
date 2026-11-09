import java.util.Scanner;

public class Main {
    static class Node {
        int roll, age;
        String name, grade;
        Node next;

        Node(int r, String n, int a, String g) {
            roll = r; name = n; age = a; grade = g;
        }
    }

    static Node head;
    static Scanner sc = new Scanner(System.in);

    static void addEnd() {
        System.out.print("Roll number: ");
        int r = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String n = sc.nextLine();
        System.out.print("Age: ");
        int a = sc.nextInt();
        sc.nextLine();
        System.out.print("Grade: ");
        String g = sc.nextLine();

        Node newNode = new Node(r, n, a, g);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        System.out.println("Student added.");
    }

    static void addAtPosition() {
        System.out.print("Position: ");
        int pos = sc.nextInt();
        sc.nextLine();
        System.out.print("Roll number: ");
        int r = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String n = sc.nextLine();
        System.out.print("Age: ");
        int a = sc.nextInt();
        sc.nextLine();
        System.out.print("Grade: ");
        String g = sc.nextLine();

        Node newNode = new Node(r, n, a, g);
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position.");
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Student added.");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter roll number: ");
        int r = sc.nextInt();

        if (head == null) {
            System.out.println("List is empty.");
        } else if (head.roll == r) {
            head = head.next;
            System.out.println("Student deleted.");
        } else {
            Node temp = head;
            while (temp.next != null && temp.next.roll != r)
                temp = temp.next;

            if (temp.next == null) System.out.println("Student not found.");
            else {
                temp.next = temp.next.next;
                System.out.println("Student deleted.");
            }
        }
    }

    static void searchStudent() {
        System.out.print("Enter roll number: ");
        int r = sc.nextInt();
        Node temp = head;

        while (temp != null && temp.roll != r) temp = temp.next;

        if (temp == null) System.out.println("Student not found.");
        else System.out.println(temp.roll + " " + temp.name + " " + temp.age + " " + temp.grade);
    }

    static void display() {
        Node temp = head;
        if (temp == null) System.out.println("No student records.");

        while (temp != null) {
            System.out.println(temp.roll + " | " + temp.name + " | " + temp.age + " | " + temp.grade);
            temp = temp.next;
        }
    }

    static void updateGrade() {
        System.out.print("Enter roll number: ");
        int r = sc.nextInt();
        sc.nextLine();
        Node temp = head;

        while (temp != null && temp.roll != r) temp = temp.next;

        if (temp == null) System.out.println("Student not found.");
        else {
            System.out.print("Enter new grade: ");
            temp.grade = sc.nextLine();
            System.out.println("Grade updated.");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Add at end  2.Add at position  3.Delete  4.Search  5.Display  6.Update grade  0.Exit");
            int ch = sc.nextInt();

            if (ch == 1) addEnd();
            else if (ch == 2) addAtPosition();
            else if (ch == 3) deleteStudent();
            else if (ch == 4) searchStudent();
            else if (ch == 5) display();
            else if (ch == 6) updateGrade();
            else if (ch == 0) break;
            else System.out.println("Wrong choice.");
        }
    }
}
