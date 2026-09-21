package lw01.unguided;



import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        try (Scanner scanner = new Scanner( Main.class.getResourceAsStream("rentals.txt"))) {
            int rentalCount = scanner.nextInt();
            Rental[] rentals = new Rental[rentalCount];
            ArrayList<Integer> units = new ArrayList<>();

            for (int index = 0; index < rentalCount; index++) {
                String type = scanner.next();
                String id = scanner.next();
                int days = scanner.nextInt();
                int rentedUnits = scanner.nextInt();

                if (type.equals("LAPTOP")) {
                    rentals[index] = new LaptopRental(id, days);
                } else if (type.equals("PROJECTOR")) {
                    rentals[index] = new ProjectorRental(id, days);
                }

                units.add(rentedUnits);
            }

            for (int index = 0; index < rentals.length; index++) {
                Rental rental = rentals[index];
                System.out.println(rental.getId() + " | " + rental.label() + " | "
                        + rental.calculateCharge(units.get(index)));
            }
        }
    }
}
