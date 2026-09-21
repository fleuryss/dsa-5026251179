package lw01.unguided;

public abstract class Rental implements Chargeable {
    private String id;
    private int days;

    public Rental(String id, int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Hari rental harus lebih dari nol!");
        }
        this.id = id;
        this.days = days;
    }

    public String getId() {
        return id;
    }

    public int getRentalDays() {
        return days;
    }
     
    public int calculateCharge(int units) {
        if (units <= 0) {
            throw new IllegalArgumentException("Unit harus lebih dari nol!");
        }
        return units * calculateCharge();
    }

    public String label() {
        return "Rental";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }
}
