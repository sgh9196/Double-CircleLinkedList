import java.util.Scanner;

public class Main {
   
    static Scanner sc = new Scanner(System.in);
   
    public static void main(String[] args) {
       
        LinkedList l = new LinkedList();
        Node n = new Node();
       
        n = l.CreateNode();
       
        Loop:
            for(;;) {
               
                System.out.print("1. Add\t    2. NextInsert\t3. PreInsert\t4. Search\t5. Delete\t"
                                        + "6. Sort\t7. Print\nSelete >> ");
               
                switch(sc.nextInt()) {
                    case 1:
                        System.out.print("Data : ");
                        l.AddNode(n, sc.nextInt());
                        break;
                    case 2:
                        System.out.print("NextInsert >> Search, Data : ");
                        l.NextInsertNode(n, sc.nextInt(), sc.nextInt());
                        break;
                    case 3:
                        System.out.print("PreInsert >> Search, Data : ");
                        l.PreInsertNode(n, sc.nextInt(), sc.nextInt());
                        break;
                    case 4:
                        System.out.print("Search : ");
                        System.out.println("Count : " + l.SearchNode(n, sc.nextInt()));
                        break;
                    case 5:
                        System.out.print("Delete >> Search : ");
                        l.DeleteNode(n, sc.nextInt());
                        break;
                    case 6:
                       
                        break;
                    case 7:
                        System.out.println("-------------");
                        l.PrintNode(n);
                        System.out.println("-------------");
                        break;
                    default:
                        System.out.println("------EXIT------");
                        break Loop;
               
                }
               
            }
       
    }
}