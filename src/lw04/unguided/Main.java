package lw04.unguided;
import java.util.*;

public class Main {
    
    static void selectionSort(int[] arr, int passes) {
        int n = arr.length;
        for (int i = 0; i < passes && i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; 
    }
    
    public static void main(String[] args) {
            Scanner nuhuh = new Scanner(Main.class.getResourceAsStream("cards.txt"));

            
            int n = nuhuh.nextInt();
            int[] cards = new int[n];
            for (int i = 0; i < n; i++) {
                cards[i] = nuhuh.nextInt();
            }

            int m = nuhuh.nextInt();
            int[] queries = new int[m];
            for (int i = 0; i < m; i++) {
                queries[i] = nuhuh.nextInt();
            }
            nuhuh.close();
            
            selectionSort(cards, 2);
            
            for (int i = 0; i < cards.length; i++) {
                System.out.print(cards[i] + (i < cards.length - 1 ? " " : ""));
            }
            System.out.println();

            for (int i = 0; i < m; i++) {
                int target = queries[i];
                int index = linearSearch(cards, target);
                
                if (index != -1) {
                    System.out.println(target + ": FOUND at index " + index);
                } else {
                    System.out.println(target + ": NOT FOUND");
                }
            }
            
        
    }
}