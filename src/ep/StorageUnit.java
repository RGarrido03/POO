package ep;

public abstract class StorageUnit {
    private String location;
    private int[] dimensions;
    private double price;
    private final int maxDuration;
    private final UnitType type;

    public StorageUnit(String location, int[] dimensions, int price, int maxDuration, UnitType type) {
        this.location = location;
        this.dimensions = dimensions;
        this.price = price;
        this.maxDuration = maxDuration;
        this.type = type;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public double getPrice() {
        return price;
    }

    public int[] getDimensions() {
        return dimensions;
    }

    public UnitType getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return type.toString() +
                " unit located in " + location
                + ", with dimension " + dimensions[0] + "x" + dimensions[1] + "x" + dimensions[2]
                + ", " + price + "/day";
    }
}
