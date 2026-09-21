package lw01.unguided;

public class ProjectorRental extends Rental {
    public ProjectorRental(String id, int days) {
        super(id, days);
    }

    @Override 
    public int calculateCharge() {
        int days = getRentalDays();
        int firstThree = Math.min(days, 3);
        int beyondThree = Math.max(days - 3, 0);
        int extra = 20000;
        return (((firstThree * 60000) + (beyondThree * 45000) + extra));
    }


    @Override 
    public String label() {
        return "Projector";
    }
}
