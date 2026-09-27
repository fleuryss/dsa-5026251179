package lw02.prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        LinkedList<String[]> allTransactions = new LinkedList<>();

        try (Scanner sc = new Scanner(new File("transactions.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\\s+");
                allTransactions.add(parts);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: transactions.txt not found.");
            return;
        }

        LinkedList<String[]> customers = new LinkedList<>();

        for (String[] transaction : allTransactions) {
            String name = transaction[0];
            if (findCustomerIndex(customers, name) == -1) {
                customers.add(new String[]{name, "0"});
            }
        }

        Queue<String[]> transactionQueue = new LinkedList<>(allTransactions);

        Stack<String[]> failedWithdrawals = new Stack<>();

        while (!transactionQueue.isEmpty()) {
            String[] transaction = transactionQueue.poll();
            String name = transaction[0];
            String type = transaction[1];
            long amount = Long.parseLong(transaction[2]);

            int customerIndex = findCustomerIndex(customers, name);
            String[] customer = customers.get(customerIndex);
            long balance = Long.parseLong(customer[1]);

            if (type.equalsIgnoreCase("DEPOSIT")) {
                balance += amount;
                customer[1] = Long.toString(balance);
            } else if (type.equalsIgnoreCase("WITHDRAW")) {
                if (amount > balance) {

                    failedWithdrawals.push(transaction);
                } else {
                    balance -= amount;
                    customer[1] = Long.toString(balance);
                }
            }
        }

        System.out.println("=== Final Balances ===");
        for (String[] customer : customers) {
            System.out.println(customer[0] + " : " + customer[1]);
        }

        System.out.println();
        System.out.println("=== Failed Transactions ===");
        while (!failedWithdrawals.isEmpty()) {
            String[] failed = failedWithdrawals.pop();
            System.out.println(failed[0] + " " + failed[1] + " " + failed[2]);
        }
    }

    private static int findCustomerIndex(LinkedList<String[]> customers, String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i)[0].equals(name)) {
                return i;
            }
        }
        return -1;
    }
}