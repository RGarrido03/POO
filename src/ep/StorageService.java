package ep;

import java.time.LocalDate;
import java.util.*;

public class StorageService implements StorageServiceInterface {
    private String name;
    private String location;
    private List<Client> clientList = new ArrayList<>();
    private List<StorageUnit> storageUnitList = new ArrayList<>();
    private Map<Client, List<Rental>> rentalMap = new TreeMap<>(Comparator.comparing(Client::getNif));

    public StorageService(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public boolean registerClient(int taxId, String name, ClientType type) {
        return clientList.add(new Client(taxId, name, type));
    }

    @Override
    public Client getClient(int taxId) {
        for (Client client : clientList) {
            if (client.getNif() == taxId) {
                return client;
            }
        }
        return null;
    }

    @Override
    public void addStorageUnit(StorageUnit storageUnit) {
        storageUnitList.add(storageUnit);
    }

    @Override
    public void addStorageUnits(Collection<StorageUnit> storageUnits) {
        storageUnitList.addAll(storageUnits);
    }

    @Override
    public boolean checkAvailability(StorageUnit storageUnit, LocalDate startDate, LocalDate endDate) {
        for (List<Rental> rentalList : rentalMap.values()) {
            for (Rental rental : rentalList) {
                if (rental.getStorageUnit() == storageUnit
                    && ((rental.getStartDate().isBefore(startDate) && rental.getEndDate().isAfter(startDate))
                        || (rental.getStartDate().isAfter(endDate) && rental.getEndDate().isBefore(endDate)))) {
                    return false;
                }
            }
        }

        return true;
    }


    @Override
    public List<StorageUnit> findAvailableUnits(UnitType unitType, LocalDate fromDate, int duration, int[] minDimensions) {
        List<StorageUnit> availableStorageUnits = storageUnitList.subList(0, storageUnitList.size());

        for (List<Rental> rentalList: rentalMap.values()) {
            for (Rental rental : rentalList) {
                if (checkAvailability(rental.getStorageUnit(), fromDate, fromDate.plusDays(duration))
                ) {
                    int[] dimensions = rental.getStorageUnit().getDimensions();

                    if(dimensions[0] < minDimensions[0] || dimensions[1] < minDimensions[1] || dimensions[2] < minDimensions[2]) {
                        availableStorageUnits.remove(rental.getStorageUnit());
                    }
                } else {
                    availableStorageUnits.remove(rental.getStorageUnit());
                }
            }
        }

        availableStorageUnits.removeIf(storageUnit -> storageUnit.getType() != unitType);

        return availableStorageUnits;
    }

    @Override
    public boolean rentStorageUnit(Client client, StorageUnit unit, LocalDate startDate, int duration) {
        if (client.getClientType() == ClientType.PERSONAL && unit.getType() == UnitType.WAREHOUSE) {
            return false;
        }

        if (duration > unit.getMaxDuration()) {
            return false;
        }

        if (!this.checkAvailability(unit, startDate, startDate.plusDays(duration))) {
            return false;
        }

        Rental rental = new Rental(unit, startDate, startDate.plusDays(duration));

        List<Rental> temp = rentalMap.containsKey(client) ? rentalMap.get(client) : new ArrayList<>();
        temp.add(rental);
        rentalMap.put(client, temp);

        return true;
    }

    @Override
    public double calculateTotalCost(StorageUnit unit, int duration) {
        return unit.getPrice() * duration;
    }

    @Override
    public List<String> listRentals() {
        List<String> temp = new ArrayList<>();

        for (UnitType unitType : UnitType.values()) {
            temp.addAll(listRentals(unitType));
        }

        return temp;
    }

    @Override
    public List<String> listRentals(UnitType unitType) {
        List<String> temp = new ArrayList<>();

        for (Map.Entry<Client, List<Rental>> clientRentalEntry : rentalMap.entrySet()) {
            for (Rental rental : clientRentalEntry.getValue()) {
                if(rental.getStorageUnit().getType() == unitType) {
                    StringBuilder sb = new StringBuilder();

                    // append client
                    sb.append(clientRentalEntry.getKey()).append(" - ");

                    // append rental
                    sb.append(rental).append("\n");

                    temp.add(sb.toString());
                }
            }
        }

        return temp;
    }

    public List<StorageUnit> getAvailableUnitsBySize(LocalDate startDate, int duration) {
        return null;
    }
}
