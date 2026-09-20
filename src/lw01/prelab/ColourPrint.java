package lw01.prelab;

public class ColourPrint extends PrintJob {
    private int FIRST_PAGES = 10;
    private int RATE_FIRST = 1500;
    private int RATE_EXTRA = 1000;
    private int SETUP_FEE = 2000;
 
    public ColourPrint(String id, int pages) {
        super(id, pages);
    }
 
    public int calculateCharge() {
        int pages = getPages();
        int firstPart = Math.min(pages, FIRST_PAGES);
        int extraPart = Math.max(0, pages - FIRST_PAGES);
        return firstPart * RATE_FIRST + extraPart * RATE_EXTRA + SETUP_FEE;
    }
 
    public String label() {
        return "Colour";
    }
}