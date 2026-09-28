package lw02.unguided;

import java.util.*;
public class Main {
    private static int MAX_BORROW = 2;
    public static void main(String[] args) {
        LinkedList<String[]> request = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();
        LinkedList<String[]> successfulRequest = new LinkedList<>();
        Queue<String[]> bookRequest = new LinkedList<>();
        Stack<String[]> failedRequest = new Stack<>();

        books.add(new String[]{"Kalkulus", "2"});
        books.add(new String[]{"Fisika", "1"});
        books.add(new String[]{"Statistika", "2"});

        Scanner brah = new Scanner(Main.class.getResourceAsStream("Borrowing.txt"));
        while (brah.hasNext()) {
            String[] borrowing = new String[2];
            borrowing[0] = brah.next();
            borrowing[1] = brah.next();
            request.add(borrowing);

            if (findRecordIndex(members, borrowing[0]) == -1) {
                members.add(new String[]{borrowing[0], "0"});
            }
        }
        
        brah.close();

        bookRequest.addAll(request);
        while (!bookRequest.isEmpty()) {
            String[] borrowing = bookRequest.poll();
            String[] book = null;
            for (String[] data : books) {
                if (data[0].equals(borrowing[1])) {
                    book = data;
                    break;
                }
            }

            String[] member = null;
            for (String[] data : members) {
                if (data[0].equals(borrowing[0])) {
                    member = data;
                    break;
                }
            }

            if (book == null || member == null) {
                failedRequest.push(borrowing);
                continue;
            }

            int currentStock = Integer.parseInt(book[1]);
            int borrowedCount = Integer.parseInt(member[1]);
            if (currentStock > 0 && borrowedCount < MAX_BORROW) {
                book[1] = String.valueOf(currentStock - 1);
                member[1] = String.valueOf(borrowedCount + 1);
                successfulRequest.add(borrowing);
            } else {
                failedRequest.push(borrowing);
            }
        }

        System.out.println("=== Successfully Processed Requests ===");
        for (String[] borrowing : successfulRequest) {
            System.out.println(borrowing[0] + " " + borrowing[1]);
        }

        System.out.println("=== Remaining Book Stock ===");
        for (String[] book : books) {
            System.out.println(book[0] + ": " + book[1]);
        }

        System.out.println("=== Failed Requests (LIFO) ===");
        while (!failedRequest.isEmpty()) {
            String[] borrowing = failedRequest.pop();
            System.out.println(borrowing[0] + " " + borrowing[1]);
        }
    }
    
    private static int findRecordIndex(LinkedList<String[]> records, String key) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i)[0].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
