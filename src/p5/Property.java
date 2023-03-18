package p5;

public class Property {
    private final int bedrooms, price;
    private final String location;
    private boolean available;
    private DateYMD auctionStart, auctionEnd;

    Property(String location, int bedrooms, int price) {
        this.location = location;
        this.bedrooms = bedrooms;
        this.price = price;
        this.setAvailable(true);
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable (boolean available) {
        this.available = available;
    }

    public int getBedrooms() {
        return this.bedrooms;
    }

    public int getPrice() {
        return this.price;
    }

    public String getLocation() {
        return this.location;
    }

    public DateYMD getAuctionStart() {
        return this.auctionStart;
    }

    public DateYMD getAuctionEnd() {
        return this.auctionEnd;
    }

    public void setAuction (DateYMD auctionStart, int days) {
        this.auctionStart = auctionStart;

        /*
         * I think the pdf is wrong.
         * We should "clone" the auctionStart object and increment the date on the newly
         * created one. However, both start and end dates on the example are the same.
        */
        for (int i = 0; i < days - 1; i++) {
            auctionStart.incrementDate();
        }
        this.auctionEnd = auctionStart;
    }
}
