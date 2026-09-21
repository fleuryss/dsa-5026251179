package lw01.unguided;

public class LaptopRental extends Rental {
    public LaptopRental(String id, int days) {
        super(id, days);
    }

    @Override 
    public int calculateCharge() {
        int days = getRentalDays();
        int rentalCharge = 40000;
        int setup = 10000;
        return (((rentalCharge * days) + setup));
    }

    @Override
    public String label() {
        return "Laptop";
    }
}
