package lw03.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        Map<String, Integer> register = new LinkedHashMap<>();
        List<String> checks = new ArrayList<>();
        int invalid = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split(" ");
            String type = parts[0];
            String name = parts[1];

            if (type.equals("CHECK")) {
                checks.add(name);
            } else if (type.equals("REGISTER")) {
                int count = Integer.parseInt(parts[2]);
                if (count <= 0) {
                    invalid++;
                } else {
                    register.put(name, register.getOrDefault(name, 0) + count);
                }
            } else if (type.equals("WITHDRAW")) {
                int count = Integer.parseInt(parts[2]);
                if (count <= 0 || !register.containsKey(name) || register.get(name) < count) {
                    invalid++;
                } else {
                    int remaining = register.get(name) - count;
                    if (remaining == 0) {
                        register.remove(name);
                    } else {
                        register.put(name, remaining);
                    }
                }
            } else {
                invalid++;
            }
        }
        sc.close();

        System.out.println("===== Enrollment Checks =====");
        for (String name : checks) {
            if (register.containsKey(name)) {
                System.out.println(name + ": " + register.get(name) + " students");
            } else {
                System.out.println(name + ": Not found");
            }
        }
 
        System.out.println("===== Final Enrollment =====");
        for (String code : register.keySet()) {
            System.out.println(code + ": " + register.get(code) + " students");
        }
        System.out.println("Rejected operations: " + invalid);
    }
}
