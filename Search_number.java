import java.util.*;
class Search_number{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of rows  ");
        int a=sc.nextInt();
        System.out.print("Enter the number of columns  ");
        int b=sc.nextInt();
        int arr[][]=new int[a][b];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                System.out.print("Enter the number  ");
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.print("Enter the you want to search  ");
        int search=sc.nextInt();
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(arr[i][j]==search){
                    System.out.println("The index value is ["+i+"]["+j+"]");
                }
            }
        }
    }
}