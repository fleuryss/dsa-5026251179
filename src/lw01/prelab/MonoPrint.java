package lw01.prelab;

public class MonoPrint extends PrintJob {
    private int RATE_PER_PAGE = 500;
 
    public MonoPrint(String id, int pages) {
        super(id, pages);
    }
 
    public int calculateCharge() {
        return getPages() * RATE_PER_PAGE;
    }
 
    public String label() {
        return "Mono";
    }
}
 