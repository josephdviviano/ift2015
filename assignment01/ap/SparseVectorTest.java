package hw1;
import java.util.Scanner;

/** Class SparseVector **/
public class SparseVectorTest
{
    public static void main(String[] args)
    {
        System.out.println("Sparse Vector Test\n");
        Scanner scan = new Scanner(System.in);
 
        System.out.println("Enter size of sparse vector");
        int n = scan.nextInt();
        
        SparseVector v1 = new SparseVector(n);
        
        // set() test
        v1.set(2, 31);
        v1.set(8, 89);
        v1.set(0, 101);
        v1.set(1, 81);
        v1.set(9, 1010);	
        v1.printList();
        
        // Print list
        v1.printList();
        System.out.println(v1.size() + "  " + v1.length());
    }
}
