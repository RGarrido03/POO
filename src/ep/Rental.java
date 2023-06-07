package ep;

import java.time.LocalDate;

public class Rental {
    private StorageUnit storageUnit;
    private LocalDate startDate;
    private LocalDate endDate;

    public Rental(StorageUnit storageUnit, LocalDate startDate, LocalDate endDate) {
        this.storageUnit = storageUnit;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public StorageUnit getStorageUnit() {
        return storageUnit;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "[" + startDate.toString() + " : " + endDate.toString() + "] " + storageUnit.toString();
    }
}
