package ep;

public class LockerStorage extends StorageUnit {
    public LockerStorage(String location, int[] dimensions, int price) {
        super(location, dimensions, price, 30, UnitType.LOCKER);
    }
}
