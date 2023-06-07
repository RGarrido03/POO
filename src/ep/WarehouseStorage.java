package ep;

public class WarehouseStorage extends StorageUnit {
    public WarehouseStorage(String location, int[] dimensions, int price) {
        super(location, dimensions, price, 10*365, UnitType.WAREHOUSE);
    }
}
