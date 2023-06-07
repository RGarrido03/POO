package ep;

public class GarageStorage extends  StorageUnit {
    public GarageStorage(String location, int[] dimensions, int price) {
        super(location, dimensions, price, 5*365, UnitType.GARAGE);
    }
}
