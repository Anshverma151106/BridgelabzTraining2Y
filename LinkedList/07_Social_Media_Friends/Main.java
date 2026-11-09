import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static class Node {
        int id, age;
        String name;
        ArrayList<Integer> friends = new ArrayList<Integer>();
        Node next;
        Node(int i,String n,int a) { id=i; name=n; age=a; }
    }

    static Node head;
    static Scanner sc=new Scanner(System.in);

    static Node findUser(int id) {
        Node temp=head;
        while(temp!=null) {
            if(temp.id==id) return temp;
            temp=temp.next;
        }
        return null;
    }

    static void addUser() {
        System.out.print("User ID: "); int id=sc.nextInt(); sc.nextLine();
        System.out.print("Name: "); String name=sc.nextLine();
        System.out.print("Age: "); int age=sc.nextInt();
        Node n=new Node(id,name,age);
        if(head==null) head=n;
        else {
            Node temp=head;
            while(temp.next!=null) temp=temp.next;
            temp.next=n;
        }
        System.out.println("User added.");
    }

    static void addFriend() {
        System.out.print("First user ID: "); int a=sc.nextInt();
        System.out.print("Second user ID: "); int b=sc.nextInt();
        Node x=findUser(a), y=findUser(b);
        if(x==null || y==null) System.out.println("User not found.");
        else {
            if(!x.friends.contains(b)) x.friends.add(b);
            if(!y.friends.contains(a)) y.friends.add(a);
            System.out.println("Friend added.");
        }
    }

    static void removeFriend() {
        System.out.print("First user ID: "); int a=sc.nextInt();
        System.out.print("Second user ID: "); int b=sc.nextInt();
        Node x=findUser(a), y=findUser(b);
        if(x!=null) x.friends.remove(Integer.valueOf(b));
        if(y!=null) y.friends.remove(Integer.valueOf(a));
        System.out.println("Connection removed if it existed.");
    }

    static void showFriends() {
        System.out.print("User ID: "); int id=sc.nextInt();
        Node x=findUser(id);
        if(x==null) { System.out.println("User not found."); return; }
        System.out.println("Friends of "+x.name+":");
        for(int friendId:x.friends) {
            Node f=findUser(friendId);
            if(f!=null) System.out.println(f.id+" "+f.name);
        }
    }

    static void mutualFriends() {
        System.out.print("First user ID: "); int a=sc.nextInt();
        System.out.print("Second user ID: "); int b=sc.nextInt();
        Node x=findUser(a), y=findUser(b);
        if(x==null || y==null) { System.out.println("User not found."); return; }
        boolean found=false;
        for(int id:x.friends) {
            if(y.friends.contains(id)) {
                Node f=findUser(id);
                System.out.println(f.name);
                found=true;
            }
        }
        if(!found) System.out.println("No mutual friends.");
    }

    static void searchUser() {
        System.out.print("Enter user name: "); sc.nextLine();
        String name=sc.nextLine();
        Node temp=head;
        while(temp!=null && !temp.name.equalsIgnoreCase(name)) temp=temp.next;
        if(temp==null) System.out.println("User not found.");
        else System.out.println(temp.id+" "+temp.name+" "+temp.age);
    }

    static void countFriends() {
        Node temp=head;
        while(temp!=null) {
            System.out.println(temp.name+": "+temp.friends.size()+" friend(s)");
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("\n1.Add user 2.Add friend 3.Remove friend 4.Mutual friends 5.Show friends 6.Search user 7.Count friends 0.Exit");
            int ch=sc.nextInt();
            if(ch==1) addUser();
            else if(ch==2) addFriend();
            else if(ch==3) removeFriend();
            else if(ch==4) mutualFriends();
            else if(ch==5) showFriends();
            else if(ch==6) searchUser();
            else if(ch==7) countFriends();
            else if(ch==0) break;
            else System.out.println("Wrong choice.");
        }
    }
}
