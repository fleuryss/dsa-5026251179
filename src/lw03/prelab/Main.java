package lw03.prelab;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        p1();
        p2();
        p3();
    }

    static void p1() {
        List<String> playlist = new ArrayList<>();
 
        Scanner satu = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        while (satu.hasNextLine()) {
            String line = satu.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
 
            String[] parts = line.split(" ", 2);
            String type = parts[0];
 
            if (type.equals("ADD")) {
                playlist.add(parts[1]);
            } else if (type.equals("INSERT")) {
                // ngikutin format: INSERT <INDEX> <SONG>
                String[] rest = parts[1].split(" ", 2);
                int index = Integer.parseInt(rest[0]);
                if (index >= 0 && index <= playlist.size()) {
                    playlist.add(index, rest[1]);
                }
            } else if (type.equals("REMOVE")) {
                playlist.remove(parts[1]);
            }
        }
        satu.close();
 
        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        int i = 0;
        for (String plays : playlist) {
            System.out.println((i + 1) + ": " + plays);
            i++;
        }
        System.out.println();
    }

    static void p2() {
        Set<String> participants = new LinkedHashSet<>();
        int duplicates = 0;
 
        Scanner dua = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        while (dua.hasNextLine()) {
            String name = dua.nextLine().trim();
            if (name.isEmpty()) {
                continue;
            }
 
            if (participants.contains(name)) {
                duplicates++;
            } else {
                participants.add(name);
            }
        }
        dua.close();
 
        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());
        int no = 1;
        for (String name : participants) {
            System.out.println(no + ". " + name);
            no++;
        }
        System.out.println("Duplicate registrations: " + duplicates);
        System.out.println();
    }

    static void p3() {
        Map<String, Integer> stock = new LinkedHashMap<>();
        int failedSales = 0;
 
        Scanner tiga = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        while (tiga.hasNextLine()) {
            String line = tiga.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
 
            String[] parts = line.split(" ");
            String type = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);
 
            if (type.equals("ADD")) {
                if (stock.containsKey(product)) {
                    int c = stock.get(product) + quantity;
                    stock.put(product, c);
                } else {
                    stock.put(product, quantity);
                }
            } else if (type.equals("SELL")) {
                if (stock.containsKey(product) && stock.get(product) >= quantity) {
                    int c = stock.get(product) - quantity;
                    stock.put(product, c);
                } else {
                    failedSales++;
                }
            }
        }
        tiga.close();
 
        System.out.println("===== Problem 3 =====");
        stock.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("Failed sales: " + failedSales);
    }
}
