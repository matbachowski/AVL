//package asd.avl;
//
//public class Main {
//
//    public static void main(String[] args) {
//	// write your code here
//    }
//}

package asd.avl;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException {
        IBST<Integer> bst = new AVL<>();
        int[] tab;
        //tab = new int[]{7, 15, 5, 1, 9, 10, 2, 6, 20, 17, 22, 19, 21, 23};
        tab = new int[]{1,2,3,4,5,6,7,8};
        //tab = new int[]{8,7,12,10,9,4,3,2,1,0};
        for (int i : tab) {
            bst.wstaw(i);
            System.out.println(bst.toString());
            //System.in.read();
        }
        System.out.println(bst.toString());


        System.out.println("Odnajdywanie");
        System.out.println("-----------Odnajdywanie wartości 8, która nie występuje-----------");
        System.out.println(bst.czyJest(8));
        System.out.println("-----------Odnajdywanie wartości 6, która występuje na liście-----------");
        System.out.println(bst.czyJest(6));
        System.out.println("-----------Minimum-----------");
        System.out.println(bst.minimum());
        System.out.println("-----------Maksimum-----------");
        System.out.println(bst.maksimum());
    }
}
