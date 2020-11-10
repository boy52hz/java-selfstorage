package StorageService;

import Base.Person;

public class StorageService {
    private String name;
    private StorageList storages;
    
    public StorageService(String name, StorageList storages) {
        this.name = name;
        this.storages = storages;
    }
    /***
     * TODO: Customer will require storage type that he/she need
     * 1.check if our storage is full
     * 2.check if customer can afford this
     * 3.add storage to storage list
     * 
     * @param customer
     * @param storageType
     * @return Storage
     */
    public Storage rentStorage(Person customer, StorageType storageType) {
        return null;
    }
    /***
     * TODO: 1500, 2000, 2500 for SMALL, MEDIUM, LARGE
     * @param storageType
     * @return service price
     */
    private static double getCost(StorageType storageType) {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StorageService{name=").append(name);
        sb.append(", storages=").append(storages);
        sb.append('}');
        return sb.toString();
    }
}
