package lw04.prelab;
import java.util.*;

public class Main {
    void inverseInsertion (int a[]) {
        for (int i = 1; i < a.length && i <= 3; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] < key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    public static void main(String[]args) {
        Scanner yey = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        int a[] = new int[yey.nextInt()];
        for (int i = 0; i < a.length; i++) {
            a[i] = yey.nextInt();
        }
        

        Main obj = new Main();
        obj.inverseInsertion(a);

        int n = a.length;
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
        

        int b = yey.nextInt();
        for (int i = 0; i < b; i++) {
            int c = yey.nextInt();
            for (int j = 0; j < n; j++) {
                if (a[j] == c) {
                    System.out.println(c + ": FOUND at index " + j);
                    break;
                } else if (j == n - 1) {
                    System.out.println(c + ": NOT FOUND");
                }
            }
        }

        yey.close();
    }
}
